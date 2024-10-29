# APPEND MODULE DIRECTORY TO PATH
"""
    MAJOR v7 :
        + filter "LD-"
        + add new column LD (livraison directe)
        + PATH management -> relative path
    MAJOR v8 :
        + add sql_server data management & integration 
"""

import sys
import easygui
import time
import random

sys.path.append("A_data_extraction")
sys.path.append("B_data_processing")
sys.path.append("C_data_load")
sys.path.append("F_post_traitement")
sys.path.append("G_BLOBAL")

#from G_GLOBAL.variable import PROJECT_PATH

# RUN EXTRACTION
# from A_data_extraction.data_extraction import Extraction

from A_data_extraction.obj.ClassScheduler import Scheduler
i=0

while(True) :
    print(f">>>>>>>> Extract : ({i}) <<<<<<<<<<<<")
    
    try :
        # RUN EXTRACT
        if not 'has_run' in locals():    
            print("has_run is not defined. (oto_bot_created !)")
            scheduler = Scheduler()
            #sc = Scheduler()
            
            response = easygui.ynbox("Continue ?", "LOGIN SSL") # Show a yes/no question box and get the user's response
            if response :
                print("[OK] -> TASK CONTINUE in 5s")
                has_run = True
                time.sleep(5)
                
            else :
                del scheduler
                del has_run
                print("[X] -> TASK ABORTED ")
        
        scheduler.run_all(window_interval=31)
        
        # RUN TRANSFORMATION
        from B_data_processing.script import cds, converter, data_cast
        
        converter.run_converter()
        cds.run_cds()
        data_cast.run_cast() # bug on cds data read

        # RUN LOAD
        from C_data_load.script.sql_server import load as sql_load
        sql_load()
        
        #from script.talend_subprocess import run_all_integration#, run_vente_carburant_integration
        #run_all_integration() 
        # Duplicate entry '00046 - AMBANJA-2023-09-26-00002 - SP-1-1-20230927' for key 'vente_carburant.PRIMARY'
        #run_vente_carburant_integration()
        
    finally :
        # split data  # format Excel
        from F_post_traitement.data_filtering import run_data_filtering
        from F_post_traitement.excel_formatting import run_excel_formating
        run_data_filtering()
        run_excel_formating()
        
        # sleep before next iteration
        i+=1
        rand_sleep = random.randint(1500, 2400)
        print(">>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<")
        print(f"system sleeping for {rand_sleep/60} minutes !")
        time.sleep(rand_sleep)

from B_data_processing.script import cds, converter, data_cast
converter.run_converter()
cds.run_cds()
data_cast.run_cast() # bug on cds data read