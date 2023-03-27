import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 29.08.2022
 * @author 
 */

public class CD_GUI extends JFrame {
  // Anfang Attribute
  private CD_Regal cdRegal;
  private JButton bAnzeigen = new JButton();
  private JButton bSuchen = new JButton();
  private JButton bHinzufügen = new JButton();
  private JButton bEntfernen = new JButton();
  private JButton bAuslesen = new JButton();
  private JButton bSpeichern = new JButton();
  //private JTextArea jTextArea1 = new JTextArea("Herzlich Wilkommen!");
  //  private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);

  private JTable jTable1 = new JTable(100, 3);
    private DefaultTableModel jTable1Model = (DefaultTableModel) jTable1.getModel();
    private JScrollPane jTable1ScrollPane = new JScrollPane(jTable1);
  // Ende Attribute
  
  public CD_GUI() { 
    // Frame-Initialisierung
    super();
    this.cdRegal = new CD_Regal();
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    int frameWidth = 690; 
    int frameHeight = 421;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("CD Sammlung");
    setResizable(true);
    Container cp = getContentPane();
    cp.setLayout(null);
    
    // Anfang Komponenten
    
    jButton1.setBounds(464, 28, 75, 25);
    jButton1.setText("Anzeigen");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    jButton2.setBounds(464, 70, 75, 25);
    jButton2.setText("Suchen");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    cp.add(jButton2);
    jButton3.setBounds(463, 112, 75, 25);
    jButton3.setText("Hinzufügen");
    jButton3.setMargin(new Insets(2, 2, 2, 2));
    jButton3.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton3_ActionPerformed(evt);
      }
    });
    cp.add(jButton3);
    jButton4.setBounds(465, 154, 75, 25);
    jButton4.setText("Entfernen");
    jButton4.setMargin(new Insets(2, 2, 2, 2));
    jButton4.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton4_ActionPerformed(evt);
      }
    });
    cp.add(jButton4);
    jButton5.setBounds(464, 200, 75, 25);
    jButton5.setText("Auslesen");
    jButton5.setMargin(new Insets(2, 2, 2, 2));
    jButton5.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton5_ActionPerformed(evt);
      }
    });
    cp.add(jButton5);
    
    bSpeichern.setBounds(467, 246, 75, 25);
    bSpeichern.setText("Speichern");
    bSpeichern.setMargin(new Insets(2, 2, 2, 2));
    bSpeichern.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bSpeichern_ActionPerformed(evt);
      }
    });
    cp.add(bSpeichern);
    //jTextArea1ScrollPane.setBounds(40, 30, 392, 244);
    //cp.add(jTextArea1ScrollPane);
    jTable1ScrollPane.setBounds(40, 32, 396, 246);
    jTable1.getColumnModel().getColumn(0).setHeaderValue("Titel");
    jTable1.getColumnModel().getColumn(1).setHeaderValue("Interpret");
    jTable1.getColumnModel().getColumn(2).setHeaderValue("Erscheinungsjahr");
  
    cp.add(jTable1ScrollPane);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public CD_GUI
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new CD_GUI();
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of jButton1_ActionPerformed

  public void jButton2_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of jButton2_ActionPerformed

  public void jButton3_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of jButton3_ActionPerformed

  public void jButton4_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of jButton4_ActionPerformed

  public void jButton5_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of jButton5_ActionPerformed

  public void bSpeichern_ActionPerformed(ActionEvent evt) {
    //this.jTextArea1.setText("Speichern der Sammlung wird initiiert!");
    
  } // end of bSpeichern_ActionPerformed
  
  /*public void titelInTextAreaAusgeben() {
    CD[] cds = this.cdRegal.getCds();
    
     for(int i = 0; i < cds.length; i++)
    {
      if(cds[i] != null) {
        this.jTextArea1.setText("Der Titel der CD an der Position " +(i+1) + " lautet " + cds[i].getTitel() ); 
      }
    }
  }*/

  // Ende Methoden
} // end of class CD_GUI

