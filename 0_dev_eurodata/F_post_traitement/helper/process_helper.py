# -*- coding: utf-8 -*-
"""
Created on Mon Feb 12 15:27:42 2024
@author: Andry-Harifetra

    * execute entire script

"""

import subprocess

# Define the path to the Python script you want to 

def run_sub_precess(task_path,task_name):
    try:
        subprocess.run(["python", task_path], check=True)
        
        print(f"> {task_name} executed successfully !")
        
    except subprocess.CalledProcessError as e:
        print(f"> {task_name}  failed error : {e}")
        
if __name__ =="__main__" :
    data_filtering = "C:/Users/datamanager1/0_dev_eurodata/F_post_traitement/data_filtering.py"
    run_sub_precess(data_filtering,'data_filtering')
    