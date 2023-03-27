/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 24.10.2022
 * @author 
 */

public class Schuetze {
  
  // Anfang Attribute
   private int[] treffer;
  private int schuesse;
  //
  // Ende Attribute
  
  // Anfang Methoden
  public Schuetze(){
    treffer = new int[5];
    }
  
  public int trefferZusammenfuegen(){
   
    int summe = 0;
    for (int i=0; i<treffer.length; i++) {
      summe = summe + treffer[i]*(i+1);    
    }
    return summe;
  }
  
  public void trefferEinfuegen(int pTreffer){
  
     if (schuesse < 20) {
          
        if(pTreffer > this.treffer.length || pTreffer <= 0){
        
          System.out.println("Der Wert liegt außerhalb des Trefferfeldes");
            
          }
        else {
           this.treffer[pTreffer-1] = this.treffer[pTreffer-1] + 1;
          schuesse = schuesse + 1;
          }
        
    } 
    else {
      
      System.out.println("Die Anzahl der Treffer nach 20 Schüssen beträgt " + this.trefferZusammenfuegen());
      this.arrayAufraeumen();
    
    
    } 
  
  } 
  
  
  private void arrayAufraeumen(){
    for (int j = 0;j < this.treffer.length ;j++ ) {
        this.treffer[j]=0;
      this.schuesse = 0;
    } // end of for
    
     }

 

    // Ende Methoden
} // end of Schuetze

