/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 17.10.2022
 * @author 
 */
 
package Sportsütze;

import com.*;
 
import java.util.ArrayList;

public class Sportschuetze {
  private int[] pfeffer = new int[5];
  private int anzahlPfeffer = 0;
  private int count;
  
  public static ArrayList<Sportschuetze> queue = new ArrayList<Sportschuetze>();

  
  public Sportschuetze(){
    queue.add(this); 
    System.out.println("Eingetragen");
  }
  
  // Anfang Methoden
  public void pfefferEinfügen(int pPfeffer) throws Exception {
    if(pPfeffer > pfeffer.length || pPfeffer <= 1) throw new Exception("valueOutOfBound - Der Wert liegt ausßerhalb des vorgesehenen Bereiches");
    
    count = pfeffer[pPfeffer-1] + 1;
    pfeffer[pPfeffer-1] = count;
    
    anzahlPfeffer++;
    
    if(anzahlPfeffer == 20) zusammenZaehlen();
  }
  
  public int zusammenZaehlen() {
    int sum = 0;
    
    for (int i = 0; i < pfeffer.length; i++) {
      sum += (pfeffer[i] * (i+1));
    }
      
    System.out.println("Das Ergebnis des Schützen beläut sich auf " + Integer.toString(sum) + " Punkte.");
    
    return(sum);
  }
  
  private void reset() {
    count = 0;
    pfeffer = null;
    
    System.gc();
  }
  
  public void hello() {
    System.out.println(Integer.toString(queue.size()));
  }
  // Ende Methoden
}

