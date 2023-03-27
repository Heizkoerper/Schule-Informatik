/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 30.01.2023
 * @author 
 */

import java.io.*;
import java.util.*;

public class Einkaufsliste {
  
  private List<Artikel> list = new List<>();
  
  
  public boolean hinzufuegen(String pName, int pAnzahl, boolean pAdd) throws IOException {
    
    if (pruefen(pName) && (! pAdd)) { System.out.println("Artikel bereits vorhanden"); return false; }
    
    if (pruefen(pName) && pAdd) { pAnzahl += list.getContent().getAnzahl(); entfernen(pName); }
    
    Artikel artikel = new Artikel(pName, pAnzahl);
    list.append(artikel);
    listeSpeichern();
    
    return true;
    
  }
  
  
  public void entfernen(String pName) throws IOException {
    
    if (! pruefen(pName) ) { System.out.println("Artikel nicht vorhanden"); return; }
    
    list.toFirst();
    while (! list.getContent().getName().equalsIgnoreCase(pName)) { list.next(); }
    list.remove();
    
    listeSpeichern();
    
  }
  
  
  public boolean pruefen(String pName) {
    
    if (list.isEmpty()) { return false; }
    else { list.toFirst(); }
    if (! list.hasAccess()) { return false; }
    
    list.toLast(); 
    String last = list.getContent().getName();
    
    list.toFirst();
    
    while (! list.getContent().getName().equalsIgnoreCase(last)) {
      
      if (list.getContent().getName().equalsIgnoreCase(pName)) { return true; }
      list.next();
      
    }
    
    if (list.getContent().getName().equalsIgnoreCase(pName)) { return true; }
    
    return false;
    
  }
  
  
  public int anzahlVonNamen(String pName) {
    
    int anzahl;
  
    if (list.isEmpty()) { return 0; }
    else { list.toFirst(); }
    if (! list.hasAccess()) { return 0; }
    
    list.toLast(); 
    String last = list.getContent().getName();
    
    list.toFirst();
    
    while (! list.getContent().getName().equalsIgnoreCase(last)) {
      
      if (list.getContent().getName().equalsIgnoreCase(pName)) { return list.getContent().getAnzahl(); }
      list.next();
      
    }
    
    if (list.getContent().getName().equalsIgnoreCase(pName)) { return list.getContent().getAnzahl(); }
    
    return 0;
    
  }
  
  
  public String ausgeben() {
    
    String output = "";
    
    if (list.isEmpty()) { return ""; }
    else { list.toFirst(); }
    if (! list.hasAccess()) { return ""; }
    
    list.toLast(); 
    String last = list.getContent().getName();
    
    list.toFirst();
    
    while (! list.getContent().getName().equalsIgnoreCase(last)) {
      
      //System.out.println(list.getContent().getName() + " (n)".replace("n", (list.getContent().getAnzahl() + "")));
      output = output.concat(list.getContent().getName() + " (n)".replace("n", (list.getContent().getAnzahl() + "")) + "\n");
      list.next();
      
    }
    
    //System.out.println(list.getContent().getName() + " (n)".replace("n", (list.getContent().getAnzahl() + "")));
    output = output.concat(list.getContent().getName() + " (n)".replace("n", (list.getContent().getAnzahl() + "")) + "\n");
    
    return output;
  }
  
  
  public List getListe() {
    return this.list;
  }
  
  
  private void listeSpeichern() throws IOException {
    
    if (list.isEmpty()) { return; }
    else { list.toFirst(); }
    if (! list.hasAccess()) { return; }
    
    try {
      
      new FileOutputStream("liste.txt").close();
      
      FileWriter fw = new FileWriter("liste.txt");
      BufferedWriter bw = new BufferedWriter(fw);
      
      list.toLast(); 
      String last = list.getContent().getName();
      
      list.toFirst();
      
      while (! list.getContent().getName().equalsIgnoreCase(last)) {
        
        bw.write(list.getContent().getName() + " (n)".replace("n", (list.getContent().getAnzahl() + "")) + "\n");
        list.next();
        
      }
      
      bw.write(list.getContent().getName() + " (n)".replace("n", (list.getContent().getAnzahl() + "")) + "\n");
      
      bw.close();
      
    }
    
    catch(IOException e) {
      
      System.out.println("Please provide a valid file, or a file at all...");
      System.out.println("Well, anyways, Im gone!");
      
      System.exit(1);
      
    }
  
  }
  
}

