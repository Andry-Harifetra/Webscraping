"""
Target : Pipelline scheduling

"""

#import time
from datetime import datetime, timedelta
from obj.ClassPipelline import Pipelline
#first_pipe_livr = Pipelline()    # browser instance -> LOG SSL before resuming

"""
    CLASS - SCHEDULER
    set the date and module
"""

class Scheduler :
    _instance_count = 0  # Class-level variable to count instances
    
    def __init__(self,window_interval=7):
        self.window_interval = window_interval  # 7 day moving interval ! by default
        self.pipelline = Pipelline()
        Scheduler._instance_count += 1  # Increment the count on instance creation
                    # create a pipelline

    def refresh_tab(self):
        self.pipelline.refresh_tab()

    @classmethod
    def get_instance_count(cls):
        return cls._instance_count  # Class method to retrieve the count
    
    
    def get_today(self):
        # return today in format dd/mm/yyy
        current_date = datetime.now()
        return current_date.strftime("%d/%m/%Y")

    def get_interval_start(self,window_interval=None,interval_end=None):
        if window_interval == None: 
            window_interval = self.window_interval # set default interval if not explicit
            
        if interval_end == None:
            date_begin = datetime.now() - timedelta(days=window_interval)
        else:
            date_begin = datetime.strptime(interval_end, "%d/%m/%Y") - timedelta(days=window_interval-1)
            
        return date_begin.strftime("%d/%m/%Y")
    
    def get_interval_end(self,window_interval=None,interval_end=None):
        # use today as interval end if not explicit
        if interval_end==None:
            return self.get_today()
        else :
            return interval_end
    
    
    def run_unique(self,window_interval,interval_end,module_name,select_type,select_site):
        date_begin = self.get_interval_start(window_interval=window_interval,interval_end=interval_end)
        date_end   = self.get_interval_end(interval_end=interval_end)
        
        self.pipelline.download_module(date_begin = date_begin, 
                                           date_end = date_end, 
                                           module_name = module_name,
                                           select_type = select_type,
                                           select_site = select_site) # select "tous" (tout les statut)
# main method
    def run_all(self,window_interval=None,interval_end=None):
        
        date_begin = self.get_interval_start(window_interval=window_interval,interval_end=interval_end)
        
        date_end   = self.get_interval_end(interval_end=interval_end)
        
        print("interval begin > "+ date_begin)
        print("interval end   > "+ date_end)
        
# full pipelline
        # ---- > VALIDATION JOURNEE

        self.pipelline.download_module(date_begin=date_begin, 
                                       date_end=date_end,
                                       module_name="validation_journee",
                                       select_type= "Tous") # select "tous" (tout les statut)

        # ---- > STOCK
        self.pipelline.download_module(date_begin = date_begin,
                                        date_end =  date_end,
                                        module_name= "stock_carburant",  # module
                                        select_site= "00000 - Tous", # set filter to all site
                                        select_type= "00000 - Tous") # set filter to all type (carburant)

        # ---- > LIVRAISON
        self.pipelline.download_module(date_begin = date_begin,date_end =  date_end,
                                       module_name= "livraison_carburant") # module
                                                            # select "tous" (tout les statut)

        # ---- > VENTE CARBURANT
        self.pipelline.download_module(date_begin  = date_begin,date_end   =  date_end,
                                       module_name= "vente_carburant") 
      
        # ---- > ENCAISSEMENT
        #self.pipelline.download_module(date_begin  = date_begin,date_end =date_end,
        #                               module_name= "encaissement")                                                    

        # ---- > CDS
        self.pipelline.download_module(date_begin  = date_begin,date_end = date_end,
                                       select_site= "00000 - Tous", 
                                       module_name= "cds")  
        # ---- > CATALOGUE LIVRAISON
        self.pipelline.download_module(date_begin  = date_begin,date_end = date_end,
                                       module_name= "catalogue_livraison") 
    
        # ---- > VENTE PAR FAMILLE
        #self.pipelline.download_module(date_begin  = date_begin,date_end = date_end,
        #                               module_name= "vente_par_famille")

# facultative method        
    def run_vente_carburant(self,window_interval=None,interval_end=None):
        date_begin = self.get_interval_start(window_interval=window_interval,interval_end=interval_end)
        
        date_end   = self.get_interval_end(interval_end=interval_end)
        self.pipelline.download_module(date_begin  = date_begin,date_end   =  date_end,
                                           module_name= "vente_carburant") 
    
    def run_vente_par_famille(self,window_interval=None,interval_end=None):
        date_begin = self.get_interval_start(window_interval=window_interval,interval_end=interval_end)
        
        date_end   = self.get_interval_end(interval_end=interval_end)
        self.pipelline.download_module(date_begin  = date_begin,date_end   =  date_end,
                                           module_name= "vente_par_famille") 
        
    def __del__(self):
        print('scheduler instance deleted !')
        Scheduler._instance_count -= 1  # Decrement the count on instance deletion

##############################################################################


#************************************************
#
#      ADVANCED SETTING FOR EACH PIPELLINE
#
#************************************************
'''
# ---- > VALIDATION DES JOURNEES
first_pipe_livr.download_module(date_begin = "01/06/2023",
                                date_end =   "31/08/2023",
                                module_name= "validation_journee", # module
                                select_type= "Tous")                     # select "tous" (tout les statut)

# ---- > STOCK
first_pipe_livr.download_module(date_begin = "01/06/2023",
                                date_end =   "31/08/2023",
                                module_name= "stock_carburant",  # module
                                select_site= "00000 - Tous", # set filter to all site
                                select_type= "00000 - Tous") # set filter to all type (carburant)

# ---- > LIVRAISON
first_pipe_livr.download_module(date_begin = "01/06/2023",
                                date_end =   "31/08/2023",
                                module_name= "livraison_carburant") # module
                                                    # select "tous" (tout les statut)

# ---- > VENTE CARBURANT
first_pipe_livr.download_module(date_begin = "01/06/2023",
                                date_end =   "31/08/2023",
                                module_name= "vente_carburant") # module
                                                     # select "tous" (tout les statut)

'''
#************************************************
#
#                        LOOP
#
#************************************************

"""
# Available schedule
seq = [
       "livraison_carburant",
       "vente_carburant",
       "validation_journee",
       "stock_carburant"
       ]

# Loop sequence - daily routing
for module in seq :
    first_pipe_livr.download_module(date_begin = "01/07/2023",
                                    date_end =   "31/08/2023",
                                    module_name = module)
"""           