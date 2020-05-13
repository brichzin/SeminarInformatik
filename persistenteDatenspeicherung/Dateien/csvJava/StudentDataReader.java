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
public class StudentDataReader extends DataReader
{
   
    public StudentDataReader(String nFile)
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
                database.doCommand("INSERT INTO student(prename , name, class, lastYearsClass,"+
                    " educationPath, religiousEducation, languages, studentID) VALUES('"+nextLine[0]+
                    "','"+nextLine[sortArray[1]]+"','"+nextLine[sortArray[2]]+"','"+nextLine[sortArray[3]]+"','"+nextLine[sortArray[4]]+"','"+nextLine[sortArray[5]]+"','"+nextLine[sortArray[6]]+"','"+ID+"');");
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
        if (nextLine[i].equals("FAMILIENNAME"))
            {
                sortArray[i]=0;
            }
        else if(nextLine[i].equals("VORNAMEN"))
            {
                sortArray[i]=1;
            }
        else if(nextLine[i].equals("KLASSE"))
            {
                sortArray[i]=2;
            }
        else if(nextLine[i].equals("RELIGION_ETHIK"))
            {
                sortArray[i]=6;
            }
        else if(nextLine[i].equals("_FREMDSPRACHE"))
            {
                sortArray[i]=5;
            }
        else if(nextLine[i].equals("AUSBILDUNGSR"))
            {
                sortArray[i]=3;
            }
        else if(nextLine[i].equals("VORJAHR_KLASSE"))
            {
                sortArray[i]=4;
            }
        }
    }
    
}
