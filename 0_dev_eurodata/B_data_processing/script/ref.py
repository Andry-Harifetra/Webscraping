# -*- coding: utf-8 -*-
"""
Created on Thu Jul  4 15:23:20 2024

@author: Andry-Harifetra
"""
import pandas as pd

def get_region(station):
    
    try:
        df_region = pd.read_excel("REF/ref_num_ss_region.xlsx")
        region = df_region.loc[df_region['Site'] == station, 'Region'].values[0]
        
        return region
    except IndexError:
        raise ValueError(f"station : {station} not find in ref !")


if __name__ =="__main__" :
    print(get_region("00001 - ALAOTRA"))