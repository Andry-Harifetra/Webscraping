# -*- coding: utf-8 -*-
"""
Created on Wed Jul 19 15:40:33 2023

@author: Andry-Harifetra
"""

##########
#
##  goto validation
#
##########
daily_activity = "#accordion > ul > li:nth-child(4) > div"
driver.find_element(By.CSS_SELECTOR,daily_activity).click()
daily_validation = "#accordion > ul > li:nth-child(4) > ul > li:nth-child(3) > ul > li:nth-child(1) > a"
driver.find_element(By.CSS_SELECTOR,daily_validation).click()

##########
#
##  goto livraison
#
##########
activite_carburant = "#accordion > ul > li:nth-child(3) > div"
driver.find_element(By.CSS_SELECTOR,activite_carburant).click()
livraison_carburant = "#accordion > ul > li:nth-child(3) > ul > li:nth-child(1) > a"
driver.find_element(By.CSS_SELECTOR,livraison_carburant).click()

driver.implicitly_wait(7)