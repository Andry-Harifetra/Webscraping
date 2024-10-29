Description :
  --> Script pour scraper les données du site EURODATA
  --> Login et mot de passe à saisir lors du lancement (pour sécuriter)
  --> Sauvegrade faite sur une base interne , module de pré-taitement et de visualsation à faire pour plus tard

0_dev_eurodata """ Data sourrce """"
      |
      |___ main.py """ Script de lancement """
      |
      |___ A_data_extraction/obj """ Class Browser / Pipeline (navigation)  """ 
      |
      |___ B_data_processing """ Calcul """
      |
      |___ C_data_load """ Export  """
      |
      |___ D_data_viz """ Pour visualisation """ (En cours)
      |
      |___ E_schema
      |
      |___ F_post_traitement """ Formattage de donnée """
      |
      |___ G_GLOBAL """" Variable global (chemin absolue) """
      |
      |___ TRAITEMENT
      |
      |___ Web Driver """ Navigateur utilisé par le bibliothèque Selenium """ ==> A télécharger dans le drive google
      |
      |___ webscrapenv """ Environement virtuel """"
