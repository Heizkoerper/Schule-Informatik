/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 24.10.2022
 * @author 
 */

public class Duell {
  
  // Anfang Attribute
  // Ende Attribute
  private Schuetze besterSchuetze;
  
  // Anfang Methoden
  
  public Duell(){
  
    }
  
  public Schuetze besterSchuetze(Schuetze pSchuetze1, Schuetze pSchuetze2) {
     
        if(pSchuetze1.trefferZusammenfuegen()> pSchuetze2.trefferZusammenfuegen()){
    
         System.out.println("Schuetze 1 hat gewonnen!");
         return pSchuetze1;
          }
        else if(pSchuetze1.trefferZusammenfuegen() < pSchuetze2.trefferZusammenfuegen()){
    
           System.out.println("Schuetze 2 hat gewonnen!");
         return pSchuetze2;
      } // end of if-else
          else{
                System.out.println("Unentschieden!");
      return null;
            }
    
    }
  // Ende Methoden
} // end of Duell

