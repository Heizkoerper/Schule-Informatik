/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 06.02.2023
 * @author 
 */

public class Artikel {
  
  private int anzahl;
  private String name;

  
  public Artikel(String name, int anzahl) {
    this.anzahl = anzahl;
    this.name = name;
  }

  public void Artikel() {
    this.anzahl = 0;
    this.name = "";
  }
  
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String pName) {
    this.name = pName;
  }
  
  
  public int getAnzahl() {
    return this.anzahl;
  }
  
  public void setName(int pAnzahl) {
    this.anzahl = pAnzahl; 
  }

} 

