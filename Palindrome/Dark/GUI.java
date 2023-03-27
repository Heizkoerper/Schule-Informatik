import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.Color;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 12.01.2023
 * @author 
 */

public class GUI extends JFrame {
  // Anfang Attribute
  private JLabel lPalindromPrufer = new JLabel();
  private JTextArea jTextArea1 = new JTextArea("");
    private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  private JTextField jTextField1 = new JTextField();
  private JButton bPrufen = new JButton();
  // Ende Attribute
  
  public GUI() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 600; 
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Palindrom Prüfer");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    setUndecorated(false);
    lPalindromPrufer.setBounds(6, 5, 566, 28);
    lPalindromPrufer.setText("Palindrom Prüfer");
    lPalindromPrufer.setFont(new Font("Dialog", Font.BOLD, 18));
    lPalindromPrufer.setForeground(Color.WHITE);
    cp.add(lPalindromPrufer);
    jTextArea1ScrollPane.setBounds(7, 48, 568, 156);
    jTextArea1.setLineWrap(true);
    jTextArea1.setBackground(new Color(0xC0C0C0));
    jTextArea1.setForeground(Color.WHITE);
    cp.add(jTextArea1ScrollPane);
    jTextField1.setBounds(7, 215, 470, 25);
    jTextField1.setEditable(false);
    jTextField1.setBackground(Color.GRAY);
    jTextField1.setForeground(Color.RED);
    cp.add(jTextField1);
    bPrufen.setBounds(483, 215, 91, 25);
    bPrufen.setText("Prüfen");
    bPrufen.setMargin(new Insets(2, 2, 2, 2));
    bPrufen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bPrufen_ActionPerformed(evt);
      }
    });
    bPrufen.setBackground(new Color(0xC0C0C0));
    cp.add(bPrufen);
    cp.setBackground(new Color(0x404040));
    // Ende Komponenten
    
    setVisible(true);
  } // end of public GUI
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new GUI();
  } // end of main
  
  public void bPrufen_ActionPerformed(ActionEvent evt) {
    String txt = jTextArea1.getText();
    
    if (txt == "") { jTextField1.setForeground(Color.RED); jTextField1.setText("Leere Eingabe nicht möglich!"); return; }
    
    boolean val = Palindrome.palindromPruefen(txt);
    
    String antwort = "Kein Palindrom";
    jTextField1.setForeground(Color.RED);
    
    if (val) {
      antwort = "Palindrom";
      jTextField1.setForeground(Color.GREEN);
    }
    
    jTextField1.setText(antwort);
    
  } // end of bPrufen_ActionPerformed

  // Ende Methoden
} // end of class GUI

