
 ###############
 #
 # FILE RENAME 
 #
 ###############
 
import os
import shutil

dirpath = "c:\\Users\\andryharifetra\\eurodata_oto\\download"
# find the most recent element
filename = max([filepath +'\\'+ f for f in os.listdir(filepath)], key=os.path.getctime)
# replace NAME by a NEW one
shutil.move(os.path.join(dirpath,filename),os.path.join(dirpath, "livraison.xlsx"))


