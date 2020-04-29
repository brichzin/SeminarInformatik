import java.util.*;

/**
 * Beschreiben Sie hier die Klasse Model.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Model
{
    ArrayList<Datenpunkt> daten;

    /**
     * Konstruktor f�r Objekte der Klasse Model
     */
    public Model()
    {
       daten = new ArrayList<Datenpunkt>();
    }

    
    /**
     * Neuen Datenpunkt eingeben
     * 
     * @param infizierteNeu
     * @param todesfaelleNeu
     * @param tagNeu
     * @param monatNeu
     */
    public void datenpunktEingeben(int infizierteNeu, int todesfaelleNeu, int tagNeu, int monatNeu)
    {
        daten.add(new Datenpunkt(infizierteNeu, todesfaelleNeu, tagNeu, monatNeu));
    }
    
    /**
     * Neuen Datenpunkt hinzuf�gen
     * 
     * @param datenpunktNeu
     */
    public void datenpunktEingeben(Datenpunkt datenpunktNeu){
        daten.add(datenpunktNeu);
    }
    
    public ArrayList<Datenpunkt> datenAuslesen()
    {
        return daten;
    }
}
