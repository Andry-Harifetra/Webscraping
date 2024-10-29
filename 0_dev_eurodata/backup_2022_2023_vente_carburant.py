'''
BACKUP DATA from 2022 to 2023 by decrement way

(vente_carburant)

'''


# APPEND MODULE DIRECTORY TO PATH
import sys
import easygui
import time
import random
from datetime import datetime, timedelta

sys.path.append("C:/Users/datamanager1/0_dev_eurodata/A_data_extraction")  
sys.path.append("C:/Users/datamanager1/0_dev_eurodata/B_data_processing")
sys.path.append("C:/Users/datamanager1/0_dev_eurodata/C_data_load")

# RUN EXTRACTION
# from A_data_extraction.data_extraction import Extraction

from A_data_extraction.obj.ClassScheduler import Scheduler

# INIT, 17/12
i=0
start_date = datetime.strptime("31/01/2024", "%d/%m/%Y")

# minimum day to get historiq
while(start_date>datetime.strptime("01/10/2023", "%d/%m/%Y")) :
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
        
        scheduler.run_vente_carburant(window_interval=30, interval_end = start_date.strftime("%d/%m/%Y"))
        
        # RUN TRANSFORMATION
        from B_data_processing.script import converter, data_cast #,cds
        
        converter.run_converter()
        #cds.run_cds()
        data_cast.run_cast() # bug on cds data read
    
        # RUN LOAD
        from script.talend_subprocess import run_all_integration#, run_vente_carburant_integration
        run_all_integration() 
        # Duplicate entry '00046 - AMBANJA-2023-09-26-00002 - SP-1-1-20230927' for key 'vente_carburant.PRIMARY'
        # run_vente_carburant_integration()
    
    except Exception:
        print(Exception)
        
    finally :
        i+=1
        #·rand_sleep = random.randint(1500, 1620) sleep for 30minutes
        rand_sleep = random.randint(60, 120) # [number of second]
        
        print(">>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<")
        print(f"system sleeping for {rand_sleep/60} minutes !")
        
## DECREMENT THE DATE        
        start_date -= timedelta(days=29) # decrement the date
        
        time.sleep(rand_sleep)

print("[OK] BACKUP DONE !")