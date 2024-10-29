# -*- coding: utf-8 -*-
"""
@author: Andry-Harifetra
Created on Mon Feb 12 10:39:12 2024

    1) filter data (En cours)
    2) File split by region

"""
import pandas as pd
import os

from G_GLOBAL.variable import PROJECT_PATH, REMOTE_PATH

input_path = PROJECT_PATH+r'B_data_processing/OUTPUT/'
# EXPLICIT EXCEL OUTPUT PATH
#output_path = PROJECT_PATH+r'F_post_traitement/OUTPUT/'
output_path = REMOTE_PATH

###### 0) delete output
def run_data_filtering():
# Get a list of all files in the directory
    file_list = os.listdir(output_path)
    
    # Iterate through the list and delete each file
    for file_name in file_list:
        file_path = os.path.join(output_path, file_name)
        try:
            os.remove(file_path)
            print(f"Deleted: {file_path}")
        except Exception as e:
            print(f"Error deleting {file_path}: {e}")
    
    print("All files deleted.")
    
    
    ###### 1) Reorder column as need 
    
    
    #def separate_reg :
    df_prevalid_cds = pd.read_excel(input_path+'cds_prevalidation.xlsx').drop('date_extract',axis=1)
    df_prevalid_cds = df_prevalid_cds[df_prevalid_cds["Statut"]=="En cours"]
    df_prevalid_cds['Date'] = pd.to_datetime(df_prevalid_cds['Date'],format="%d/%m/%Y")
    df_prevalid_cds['Date'] = df_prevalid_cds['Date'].dt.strftime("%d/%m/%Y")
    
    
    # reaorder column
    reod_col = ['Date', 'Site', 'Region', 'Carburant', 'Statut','Date/heure de synchronisation&nbsp;', 'Origine', 
                     
               'qtt_manuelle_livraison_BL', 
               
               'Quantité automatique',
               'Ecarts catalogue livraison',
               'Ecarts pour 1000 catalogue livraison', 
               #livraison directe LD
               'Livraison Directe',
               'Stock d ouverture',
               'Stock théorique final', 
               'Stock réel final', 
               'Volume de ventes',
               'Différence',
               
               
               'Tests de pompe',
               
               'Ecart vs vente pour 1000',
               'cumul vente', 
               'cumul ecart',
               '% cumul ecart vs vente']
    
    """
    true order : Date	Site	Region	Carburant	Statut	Date/heure de synchronisation&nbsp;	Origine	 Quantité BL 	 Quantité Mesuré 	 Ecarts 	 Ecarts pour 1000  	 Stock d ouverture 	 Stock théorique final 	 Stock réel final 	 Volume de ventes 	 Différence 	 Tests de pompe 	 Ecart vs vente pour 1000 	  cumul vente 	 cumul ecart 	 % cumul ecart vs vente 
    
    """
    
    ###### 2) Split dataframe to file by region
    
    # data export
    df_prevalid_cds = df_prevalid_cds[reod_col]
    dfs_prevalid_cds = {region: group for region, group in df_prevalid_cds.groupby('Region')}
    
    # Exporter chaque DataFrame dans un fichier Excel
    for region, df_region in dfs_prevalid_cds.items():
        # EXPORTER REGION
        excel_filename = f"{output_path}{region}.xlsx"
        df_region.to_excel(excel_filename, index=False)
    
        # METTRE EN FORME le fichier excel
        print(f"DataFrame pour la région {region} exporté en {excel_filename}")


if __name__=="__main__" :
    run_data_filtering()