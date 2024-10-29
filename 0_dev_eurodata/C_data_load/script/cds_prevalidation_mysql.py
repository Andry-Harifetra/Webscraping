# -*- coding: utf-8 -*-
"""
Created on Thu Feb 29 10:10:20 2024
@author: Andry-Harifetra

@this : 1) prepare the data 
        2) integrate in sql table

"""

import pandas as pd
import numpy as np
from G_GLOBAL.variable import PROJECT_PATH

# ----------------------------------------------

# 1) prepare data
df_cds_prevalid = pd.read_excel(PROJECT_PATH+"B_data_processing/OUTPUT/cds_prevalidation.xlsx")

#df_cds_prevalid.dtypes

#---RENAME COLUMN
#--------> load rename_ref
col_ref = pd.read_excel(PROJECT_PATH+"C_data_load/REF/col_renaming.xlsx")
#--------> make a dictionary
rename_dict = dict(zip(col_ref['col_src'], col_ref['col_dest']))
#--------> renaming
df_cds_prevalid.rename(columns=rename_dict,inplace=True)
df_cds_prevalid.replace([float('inf'), float('-inf')], None, inplace=True) # replace inf
#df_cds_prevalid = df_cds_prevalid.where(pd.notna(df_cds_prevalid), 0)
df_cds_prevalid.replace({np.nan: None}, inplace=True) # replace works

    # formating
df_cds_prevalid['date'] = pd.to_datetime(df_cds_prevalid['date'], format='%d/%m/%Y').dt.strftime('%Y-%m-%d')
df_cds_prevalid['date_synchro'] = pd.to_datetime(df_cds_prevalid['date_synchro'], format='%d/%m/%Y %H:%M:%S').dt.strftime('%Y-%m-%d %H:%M:%S')
df_cds_prevalid['date_extract'] = pd.to_datetime(df_cds_prevalid['date_extract'], format='%d/%m/%Y %H:%M:%S').dt.strftime('%Y-%m-%d %H:%M:%S')

# ----------------------------------------------

from sqlalchemy import create_engine, Column, Integer, String, MetaData, Table
from sqlalchemy.orm import declarative_base, Session

# 2) data load
    # make con / schema
engine = create_engine('mysql://root:Cpktnwt88#@localhost:3306/eurodata',echo=True)
metadata = MetaData()
metadata.reflect(bind=engine)
table_prevalid = Table('cds_prevalidation', metadata, autoload_with=engine)
    # check df & table key
if set(df_cds_prevalid.columns) != set(table_prevalid.columns.keys()):
    raise ValueError("le dataframe et les dimensions de la table ne correspond pas !")

# Itérer sur les lignes du DataFrame et insérer les données une par une
# single insertion

#Ê iterate
with engine.begin() as connection:
    for index, row in df_cds_prevalid.iterrows():
        data = row.to_dict()
        connection.execute(table_prevalid.insert().values(data))


'''
     INSERT DATA - row by row

'''
#df = df.where(pd.notna(df), None)


'''
    # change inf -> None
df_cds_prevalid.to_sql('cds_prevalidation', engine, index=False, if_exists='replace')

    # write data
df_cds_prevalid.to_sql(name='users', con=engine, if_exists='replace', index=False)
'''