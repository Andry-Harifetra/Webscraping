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

# start driver
driver = webdriver.Chrome()
driver.maximize_window()

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
##                    goto vente_carburant
#
##################################################################
# wait for selector

def click_on_selector(css_selector):
    element_visible = EC.visibility_of_element_located((By.CSS_SELECTOR, css_selector))
    WebDriverWait(driver, 10).until(element_visible)

    btn = driver.find_element(By.CSS_SELECTOR,css_selector)
    btn.click()

#####
# Set_select
dropdown_element = driver.find_element(By.ID,"A26") # dropdown_id

from selenium.webdriver.support.ui import Select
dropdown = Select(dropdown_element)     # from selenium.webdriver.support.ui import Select

#####
# Select an option by value
dropdown.select_by_visible_text("Tous")

def set_select(select_Id,dropdown_target) :
    dropdown_element = driver.find_element(By.ID,select_Id) # dropdown_id
    dropdown = Select(dropdown_element)                     # from selenium.webdriver.support.ui import Select
    dropdown.select_by_visible_text(dropdown_target)
    # wait complete load
    WebDriverWait(driver, 100).until(lambda driver: driver.execute_script('return document.readyState') == 'complete')

set_select("A26","Tous")
driver.find_element(By.CSS_SELECTOR,"#ttA6 > td:nth-child(2) > img").click()
driver.find_element(By.CSS_SELECTOR,"body > ul > li:nth-child(1)").click()
print("> ok")
# Go_to     
click_on_selector("#accordion > ul > li:nth-child(4) > div")
click_on_selector("#accordion > ul > li:nth-child(4) > ul > li:nth-child(3) > div") # declaratio act
click_on_selector("#accordion > ul > li:nth-child(4) > ul > li:nth-child(3) > ul > li:nth-child(1) > a") # validation d'activité
click_on_selector("#accordion > ul > li:nth-child(4) > ul > li:nth-child(3) > ul > li:nth-child(2) > ul > li:nth-child(4) > a") # act carb

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
