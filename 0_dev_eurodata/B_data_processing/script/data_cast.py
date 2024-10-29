# -*- coding: utf-8 -*-
"""
Created on Mon Sep 25 15:20:42 2023

Target : Type cast and datatype normalisation 

@author: Andry-Harifetra
"""
import pandas as pd
import os
from G_GLOBAL.variable import PROJECT_PATH

input_directory  = PROJECT_PATH+r'B_data_processing/INPUT/'
output_directory = PROJECT_PATH+r'B_data_processing/INPUT/'


str_col =  ['Site','Carburant','Date/heure de synchronisation&nbsp;','Information complémentaire']
date_col = ['Date','Date comptable']                         # list all date column to cast
dec_col  = ['Prix unitaire','Prix unitaire','Montant','Quantité manuelle','Quantité automatique'] # list all decimal column to cast

# cast date
def date_cast(df_date):
    df_date = df_date.dt.strftime('%d-%m-%Y')
    return df_date

# decimal / float cast
def decimal_cast(df_decimal):
    df_decimal = df_decimal.str.replace(',', '.').str.replace(' ', '').str.strip().str.replace(r'\s+', '', regex=True)
    df_decimal = df_decimal.astype(float)
    return df_decimal

def str_cast(df_str):
    df_str = df_str.astype(str)
    return df_str

def file_cast(df):
    for column in df.columns :
        print(f'column -{column}')
        
        if column in date_col :
            df[column] = date_cast(df[column])
            #print(f"{column} casted as date")
        elif column in dec_col :
            df[column] = decimal_cast(df[column])
            #print(f"{column} casted as decimal")
        
        elif column in str_col :
            df[column] = str_cast(df[column])
            
        else : 
            print('... no cast !')
    
    return df


def run_cast():
    # List all files in the directory
    file_list = os.listdir(input_directory)
    
    # Iterate through the files
    for filename in file_list:
        try :
            df = pd.read_excel(input_directory+filename)
            df = file_cast(df)
            
            df.to_excel(output_directory+filename,header=True,index=False)
            
            print(f'File: {filename}')
        except:
            print(f"error while casting {filename}")
            
    print("[!] cast done !")


if __name__ == '__main__' :
    run_cast()