
/**
 * Die Klasse DatabaseConn ermöglicht den Umgang mit SQLite-Datenbanken. 
 * sqlitejdbc-v056.jar muss geladen sein!
 * 
 * @author Tobias Winter
 * @version 9. 7. 10
 */

import java.sql.*;

public class DatabaseConn
{
    // Instanzvariablen
    private Connection conn;
    private Statement stat;

    /**
     * Konstruktor für Objekte der Klasse Database
     * @param pathName  Der Pfad zur .db-Datei (incl ".db")
     */
    public DatabaseConn(String pathName) throws ClassNotFoundException, SQLException
    {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:" + pathName);
        stat = conn.createStatement();
    }
    
    /**
     * Erstellt die Tabellen für unsere Datenbank.
     * Die Datenbank sollte zuvor leer sein oder zumindest noch keine
     * Tabellen enthalten die von uns verwendet werden.
     */
    public void createTables() throws SQLException
    {
        if (conn == null)
        {
            throw new NullPointerException("Database connection is already closed!");
        }
        stat.executeUpdate("create table Book(title text, author text, price double, ISBN text, subject text);");
        stat.executeUpdate("create table Loan(studentID integer, exemplarID integer, holidayLoan integer, loanDate integer);");
        stat.executeUpdate("create table Student(prename text, name text, class text, lastYearsClass text, educationPath text, religiousEducation text, languages text, studentID integer);");
        stat.executeUpdate("create table Journal(studentPrename text, studentName text, class text, damageDescription text, costInCent integer, paid integer, exemplarId integer, cost double, damageDate integer);");
        stat.executeUpdate("create table Damage(description text, damageDate integer, paid integer, costInCent integer, damageID integer);");
        stat.executeUpdate("create table Exemplar(ISBNBookType text, exemplarID integer);");
        stat.executeUpdate("create table StudentBookDamage(studentID integer, exemplarID integer, damageID integer);");
        stat.executeUpdate("create table Book_To_Grade(ISBN text, grade integer);");
        stat.executeUpdate("create table Grade(grade integer);");
    }
    
    /**
     * Löscht eine Tabelle, wenn diese vorhanden ist
     * @param name  Der Name der Tabelle, die gelöscht werden soll
     */
    public void deleteTable(String tableName) throws SQLException
    {
        if (conn == null)
        {
            throw new NullPointerException("Database connection is already closed!");
        }
        stat.executeUpdate("drop table if exists " + tableName);
    }
    
    /**
     * Führt einen SQL-Befehl mauell aus. Da es keinen Rueckgabewert gibt,
     * ist sie ausschliesslich zur Bearbeitung und nicht zur Abfrage geeignet
     * @param command   Dier SQL-Befehl als String
     */
    public void doCommand(String command) throws SQLException
    {
        if (conn == null)
        {
            throw new NullPointerException("Database connection is already closed!");
        }
        stat.executeUpdate(command);
    }
    
    /**
     * Gibt die Tabelle zurueck
     * @param tableName Der Name der Tabelle
     * @return Die Ergebnisse der Suche als ResultSet
     */
    public ResultSet getTable(String tableName) throws SQLException
    {
        if (conn == null)
        {
            throw new NullPointerException("Database connection is already closed!");
        }
        ResultSet rs = stat.executeQuery("select * from " + tableName + ";");
        return rs;        
    }
    
    /**
     * Schließt die Datenbankverbindung.
     * Danach ist dieses Objekt nicht mehr nutzbar und sollte nicht weiter referenziert werden.
     * Diese Methode sollte immmer aufgerufen werden, wenn die Datenbank nicht mehr gebraucht
     * wird, da die Verbindung sonst erst beim nächsten GarbageCollector durchlauf geschlossen
     * wird.
     */
    public void close() throws SQLException
    {
        conn.close();
        conn = null;
    }
    
    /**
     * Diese Methode wird vom GarbageCollector als Destruktor aufgerufen.
     * Wir nutzen sie um auch in diesem Fall nach Möglichkeit die Datenbankvebindung
     * zu schließen.
     */
    protected void finalize()
    {
        try
        {
            close();
        }
        catch(SQLException e)
        {
            System.out.println("Could not close the database connection: " +
                e.getMessage());
        }
        conn = null;
    }
}
