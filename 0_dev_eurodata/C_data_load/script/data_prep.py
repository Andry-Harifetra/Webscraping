# -*- coding: utf-8 -*-
"""
Created on Mon Mar 18 15:17:10 2024
    PREPARE DATA :
        column_name & order
        cast datatype (tuple or df)

"""
import pandas as pd
from datetime import datetime
import os
import numpy as np

from G_GLOBAL.variable import PROJECT_PATH

input_path = PROJECT_PATH+r'B_data_processing/OUTPUT/'
output_path = PROJECT_PATH+r'C_data_load/output/'

###### 0) delete output
def col_reorder():
# Get a list of all files in the directory

    #def separate_reg :
    df_prevalid_cds = pd.read_excel(input_path+'cds_prevalidation.xlsx')
    #df_prevalid_cds = df_prevalid_cds[df_prevalid_cds["Statut"]=="En cours"]
    #df_prevalid_cds['Date'] = pd.to_datetime(df_prevalid_cds['Date'],format="%d/%m/%Y")
    #df_prevalid_cds['Date'] = df_prevalid_cds['Date'].dt.strftime("%d/%m/%Y")
    
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

    # data export
    df_prevalid_cds = df_prevalid_cds[reod_col]
    return df_prevalid_cds
    
def col_rename(df_prevalid_cds):
    col_ref = pd.read_excel(PROJECT_PATH+"C_data_load/REF/col_renaming.xlsx")
    #--------> make a dictionary
    rename_dict = dict(zip(col_ref['col_src'], col_ref['col_dest']))
    #--------> renaming
    df_prevalid_cds.rename(columns=rename_dict,inplace=True)
    df_prevalid_cds.replace([float('inf'), float('-inf')], None, inplace=True) # replace inf
    #df_prevalid_cds = df_cds_prevalid.where(pd.notna(df_cds_prevalid), 0)
    df_prevalid_cds.replace({np.nan: None}, inplace=True) # replace works

        # formating
    #df_prevalid_cds['date'] = pd.to_datetime(df_prevalid_cds['date'], format='%d/%m/%Y').dt.strftime('%Y-%m-%d')
    #df_prevalid_cds['date_synchro'] = pd.to_datetime(df_prevalid_cds['date_synchro'], format='%d/%m/%Y %H:%M:%S').dt.strftime('%Y-%m-%d %H:%M:%S')
    #df_prevalid_cds['date_extract'] = df_prevalid_cds['date_extract'].dt.strftime('%Y-%m-%d %H:%M:%S')

    return df_prevalid_cds

def get_data_prep():
    df_prevalid_cds = col_reorder()
    df_prevalid_cds = col_rename(df_prevalid_cds)
    return df_prevalid_cds

if __name__== "__main__" :
    df_prevalid_cds = col_reorder()
    df_prevalid_cds = col_rename(df_prevalid_cds)
    df_prevalid_cds.to_excel(output_path+"cds.xlsx", index=False)
    print('[ok] data prepared export')