# -*- coding: utf-8 -*-
"""
Created on Wed Sep  6 11:49:51 2023

@author: Andry-Harifetra

    ** all modif about Livraison Direct must be mentionned "LD"

"""
import pandas as pd
import numpy as np
import datetime

from G_GLOBAL.variable import PROJECT_PATH
from script.cds_hezaka import run_cds_hezaka
from script.type_util import is_missing

def count_missing_values(df, columns):
    # Définir les types de valeurs manquantes à vérifier
    missing_types = {
        'pd.isna': lambda x: pd.isna(x),
        'None': lambda x: x is None,
        '0': lambda x: x == 0,
        'pd.NaT': lambda x: x is pd.NaT,
        'NaN': lambda x: pd.isna(x),
        'Empty String': lambda x: x == '',
        'Whitespace String': lambda x: isinstance(x, str) and x.isspace()
    }
    
    # Créer un dictionnaire pour stocker les résultats
    results = {col: {key: 0 for key in missing_types.keys()} for col in columns}
    
    # Parcourir chaque colonne et compter les types de valeurs manquantes
    for col in columns:
        for key, func in missing_types.items():
            results[col][key] = df[col].apply(func).sum()
    
    # Convertir le dictionnaire en DataFrame
    result_df = pd.DataFrame(results)
    
    return result_df


"""
    XLSX PROCESSING
    
"""

def run_cds ():
    print('[i] : CDS is runnning !')
    input_directory = PROJECT_PATH+'B_data_processing\INPUT'
    output_directory = PROJECT_PATH+'B_data_processing\OUTPUT'
    
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
    
    # LD
    df_livraison_carburant['N° Bon de livraison'] = df_livraison_carburant['N° Bon de livraison'].astype(str)
    df_livraison_carburant['Livraison Directe'] = df_livraison_carburant['N° Bon de livraison'].apply(lambda x: True if x.startswith('LD') else False)

    # AGG
    df_volume_de_livraison = df_livraison_carburant.groupby(['Date','Site','Carburant','Livraison Directe']).agg({'Quantité':'sum'}).reset_index()

    df_volume_de_livraison = df_volume_de_livraison.rename(columns={'Quantité':'qtt_manuelle_livraison_BL'})
    # take BL_QTT by default

    df_volume_de_livraison['qtt_automatique_livraison_mesuree'] = df_volume_de_livraison['qtt_manuelle_livraison_BL']

    carb_ref = {"GO" : "00001 - GO","SP":	"00002 - SP", "PETROLE":	"00003 - PETROLE"}

    df_volume_de_livraison['Carburant'] = df_volume_de_livraison['Carburant'].apply(lambda x: carb_ref.get(x))

    # tmp = df_volume_de_livraison[df_volume_de_livraison["Site"]=="00088 - MANANGAREZA"]

    # Catalogue de livraison
    #######################
    df_catalogue_livraison = pd.read_excel(input_directory +'/catalogue_livraison.xlsx')
    df_catalogue_livraison = df_catalogue_livraison.groupby(['Site','Date comptable','Carburant']).agg({'Quantité automatique':'sum','Quantité manuelle':'sum'}).reset_index()
    df_catalogue_livraison['Ecarts catalogue livraison'] = df_catalogue_livraison['Quantité automatique'] - df_catalogue_livraison['Quantité manuelle']
    df_catalogue_livraison['Ecarts pour 1000 catalogue livraison'] = 1000 * df_catalogue_livraison['Ecarts catalogue livraison'] / df_catalogue_livraison['Quantité manuelle']
    df_catalogue_livraison.rename(columns={'Date comptable': 'Date'}, inplace=True)
    df_catalogue_livraison['Date'] = df_catalogue_livraison['Date'].dt.strftime('%d-%m-%Y')

    #df_volume_de_livraison.head()
    
    # stock réel final
    #########################
    df_stock_carburant  = pd.read_excel(input_directory +'/stock_carburant.xlsx',engine="openpyxl")
    df_stock_reel_final = df_stock_carburant.groupby(['Date','Site','Carburant']).agg({'Quantité':'sum'}).reset_index()
    df_stock_reel_final = df_stock_reel_final.rename(columns={'Quantité':'Stock réel final'})
    df_stock_reel_final['Date'] = pd.to_datetime(df_stock_reel_final['Date'],format='%d-%m-%Y')
    df_stock_reel_final['Date'] = df_stock_reel_final['Date'].dt.strftime('%d-%m-%Y')
    #df_stock_reel_final.head()
    
    # stock théorique
    # stock d'ouverture + volume_livraison - Volume de vente
    # get stock d'ouverture
    df_stock_ouverture = df_stock_reel_final.copy()
    #df_stock_reel_final['Date'] = pd.to_datetime(df_stock_reel_final['Date'])
    df_stock_ouverture['Date'] = pd.to_datetime(df_stock_reel_final['Date'],format='%d-%m-%Y') + datetime.timedelta(days=1)
    df_stock_ouverture = df_stock_ouverture.rename(columns={"Stock réel final":"Stock d ouverture"}).reset_index()
    df_stock_ouverture['Date'] = df_stock_ouverture['Date'].dt.strftime('%d-%m-%Y')
    #df_stock_ouverture.head()
    
    # validation des journées
    df_validation_journee =  pd.read_excel(input_directory +'/validation_journee.xlsx')
    df_validation_journee['Date'] = pd.to_datetime(df_validation_journee['Date'],format='%d-%m-%Y').dt.strftime("%d-%m-%Y")
    util_col = ['Valider','Site', 'Date','Statut','Origine','Date/heure de synchronisation&nbsp;'] #RECENT_ADD
    col_to_drop = [col for col in df_validation_journee.columns if col not in util_col]
    df_validation_journee = df_validation_journee.drop(columns=col_to_drop)
    #df_validation_journee.head()
    # qtt_manuelle_livraison_BL
    '''
    
        MERGIN DATAFRAME
    
    '''
    # stock_reel_final + stock_ouverture
    df_merged = df_stock_reel_final.merge(df_stock_ouverture, on=['Date','Site','Carburant'], how='outer')
    
    # + volume_de_livraison
    try :
        df_volume_de_livraison['Date'] = df_volume_de_livraison['Date'].dt.strftime('%d-%m-%Y')
    except :
        pass
    
    # merge where livraison is not LD
    #df_merged = df_merged.merge(df_volume_de_livraison[df_volume_de_livraison['Livraison Directe']==False],on=['Date','Site','Carburant'], how='outer')
    
    # new way : first sum_up_livraison_before merge
    tmp_volume_de_livraison = df_volume_de_livraison.groupby(['Date','Site','Carburant']).agg('sum').reset_index().drop("Livraison Directe",axis=1,inplace=False)
    tmp_volume_de_livraison["Livraison Directe"] = True
    
    df_merged = df_merged.merge(tmp_volume_de_livraison,on=['Date','Site','Carburant'], how='outer') # False was deleted
    #df_volume_de_livraison = tmp_volume_de_livraison
    
    # old way
    #df_merged = df_merged.merge(df_volume_de_livraison,on=['Date','Site','Carburant'], how='outer') # False was deleted
    
    
    # + volume_vente
    try :
        df_volume_de_vente['Date'] = df_volume_de_vente['Date'].dt.strftime('%d-%m-%Y')
    except :
        pass
    
    df_merged = df_merged.merge(df_volume_de_vente,on=['Date','Site','Carburant'], how='outer')
    
    # + catalogue de livraison
    #df_merged['Date'] = df_merged['Date'].dt.strftime('%d-%m-%Y')
    df_merged = df_merged.merge(df_catalogue_livraison, on=['Date','Site','Carburant'], how='outer')


    '''
    
        FEATURES INGENIEERING
        
    '''
    df_cds = df_merged.copy()

# MERGING    
    # stock theorique final
    df_cds_not_null = df_merged.copy().fillna(0) # prevent arithmetic operation error on "null"
    df_cds['Stock théorique final'] = df_cds_not_null['Stock d ouverture'] - df_cds_not_null['Volume de ventes'] + df_cds_not_null['qtt_manuelle_livraison_BL']
    
    # ecart CDS
    #df_cds_not_null.columns
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

    df_cds_not_null['mounth-year'] = pd.to_datetime(df_cds['Date'],format='%d-%m-%Y').dt.strftime("%m-%y")
    df_cds_not_null['day'] = pd.to_datetime(df_cds['Date'],format='%d-%m-%Y').dt.strftime("%d")
    df_cds_not_null['Différence'] = df_cds['Différence']
    
    df_cds['cumul vente'] = df_cds_not_null.groupby(['Site','Carburant','mounth-year'])['Volume de ventes'].cumsum()
    
    # écarts cumulee
    df_cds['cumul ecart'] = df_cds_not_null.groupby(['Site','Carburant','mounth-year'])['Différence'].cumsum()
    
    #df_cds_not_null.columns
    
    # % écarts cumulee
    is_zero_div = df_cds['cumul vente'] == 0
    df_cds['% cumul ecart vs vente'] = np.where(is_zero_div,0,df_cds['cumul ecart'] *1000/ df_cds['cumul vente'])
    
    df_cds = df_cds.merge(df_validation_journee,on=['Date','Site'],how='left')
    
    """ REGION LOOKUP """
    
    ref_directory = PROJECT_PATH+'B_data_processing/REF/ref_num_ss_region.xlsx'
    df_ref_region = pd.read_excel(ref_directory)
    
    df_cds = df_cds.merge(df_ref_region[['Site','Region']], on=['Site'],how='left')
    
    
    """"""         """"""
# column REAODERING    
    reod_col = ['Livraison Directe','index','Date', 'Site', 'Region', 'Carburant','Valider', 'Statut','Date/heure de synchronisation&nbsp;', 'Origine', 
               
               'qtt_manuelle_livraison_BL',
               'qtt_automatique_livraison_mesuree', 
               
               'Quantité automatique',
               'Ecarts catalogue livraison',
               'Ecarts pour 1000 catalogue livraison', 
                
               'Stock d ouverture',
               'Stock théorique final',
               'Stock réel final', 
               'Différence',
               
               'Volume de ventes',
               'Tests de pompe',
               
               'Ecart vs vente pour 1000',
               'cumul vente', 
               'cumul ecart',
               '% cumul ecart vs vente',
               'date_time']
    
    #format_date
    #df_cds['Date'] = df_cds['Date'].dt.strftime('%d/%m/%Y')

# EXCLUSION
    # exclude statut == "A saisir"
    df_cds = df_cds[df_cds['Statut']!='A saisir']
    
    
    # exclude minimum date
    df_cds['date_time'] = pd.to_datetime(df_cds['Date'],format="%d-%m-%Y")
    min_date = df_cds['date_time'].min()
    df_cds = df_cds[df_cds['date_time']>min_date]

    df_cds['Date'] = df_cds['date_time'].dt.strftime("%d/%m/%Y")

# COLUMN DROP
    df_cds = df_cds[reod_col].drop(['Livraison Directe','Valider','date_time','index','qtt_automatique_livraison_mesuree'],axis=1)    
   # df_cds['Date'] = df_cds['Date'].dt.strftime("%d-%m-%Y")
    #df_cds.dtypes
    
# GREP Livraison Directe
     #df_tmp_ld = df_volume_de_livraison[df_volume_de_livraison['Livraison Directe']==True]
    # LD
    try :
    #df_cds_tmp = df_cds.copy()
        df_volume_de_livraison['Date'] = df_volume_de_livraison['Date'].str.replace('-', '/')
        df_cds = df_cds.merge(df_volume_de_livraison[df_volume_de_livraison['Livraison Directe']==True],on=['Date','Site','Carburant'], how='left')
        #df_cds_tmp.to_excel("cds_temp.xlsx")
        #df_volume_de_livraison.to_excel("livraison.xlsx")
        df_cds = df_cds.drop(['qtt_automatique_livraison_mesuree','Livraison Directe'],axis=1)
        df_cds= df_cds.rename(columns={"qtt_manuelle_livraison_BL_y":"Livraison Directe","qtt_manuelle_livraison_BL_x":"qtt_manuelle_livraison_BL"}) # renaming
        
    except:
        pass

    # delete HEZAKA from prevalidation
    df_cds = df_cds[df_cds['Site']!="01025 - HEZAKA"]
    #df_cds_hezaka = run_cds_hezaka()
    
    # check data has value

    #hezaka_missing_values = count_missing_values(df_cds_hezaka,["Date","Date/heure de synchronisation&nbsp;"])
    
    # concat cds
    #df_cds = pd.concat([df_cds,df_cds_hezaka],ignore_index=True)
    
    #df_cds = df_cds[df_cds['Site']!="01025 - HEZAKA"]        
    # ADD extraction time
    df_cds["date_extract"] = datetime.datetime.now().strftime("%d/%m/%Y %H:%M:%S")

    # add a default date if date_synchro is missing
    df_cds['Date/heure de synchronisation&nbsp;'] = df_cds.apply(lambda x: x['date_extract'] if is_missing(x['Date/heure de synchronisation&nbsp;']) else x['Date/heure de synchronisation&nbsp;'] , axis=1)

    #cds_missing_values = count_missing_values(df_cds,["Date","Date/heure de synchronisation&nbsp;","date_extract"])    

    df_cds.to_excel(output_directory + "\cds_prevalidation.xlsx",index=False)
    print("[OK] -> CDS exported successfully ! ")


if __name__ == "__main__" :
    run_cds()

