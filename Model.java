 import java.util.*;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

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
    public void datenAusDateiLesen() throws IOException
    {
        //Pfad "coronaStatistikDatei.csv"

        String dateiname = "coronaStatistikDatei.csv";
        // Beschränkung zunächst auf 5 Werte pro Datenpunkt
        String[] einzeldaten=new String[5];
        FileReader reader = new FileReader(dateiname);
        BufferedReader inBuffer = new BufferedReader(reader);

        String line = inBuffer.readLine();
   
        while (line != null)
        {
            //System.out.println(line);
            einzeldaten = line.split(",");
            datenpunktEingeben(Integer.parseInt(einzeldaten[0]),Integer.parseInt(einzeldaten[1]),Integer.parseInt(einzeldaten[2]),Integer.parseInt(einzeldaten[3]),Integer.parseInt(einzeldaten[4]));
            line = inBuffer.readLine();
        }
    }
    
    public void datenInDateiSchreiben(Datenpunkt daten) throws IOException
    {
        String dateiname = "coronaStatistikDatei.csv";
        FileWriter writer = new FileWriter(dateiname);
        BufferedWriter outBuffer = new BufferedWriter(writer);
        
        String line;
        line = Integer.toString(daten.infizierte) + "," + 
        Integer.toString(daten.todesfaelle) + "," +
        Integer.toString(daten.tag) + "," +
        Integer.toString(daten.monat) + "," +
        Integer.toString(daten.jahr) + "\n";
            
        outBuffer.write(line);
        outBuffer.close();
        
    }
}
