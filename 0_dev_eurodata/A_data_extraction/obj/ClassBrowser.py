"""
Custom Browser Driver object fit for EDCMS SITE
Target : 

"""
from credentials import login_str, password_str #LOAD credentials

from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains

from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support.ui import Select
from selenium.webdriver.support import expected_conditions as EC

from G_GLOBAL.variable import PROJECT_PATH,R_PROJECT_PATH,DRIVER_PATH
#PROJECT_PATH+r"A_data_extraction/OUTPUT"
# dowload folder set
#from selenium.webdriver.chrome.service import Service as ChromeService  # not used

class Browser:
    
    _instance_count = 0
    
    def __init__(self):
        # set on user change
        self.download_directory = R_PROJECT_PATH+r"\A_data_extraction\OUTPUT"
        
        self.chromeOptions = webdriver.ChromeOptions()
        self.prefs = {"download.default_directory" : self.download_directory}
        self.chromeOptions.add_experimental_option("prefs",self.prefs)
        self.chromeOptions.binary_location = DRIVER_PATH
        
        ## stability option
        self.chromeOptions.add_argument('--no-sandbox')
        self.chromeOptions.add_argument('--disable-dev-shm-usage')
        self.chromeOptions.add_argument('--disable-gpu')
        self.chromeOptions.add_argument('--remote-debugging-port=9222')  # Ensure no conflicts with other ports

        
        self.driver = webdriver.Chrome(options=self.chromeOptions)
        self.driver.maximize_window()
        Browser._instance_count+=1
                
    @classmethod
    def get_instance_count(cls):
        return cls._instance_count  # Class method to retrieve the count
        
    def wait_complete_load(self):
        WebDriverWait(self.driver, 120,poll_frequency=5000).until(lambda driver: self.driver.execute_script('return document.readyState') == 'complete')
        
    def go_to_edcms(self):
        self.driver.get('https://blueedcms.eurodata.fr/edcms/')
    
    # create new tab and move focus
    def new_tab(self):
        self.driver.switch_to.window(self.driver.window_handles[0])
        self.driver.execute_script("window.open('');")
        # Switch to the new tab
        self.driver.switch_to.window(self.driver.window_handles[1])
    
    def log_in(self):
        element_id = "tzA4"
        element_visible = EC.visibility_of_element_located((By.ID, element_id))
        WebDriverWait(self.driver, 10).until(element_visible)
        
        login = self.driver.find_element(By.ID,"tzA4")   #login
        login.click()
        ActionChains(self.driver).send_keys(login_str).perform() #fill username
        #password
        pswrd = self.driver.find_element(By.ID,"A6")     #login
        pswrd.click()
        ActionChains(self.driver).send_keys(password_str).perform() #fill password
        ActionChains(self.driver).key_down(Keys.ENTER).perform() #PRESS ENTER
        self.driver.implicitly_wait(10)
         
# MODULE LIST
    def home(self):
        self.click_on_selector('a[title="Home"]')

    def home_reached(self):
        # throw error when button can't be click
        self.click_on_selector('#accordion > ul > li:nth-child(9) > div')

    def livraison_carburant(self):
        self.click_on_selector("#accordion > ul > li:nth-child(4) > div")    
        self.click_on_selector("#accordion > ul > li:nth-child(4) > ul > li:nth-child(3) > div") # declaratio act
        self.click_on_selector("#accordion > ul > li:nth-child(4) > ul > li:nth-child(3) > ul > li:nth-child(2) > div") # act carb
        self.click_on_selector("#accordion > ul > li:nth-child(4) > ul > li:nth-child(3) > ul > li:nth-child(2) > ul > li:nth-child(2) > a") # act carb
    
    def vente_carburant(self):
        self.click_on_selector("#accordion > ul > li:nth-child(4) > div")    
        self.click_on_selector("#accordion > ul > li:nth-child(4) > ul > li:nth-child(3) > div") # declaratio act
        self.click_on_selector("#accordion > ul > li:nth-child(4) > ul > li:nth-child(3) > ul > li:nth-child(2) > div") # act carb
        self.click_on_selector("#accordion > ul > li:nth-child(4) > ul > li:nth-child(3) > ul > li:nth-child(2) > ul > li:nth-child(4) > a") # act carb
  
    def validation_journee(self):
        self.click_on_selector("#accordion > ul > li:nth-child(4) > div")
        self.click_on_selector("#accordion > ul > li:nth-child(4) > ul > li:nth-child(3) > div") # declaratio act
        self.click_on_selector("#accordion > ul > li:nth-child(4) > ul > li:nth-child(3) > ul > li:nth-child(1) > a") # validation d'activité
    
    def stock_carburant(self):
        self.click_on_selector("#accordion > ul > li:nth-child(4) > div")    
        self.click_on_selector("#accordion > ul > li:nth-child(4) > ul > li:nth-child(3) > div") # declaration act
        self.click_on_selector("#accordion > ul > li:nth-child(4) > ul > li:nth-child(3) > ul > li:nth-child(2) > div") # act carb
        self.click_on_selector("#accordion > ul > li:nth-child(4) > ul > li:nth-child(3) > ul > li:nth-child(2) > ul > li:nth-child(1) > a") # stock
    
    def encaissement(self):
        self.click_on_selector("#accordion > ul > li:nth-child(4) > div")   
        self.click_on_selector("#accordion > ul > li:nth-child(4) > ul > li:nth-child(3) > div") # declaratio act
        self.click_on_selector("#accordion > ul > li:nth-child(4) > ul > li:nth-child(3) > ul > li:nth-child(3) > div") # traitement du jour
        self.click_on_selector("#accordion > ul > li:nth-child(4) > ul > li:nth-child(3) > ul > li:nth-child(3) > ul > li:nth-child(2) > a") # encaissement

    def cds(self):
        self.click_on_selector("#accordion > ul > li:nth-child(3) > div")                       # activite_carburant  
        self.click_on_selector("#accordion > ul > li:nth-child(3) > ul > li:nth-child(4) > a")  # CDS

    def vente_par_famille(self):
        self.click_on_selector("#accordion > ul > li:nth-child(4) > div")   
        self.click_on_selector("#accordion > ul > li:nth-child(4) > ul > li:nth-child(3) > div") # declaratio act
        self.click_on_selector("#accordion > ul > li:nth-child(4) > ul > li:nth-child(3) > ul > li:nth-child(3) > div") # traitement du jour        
        self.click_on_selector("#accordion > ul > li:nth-child(4) > ul > li:nth-child(3) > ul > li:nth-child(3) > ul > li:nth-child(1) > a")

    def catalogue_livraison(self):
        self.click_on_selector("#accordion > ul > li:nth-child(3) > div") # activite_carburant  
        self.click_on_selector("#accordion > ul > li:nth-child(3) > ul > li:nth-child(1) > a")  # Catalogue de livraison
        
# FIN MODULE
    def click_on_selector(self, css_selector):
        element_visible = EC.visibility_of_element_located((By.CSS_SELECTOR, css_selector))
        WebDriverWait(self.driver, 10).until(element_visible)
        btn = self.driver.find_element(By.CSS_SELECTOR,css_selector)
        btn.click()
        
    def set_date(self,date_begin,date_end,validate_btn_id="#A19"):
        #date_begin = date_a # set d begin
        element = self.driver.find_element(By.CSS_SELECTOR,"#A23")
        self.driver.find_element(By.CSS_SELECTOR,"#A23").click()
        ActionChains(self.driver).key_down(Keys.CONTROL).send_keys('a').key_up(Keys.CONTROL).key_down(Keys.BACK_SPACE).perform()
        ActionChains(self.driver).send_keys('a').perform()
        element.send_keys(date_begin)
        
        #date_end = date_b # set d end
        element = self.driver.find_element(By.CSS_SELECTOR,"#A24")
        self.driver.find_element(By.CSS_SELECTOR,"#A24").click()
        ActionChains(self.driver).key_down(Keys.CONTROL).send_keys('a').key_up(Keys.CONTROL).key_down(Keys.BACK_SPACE).perform()
        ActionChains(self.driver).send_keys('a').perform()
        element.send_keys(date_end)
        
        #validate entry
        self.driver.find_element(By.CSS_SELECTOR,validate_btn_id).click()
            
        self.driver.implicitly_wait(7)
        
    def set_select(self,select_Id,dropdown_target) :
        dropdown_element = self.driver.find_element(By.ID,select_Id) # dropdown_id
        dropdown = Select(dropdown_element)                          # from selenium.webdriver.support.ui import Select
        dropdown.select_by_visible_text(dropdown_target)
        self.wait_complete_load() # wait complete load

    def start_download(self):
        self.driver.find_element(By.CSS_SELECTOR,"#ttA6 > td:nth-child(2) > img").click()
        self.driver.find_element(By.CSS_SELECTOR,"body > ul > li:nth-child(1)").click()

    def refresh_tab(self):
        #self.driver.refresh()
        #self.click_on_selector('a[title="Home"]')
        self.driver.get('https://blueedcms.eurodata.fr/edcms/')
        
    # tab close
    def close_tab(self):
        self.driver.close()
    
    def __del__(self):
        self.driver.close()
        Browser._instance_count -= 1
        print("> Browser closed !")


