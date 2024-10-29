"""
Browser management for MODULE DOWNLOAD
Target : Browser controle for specific pipelline

"""
from obj.ClassBrowser import Browser
import os
import time

class Pipelline:
    #_browser_count = Browser.get_instance_count()
    
    def __init__(self):
        self.driver = Browser()
        self.driver.go_to_edcms()
        self.download_directory = self.driver.download_directory
        self.state = "init"
    
    def refresh_tab(self):
        self.driver.refresh_tab()
        
# h> add file remove and replace if file already existed
    def handle_export(self):
        
        download_timeout = 180  # seconds
        # delete if file already exist
        
        # track export.xlsx file
        downloaded_file_path = os.path.join(self.download_directory, "export.xlsx")
        start_time = time.time()
        
        while time.time() - start_time < download_timeout:
            if os.path.exists(downloaded_file_path):
                break
            time.sleep(1)
        
        new_file_name = os.path.join(self.download_directory, self.state+".xlsx")
        
        try :
            os.remove(new_file_name)
            print("Duplicated file deleted !")
        except :
            print("no duplicated file ! ")
        # Rename the downloaded file (if it exists)
        finally :
            if os.path.exists(downloaded_file_path):
                os.rename(downloaded_file_path, new_file_name)
                print("[OK] file renamed ! ")# -*- coding: utf-8 -*-
            else:
                print("[X] file not found !")

    def call_method_by_string(self,class_instance, method_name):
        method = getattr(class_instance, method_name, None)
        if callable(method):
            method()
        else:
            print("[X] -> Method not found")

    # call module by it's name
    def download_module(self,date_begin,date_end,module_name,select_site=None,select_type=None):
        self.state = module_name            # set state

        try :

            self.driver.home()                     # attempt to reach Home
            self.driver.wait_complete_load()
            self.driver.home_reached()             # check if home is reached
            print("[ok] home reached !")
            
        except :
            print("[x] Go to home failed !")
            #self.driver.new_tab()           # open new tab every module download
            self.driver.go_to_edcms()        # go to the main page
            self.driver.wait_complete_load() # wait complete load
            self.driver.log_in()             # complete login
            self.driver.wait_complete_load()
            
        finally :
            
            # specify module methode to apply 
            self.call_method_by_string(self.driver,module_name)
            
            # ! Download all status
            if select_type != None :
                self.driver.set_select(select_Id="A26", dropdown_target=select_type) # status select "Tous"
            
            if select_site != None :
                self.driver.set_select(select_Id="A25", dropdown_target=select_site) # status select "Tous"
            
            self.driver.wait_complete_load()
            
            # module CDS has a different btn_id for date validate
            if module_name=="cds" :#CDS exeption btn
                self.driver.set_date(date_begin = date_begin, date_end = date_end,validate_btn_id="#A12")
                print("[OK] date is set [cds]")
            else :
                self.driver.set_date(date_begin = date_begin, date_end = date_end)
            
            self.driver.wait_complete_load()
            #self.driver.move_downloaded_file # to improve
            self.driver.start_download()
            
        # rename
            self.handle_export()    # file existance checkout > 60s timeout
            
            print(f"[OK] -> {self.state} downloaded !")
            self.state="iddle"
        
'''
# some unit test
brozer = Browser()
brozer.go_to_edcms()
brozer.log_in()
brozer.go_to_vente_carburant()
brozer.set_date(date_begin="11/08/2023", date_end="15/08/2023")
brozer.start_download()
'''