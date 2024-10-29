# -*- coding: utf-8 -*-
"""
Created on Wed Sep  6 11:38:11 2023

Target : file converter (file read exeption handling)

@author: Andry-Harifetra
"""

import os
import  aspose.cells 
from aspose.cells import Workbook
from G_GLOBAL.variable import PROJECT_PATH

def run_converter():
    input_directory = PROJECT_PATH+r'A_data_extraction/OUTPUT/'
    output_directory = PROJECT_PATH+r'B_data_processing/INPUT/'
    
    # List all files in the directory
    file_list = os.listdir(input_directory)
    
    # Iterate through the files
    for filename in file_list:
        if os.path.isfile(os.path.join(input_directory, filename)):
            workbook = Workbook(input_directory+filename)
            workbook.save(output_directory+filename)
            
            print(f'File: {filename}')

    print("[!] conversion done !")
    
if __name__ == '__main__' :
    run_converter()