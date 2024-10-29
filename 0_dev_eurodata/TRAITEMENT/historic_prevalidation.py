# -*- coding: utf-8 -*-
"""
Created on Wed Jan 17 10:13:28 2024

@author: Andry-Harifetra
"""
import pandas as pd
import numpy as np

import datetime

    # catalogue de livraison
df_catalogue_livraison = pd.read_excel('TRAITEMENT/catalogue_livraison_2023.xlsx')
df_catalogue_livraison = df_catalogue_livraison.groupby(['Site','Date comptable','Carburant']).agg({'Quantité automatique':'sum','Quantité manuelle':'sum'}).reset_index()
df_catalogue_livraison['Ecarts catalogue livraison'] = df_catalogue_livraison['Quantité automatique'] - df_catalogue_livraison['Quantité manuelle']
df_catalogue_livraison['Ecarts pour 1000 catalogue livraison'] = 1000 * df_catalogue_livraison['Ecarts catalogue livraison'] / df_catalogue_livraison['Quantité manuelle']
df_catalogue_livraison.rename(columns={'Date comptable': 'Date'}, inplace=True)
df_catalogue_livraison['Date'] = df_catalogue_livraison['Date'].dt.strftime('%d-%m-%Y')
df_catalogue_livraison.dtypes

    # validation des journées
df_validation_journee =  pd.read_excel('TRAITEMENT/validation_journee_2023.xlsx')
util_col = ['Valider','Site', 'Date','Statut','Origine','Date/heure de synchronisation&nbsp;'] #RECENT_ADD
col_to_drop = [col for col in df_validation_journee.columns if col not in util_col]
df_validation_journee = df_validation_journee.drop(columns=col_to_drop)
df_validation_journee['Date'] = df_validation_journee['Date'].dt.strftime('%d-%m-%Y')
df_validation_journee.dtypes
df_validation_journee['Statut'].value_counts()
df_miss_preval = df_validation_journee[df_validation_journee['Statut']=='En cours']

    # CDS
df_cds = pd.read_excel('TRAITEMENT/CDS_2023.xlsx')
df_cds['Date_comptable'] = df_cds['Date_comptable'].dt.strftime('%d-%m-%Y')
df_cds = df_cds.rename(columns={'Date_comptable':'Date'})
#df_cds.dtypes
        # CDS cumul vente
df_copy_cds = df_cds.copy()
df_copy_cds['Date'] = pd.to_datetime(df_copy_cds['Date'],format='%d-%m-%Y')
df_copy_cds['mounth-year'] = df_copy_cds['Date'].dt.strftime("%m-%y")
df_copy_cds['day'] = df_copy_cds['Date'].dt.strftime("%d")
df_copy_cds['cumul vente'] = df_copy_cds.groupby(['Site','Carburant','mounth-year'])['Volume_de_ventes'].cumsum()
df_cds['cumul vente'] = df_copy_cds['cumul vente']
            # test - extrait 'alaotra GO'
#test_tmp = df_copy_cds[(df_copy_cds['Site']=='00001 - ALAOTRA') & (df_copy_cds['Carburant']=='00001 - GO')]
#test_tmp.head(100).to_excel('TRAITEMENT/alaotra_extract_test_cumul_vente.xlsx')

        # CDS REGION - lookup
ref_directory = r'C:\Users\datamanager1\0_dev_eurodata\B_data_processing\REF\ref_num_ss_region.xlsx'
df_ref_region = pd.read_excel(ref_directory)
    
df_cds = df_cds.merge(df_ref_region[['Site','Region']], on=['Site'],how='left')


####### Merge

df_cds_historic = df_cds.copy()

# + validation journée
df_merge = df_cds_historic.merge(df_validation_journee, on=['Site','Date'], how='outer')

# + catalogue livraison
df_merge = df_merge.merge(df_catalogue_livraison, on=['Site','Date','Carburant'], how='outer')

# + prevalidation en cours


######## Fine tuning
 
# model
df_model_cds = pd.read_excel('B_data_processing/OUTPUT/cds_prevalidation.xlsx')
df_column_model = df_model_cds.columns

'''
column model = ['Date', 'Site', 'Region', 'Carburant', 'Statut',
       'Date/heure de synchronisation&nbsp;', 'Origine',
       'qtt_manuelle_livraison_BL', 'Quantité automatique',
       'Ecarts catalogue livraison', 'Ecarts pour 1000 catalogue livraison',
       'Stock d ouverture', 'Stock théorique final', 'Stock réel final',
       'Différence', 'Volume de ventes', 'Tests de pompe',
       'Ecart vs vente pour 1000', 'cumul vente', 'cumul ecart',
       '% cumul ecart vs vente']
'''

# renaming column
df_merge.rename(columns={'Stock_d_ouverture': 'Stock d ouverture',
                         'Volume_de_ventes' : 'Volume de ventes',
                         'Volume_livre':'Quantité automatique',
                         'Stock_theo_final':'Stock théorique final',
                         'Stock_reel_final':'Stock réel final',
                         'Difference':'Différence',
                         'Différence_Vs_ventes_pour_1000':'Ecart vs vente pour 1000',
                         'Test_pompes':'Tests de pompe',
                         'Difference_cumulee':'cumul ecart',
                         'Difference_Vs_ventes_cumulees_(â€°)':'% cumul ecart vs vente',
                         'Quantité manuelle':'qtt_manuelle_livraison_BL',
                         }, inplace=True)

# removing column NOK
df_merge = df_merge.drop(['Groupe_de_cuve',
                          'Valider',
                          'Date_Heure_debut_periode',
                          'Date_Heure_fin_periode'],axis=1)


# FIND culumn NOK
column_merge_ok = [value for value in df_model_cds.columns if value in df_merge.columns]
column_merge_nok = [value for value in df_merge if value not in column_merge_ok ]

# reordering column
column_order = df_model_cds.columns
df_merge = df_merge[df_model_cds.columns]


# EXPORT
df_merge.columns
df_en_cours = df_merge[df_merge['Statut']=='En cours']
