/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 25.04.2020
 * @author 
 */

public class TestBrichzin {
  
  // Anfang Attribute
  private String nachricht;
  // Ende Attribute
  
  TestBrichzin() 
  {
     nachricht= "Hallo! Wie geht es Euch?";
  }

  
  // Anfang Methoden
  public String getNachricht() {
    return nachricht;
  }
  
  public void setNachricht(String n) {
    nachricht = n;
  }

  // Ende Methoden
} // end of TestBrichzin

