import java.io.*;
import java.text.*;
import java.util.Date;
import java.util.Locale;
import java.sql.*;

/**
 * Reads out Student Data of CSV-Tables with delimiter ":" and textseparator "'"
 * 
 * @author (Dominik Busch, Fabian Frank) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class DataReader
{
   CSVReader reader;
   String [] nextLine;
   String file;
   int [] sortArray;
   //Constructor
  public DataReader(String nFile)
  {
      file=nFile;
      reload();
  }
  
  public void reload()
  {
      if(reader != null)
      {
           try
        {
          reader.close();
          reader=null;
        }
          catch(IOException e)
        {
        }
        }
              try
        {
            reader = new CSVReader(new FileReader(file), ':', '\'');
        }
        catch(IOException e)
        {
            System.out.println("Konnte die Datei "+file+
             " nicht erstellen:\n"+e.getMessage());

            }
           
    }
  
  public void getData()
  {

      try
        {
            while ((nextLine = reader.readNext()) != null)
            {
                // nextLine[] is an array of values from the line
                for(int i=0 ; i<nextLine.length ; i=i+1)
                {
                    System.out.print(nextLine[i] +" | ");
                }
                    System.out.println("");
            }
        }
            catch(IOException e)
            {
            }
            reload();
    }
    
    public int getColumnNum()
    {
     int length;
       try
        {
        nextLine = reader.readNext();
        length=nextLine.length;
        reload();
        }
        catch(IOException e)
        {
        length=-1;
        }
        return length;
    }
    
    /**
    public void  dateTest()
    {
      String sDate;
      sDate="10.11.2008";
      SimpleDateFormat dFormat=new SimpleDateFormat("dd.MM.yyyy");
      ParsePosition pos = new ParsePosition(0);
      Date nDate= dFormat.parse(sDate,pos);
      StringBuffer dateBuffer = new StringBuffer();
      FieldPosition fpos = new FieldPosition(0);
      dFormat.format(nDate,dateBuffer,fpos);
        System.out.println("Datum als DATE: "+nDate);
        System.out.println("Datum als String: "+dateBuffer);
    }
    */
    
    public Date ToDate(String sDate)
    {
        Date dDate;
         SimpleDateFormat dFormat=new SimpleDateFormat("dd.MM.yyyy");
         ParsePosition pos = new ParsePosition(0);
         dDate = dFormat.parse(sDate,pos);
        return dDate;
    }
      

  // weitere Methoden

}

