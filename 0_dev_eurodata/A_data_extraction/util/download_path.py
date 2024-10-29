from selenium import webdriver
from selenium.webdriver.chrome.service import Service as ChromeService



# Set the download directory
#download_directory = r"C:\Users\datamanager1\eurodata_oto\data\download"
chrome_options = webdriver.ChromeOptions()
download_directory = r"C:\Users\datamanager1\eurodata_oto\data\download"
chromeOptions = webdriver.ChromeOptions()
prefs = {"download.default_directory" : download_directory}
chromeOptions.add_experimental_option("prefs",prefs)
driver = webdriver.Chrome(options=chromeOptions)

# Your test script

#driver.quit()