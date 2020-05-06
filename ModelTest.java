

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse ModelTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class ModelTest
{
    private Datenpunkt datenpun1;
    private Datenpunkt datenpun2;
    private Model model1;
    private Datenpunkt datenpun3;
    private Datenpunkt datenpun4;
    private Datenpunkt datenpun5;

    
    
    

    /**
     * Konstruktor fuer die Test-Klasse ModelTest
     */
    public ModelTest()
    {
    }

    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @Before
    public void setUp()
    {
        datenpun1 = new Datenpunkt(1, 1, 1, 1, 2020);
        datenpun2 = new Datenpunkt(2, 2, 2, 1, 2020);
        model1 = new Model();
        datenpun1.datenAktualisieren(2, 0, 28, 01, 2020);
        datenpun2.datenAktualisieren(2, 0, 29, 01, 2020);
        datenpun3 = new Datenpunkt(4, 0, 31, 01, 2020);
        datenpun4 = new Datenpunkt(1, 0, 03, 02, 2020);
        datenpun5 = new Datenpunkt(4, 0, 04, 02, 2020);
        model1.datenpunktEingeben(datenpun1);
        model1.datenpunktEingeben(datenpun2);
        model1.datenpunktEingeben(datenpun3);
        model1.datenpunktEingeben(datenpun4);
        model1.datenpunktEingeben(datenpun5);
    }

    /**
     * Gibt das Testgerüst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @After
    public void tearDown()
    {
    }
}
