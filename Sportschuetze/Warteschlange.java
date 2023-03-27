/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 10.11.2022
 * @author 
 */

public class Warteschlange {
  
  // Anfang Attribute
  
  private Kontainer ersterKontainer;
  private Kontainer letzterKontainer; 
  
  // Ende Attribute
  
  // Anfang Methoden
  
  public void schuetzeAusWarteschlangeEntfernen(){
    if(!this.istSchlangeLeer()){  // Schlange ist leer, nichts zu tun
    
      if(this.ersterSchuetze == this.letzterSchuetze) {
        this.ersterSchuetze = null;
        this.letzterSchuetze = null;
        }
      else {
          this.ersterSchuetze = this.ersterSchuetze.getNaechsterSchuetze();
        
        }
      
      }
    
    
    }
  
  public void schuetzeAnstellen(){
  
    Schuetze neuerSchuetze = new Schuetze();
    
    if(this.istSchlangeLeer() == false) {
       letzterSchuetze.setNaechsterSchuetze(neuerSchuetze);
       letzterSchuetze = neuerSchuetze;
    }
    
    else {
      ersterSchuetze = neuerSchuetze;
      letzterSchuetze = neuerSchuetze;
    }
    
  }
  
  public boolean istSchlangeLeer(){
       if(this.ersterSchuetze == null){
       return true;
         }
    else{
      return false;
      }
    }
  
  
  public Schuetze getErsterSchuetze() {
    return ersterSchuetze;
  }

  public void setErsterSchuetze(Schuetze ersterSchuetzeNeu) {
    ersterSchuetze = ersterSchuetzeNeu;
  }
  // Ende Methoden
} // end of Warteschlange

