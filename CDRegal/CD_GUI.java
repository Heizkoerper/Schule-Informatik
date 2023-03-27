import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
 
import java.io.*;
import java.util.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 05.09.2022
 * @author 
 */

public class CD_GUI extends JFrame {
  // Anfang Attribute
  private CD_Regal cd_regal = new CD_Regal();
  
  private JTable jTable1 = new JTable(50, 3);
    private DefaultTableModel jTable1Model = (DefaultTableModel) jTable1.getModel();
    private JScrollPane jTable1ScrollPane = new JScrollPane(jTable1);
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  private JButton jButton3 = new JButton();
  private JButton jButton4 = new JButton();
  private JButton jButton5 = new JButton();
  private JButton jButton6 = new JButton();
  private JPasswordField jPasswordField1 = new JPasswordField();
  private JTextField jTextField1 = new JTextField();
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JTextField jTextField2 = new JTextField();
  private JLabel jLabel3 = new JLabel();
  private JLabel jLabel4 = new JLabel();
  // Ende Attribute
  
  public CD_GUI() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    int frameWidth = 1200; 
    int frameHeight = 700;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("CD Sammlung");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    
    // Anfang Komponenten
    
    /*private JTable tabelle = new JTable(100, 3);
    
    private JButton bAnzeigen = new JButton();
    private JButton bSuchen = new JButton();
    private JButton bHinzufügen = new JButton();
    private JButton bEntfernen = new JButton();
    private JButton bAuslesen = new JButton();
    private JButton bSpeichern = new JButton();*/
    
    jTable1ScrollPane.setBounds(16, 56, 948, 518);
    jTable1.getColumnModel().getColumn(0).setHeaderValue("Titel");
    jTable1.getColumnModel().getColumn(1).setHeaderValue("Interpret");
    jTable1.getColumnModel().getColumn(2).setHeaderValue("Erscheinungsjahr");
    cp.add(jTable1ScrollPane);
    jButton1.setBounds(979, 55, 187, 33);
    jButton1.setText("Anzeigen");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jButton2.setBounds(977, 101, 187, 33);
    jButton2.setText("Suchen");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    cp.add(jButton2);
    jButton3.setBounds(980, 169, 187, 33);
    jButton3.setText("Hinzufügen");
    jButton3.setMargin(new Insets(2, 2, 2, 2));
    jButton3.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton3_ActionPerformed(evt);
      }
    });
    cp.add(jButton3);
    jButton4.setBounds(978, 214, 187, 33);
    jButton4.setText("Entfernen");
    jButton4.setMargin(new Insets(2, 2, 2, 2));
    jButton4.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton4_ActionPerformed(evt);
      }
    });
    cp.add(jButton4);
    jButton5.setBounds(984, 288, 187, 33);
    jButton5.setText("Einlesen");
    jButton5.setMargin(new Insets(2, 2, 2, 2));
    jButton5.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton5_ActionPerformed(evt);
      }
    });
    cp.add(jButton5);
    jButton6.setBounds(980, 341, 187, 33);
    jButton6.setText("Speichern");
    jButton6.setMargin(new Insets(2, 2, 2, 2));
    jButton6.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton6_ActionPerformed(evt);
      }
    });
    cp.add(jButton6);
    jPasswordField1.setBounds(983, 544, 190, 28);
    jPasswordField1.setText("");
    jPasswordField1.setToolTipText("Passwort");
    cp.add(jPasswordField1);
    jTextField1.setBounds(983, 493, 190, 28);
    jTextField1.setToolTipText("Nutzername");
    cp.add(jTextField1);
    jLabel1.setBounds(982, 525, 110, 20);
    jLabel1.setText("Nutzername");
    cp.add(jLabel1);
    jLabel2.setBounds(982, 471, 110, 20);
    jLabel2.setText("Passwort");
    cp.add(jLabel2);
    jTextField2.setBounds(16, 592, 1153, 25);
    jTextField2.setEditable(false);
    jTextField2.setText("Herzlich Willkommen!");
    cp.add(jTextField2);
    jLabel3.setBounds(16, 8, 513, 41);
    jLabel3.setText("Meine CD Sammlung");
    cp.add(jLabel3);
    jLabel4.setBounds(1000, 640, 177, 17);
    jLabel4.setText("(c) Jonathan Schnieders, 2022");
    cp.add(jLabel4);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public CD_GUI
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new CD_GUI();
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    
    /*if(this.cd_regal != null) {
      System.out.println("Test 1");
    }
    else {
      System.out.println("Test 2");
    } // end of if-else*/
    
    System.out.println("Test" + String.valueOf(Arrays.stream(this.cd_regal.cds).filter(e -> e != null).count()));
    
    for (int i = 0; i < Arrays.stream(this.cd_regal.cds).filter(e -> e != null).count(); i++) {
      jTable1.setValueAt(this.cd_regal.cds[i].getTitel(), i, 0);
      jTable1.setValueAt(this.cd_regal.cds[i].getInterpret(), i, 1);
      jTable1.setValueAt(this.cd_regal.cds[i].getErscheinungsjahr(), i, 2);
    }
    
    /*jTable1.setValueAt("Titel", 0, 0);
    jTable1.setValueAt("Interpret", 0, 1);
    jTable1.setValueAt("Jahr", 0, 2); */
  } // end of jButton1_ActionPerformed

  public void jButton2_ActionPerformed(ActionEvent evt) {
    for (int i = 0; i < Arrays.stream(this.cd_regal.cds).filter(e -> e != null).count(); i++) {
      
      System.out.println(String.valueOf(Arrays.stream(this.cd_regal.cds).filter(e -> e != null).count()));
      
      if (this.cd_regal.cds[i] != null) {
        System.out.println("Test");
      }
      
      /*jTable1.setValueAt(this.cd_regal.cds[i].getTitel(), i, 0);
      jTable1.setValueAt(this.cd_regal.cds[i].getInterpret(), i, 1);
      jTable1.setValueAt(this.cd_regal.cds[i].getErscheinungsjahr(), i, 2);*/
    }
    
  } // end of jButton2_ActionPerformed

  public void jButton3_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of jButton3_ActionPerformed

  public void jButton4_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of jButton4_ActionPerformed

  public void jButton5_ActionPerformed(ActionEvent evt) {
    try {
      this.cd_regal.sammlungEinlesen();
      jTextField2.setText("Sammlung erfolgreich eingelesen!");
    }
    catch(Exception e) {
      jTextField2.setText("Fehler beim Einlesen der Sammlung!");
    }
  } // end of jButton5_ActionPerformed

  public void jButton6_ActionPerformed(ActionEvent evt) {
    try {
      this.cd_regal.sammlungSpeichern();
      jTextField2.setText("Sammlung erfolgreich gespeichert!");
    }
    catch(Exception e) {
      jTextField2.setText("Fehler beim Speichern der Sammlung!");
    }
  } // end of jButton6_ActionPerformed

  // Ende Methoden
} // end of class CD_GUI

