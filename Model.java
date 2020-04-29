
/**
 * Beschreiben Sie hier die Klasse Model.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Model
{
    int infizierte;
    int todesfaelle;
    int tag;
    int monat;

    /**
     * Konstruktor für Objekte der Klasse Model
     */
    public Model()
    {
       infizierte = 0;
        todesfaelle = 0;
        tag = -1;
        monat = -1;
    }

    
    //Infizierte, Todesfälle, Datum(tag,Monat)
    public void datenManuellEingeben(int infizierteNeu, int todesfaelleNeu, int tagNeu, int monatNeu)
    {
        infizierte = infizierteNeu;
        todesfaelle = todesfaelleNeu;
        tag = tagNeu;
        monat = monatNeu;
    }
    
    public void datenAuslesen()
    {
        
    }
}
