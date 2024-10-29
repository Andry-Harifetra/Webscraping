# -*- coding: utf-8 -*-
"""
Created on Tue Jul  2 14:44:46 2024

function utiliy for DATA TYPE TEST and management

@author: Andry-Harifetra
"""
from pandas import isna

def is_missing(val):
    if val == "" or isna(val) or val is None:
        return True
    return False