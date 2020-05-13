import java. sql. *;

/**
 * Stellt die Methoden zum Zugriff auf die Datenbank zur Verf&uuml;gung.
 * Es muss sqlitejdbc-v056 in der Bibliothek geladen sein.
 * Als Beispiel wird eine Ueberpruefung von Login-Daten verwendet.
 * Als Login Daten ist ein Benutzername in Form einer Zeichenkette (String) gespeichert
 * und ein Kennwort in Form einer Zahl
 *
 *
 * @author Peter Brichzin
 * @version 1.0
 */
class DATENBANKVERBINDUNG2
{
    /** Speichert die Verbindung zur Datenbank. */
    private Connection conn;
    //private Statement stat;
    
    /**
     * Baut die Verbindung zur Datenbank auf.
     */
    DATENBANKVERBINDUNG2()
    {
         try
        {
            // Treiber laden
            Class.forName("org.sqlite.JDBC");
            //Datenbankverbindung aufbauen
            conn=DriverManager.getConnection("jdbc:sqlite:" + "./testpasswoerter.db");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        
    }
    
    /**
     * Meldet das Verbindungsobjekt.
     * @return verbindug
     */
    Connection VerbindungGeben ()
    {
        return conn;
    }

    /**
     * Beendet die Verbindung, danach ist Schluss.
     */
    void VerbindungBeenden ()
    {
        try
        {
            conn. close ();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Holt alle Daten und gibt sie aus.
     */
    void DatenHolen ()
    {
        Statement st;  // Datenbankabfrage - SQL statement
        ResultSet rs;   // Ergebnistabelle der Abfrage
        try
        {
            //Erzeugen einer Datenbankabfrage (SQL statement)
            st = conn. createStatement ();
            //Ausfuehren der Abfrage --> die Ergbnistabelle wird im Attribut rs gespeichert
            rs = st. executeQuery ("SELECT Name, Passwort FROM benutzer");
            while (rs. next ())  //solange es noch eine Zeile in der Ergebnistabelle gibt
            {
                //Ausgabe der Werte: Dazu muss bekannt sein, wie die Tabelle aufgebaut ist
                // in diesem Fall hat die Tabelle zwei Spalten:
                // in der ersten ist als String der Benutzername gespeichert
                // in der zweiten als int das Kennwort (in Form einer PIN)
                System.out.println("Name: "+ rs. getString ("Name") + " und Nummer " + rs. getInt ("Passwort"));
            }
            // schliessen der Ergebnistabelle und der Abfrage
            rs. close ();
            st. close ();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * Holt das Kennwort zu einem gegebenen Benutzernamen.
     * Kann fuer eine Zugangsueberpruefung verwendet werden.
     * 
     * @param benutzername
     * @return Kennwort in Form einer Zahl; existiert der Benutzer nicht, wird -1 zurueckgegeben
     */
    int KennwortHolen (String benutzername)
    {
        Statement st;
        ResultSet rs;
        int ergebnis;
        ergebnis = -1;
        try
        {
            st = conn. createStatement ();
            rs = st. executeQuery ("SELECT Passwort FROM benutzer WHERE Name='" + benutzername + "'" );
            
            if(rs. next ())
            {
                ergebnis = rs. getInt ("Passwort");
            }
            
            rs. close ();
            st. close ();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
         return ergebnis;
    }
    
     /**
     * Holt das Kennwort zu einem gegebenen Benutzernamen.
     * Kann fuer eine Zugangsueberpruefung verwendet werden.
     * 
     * @param benutzername
     * @param kennwort
     * @return true, falls die Zugangsdatenkorrekt sind
     */
    boolean KennwortUeberpruefen (String benutzername, int passwort)
    {
        Statement st;
        ResultSet rs;
        boolean ergebnis;
        ergebnis = false;
        try
        {
            st = conn. createStatement ();
            rs = st. executeQuery ("SELECT Passwort FROM benutzer WHERE Name='" + benutzername + "'" );
            
            if(rs. next ())
            {
                ergebnis = (rs. getInt ("Passwort") == passwort);
            }
           
            
            rs. close ();
            st. close ();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
         return ergebnis;
    }

    
    void NeuenBenutzerEingeben(String benutzerNeu, int passwortNeu)
    {
        Statement st;
        ResultSet rs;
        try
        {
            if(passwortNeu<1000)
            {
                System.out.println("Das Kennwort muss mindestens eine vierstellige positive Zahl sein");
            }
            else
            {
            st = conn. createStatement ();
            st.execute("INSERT INTO benutzer (Name, Passwort)VALUES ('"+ benutzerNeu +"', '"+passwortNeu+"')");

            st. close ();
            DatenHolen();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
