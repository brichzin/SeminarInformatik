import java.sql.*;
import java.io.*;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    public Main() throws SQLException , ClassNotFoundException , IOException
    {
        DatabaseConn Database=new DatabaseConn("data.db");
        Database.createTables();
        StudentDataReader sReader=new StudentDataReader("SchuelerdatenTestdaten.csv");
        sReader.sort();
        sReader.convert(Database);  
        
        BookDataReader bReader=new BookDataReader("test_ISBN.csv");
        bReader.sort();
        bReader.convert(Database); 
        Database.close();
        System.out.println("Finished");
    }
}
