# -*- coding: utf-8 -*-
"""
Created on Thu Mar 21 09:51:00 2024

    MAJOR v7 :
        + filter "LD-"
        + add new column LD (livraison directe)
        + PATH management -> relative path

    MAJOR v8 :
        + add sql_server data management & integration
        + schedule
        MINOR v8.1 :
            + default data_extraction fill if nan
        MINOR v8.2 :
            + missing_value management

@author: Andry-Harifetra
"""

import sys,easygui,time
from datetime import datetime,timedelta
import traceback

# append path
sys.path.append("A_data_extraction")
sys.path.append("B_data_processing")
sys.path.append("C_data_load")
sys.path.append("F_post_traitement")
sys.path.append("G_BLOBAL")

# execution scheduling + devTool refresh
def wait_execution(time_execute, scheduler):
    while True:
        current_time = datetime.now().strftime("%H:%M:%S")
        current_minute = datetime.now().minute
        
        if current_time in time_execute:
            print("Schedule trigger")
            break
        elif current_minute in [30,50]:  # refresh
            print(f"Refreshing tab at minute {current_minute}")
            scheduler.refresh_tab()
            time.sleep(60)  # Avoid multiple refreshes within the same minute
        else:
            time.sleep(1)  # Check every second for more precise timing

#
#   MAIN
#

from A_data_extraction.obj.ClassScheduler import Scheduler
iteration = 0

interval_end = "03/07/2024"
interval_start = "01/12/2023"

while datetime.strptime(interval_end,"%d/%m/%Y") >= datetime.strptime(interval_start,"%d/%m/%Y"):
    #wait_execution(["09:15:00", "13:15:00", "15:15:00"])
    
    print(f"------ Extraction Start : ({iteration}nth iteration) -----")
    try:
        # RUN EXTRACT
        if not 'has_run' in locals():
            print("has_run n'est pas défini. (oto_bot_created !)")
            scheduler = Scheduler()
            # Show a yes/no question box and get the user's response
            response = easygui.ynbox("Continuer ?", "LOGIN SSL")
            if response:
                print("[OK] TASK CONTINUE in 5s")
                has_run = True
                time.sleep(5)
            else:
                del scheduler
                del has_run
                print("[X] TASK ABORTED")

        scheduler.run_all(window_interval=31,interval_end=interval_end)
#scheduler.run_unique(window_interval=20,interval_end="09/09/2024",module_name="livraison_carburant",select_site= "00000 - Tous",select_type= "00000 - Tous")

        # RUN TRANSFORMATION
        from B_data_processing.script import cds, converter, data_cast
        converter.run_converter()
        cds.run_cds()
        data_cast.run_cast()  # bug sur la lecture des données cds
   
        # RUN LOAD
        from C_data_load.script.sql_server import load as sql_load
        sql_load()

        # RUN EXCEL EXPORT
        #from F_post_traitement.data_filtering import run_data_filtering
        #from F_post_traitement.excel_formatting import run_excel_formating

        #run_data_filtering()
        #run_excel_formating()
     
    except Exception as e:
        print(f"Error: {str(e)}")
        traceback.print_exc()
        
    finally:
        iteration += 1
        finished_time = datetime.now().strftime("%H:%M:%S")
        print(f"\n{iteration} Finished at {finished_time}, wait next execution !")
        
        interval_end_date = datetime.strptime(interval_end, "%d/%m/%Y")
        interval_end_date -= timedelta(days=30)
        
        # Convert back to string format
        interval_end = interval_end_date.strftime("%d/%m/%Y")
        
        time.sleep(120)
        #wait_execution(["09:15:00", "13:15:00", "15:15:00"],scheduler)

