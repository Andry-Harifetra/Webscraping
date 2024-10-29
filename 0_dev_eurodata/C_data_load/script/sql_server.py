# -*- coding: utf-8 -*-
"""
Created on Mon Mar 18 09:22:19 2024

@MANAGE SQL Server OPERATION

@author: Andry-Harifetra
"""
import pandas as pd
from datetime import datetime
import os
import numpy as np
import pymssql

from G_GLOBAL.variable import PROJECT_PATH

input_path = PROJECT_PATH+r'B_data_processing/OUTPUT/'
output_path = PROJECT_PATH+r'C_data_load/output/'


def col_reorder():
    df_prevalid_cds = pd.read_excel(input_path+'cds_prevalidation.xlsx')
    # reaorder column
    reod_col = ['Date', 'Site', 'Region', 'Carburant', 'Statut','Date/heure de synchronisation&nbsp;', 'Origine', 
                     
               'qtt_manuelle_livraison_BL', 
               
               'Quantité automatique',
               'Ecarts catalogue livraison',
               'Ecarts pour 1000 catalogue livraison',
               
               'Stock d ouverture',
               'Stock théorique final', 
               'Stock réel final', 
               'Volume de ventes',
               'Différence',
               'Tests de pompe',
               'Ecart vs vente pour 1000',
               'cumul vente', 
               'cumul ecart',
               '% cumul ecart vs vente',
               'Livraison Directe',
               'date_extract']

    df_prevalid_cds = df_prevalid_cds[reod_col]
    return df_prevalid_cds

def col_rename(df_prevalid_cds):
    col_ref = pd.read_excel(PROJECT_PATH+"C_data_load/REF/col_renaming.xlsx")
    rename_dict = dict(zip(col_ref['col_src'], col_ref['col_dest']))
    df_prevalid_cds.rename(columns=rename_dict,inplace=True)
    return df_prevalid_cds

def col_cast(df_prevalid_cds):

    df_prevalid_cds['statut'].fillna("", inplace=True)
    
    df_prevalid_cds.replace([float('inf'), float('-inf')], None, inplace=True) # replace inf
    df_prevalid_cds.replace({np.nan: None}, inplace=True) # replace NaN
    #df_prevalid_cds.replace({np.datetime64('NaT'): None}, inplace=True) # replace NaT
    df_prevalid_cds.replace({pd.NaT: None}, inplace=True) # replace works
    
    # Compatibilities cast
    df_prevalid_cds['date'] = pd.to_datetime(df_prevalid_cds['date'], format='%d/%m/%Y')
    df_prevalid_cds['date_synchro'] = pd.to_datetime(df_prevalid_cds['date_synchro'], format='%d/%m/%Y %H:%M:%S')
    df_prevalid_cds['date_extract'] = pd.to_datetime(df_prevalid_cds['date_extract'], format='%d/%m/%Y %H:%M:%S')
    
    # foramt cast
    return df_prevalid_cds

def get_data_prep():
    # reorder column -> rename column -> cast data
    df_prevalid_cds = col_reorder()
    df_prevalid_cds = col_rename(df_prevalid_cds)
    df_prevalid_cds = col_cast(df_prevalid_cds)
    return df_prevalid_cds
'''

    SQL


'''


def get_connection():
    # connection param
    server = '192.168.130.233\DBAPPLI' 
    database = 'eurodata' 
    username = 'eurodata_user' 
    password = 'eµrodata@Jovena8' 
    # connection
    conn = pymssql.connect(server, username, password, database)
    return conn

def insert_simple_ligne(conn, data):
    # insert sample data (dict)
    cursor = conn.cursor()
    insert_query = "INSERT INTO cds_prevalidation (date, Site, Volume, sync) VALUES (%s, %s, %s, %s)"
    cursor.execute(insert_query, data)
    #commit changes
    conn.commit()
    cursor.close()

def insert_data(conn, data, schema):
    # dict
    cursor = conn.cursor()

    insert_query = "INSERT INTO cds_prevalidation ({}) VALUES ({})".format(
        ', '.join(schema.keys()),
        ', '.join(['%s' for _ in schema])
    )

    for row in data:
        row_values = tuple(row[column] if column in row else None for column in schema.keys())
        # or if the data is already a tuple
        # row_values = [row[column] if column in row else None for column in schema.keys()]
        cursor.execute(insert_query, row_values)

    conn.commit()
    cursor.close()

def insert_df(conn, data, schema):
    # insert dataframe
    cursor = conn.cursor()

    insert_query = "INSERT INTO cds_prevalidation ({}) VALUES ({})".format(
        ', '.join(schema.keys()),
        ', '.join(['%s' for _ in schema])
    )

    for _,row in data.iterrows():
        try:
            row_values = tuple(row[column] if column in row else None for column in schema.keys())
            cursor.execute(insert_query, row_values)
            print("|", end='', flush=True)
        except Exception as e:
            # record rejection
            print("error occurred:", e)
            
    conn.commit()
    cursor.close()

def insert_df_many(conn, data, schema):
    # insert dataframe
    cursor = conn.cursor()

    insert_query = "INSERT INTO cds_prevalidation ({}) VALUES ({})".format(
        ', '.join(schema.keys()),
        ', '.join(['%s' for _ in schema])
    )

    try:
        rows = [tuple(row.get(column, None) for column in schema.keys()) for _, row in data.iterrows()]
        cursor.executemany(insert_query, rows)
    except Exception as e:
        # record rejection
        print("An unexpected error occurred:", e)
    else:
        conn.commit()
    finally:
        cursor.close()


def get_table_list(conn,db):
    cursor = conn.cursor()
    query = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE='BASE TABLE' AND TABLE_CATALOG=%s"
    cursor.execute(query, db)
    tables = [row[0] for row in cursor.fetchall()]
    cursor.close()
    return tables

def get_column_list(conn,table):
    cursor = conn.cursor()
    query = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = %s"
    cursor.execute(query, table)
    columns = [row[0] for row in cursor.fetchall()]
    cursor.close()
    return columns

def get_column_datatypes(conn,table):
    cursor = conn.cursor()
    query = "SELECT COLUMN_NAME, DATA_TYPE FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = %s"
    cursor.execute(query, table)
    columns = {row[0]: row[1] for row in cursor.fetchall()}
    cursor.close()
    return columns

'''#############

       MAIN

'''#############

def load():
    try:
        print("> LOAD is Starting !")
        # connect DB
        conn = get_connection()
        #get_table_list(conn,"eurodata")
        
        # get SCHEMA
        #columns = get_column_list(conn,"cds_prevalidation")
        schema = get_column_datatypes(conn,"cds_prevalidation")
        
        # LOAD data
        #from sample.data import sample_data as data

        # CAST data
        data = get_data_prep()
        insert_df(conn,data,schema) # use of execute
        #insert_df_many(conn,data,schema) # use of execute many

        # -> g
    finally:
        # Fermeture de la connexion
        conn.close()
        print("[OK] LOAD DONE ! connection closed")

if __name__ == "__main__":
    #load()
    data = get_data_prep()
    data.columns
    cnt = data['date_synchro'].value_counts()
    cnt.to_excel("test.xlsx")
    #data.to_csv("data_prepared.csv", index=False)
    #tmp = data['date_extract'].dt.strftime('%d/%m/%Y %H:%M:%S')
    