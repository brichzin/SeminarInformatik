import java.sql.*;

public class DBAnbindung
{
    Connection c;

    public DBAnbindung()
    {
        c = null;
        init();
        ausgeben();
    }

    private void init()  {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:CoronaDaten.db");
            System.out.println("QSQLite DB connected");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    private void ausgeben() {
        try {
            Statement stat = c.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM CoronaDaten");
            while (res.next())
            {
                System.out.print("Tag: " + res.getInt("Tag") + ", ");
                System.out.print("Monat: " + res.getInt("Monat") + ", ");
                System.out.print("Jahr: " + res.getInt("Jahr") + ", ");
                System.out.print("Infizierte: " + res.getInt("Infizierte") + ", ");
                System.out.print("Tote: " + res.getInt("Tote"));
                System.out.println("");
                
            }
        }
        catch (Exception e) {
            System.out.println(e);

        }

    }
    /*private void inDatenbankEingeben(int TagNeu, int MonatNeu, int JahrNeu, int InfizierteNeu, int ToteNeu) {
        try {
            Statement stat = c.createStatement();
            int Anzahl=stat.executeUpdate("INSERT INTO CoronaDaten"+
            "VALUES ( TagNeu, MonatNeu, JahrNeu, InfizierteNeu, ToteNeu)");
            
        }
        catch (Exception e) {
            System.out.println(e);

        }

    }*/
}
