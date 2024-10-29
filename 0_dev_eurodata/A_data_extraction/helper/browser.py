

#from selenium.webdriver.common.actions import Actions
 ###############
 #
 # CHECK if an element is VISIBLE 
 #
 ###############


 ###############
 #
 # GOTO HOME 
 #
 ###############
# find home button 
driver.find_element(By.CSS_SELECTOR,'[Title="Home"]').click()
driver.implicitly_wait(7)



from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains

from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

 ###############
 #
 # wait for an element to be visible 
 #
 ###############
 
 css_selector = "selector"

 element_visible = EC.visibility_of_element_located((By.CSS_SELECTOR, css_selector))
 WebDriverWait(driver, 10).until(element_visible)


############### 
#
# > wait until PAGE completly LOADED
#
##############

from selenium.webdriver.support.ui import WebDriverWait
WebDriverWait(driver, 100).until(lambda driver: driver.execute_script('return document.readyState') == 'complete')

#////////////////////////
