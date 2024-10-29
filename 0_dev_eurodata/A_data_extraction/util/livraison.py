#####
#
#   CONFIG
#
#####

from credentials import login_str, password_str

user_name = login_str
password = password_str
date_a =  "01/01/2023"  #date start
date_b =  "23/07/2023" #date end


#####
#
#   IMPORTING PACKAGE/MODULE
#
###

from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains

from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

######### set download path setting
from selenium.webdriver.chrome.options import Options
PATH = "/Users/datamanager1/eurodata_oto/download"
options = Options()
prefs = {"download.default_directory" : PATH}
options.add_experimental_option("prefs",prefs)
##

driver = webdriver.Chrome(options=options)
driver.maximize_window()

driver.get('https://blueedcms.eurodata.fr/edcms/')

########## PROMPT HANDLING
# ????????????
"""
alert = driver.switch_to.active_element
alert = driver.switch_to.parent_frame
alert.__dir__()
alert.send_keys("kk")
alert.click()
#driver.execute_script("document.getElementsByClassName('comment-user')[0].click()")
ActionChains(driver).send_keys("p").perform() #fill password
ActionChains(driver).key_down(Keys.TAB).key_up(Keys.TAB).perform()
#driver.switchTo().activeElement()
"""
##################################################################
#
##                      OPEN NEW TAB 
#
##################################################################
# focus on default TAB
driver.switch_to.window(driver.window_handles[0])
driver.execute_script("window.open('');")
# Switch to the new tab
driver.switch_to.window(driver.window_handles[1])
driver.get('https://blueedcms.eurodata.fr/edcms/')

##################################################################
#
##                          LOGIN 
#
##################################################################
# wait for element to appear
element_id = "tzA4"
element_visible = EC.visibility_of_element_located((By.ID, element_id))
WebDriverWait(driver, 10).until(element_visible)

login = driver.find_element(By.ID,"tzA4")   #login
login.click()
ActionChains(driver).send_keys(user_name).perform() #fill username
#password
pswrd = driver.find_element(By.ID,"A6")     #login
pswrd.click()
ActionChains(driver).send_keys(password).perform() #fill password
ActionChains(driver).key_down(Keys.ENTER).perform() #PRESS ENTER


##################################################################
#
##                    goto livraison
#
##################################################################
# wait for selector
activite_carburant = "#accordion > ul > li:nth-child(3) > div"

element_visible = EC.visibility_of_element_located((By.CSS_SELECTOR, activite_carburant))
WebDriverWait(driver, 10).until(element_visible)

# open
activite_carburant_btn = driver.find_element(By.CSS_SELECTOR,activite_carburant)
activite_carburant_btn.click()

livraison_carburant = "#accordion > ul > li:nth-child(3) > ul > li:nth-child(1) > a"
driver.find_element(By.CSS_SELECTOR,livraison_carburant).click()

driver.implicitly_wait(7)

##################################################################
#
##                   setting up date site
#
##################################################################
date_begin = date_a # set d begin 
element = driver.find_element(By.CSS_SELECTOR,"#A23")
driver.find_element(By.CSS_SELECTOR,"#A23").click()
ActionChains(driver).key_down(Keys.CONTROL).send_keys('a').key_up(Keys.CONTROL).key_down(Keys.BACK_SPACE).perform()
ActionChains(driver).send_keys('a').perform()
element.send_keys(date_begin)

date_end = date_b # set d end
element = driver.find_element(By.CSS_SELECTOR,"#A24")
driver.find_element(By.CSS_SELECTOR,"#A24").click()
ActionChains(driver).key_down(Keys.CONTROL).send_keys('a').key_up(Keys.CONTROL).key_down(Keys.BACK_SPACE).perform()
ActionChains(driver).send_keys('a').perform()
element.send_keys(date_end)

#validate entry
driver.find_element(By.CSS_SELECTOR,"#A19").click()
driver.implicitly_wait(7)

############### > wait until PAGE completly LOADED

from selenium.webdriver.support.ui import WebDriverWait
WebDriverWait(driver, 100).until(lambda driver: driver.execute_script('return document.readyState') == 'complete')

############### >

##################################################################
#
##                      START DOWNLOAD
#
##################################################################
driver.find_element(By.CSS_SELECTOR,"#ttA6 > td:nth-child(2) > img").click()
driver.find_element(By.CSS_SELECTOR,"body > ul > li:nth-child(1)").click()

## rename downloaded file


driver.close()
