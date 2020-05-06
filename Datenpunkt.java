/**
 * Jedes Objekt der Klasse Datenpunkt, speichert die Daten eines Tages.
 * Datumsdarstellung ist sehr eifach für das Jahr 2020 gehalten.
 * 
 * @author (Stadtmüller / Brichzin) 
 * @version (Version 1)
 */
public class Datenpunkt
{
    int infizierte;
    int todesfaelle;
    int tag;
    int monat;
    int jahr;

    /**
     * Konstruktor für Objekte der Klasse Datenpunkt
     */
    public Datenpunkt()
    {
        infizierte = 0;
        todesfaelle = 0;
        tag = -1;
        monat = -1;
        jahr = -1;
    }
    
    /**
     * Konstruktor für Objekte der Klasse Datenpunkt
     */
    public Datenpunkt(int infizierteNeu, int todesfaelleNeu, int tagNeu, int monatNeu, int jahrNeu)
    {
        infizierte = infizierteNeu;
        todesfaelle = todesfaelleNeu;
        tag = tagNeu;
        monat = monatNeu;
        jahr = jahrNeu;
    }

    /**
     * Aktualisiert einen Datenpunkt
     * 
     * @param infizierteNeu
     * @param todesfaelleNeu
     * @param tagNeu
     * @param monatNeu
     * @param jahrNeu
     */
    public void datenAktualisieren(int infizierteNeu, int todesfaelleNeu, int tagNeu, int monatNeu, int jahrNeu)
    {
        infizierte = infizierteNeu;
        todesfaelle = todesfaelleNeu;
        tag = tagNeu;
        monat = monatNeu;
        jahr = jahrNeu;
    }
}
