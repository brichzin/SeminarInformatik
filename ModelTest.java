

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
        datenpun1 = new Datenpunkt(1, 1, 1, 1);
        datenpun2 = new Datenpunkt(2, 2, 2, 1);
        model1 = new Model();
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
