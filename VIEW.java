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
    // Anfang Attribute
    private JLabel lDatum = new JLabel();
    private JLabel lNeuinfizierte = new JLabel();
    private JLabel lTodesfaelle = new JLabel();
    private JLabel lEingabemaske = new JLabel();
    private JButton buttonAbsenden = new JButton();
    private JSpinner eingabeNeuinfizierte = new JSpinner();
    private SpinnerNumberModel eingabeNeuinfizierteModel = new SpinnerNumberModel(0, 0, 1000000, 1);
    private JSpinner eingabeTote = new JSpinner();
    private SpinnerNumberModel eingabeToteModel = new SpinnerNumberModel(0, 0, 1000000, 1);
    private JSpinner eingabeTag = new JSpinner();
    private SpinnerNumberModel eingabeTagModel = new SpinnerNumberModel(0, 1, 31, 1);
    private JSpinner eingabeMonat = new JSpinner();
    private SpinnerNumberModel eingabeMonatModel = new SpinnerNumberModel(0, 1, 12, 1);
    private JSpinner eingabeJahr = new JSpinner();
    private SpinnerNumberModel eingabeJahrModel = new SpinnerNumberModel(0, 0, 2030, 1);
    private JLabel lRegion = new JLabel();
    private JComboBox<String> jComboBox1 = new JComboBox<String>();
    private DefaultComboBoxModel<String> jComboBox1Model = new DefaultComboBoxModel<String>();
    // Ende Attribute

    public VIEW() { 
        // Frame-Initialisierung
        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 537; 
        int frameHeight = 300;
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
        lTodesfaelle.setText("Todesfälle");
        cp.add(lTodesfaelle);
        lEingabemaske.setBounds(21, 11, 246, 28);
        lEingabemaske.setText("Eingabemaske");
        cp.add(lEingabemaske);
        buttonAbsenden.setBounds(145, 212, 123, 41);
        buttonAbsenden.setText("Absenden");
        buttonAbsenden.setMargin(new Insets(2, 2, 2, 2));
        buttonAbsenden.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    buttonAbsenden_ActionPerformed(evt);
                }
            });
        cp.add(buttonAbsenden);
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
        jComboBox1Model.addElement("Baden-Würtemberg");
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
        jComboBox1Model.addElement("Thüringen");
        cp.add(jComboBox1);
        // Ende Komponenten

        setVisible(true);
    } // end of public VIEW

    // Anfang Methoden

    public static void main(String[] args) {
        new VIEW();
    } // end of main

    public void buttonAbsenden_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen

    } // end of buttonAbsenden_ActionPerformed

    public void datenEingeben()
    {

    }

    public void ausgabeTabellarisch()
    {

    }
    // Ende Methoden
} // end of class VIEW
