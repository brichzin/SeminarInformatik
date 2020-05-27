import java.sql.*;

public class DBAnbindung
{
    private Connection c;

    public DBAnbindung()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + "./CoronaDaten.db");
            System.out.println("QSQLite DB connected");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }

        ausgeben();
    }

    Connection VerbindungGeben ()
    {
        return c;
    }

    void VerbindungBeenden ()
    {
        try
        {
            c. close ();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void ausgeben() {
        try {
            Statement stat = c.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM CoronaDaten");
            while (res.next())
            {
                System.out.print("ID: " + res.getInt("ID") + ", ");
                System.out.print("Tag: " + res.getInt("Tag") + ", ");
                System.out.print("Monat: " + res.getInt("Monat") + ", ");
                System.out.print("Jahr: " + res.getInt("Jahr") + ", ");
                System.out.print("Infizierte: " + res.getInt("Infizierte") + ", ");
                System.out.print("Tote: " + res.getInt("Tote"));
                System.out.println("");

            }
            stat.close();
        }
        catch (Exception e) {
            System.out.println(e);

        }

    }

    public void inDatenbankEingeben(int TagNeu, int MonatNeu, int JahrNeu, int InfizierteNeu, int ToteNeu) {
        try {
            Statement stat = c.createStatement();
            //ResultSet res = stat.executeQuery("SELECT max('ID') FROM CoronaDaten");
            //int key = res.getInt("ID");
            //key = key + 1;
            int Anzahl=stat.executeUpdate("INSERT INTO CoronaDaten"+
                    "VALUES (key, TagNeu, MonatNeu, JahrNeu, InfizierteNeu, ToteNeu)");
            
        }
        catch (Exception e) {
            System.out.println(e);

        }

    }
}
