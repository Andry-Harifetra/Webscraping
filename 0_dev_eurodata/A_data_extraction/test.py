
import sys
sys.path.append("A_data_extraction")

from obj.ClassBrowser import Browser
 
br = Browser()
br.go_to_edcms()
br.log_in()
br.catalogue_livraison()


# FIX download directory path

br.vente_carburant()
br.home()
br.close_tab()

"""
test uni

"""

from obj.ClassPipelline import Pipelline

pipe = Pipelline()

pipe.download_module("01/07/2023", "15/07/2023", module_name="catalogue_livraison")
pipe.download_module("01/07/2023", "15/07/2023", module_name="encaissement")
pipe.download_module("01/07/2023", "15/07/2023", module_name="vente_carburant")
