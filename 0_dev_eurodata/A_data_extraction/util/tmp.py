"""
OTOBO - Eurodata file automate dowwnloader

AuTHOR - RHARIVONY
"""
#import time 
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
#from selenium.webdriver.common.alert import Alert
from selenium.webdriver.common.action_chains import ActionChains
#from selenium.webdriver.common.actions import Actions

"""
# IMPORT CUSTOM MODULE
from util.browser import *
from helper import hello
"""

# VARIABLE CONFIG
eurodata = 'https://blueedcms.eurodata.fr/edcms/'
google = 'http://google.com'
user = "rharivony"
mdp = "Jaona1010B"

#boot_into()
driver = webdriver.Chrome()

driver.get(google)
driver.implicitly_wait(7) 


##***************************##
#       prompt HANDLING
##***************************##
body = driver.find_element(By.TAG_NAME,"body")
action = webdriver.common.action_chains.ActionChains(driver)
action.move_to_element_with_offset(body, 10, 10)
action.click()

body.click()
ActionChains(driver).key_down(Keys.ENTER).perform() #press enter


##***************************##
#       LOGIN HANDLING        #
##***************************##



log_in(user,mdp)

##*********************************##
#      GOTO_VALIDATION_JOURNEE        
##*********************************##
def go_to_validation() :
    daily_activity = "#accordion > ul > li:nth-child(4) > div"
    driver.find_element(By.CSS_SELECTOR,daily_activity).click()
    daily_validation = "#accordion > ul > li:nth-child(4) > ul > li:nth-child(3) > ul > li:nth-child(1) > a"
    driver.find_element(By.CSS_SELECTOR,daily_validation).click()


    
go_to_home()
    
# CLOSE
driver.close()



"""
prompt alert handling

##click test on google [ok]
#driver.get('https://google.com/')
#search = driver.find_element(By.NAME, "q")
#search.click()
#ActionChains(driver).key_down(Keys.SHIFT).send_keys("abc").perform()

## ALERT HANDLING
#alert = Alert(driver)
driver.switch_to.alert() #.send_keys("abc")
alert.text

prompt = driver.find_element(By.TAG_NAME, "input")
search.send_keys("sss")

ActionChains(driver).key_down(Keys.SHIFT).send_keys("abc").perform()

driver.switch_to_alert().accept()
alert = wait.until(expected_conditions.alert_is_present())
"""
