# -*- coding: utf-8 -*-
"""
Created on Tue Jan 16 14:42:51 2024

@author: Andry-Harifetra
"""
####
#
#      VERIF mensuel - TRAITEMENT & ENCAISSEMENT
#
####

import pandas as pd
import numpy as np

import datetime



######## ENCAISSEMENT

'''
    Eurodata
    aggregation des donnees d'encaissement par mois et par :
        - station, region, mois, type_de_payment'
'''
# Encaissement Eurodata
df_encaissement_jour_detail = pd.read_excel("TRAITEMENT/input/Encaissement_2023.xlsx")
df_encaissement_jour_detail.dtypes
df_encaissement_jour_detail['mounth_year'] = df_encaissement_jour_detail['Date'].dt.strftime('%m-%Y')
df_encaissement_moi_detail = df_encaissement_jour_detail.groupby(['Site','Type','mounth_year']).agg({'Montant':'sum'}).reset_index()

    # + region
ref_directory = r'C:\Users\datamanager1\0_dev_eurodata\B_data_processing\REF\ref_num_ss_region.xlsx'
df_ref_region = pd.read_excel(ref_directory)
    
df_encaissement_moi_detail_region = df_encaissement_moi_detail.merge(df_ref_region[['Site','Region','ss']], on=['Site'],how='left')

df_encaissement_moi_detail_region

    # + class payment (attribuer autre pour ceux qui ne sont pas dans class_payment)
class_payment =   ['ARIARY','CARTE E+','FANILO','BONS CARBURANTS']
df_encaissement_moi_detail_region['class_payment'] = df_encaissement_moi_detail_region['Type'].apply(lambda x: x if x in class_payment else 'AUTRE')

    # Export
#df_encaissement_moi_detail.to_excel('TRAITEMENT/export/df_encaissement_mois_detail.xlsx')
df_encaissement_moi_detail_region.to_excel('TRAITEMENT/export/df_encaissement_mois_detail_region.xlsx')

'''
    aggregation data FANILO - moneytech
    
'''
    

######### CA Carburant jour

'''
    aggregation des CA, volume, livraison carburant par :
        - mois, station, region

'''


    # demande DC
df_cds_CA_jour = pd.read_excel("TRAITEMENT/CDS_CA_2023.xlsx")

df_cds_CA_jour.dtypes

    #add mounth y
df_cds_CA_jour['mounth_year'] = df_cds_CA_jour['Date_comptable'].dt.strftime('%m-%Y')
df_cds_CA_jour.columns

df_cds_CA_jour_carburant  = df_cds_CA_jour.groupby(['Site','mounth_year','Carburant']).agg({'CA TTC':'sum','Volume_de_ventes':'sum','Volume_livre':'sum'}).reset_index()

    #export
df_cds_CA_jour_carburant.to_excel('TRAITEMENT/export/cds_ca_livraison_mois_carburant.xlsx')




######## PLOT

import matplotlib.pyplot as plt

plt.scatter(df_vente_total['Date_comptable'], df_vente_total['CA TTC'])

plt.xlabel('Date')
plt.ylabel('CA TTC')
plt.title('RECAP CA Carb')

# BOX plot
#df_vente_total['CA TTC'].astype(int)
df_vente_total['CA TTC'].describe()
plt.boxplot(df_vente_total['CA TTC'])

# Outlier detection
