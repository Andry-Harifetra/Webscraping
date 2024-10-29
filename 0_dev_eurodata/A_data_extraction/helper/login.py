# -*- coding: utf-8 -*-
"""
Created on Wed Jul 19 15:38:25 2023

@author: Andry-Harifetra
"""

###########
#
## LOGIN 
#
###########

login = driver.find_element(By.ID,"tzA4") #login
login.click()
ActionChains(driver).send_keys(user_name).perform() #fill username
#password
pswrd = driver.find_element(By.ID,"A6") #login
pswrd.click()
ActionChains(driver).send_keys(password).perform() #fill password

ActionChains(driver).key_down(Keys.ENTER).perform() #fill password
