"""
    orchestration
"""
import time
from obj.ClassScheduler import Scheduler
from obj.ClassBrowser import Browser

class Extraction:
    def __init__(self):
        self.scheduler = Scheduler()
        self.Browser = Browser
        
    def run_all(self,window_interval=60):
        try :
            print('-> download RUNNING !')
            
            start_time = time.time()
            self.scheduler.run_all(window_interval=window_interval)                            # download all data for last 60 day
            #self.scheduler.run_all(window_interval=60,interval_end="07/08/2023") # run interval update in precised end date 
            #self.scheduler.run_unique(window_interval=60, interval_end=None, module_name="vente_carburant", select_type=None, select_site=None)
            
            elapsed_time = time.time() - start_time
            
            print(f"Function took {elapsed_time:.4f} seconds to execute.")
        
        except :
            print("[x] -> failed on execution extraction !")
    
        
    def run_vente_carburant(self,window_interval=60):
        self.scheduler.run_vente_carburant(window_interval=window_interval)

    def run_vente_par_famille(self,window_interval=60):
        self.scheduler.run_vente_par_famille(window_interval=window_interval)