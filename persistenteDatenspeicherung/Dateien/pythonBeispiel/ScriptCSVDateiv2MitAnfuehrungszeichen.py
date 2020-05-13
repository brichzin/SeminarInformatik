# -*- coding: utf-8 -*-
""" Author Peter Brichzin
    Version 4.4.20
    Skript zum konvertieren der csv Datei mit den Polizeidaten von New York zum
    Einlesen in phpmyadmin über csv-import
    - Ändern des Datumformats
    - Ändern des Zeitformats
    - Ergänzen bzw. beibehalten von "" geklammerte Spaltenausdrücke
    - Sollte in einem "" geklammerte Spaltenausdruck der Originaldatei ein Komma vorkommen, wird es durch einen Strichpunkt ersetzt
    
""" 


def wechsleDatumsformat(datumIn):
    datumOut =datumIn[6:10] + '-' + datumIn[0:2] + '-' + datumIn[3:5]
    return datumOut

def wechsleZeitformat(zeitIn):
    zeitOut = zeitIn + ':00'
    return zeitOut



datei = open('polizeiNY.csv', 'r')
ausgabeDatei = open('polizeiNYNeu.csv', 'w')


    
for zeile in datei:                         # Zeilenweises Einlesen der Datei
    wort =""
    spaltennummer = 0
    AnfuerhrungszeichenOffen= False
    for zeichen in zeile:       
        if  (zeichen == '"' ): # Anführungszeichen müssen erkannt werden, da Ausdruck das Komma als Trennzeichen enthalten kann und darf
            #wort = wort + zeichen
            AnfuerhrungszeichenOffen = not AnfuerhrungszeichenOffen
        else:        
            if AnfuerhrungszeichenOffen: # Falls Anführungszeichen offen lesen bis zum schliessenden Anführungszeichen
                if zeichen == ",":
                    zeichen = ";"
                    
                wort = wort + zeichen
            else: 
                if zeichen == ',':        # Falls Komma, Spalte abschliessen  
                    if spaltennummer==4:
                        wort = wechsleDatumsformat(wort)        
                    if spaltennummer==5:
                        wort = wechsleZeitformat(wort)
                    #HIER KANN MAN ANFUEHRUNGSZEICHEN ERGAENZEN    
                    #wort = '"' + wort + '"'
                    ausgabeDatei.write(wort)
                    ausgabeDatei.write(", ")
                    wort =""
                    spaltennummer = spaltennummer+1                   
                else:                   # Falls kein Komma, Zeichen einlesen
                    wort = wort + zeichen
        
    ausgabeDatei.write(wort)
           
datei.close()       
ausgabeDatei.close()       






