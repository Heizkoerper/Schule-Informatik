import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.io.*;
import java.util.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 02.02.2023
 * @author 
 */

public class GUIEinkaufsliste extends JFrame {
  // Anfang Attribute
  private Einkaufsliste einkauf;
  private String leer;
  private boolean toggleAdd = true;
  private JTextArea jTextArea1 = new JTextArea("");
  private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  private JLabel lEinkaufsliste = new JLabel();
  private JTextField jTextField1 = new JTextField();
  private JButton bHinzufuegen = new JButton();
  private JButton bEntfernen = new JButton();
  private JButton bPruefen = new JButton();
  private JButton bAusgeben = new JButton();
  private JNumberField jNumberField1 = new JNumberField();
  private JTextField jTextField2 = new JTextField();
  private JToggleButton jToggleButton1 = new JToggleButton();
  // Ende Attribute
  
  public GUIEinkaufsliste() throws IOException { 
    // Frame-Initialisierung
    super();
    
    leer = jNumberField1.getText();     // DEBUG
    
    einkauf = new Einkaufsliste();
    einkauf.hinzufuegen("Tomaten", 3, false);
    einkauf.hinzufuegen("Zwiebeln", 6, false);
    
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 455; 
    int frameHeight = 800;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Einkaufsliste");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jTextArea1ScrollPane.setBounds(16, 112, 408, 600);
    jTextArea1.setFont(new Font("Dialog", Font.BOLD, 13));
    cp.add(jTextArea1ScrollPane);
    lEinkaufsliste.setBounds(15, 7, 406, 28);
    lEinkaufsliste.setText("Einkaufsliste");
    lEinkaufsliste.setFont(new Font("Dialog", Font.BOLD, 20));
    lEinkaufsliste.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(lEinkaufsliste);
    jTextField1.setBounds(16, 47, 358, 28);
    jTextField1.setFont(new Font("Dialog", Font.BOLD, 14));
    cp.add(jTextField1);
    bHinzufuegen.setBounds(16, 80, 100, 25);
    bHinzufuegen.setText("Hinzufuegen");
    bHinzufuegen.setMargin(new Insets(2, 2, 2, 2));
    bHinzufuegen.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent evt) {
      try {
        bHinzufuegen_ActionPerformed(evt);
      } catch(Exception e) {
        return;
      } 
    }
    });
    cp.add(bHinzufuegen);
    bEntfernen.setBounds(125, 80, 100, 25);
    bEntfernen.setText("Entfernen");
    bEntfernen.setMargin(new Insets(2, 2, 2, 2));
    bEntfernen.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent evt) { 
    bEntfernen_ActionPerformed(evt);
    }
    });
    cp.add(bEntfernen);
    bPruefen.setBounds(232, 80, 100, 25);
    bPruefen.setText("Pruefen");
    bPruefen.setMargin(new Insets(2, 2, 2, 2));
    bPruefen.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent evt) { 
    bPruefen_ActionPerformed(evt);
    }
    });
    cp.add(bPruefen);
    bAusgeben.setBounds(341, 80, 81, 25);
    bAusgeben.setText("Ausgeben");
    bAusgeben.setMargin(new Insets(2, 2, 2, 2));
    bAusgeben.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent evt) { 
    bAusgeben_ActionPerformed(evt);
    }
    });
    cp.add(bAusgeben);
    jNumberField1.setBounds(377, 47, 48, 28);
    jNumberField1.setText("");
    jNumberField1.setHorizontalAlignment(SwingConstants.CENTER);
    jNumberField1.setFont(new Font("Dialog", Font.PLAIN, 14));
    cp.add(jNumberField1);
    jTextField2.setBounds(16, 720, 327, 28);
    jTextField2.setEditable(false);
    jTextField2.setFont(new Font("Dialog", Font.BOLD, 14));
    cp.add(jTextField2);
    jToggleButton1.setBounds(350, 720, 72, 28);
    jToggleButton1.setText("Addieren");
    jToggleButton1.setMargin(new Insets(2, 2, 2, 2));
    jToggleButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jToggleButton1_ActionPerformed(evt);
      }
    });
    jToggleButton1.setEnabled(true);
    jToggleButton1.setToolTipText("Zu bereits vorhandenen Artikeln dazu addieren");
    cp.add(jToggleButton1);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public GUIEinkaufsliste
  
  // Anfang Methoden
  
  public static void main(String[] args) throws IOException {
    new GUIEinkaufsliste();
  } // end of main
  
  public void bHinzufuegen_ActionPerformed(ActionEvent evt) throws IOException {
    
    jTextField2.setText("");
    
    boolean add = toggleAdd;
    boolean success;
    
    int anzahl = 1;
    
    try {  
      anzahl = Integer.parseInt(jNumberField1.getText().trim());
    }
    
    catch (NumberFormatException nfe)
    {
      anzahl = 1;
    }
    
    success = einkauf.hinzufuegen(jTextField1.getText(), anzahl, add);
    
    if (! success) { jTextField2.setForeground(Color.RED); jTextField2.setText("Artikel bereits vorhanden"); }
    
    String output = einkauf.ausgeben();
    jTextArea1.setText(output);
  } // end of bHinzufuegen_ActionPerformed
  
  
  public void bEntfernen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of bEntfernen_ActionPerformed
  
  
  public void bPruefen_ActionPerformed(ActionEvent evt) {
    
    String eingabe = jTextField1.getText();
    
    if (einkauf.pruefen(eingabe)) {
      jTextField2.setForeground(Color.GREEN);
      jTextField2.setText("Element vorhanden: " + eingabe + " (n)".replace("n", (einkauf.anzahlVonNamen(eingabe) + "")));
    }
    
    else {
      jTextField2.setForeground(Color.RED);
      jTextField2.setText("Element nicht in der Liste vorhanden!");
    }
  }
  
  
  public void bAusgeben_ActionPerformed(ActionEvent evt) {
    
    String output = einkauf.ausgeben();
    jTextArea1.setText(output);
    
  }
  
  public void jToggleButton1_ActionPerformed(ActionEvent evt) {
    
    if (this.toggleAdd) {
      this.toggleAdd = false;
    }
    else {
      this.toggleAdd = true;
    }
    
  } // end of jToggleButton1_ActionPerformed

  // Ende Methoden
} // end of class GUIEinkaufsliste

