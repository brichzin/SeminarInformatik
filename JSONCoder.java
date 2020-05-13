import java.io.FileNotFoundException; 
import java.io.PrintWriter; 
import java.io.FileReader; 
import java.util.LinkedHashMap; 
import java.util.Map; 
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

    public static void write(String filename, Datenpunkt pkt) throws Exception {
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
    
    static Datenpunkt read(String filename) throws Exception  
    { 
        // parsing file "JSONExample.json" 
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
}
