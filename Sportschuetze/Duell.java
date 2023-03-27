/**
 *
 * Beschreibung
 *
 * @version 1.0 - 24.10.2022
 * @author Jonathan Schnieders 
 */

public class Duell {
  private Sportschuetze besterSchuetze;
  
  public Sportschuetze getBesterSchuetze(Sportschuetze pSchuetze1, Sportschuetze pSchuetze2) {
    
    
    int p1 = pSchuetze1.zusammenZaehlen();
    int p2 = pSchuetze2.zusammenZaehlen();
    
    if(p1 > p2) {;
      besterSchuetze = pSchuetze1;
      System.out.println("Schütze 1 gewinnt");
    }
    else if(p2 > p1) {
      besterSchuetze = pSchuetze2;
      System.out.println("Schütze 2 gewinnt"); 
    }
    else {
      besterSchuetze = null;
      System.out.println("Unentschieden");
    } 
    
    return besterSchuetze; 
  }
} 

