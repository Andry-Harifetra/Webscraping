from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
#from selenium.webdriver.common.alert import Alert
from selenium.webdriver.common.action_chains import ActionChains

def log_in(user_name,password):
    #login
    login = driver.find_element(By.ID,"tzA4") #login
    login.click()
    ActionChains(driver).send_keys(user_name).perform() #fill username
    #password
    pswrd = driver.find_element(By.ID,"A6") #login
    pswrd.click()
    ActionChains(driver).send_keys(password).perform() #fill password
    
    ActionChains(driver).key_down(Keys.ENTER).perform() #fill password