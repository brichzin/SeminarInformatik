import java.io.*;
import java.text.*;
import java.util.Date;
import java.util.Locale;
import java.sql.*;
/**
 * Write a description of class StudentDataReader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BookDataReader extends DataReader
{
   
    public BookDataReader(String nFile)
    {
           super(nFile);
    }

   public void convert(DatabaseConn database) throws SQLException
    {
        int ID;
        ID=0;
        boolean firstline=true;
              try
        {
            while ((nextLine = reader.readNext()) != null)
            {
                if(firstline==true)
                {
                    firstline=false;
                }
                else{
                ID=ID+1;
                // nextLine[] is an array of values from the line
                database.doCommand("INSERT INTO book(title , author, , price,"+
                    " ISBN, subject) VALUES('"+nextLine[0]+
                    "','"+nextLine[sortArray[1]]+"','"+nextLine[sortArray[2]]+"','"+nextLine[sortArray[3]]+"','"+nextLine[sortArray[4]]+"');");
                }
            }
        }
            catch(IOException e)
            {
            }
            reload();
            
    }
    
    public void sort() throws IOException
    {
        sortArray = new int[8];
                nextLine = reader.readNext();
        for (int i=0;i<nextLine.length;i=i+1)
        {
        nextLine[i].toUpperCase(new Locale("GERMAN"));
        System.out.println(""+nextLine[i]);
        if (nextLine[i].equals("TITEL"))
            {
                sortArray[i]=0;
            }
        else if(nextLine[i].equals("AUTOR / HERAUSGEBER"))
            {
                sortArray[i]=1;
            }
        else if(nextLine[i].equals("PREIS"))
            {
                sortArray[i]=2;
            }
        else if(nextLine[i].equals("ISBN"))
            {
                sortArray[i]=3;
            }
        else if(nextLine[i].equals("FACH"))
            {
                sortArray[i]=4;
            }
        }
    }
    
}
