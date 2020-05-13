import java.util.*;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
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
     * Konstruktor für Objekte der Klasse Model
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
     * @param jahrNeu
     */
    public void datenpunktEingeben(int infizierteNeu, int todesfaelleNeu, int tagNeu, int monatNeu, int jahrNeu)
    {
        daten.add(new Datenpunkt(infizierteNeu, todesfaelleNeu, tagNeu, monatNeu, jahrNeu));
    }
    
    /**
     * Neuen Datenpunkt hinzufügen
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
    
    /**
     * Liest die Daten aus einer CSV-Datei und erstellt daraus neue Datenpunkte
     */
    public void datenAusDateiLesen(String dateiname) throws IOException
    {
        //Pfad "coronaStatistikDatei.csv"
        //String dateiname = "";
          FileReader reader = new FileReader(dateiname);
          BufferedReader inBuffer = new BufferedReader(reader);

          String line = inBuffer.readLine();
   
          while (line != null)
          {
          System.out.println(line);
          line = inBuffer.readLine();
        }
    }
}
