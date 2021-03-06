import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 29.04.2020
 * @author 
 */

public class VIEW extends JFrame {
    
    private Model model;
    private boolean datengeprueft;
    // Anfang Attribute
    private JLabel lDatum = new JLabel();
    private JLabel lNeuinfizierte = new JLabel();
    private JLabel lTodesfaelle = new JLabel();
    private JLabel lEingabemaske = new JLabel();
    private JLabel lPruefen = new JLabel();
    private JButton buttonAbsenden = new JButton();
    private JButton buttonPruefen = new JButton();
    private JButton buttonAusgabe = new JButton();
    private JSpinner eingabeNeuinfizierte = new JSpinner();
    private SpinnerNumberModel eingabeNeuinfizierteModel = new SpinnerNumberModel(0, 0, 1000, 1);
    private JSpinner eingabeTote = new JSpinner();
    private SpinnerNumberModel eingabeToteModel = new SpinnerNumberModel(0, 0, 1000, 1);
    private JSpinner eingabeTag = new JSpinner();
    private SpinnerNumberModel eingabeTagModel = new SpinnerNumberModel(1, 1, 31, 1);
    private JSpinner eingabeMonat = new JSpinner();
    private SpinnerNumberModel eingabeMonatModel = new SpinnerNumberModel(1, 1, 12, 1);
    private JSpinner eingabeJahr = new JSpinner();
    private SpinnerNumberModel eingabeJahrModel = new SpinnerNumberModel(2020, 2019, 2030, 1);
    private JLabel lRegion = new JLabel();
    private JComboBox<String> jComboBox1 = new JComboBox<String>();
    private DefaultComboBoxModel<String> jComboBox1Model = new DefaultComboBoxModel<String>();
    
    //DBAnbindung db;
    
    // Ende Attribute

    public VIEW(Model nModel) { 
        // Frame-Initialisierung
        super();
        model = nModel;
        datengeprueft = false;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 537; 
        int frameHeight = 350;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("VIEW");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // Anfang Komponenten

        lDatum.setBounds(29, 57, 110, 20);
        lDatum.setText("Datum");
        cp.add(lDatum);
        lNeuinfizierte.setBounds(28, 89, 110, 20);
        lNeuinfizierte.setText("Neuinfizierte");
        cp.add(lNeuinfizierte);
        lTodesfaelle.setBounds(26, 127, 110, 20);
        lTodesfaelle.setText("Todesf�lle");
        cp.add(lTodesfaelle);
        lEingabemaske.setBounds(21, 11, 246, 28);
        lEingabemaske.setText("Eingabemaske");
        cp.add(lEingabemaske);
        buttonAbsenden.setBounds(145, 212, 123, 41);
        buttonAbsenden.setText("Absenden");
        buttonAbsenden.setMargin(new Insets(2, 2, 2, 2));
        buttonAbsenden.setVisible(false);
        buttonAbsenden.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    buttonAbsenden_ActionPerformed(evt);
                }
            });
        cp.add(buttonAbsenden);
        buttonPruefen.setBounds(280, 212, 123, 41);
        buttonPruefen.setText("Daten pr�fen");
        buttonPruefen.setMargin(new Insets(2, 2, 2, 2));
        buttonPruefen.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    buttonPruefen_ActionPerformed(evt);
                }
            });
        cp.add(buttonPruefen);
        lPruefen.setBounds(280, 250, 200, 20);
        lPruefen.setText("");
        cp.add(lPruefen);
        buttonAusgabe.setBounds(145, 262, 123, 41);
        buttonAusgabe.setText("Daten ausgeben");
        buttonAusgabe.setMargin(new Insets(2, 2, 2, 2));
        buttonAusgabe.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    buttonAusgeben_ActionPerformed(evt);
                }
            });
        cp.add(buttonAusgabe);
        eingabeNeuinfizierte.setBounds(159, 88, 166, 24);
        eingabeNeuinfizierte.setValue(0);
        eingabeNeuinfizierte.setModel(eingabeNeuinfizierteModel);
        cp.add(eingabeNeuinfizierte);

        eingabeTote.setBounds(160, 123, 166, 24);
        eingabeTote.setValue(0);
        eingabeTote.setModel(eingabeToteModel);
        cp.add(eingabeTote);

        eingabeTag.setBounds(161, 54, 46, 24);
        eingabeTag.setValue(0);
        eingabeTag.setModel(eingabeTagModel);
        cp.add(eingabeTag);

        eingabeMonat.setBounds(214, 55, 46, 24);
        eingabeMonat.setValue(0);
        eingabeMonat.setModel(eingabeMonatModel);
        cp.add(eingabeMonat);

        eingabeJahr.setBounds(268, 55, 54, 24);
        eingabeJahr.setValue(0);
        eingabeJahr.setModel(eingabeJahrModel);
        cp.add(eingabeJahr);

        lRegion.setBounds(29, 168, 116, 20);
        lRegion.setText("Region");
        cp.add(lRegion);
        jComboBox1.setModel(jComboBox1Model);
        jComboBox1.setBounds(158, 168, 166, 20);
        jComboBox1Model.addElement("Baden-W�rtemberg");
        jComboBox1Model.addElement("Bayern");
        jComboBox1Model.addElement("Berlin");
        jComboBox1Model.addElement("Brandenburg");
        jComboBox1Model.addElement("Bremen");
        jComboBox1Model.addElement("Hamburg");
        jComboBox1Model.addElement("Hessen");
        jComboBox1Model.addElement("Mecklenburg-Vorpommern");
        jComboBox1Model.addElement("Niedersachsen");
        jComboBox1Model.addElement("Nordrhein-Westfalen");
        jComboBox1Model.addElement("Rheinland-Pfalz");
        jComboBox1Model.addElement("Saarland");
        jComboBox1Model.addElement("Sachsen");
        jComboBox1Model.addElement("Sachsen-Anhalt");
        jComboBox1Model.addElement("Schleswig-Holstein");
        jComboBox1Model.addElement("Th�ringen");
        cp.add(jComboBox1);
        // Ende Komponenten
        
        //db = new DBAnbindung();

        setVisible(true);
    } // end of public VIEW

    // Anfang Methoden

    public static void main(String[] args) {
        Model m = new Model();
        new VIEW(m);
    } // end of main

    public void buttonAbsenden_ActionPerformed(ActionEvent evt) {
        datenEingeben();
        buttonAbsenden.setVisible(false);
    } // end of buttonAbsenden_ActionPerformed
    
    public void buttonAusgeben_ActionPerformed(ActionEvent evt) {
        ausgabeTabellarisch();
    } // end of buttonAbsenden_ActionPerformed
    
    public void buttonPruefen_ActionPerformed(ActionEvent evt) {
        //Datum muss gepr�ft werden
        buttonAbsenden.setVisible(false);
        String ausgabe = "gepr�ft";
        int tempTag = (int) eingabeTag.getValue();
        int tempMonat = (int) eingabeMonat.getValue();
        int tempJahr = (int) eingabeJahr.getValue();
        boolean schaltjahr = false;
        if(tempJahr % 4 == 0) {
            if(tempJahr % 100 == 0 && tempJahr % 400 == 0) {
                schaltjahr = true;
            } else {
                if (tempJahr % 100 == 0 && tempJahr % 400 != 0) {
                    schaltjahr = false;
                }
            }
            schaltjahr = true;
        } 
        if(tempMonat == 2 && tempTag > 29 && schaltjahr) {
            ausgabe = "Februar hat weniger Tage!";
        } else if(tempMonat == 2 && tempTag > 28 && !schaltjahr) {
            ausgabe = "Februar hat weniger Tage!";
        } else if((tempMonat == 4 || tempMonat == 6 || tempMonat == 9 || tempMonat == 11) && tempTag == 31) {
            ausgabe = "Den 31. gibt es nicht!";
        }
        
        if(ausgabe.equals("gepr�ft")) {
            buttonAbsenden.setVisible(true);
        }
        lPruefen.setText(ausgabe);
    } // end of buttonAbsenden_ActionPerformed

    public void datenEingeben()
    {
        int tempNeuinfizierte = (int) eingabeNeuinfizierte.getValue();
        int tempTote = (int) eingabeTote.getValue();
        int tempTag = (int) eingabeTag.getValue();
        int tempMonat = (int) eingabeMonat.getValue();
        int tempJahr = (int) eingabeJahr.getValue();
        model.datenpunktEingeben(tempNeuinfizierte, tempTote, tempTag, tempMonat, tempJahr);
        //db.inDatenbankEingeben(tempTag, tempMonat, tempJahr, tempNeuinfizierte, tempTote);
        //System.out.println(tempNeuinfizierte+", tote: "+ tempTote + tempTag + tempMonat + tempJahr);
    }

    public void ausgabeTabellarisch()
    {
        int breite = 15;
        String luecke ="               ";
        ArrayList <Datenpunkt> daten = model.datenAuslesen();
        // Kopfzeile
            System.out.print(("Tag: "+luecke).substring(0,breite));
            System.out.print(("Monat: "+luecke).substring(0,breite));
            System.out.print(("Jahr: "+luecke).substring(0,breite));
            System.out.print(("Infizierte: "+luecke).substring(0,breite));
            System.out.print(("Todesf�lle: "+luecke).substring(0,breite));
            System.out.println();
        // Tabelle
        for (int i=0; i<daten.size(); i++)
        {
          
          System.out.print((""+daten.get(i).tag+""+luecke).substring(0,breite));
          System.out.print((""+daten.get(i).monat+""+luecke).substring(0,breite));
          System.out.print((""+daten.get(i).jahr+""+luecke).substring(0,breite));
          System.out.print((""+daten.get(i).infizierte+""+luecke).substring(0,breite));
          System.out.print((""+daten.get(i).todesfaelle+""+luecke).substring(0,breite));  
           System.out.println();  
        }
            
        
        
        }

    // Ende Methoden
} // end of class VIEW
