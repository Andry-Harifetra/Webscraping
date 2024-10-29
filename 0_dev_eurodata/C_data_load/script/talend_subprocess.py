# -*- coding: utf-8 -*-
"""
Created on Thu Oct 12 14:42:19 2023

@author: Andry-Harifetra
"""
import subprocess


def run_vente_carburant_integration():
    # Replace 'path/to/your/talend_job_script.bat' with the actual path to your exported script.
    talend_job_script = r'C:/Users/datamanager1/0_dev_eurodata/C_data_load/job/vente_carburant/vente_carburant/vente_carburant_run.bat'


    # Replace 'path/to/your/working_directory' with the actual working directory.
    working_directory = r'C:/Users/datamanager1/0_dev_eurodata/C_data_load/job/vente_carburant/vente_carburant'

    try:
        # Run the batch script from the specified working directory
        result = subprocess.run(talend_job_script, shell=True, cwd=working_directory, check=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        
        # Print the standard output and standard error, if needed
        print("Standard Output:")
        print(result.stdout.decode('utf-8'))
        
        print("Standard Error:")
        print(result.stderr.decode('utf-8'))
        
        print("Batch script executed successfully.")
    except subprocess.CalledProcessError as e:
        print(f"Error running batch script: {e}")

def run_all_integration():
    run_vente_carburant_integration()
    print('[DONE] all integration executed !')
    
    
if __name__ == "__main__" :
    run_vente_carburant_integration()