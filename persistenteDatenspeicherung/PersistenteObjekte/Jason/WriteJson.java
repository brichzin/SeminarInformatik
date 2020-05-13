import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;


public class WriteJson {

    public static void main(String[] args) {
        //Json Objekt Erzeuger
        JsonObjectBuilder builder = Json.createObjectBuilder();
        // 3 Eintraege
        builder.add("vorname", "Paul");
        builder.add("nachname", "Schmitz");
        builder.add("alter", 14);

        JsonArrayBuilder arrayBuilder1 = Json.createArrayBuilder();

        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("stil", "rock");
        job.add("band", "U2");
        arrayBuilder1.add(job);

        //bestehender jObjectBuilder wird neu gesetzt
        job = Json.createObjectBuilder();
        job.add("stil", "metal");
        job.add("band", "Black Sabbath");
        arrayBuilder1.add(job);

        // im Objekt oben wird ein neues Attribut musik ergänzt
        // dort wird als Attributwert ein Array eingetragen
        
        builder.add("musik", arrayBuilder1);
        builder.add("hungrig", true);
        
        // eigentliche Erzeugung des Jason Objekts
        JsonObject jo = builder.build();

        try {
            FileWriter fw = new FileWriter("test.txt");
            JsonWriter jsonWriter = Json.createWriter(fw);
            jsonWriter.writeObject(jo);
            jsonWriter.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
        //Json Objekt Erzeuger
        JsonObjectBuilder builder = Json.createObjectBuilder();
        // 3 Eintraege
        builder.add("vorname", "Paul");
        builder.add("nachname", "Schmitz");
        builder.add("alter", 14);

        JsonArrayBuilder arrayBuilder1 = Json.createArrayBuilder();

        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("stil", "rock");
        job.add("band", "U2");
        arrayBuilder1.add(job);

        //bestehender jObjectBuilder wird neu gesetzt
        job = Json.createObjectBuilder();
        job.add("stil", "metal");
        job.add("band", "Black Sabbath");
        arrayBuilder1.add(job);

        // im Objekt oben wird ein neues Attribut musik ergänzt
        // dort wird als Attributwert ein Array eingetragen
        
        builder.add("musik", arrayBuilder1);
        builder.add("hungrig", true);
        
        // eigentliche Erzeugung des Jason Objekts
        JsonObject jo = builder.build();

        try {
            FileWriter fw = new FileWriter("test.txt");
            JsonWriter jsonWriter = Json.createWriter(fw);
            jsonWriter.writeObject(jo);
            jsonWriter.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 