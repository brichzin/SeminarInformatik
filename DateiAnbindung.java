
/**
 * Beschreiben Sie hier die Klasse DateiAnbindung.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.*;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class DateiAnbindung
{
    Model aktuellesModel;
    /**
     * Konstruktor für Objekte der Klasse DateiAnbindung
     */
    public DateiAnbindung(Model neuesModel)
    {
        aktuellesModel = neuesModel;
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
            aktuellesModel.datenpunktEingeben(Integer.parseInt(einzeldaten[0]),Integer.parseInt(einzeldaten[1]),Integer.parseInt(einzeldaten[2]),Integer.parseInt(einzeldaten[3]),Integer.parseInt(einzeldaten[4]));
            line = inBuffer.readLine();
        }
    }
    
    /**
     * Daten in CSV-Datei schreiben
     */
    public void datenInDateiSchreiben() throws IOException
    {
        ArrayList<Datenpunkt> datenliste = aktuellesModel.datenAuslesen();
        String dateiname = "coronaStatistikDatei.csv";
        FileWriter writer = new FileWriter(dateiname);
        BufferedWriter outBuffer = new BufferedWriter(writer);
        
        Datenpunkt daten;
        for (int i=0; i<datenliste.size(); i++)
        {
        daten = datenliste.get(i);    
            
        String line;
        line = Integer.toString(daten.infizierte) + "," + 
        Integer.toString(daten.todesfaelle) + "," +
        Integer.toString(daten.tag) + "," +
        Integer.toString(daten.monat) + "," +
        Integer.toString(daten.jahr) + "\n";
            
        outBuffer.write(line);
    }
        outBuffer.close();
        
    }
    
}
