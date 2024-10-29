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

"""
    XLSX PROCESSING
"""


def run_cds_hezaka ():
    station_fuel_pos = ["01025 - HEZAKA"] # list of automated site
    print('[i] : CDS_hezaka is runnning !')
    input_directory = PROJECT_PATH+'B_data_processing\INPUT'
    output_directory = PROJECT_PATH+'B_data_processing\OUTPUT'
    
    # load cds_hezaka :
    cds = pd.read_excel(input_directory+"\cds.xlsx")
    cds["Date comptable"] = pd.to_datetime(cds["Date comptable"],format="%d-%m-%Y")
    cds.rename(columns={"Date comptable":"Date"}, inplace=True)
    
    # FILTER - on fuelpos
    #cds_hezaka = cds[cds['Site'].isin(station_fuel_pos)].copy()
    cds_hezaka = cds.copy()
    
    # col drop :
    cds_hezaka.drop(["Date/ Heure début période",
                     "Date/ Heure fin période",
                     "Groupe de cuve"],
                     inplace=True,
                     axis=1)

    # synchro done on j +1
    cds_hezaka["Date/heure de synchronisation&nbsp;"] = cds_hezaka.apply(lambda row : row["Date"] + datetime.timedelta(days=1) if row["Site"] in station_fuel_pos else 0,axis=1)


    # lookup
        # catalogue de livraison
    catalogue_livraison = pd.read_excel(input_directory +'/catalogue_livraison.xlsx')
    df_catalogue_livraison = catalogue_livraison[catalogue_livraison['Site'].isin(station_fuel_pos)].copy()
    
        # tag livraison directe
    df_catalogue_livraison['Information complémentaire'] = df_catalogue_livraison['Information complémentaire'].astype(str)
    df_catalogue_livraison['Livraison Directe'] = 0
    df_catalogue_livraison['Livraison Directe'] = df_catalogue_livraison.apply(lambda row: row['Quantité manuelle'] if row['Information complémentaire'].lower().startswith('ld') else 0,axis=1)
    
    df_catalogue_livraison = df_catalogue_livraison.groupby(['Site','Date comptable','Carburant']).agg({'Quantité automatique':'sum','Quantité manuelle':'sum','Livraison Directe':'sum'}).reset_index()
    df_catalogue_livraison['Ecarts catalogue livraison'] = df_catalogue_livraison['Quantité automatique'] - df_catalogue_livraison['Quantité manuelle']
    df_catalogue_livraison['Ecarts pour 1000 catalogue livraison'] = 1000 * df_catalogue_livraison['Ecarts catalogue livraison'] / df_catalogue_livraison['Quantité manuelle']
    df_catalogue_livraison.rename(columns={'Date comptable': 'Date'}, inplace=True)
    df_catalogue_livraison.drop(["Quantité automatique"],axis=1,inplace=True)
    #df_catalogue_livraison['Date'] = df_catalogue_livraison['Date'].dt.strftime('%d-%m-%Y')
        # merge livraison - not Direct
    cds_hezaka = cds_hezaka.merge(df_catalogue_livraison, on=["Site", "Carburant","Date"])
        
        # lookup region
    ''' REGION LOOKUP '''
    ref_directory = PROJECT_PATH+'B_data_processing/REF/ref_num_ss_region.xlsx'
    df_ref_region = pd.read_excel(ref_directory)
    
    cds_hezaka = cds_hezaka.merge(df_ref_region[['Site','Region']], on=['Site'],how='left')
    
    '''         '''
        
        
    # col add
    cds_hezaka["Statut"] = "Validée"
    cds_hezaka["Origine"] = "FuelPOS"
    cds_hezaka ["cumul vente"] = 0
    cds_hezaka["cumul vente"] = (cds_hezaka["Différence cumulée"] * 1000)/ cds_hezaka["Différence Vs ventes cumulées (‰)"] 
    
    # col rename
    col_rename = {"Volume de ventes":"Volume de ventes",
              "Volume livré":"Quantité automatique",
              "Stock d'ouverture":"Stock d ouverture",
              "Stock théo final":"Stock théorique final",
              "Difference":"Différence",
              "Test pompes":"Tests de pompe",
              "Quantité manuelle":"qtt_manuelle_livraison_BL",
              "Différence Vs ventes (‰)":"Ecart vs vente pour 1000",
              "Différence cumulée":"cumul ecart",
              "Différence Vs ventes cumulées (‰)":"% cumul ecart vs vente"}
    
    cds_hezaka.rename(columns=col_rename,inplace=True)
    
    # col reorder
    col_order = ["Date","Site","Region","Carburant","Statut","Date/heure de synchronisation&nbsp;","Origine","qtt_manuelle_livraison_BL","Quantité automatique","Ecarts catalogue livraison","Ecarts pour 1000 catalogue livraison","Stock d ouverture", "Stock théorique final","Stock réel final",  "Différence", "Volume de ventes","Tests de pompe","Ecart vs vente pour 1000","cumul vente","cumul ecart","% cumul ecart vs vente", "Livraison Directe"]
    cds_hezaka = cds_hezaka[col_order]
    
    # cast
    cds_hezaka["Date"] = cds_hezaka["Date"].dt.strftime('%d/%m/%Y')
    cds_hezaka["Date/heure de synchronisation&nbsp;"] = pd.to_datetime(cds_hezaka["Date/heure de synchronisation&nbsp;"])
    cds_hezaka["Date/heure de synchronisation&nbsp;"] = cds_hezaka["Date/heure de synchronisation&nbsp;"].dt.strftime('%d/%m/%Y %H:%M:%S')
    
    # export
    cds_hezaka.to_excel(output_directory + "\cds_prevalidation_hezaka.xlsx",index=False)
    print("[OK] -> CDS hezaka done ! ")
    return cds_hezaka
    

if __name__ == "__main__" :
    run_cds_hezaka()

