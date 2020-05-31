import java.io.FileNotFoundException; 
import java.io.PrintWriter; 
import java.io.FileReader; 
import java.util.LinkedHashMap; 
import java.util.Map; 
import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
/**
 * JSONCoder kann einen vorhandenen Datenpunkt zu einer json-Datei umwandeln 
 * und umgekehrt eine json-Datei in einen Datenpunkt umwandeln.
 * 
 */
public class JSONCoder
{
    /**
     * Konstruktor für Objekte der Klasse JSONCoder
     */
    public JSONCoder()
    {

    }

    /**
     * Methode schreibt den einzelnen übergebenen Datenpunkt in eine  eigene json-Datei. 
     * Die json-Datei liegt im Ordner Datenpunkte. Der anzugebene Dateiname wird um die Endung json ergänzt. 
     * @param Dateiname (ohne Endung .json), wie die entstehende json-Datei zu benennen ist.
     * @param Datenpunkt, der eingelesen werden soll
     */
    public void writeDatenpunkt(String filename, Datenpunkt pkt) throws Exception {
        //json-Inhalte zusammenstellen
        JSONObject jo = new JSONObject();
        jo.put("infizierte", pkt.infizierte);
        jo.put("todesfaelle", pkt.todesfaelle);
        jo.put("tag", pkt.tag);
        jo.put("monat", pkt.monat);
        jo.put("jahr", pkt.jahr);

        // json-Datei generieren:"JSONExample.json"
        PrintWriter pw = new PrintWriter("Datenpunkte/"+filename+".json"); 
        pw.write(jo.toJSONString()); 

        pw.flush(); 
        pw.close(); 
    }

    /**
     * Methode schreibt alle in einer ArrayList übergebenen Datenpunkte in eine gemeinsame json-Datei. 
     * Die json-Datei liegt im Ordner Datenpunkte. Der anzugebene Dateiname wird um die Endung json ergänzt. 
     * @param Dateiname (ohne Endung .json), wie die entstehende json-Datei zu benennen ist.
     * @param Liste der Datenpunkte, die eingelesen werden sollen
     */
    public void write (String filename, ArrayList<Datenpunkt> dp) {
        JSONArray ja = new JSONArray();

        for(int i = 0; i < dp.size(); i++) {
            JSONObject jo = new JSONObject();
            jo.put("infizierte", dp.get(i).infizierte);
            jo.put("todesfaelle", dp.get(i).todesfaelle);
            jo.put("tag", dp.get(i).tag);
            jo.put("monat", dp.get(i).monat);
            jo.put("jahr", dp.get(i).jahr);
            ja.add(jo);
        }

        JSONObject ausgabe = new JSONObject();
        ausgabe.put("datenpunkte", ja);

        // json-Datei generieren:"JSONExample.json"
        try{
            PrintWriter pw = new PrintWriter("Datenpunkte/"+filename+".json"); 
            pw.write(ausgabe.toJSONString()); 

            pw.flush(); 
            pw.close(); 
        } catch (Exception e) {
            System.out.println (e.toString());
        }
    }

    /**
     * Die Methode readDatenpunkt liest den in der json-Datei hinterlegten Datenpunkt ein
     * und gibt ihn als Objekt der Klasse Datenpunkt zurück. 
     * Der anzugebene Dateiname wird automatisch um die Endung .json ergänzt und die Datei im Ordner Datenpunkte gesucht.
     * @param Dateiname (ohne Endung .json), unter dem die json-Datei im Ordner Datenpunkte zu finden ist.
     * @return Datenpunkt, der eingelesen wurde
     */
    Datenpunkt readDatenpunkt(String filename) throws Exception  
    { 
        // parsing file "JSONExample.json" 
        try{
            JSONObject jo = (JSONObject) (new JSONParser().parse(new FileReader("Datenpunkte/"+filename+".json"))); 
        


        // json auslesen
        int infizierte = (int) (long) jo.get("infizierte"); 
        int todesfaelle = (int) (long) jo.get("todesfaelle");
        int tag = (int) (long) jo.get("tag"); 
        int monat = (int) (long) jo.get("monat"); 
        int jahr = (int) (long) jo.get("jahr"); 
        

        Datenpunkt pkt = new Datenpunkt (infizierte, todesfaelle, tag, monat, jahr); 
        return pkt;
        
        }
        catch (Exception e) {
            System.out.println (e.toString());
            return null;
        }
    } 

    /**
     * Die Methode read liest die in der json-Datei hinterlegte Datenpunkte ein
     * und gibt sie als ArrayList von Datenpunkten zurück. 
     * Der anzugebene Dateiname wird automatisch um die Endung .json ergänzt und die Datei im Ordner Datenpunkte gesucht.
     * @param Dateiname (ohne Endung .json), unter dem die json-Datei im Ordner Datenpunkte zu finden ist.
     * @return Arraylist der Datenpunkte, die eingelesen wurden
     */

    ArrayList<Datenpunkt> read(String filename) {
        ArrayList<Datenpunkt> datenpunkte = new ArrayList<Datenpunkt>();
        
        try{

        JSONObject jo = (JSONObject) (new JSONParser().parse(new FileReader("Datenpunkte/"+filename+".json"))); 
        //JSONArray jasonArray = (JSONArray) (new JSONParser().parse(new FileReader("Datenpunkte/"+filename+".json")));

        JSONArray jasonArray = (JSONArray) jo.get("datenpunkte"); 

        for(int i = 0; i < jasonArray.size(); i++) {
            Datenpunkt dp = new Datenpunkt();
            int infizierte = (int) (long) ((JSONObject) jasonArray.get(i)).get("infizierte"); 
            int todesfaelle = (int) (long) ((JSONObject) jasonArray.get(i)).get("todesfaelle"); 
            int tag = (int) (long) ((JSONObject) jasonArray.get(i)).get("tag"); 
            int monat = (int) (long) ((JSONObject) jasonArray.get(i)).get("monat"); 
            int jahr = (int) (long) ((JSONObject) jasonArray.get(i)).get("jahr"); 

            dp.datenAktualisieren(infizierte, todesfaelle, tag, monat,jahr);

            datenpunkte.add(dp);
        }

        return datenpunkte;
        
        }
        catch (Exception e) {
            System.out.println (e.toString());
            return null;
        }
    }

}
