# -*- coding: utf-8 -*-
"""
Created on Wed Sep  6 11:49:51 2023

@author: andryharifetra
"""
import pandas as pd
import numpy as np
import datetime

"""
    XLSX PROCESSING
"""

def run_cds ():
    print('[i] : CDS is runnning !')
    input_directory = r'C:\Users\datamanager1\0_dev_eurodata\B_data_processing\INPUT'
    output_directory = r'C:\Users\datamanager1\0_dev_eurodata\B_data_processing\OUTPUT'
    
    # volume de vente
    df_vente_carburant = pd.read_excel(input_directory +'/vente_carburant.xlsx')
    df_volume_de_vente = df_vente_carburant.groupby(['Date','Site','Carburant']).agg({'Quantité':'sum','Tests de pompe':'sum'}).reset_index()
    df_volume_de_vente = df_volume_de_vente.rename(columns={'Quantité':'Volume de ventes'})
    #df_volume_de_vente
    
    #df_vente_carburant.dtypes
    
    # volume de livraison
    #######################
    df_livraison_carburant = pd.read_excel(input_directory +'/livraison_carburant.xlsx')
    #df_livraison_carburant = df_livraison_carburant.rename(columns={'Date comptable':'Date'})
    df_volume_de_livraison = df_livraison_carburant.groupby(['Date','Site','Carburant']).agg({'Quantité':'sum'}).reset_index()

    df_volume_de_livraison = df_volume_de_livraison.rename(columns={'Quantité':'qtt_manuelle_livraison_BL'})
    # take BL_QTT by default

    df_volume_de_livraison['qtt_automatique_livraison_mesuree'] = df_volume_de_livraison['qtt_manuelle_livraison_BL']

    carb_ref = {"GO" : "00001 - GO",
                "SP":	"00002 - SP",
                "PETROLE":	"00003 - PETROLE"}

    df_volume_de_livraison['Carburant'] = df_volume_de_livraison['Carburant'].apply(lambda x: carb_ref.get(x))

    #df_volume_de_livraison.head()
    
    # stock réel final
    #########################
    df_stock_carburant  = pd.read_excel(input_directory +'/stock_carburant.xlsx',engine="openpyxl")
    df_stock_reel_final = df_stock_carburant.groupby(['Date','Site','Carburant']).agg({'Quantité':'sum'}).reset_index()
    df_stock_reel_final = df_stock_reel_final.rename(columns={'Quantité':'Stock réel final'})
    #df_stock_reel_final.head()
    
    # stock théorique
    # stock d'ouverture + volume_livraison - Volume de vente
    # get stock d'ouverture
    df_stock_ouverture = df_stock_reel_final.copy()
    df_stock_ouverture['Date'] = df_stock_reel_final['Date'] + datetime.timedelta(days=1)
    df_stock_ouverture = df_stock_ouverture.rename(columns={"Stock réel final":"Stock d ouverture"}).reset_index()
    #df_stock_ouverture.head()
    
    # validation des journées
    df_validation_journee =  pd.read_excel(input_directory +'/validation_journee.xlsx')
    util_col = ['Valider','Site', 'Date','Statut','Origine','Date/heure de synchronisation&nbsp;'] #RECENT_ADD
    col_to_drop = [col for col in df_validation_journee.columns if col not in util_col]
    df_validation_journee = df_validation_journee.drop(columns=col_to_drop)
    #df_validation_journee.head()
    
    '''
    
        MERGIN DATAFRAME
    
    '''
    # stock_reel_final + stock_ouverture
    df_merged = df_stock_reel_final.merge(df_stock_ouverture, on=['Date','Site','Carburant'], how='outer')
    
    # + volume_de_livraison
    df_merged = df_merged.merge(df_volume_de_livraison,on=['Date','Site','Carburant'], how='outer')
    
    # + volume_vente
    df_merged = df_merged.merge(df_volume_de_vente,on=['Date','Site','Carburant'], how='outer')
    
    df_merged.dtypes
    
    '''
    
        FEATURES INGENIEERING
        
    '''
    df_cds = df_merged.copy()

# MERGING    
    # stock theorique final
    df_cds_not_null = df_merged.copy().fillna(0) # prevent arithmetic operation error on "null"
    df_cds['Stock théorique final'] = df_cds_not_null['Stock d ouverture'] - df_cds_not_null['Volume de ventes'] + df_cds_not_null['qtt_manuelle_livraison_BL']
    
    # ecart CDS
    df_cds_not_null.columns
    df_cds['Différence'] = df_cds_not_null['Stock réel final'] - df_cds['Stock théorique final']
    
    # % ecarts sur vente (set to 0 if ['vente'] is null or zero)
    df_cds['Ecart vs vente pour 1000'] = np.where(df_cds_not_null['Volume de ventes'] == 0,0, df_cds['Différence']*(1000 / df_cds_not_null['Volume de ventes']))
    
    # écart livaraison
    df_cds['Ecart livraison'] =  df_cds_not_null['qtt_automatique_livraison_mesuree'] - df_cds_not_null['qtt_manuelle_livraison_BL']
    
    # % écart livraison
    percent_val = df_cds['Ecart livraison']*1000/df_cds_not_null['qtt_manuelle_livraison_BL']
    is_zero = df_cds_not_null['qtt_manuelle_livraison_BL'] == 0
    
    df_cds['Ecart livraison pour 1000'] = np.where(is_zero,0,percent_val)
    
    # vente cumulee
    df_cds_not_null['mounth-year'] = df_cds['Date'].dt.strftime("%m-%y")
    df_cds_not_null['day'] = df_cds['Date'].dt.strftime("%d")
    df_cds_not_null['Différence'] = df_cds['Différence']
    
    df_cds['cumul vente'] = df_cds_not_null.groupby(['Site','Carburant','mounth-year'])['Volume de ventes'].cumsum()
    
    # écarts cumulee
    df_cds['cumul ecart'] = df_cds_not_null.groupby(['Site','Carburant','mounth-year'])['Différence'].cumsum()
    
    df_cds_not_null.columns
    
    # % écarts cumulee
    is_zero_div = df_cds['cumul vente'] == 0
    df_cds['% cumul ecart vs vente'] = np.where(is_zero_div,0,df_cds['cumul ecart'] *1000/ df_cds['cumul vente'])
    
    df_cds = df_cds.merge(df_validation_journee,on=['Date','Site'],how='left')
    
    """ REGION LOOKUP """
    
    ref_directory = r'C:\Users\datamanager1\0_dev_eurodata\B_data_processing\REF\ref_num_ss_region.xlsx'
    df_ref_region = pd.read_excel(ref_directory)
    
    df_cds = df_cds.merge(df_ref_region[['Site','Region']], on=['Site'],how='left')
    
    
    """"""         """"""
# column REAODERING    
    reod_col = ['index','Date', 'Site', 'Region', 'Carburant','Valider', 'Statut','Date/heure de synchronisation&nbsp;', 'Origine', 
                
               
               'qtt_manuelle_livraison_BL',
               'qtt_automatique_livraison_mesuree', 
               'Ecart livraison',
               'Ecart livraison pour 1000', 
                
               'Stock d ouverture',
               'Stock théorique final', 
               'Stock réel final', 
               'Différence',
               
               'Volume de ventes',
               'Tests de pompe',
               
               'Ecart vs vente pour 1000',
               'cumul vente', 
               'cumul ecart',
               '% cumul ecart vs vente']
    
    #format_date
    #df_cds['Date'] = df_cds['Date'].dt.strftime('%d/%m/%Y')

# EXCLUSION
    # exclude statut == "A saisir"
    df_cds = df_cds[df_cds['Statut']!='A saisir']
    
    # exclude minimum date
    min_date = df_cds['Date'].min()
    df_cds = df_cds[df_cds['Date']>min_date]

    df_cds['Date'] = df_cds['Date'].dt.date

# COLUMN DROP
    df_cds = df_cds[reod_col].drop(['Valider','index','qtt_automatique_livraison_mesuree','Ecart livraison','Ecart livraison pour 1000'],axis=1)    
    
    df_cds.dtypes
    df_cds.to_excel(output_directory + "\cds_prevalidation.xlsx",index=False)
    print("[OK] -> CDS exported successfully ! ")

#run_cds()

"""
read xlsx
"""

"""
check for file directory
"""
"""
import os

file_path = 'INPUT/livraison_carburant.xlsx'  # Replace with your file path
if os.path.exists(file_path):
    print(f"File '{file_path}' exists.")
else:
    print(f"File '{file_path}' does not exist.")
"""