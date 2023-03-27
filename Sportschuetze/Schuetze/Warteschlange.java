/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 10.11.2022
 * @author 
 */

public class Warteschlange {
  
  private class Kontainer {   //private innere Klasse
  
  // Anfang Attribute
  private Schuetze meinSchuetze;
  private Kontainer naechsterKontainer;
  // Ende Attribute
  
  // Anfang Methoden
  public Kontainer(Schuetze pSchuetze){
    this.meinSchuetze = pSchuetze;
    this.naechsterKontainer = null;
    }
  
  public void setNaechsterKontainer(Kontainer pKontainer)
  {
    this.naechsterKontainer = pKontainer;
    }
  
  public Schuetze getSchuetze(){
    return this.meinSchuetze;
    }
  
  public Kontainer getNaechsterKontainer(){
  
    return naechsterKontainer;
    }
  
  // Ende Methoden
} // end of Kontainer
  
  
  
  // Anfang Attribute
  
  private Kontainer ersterKontainer;
  private Kontainer letzterKontainer; 
  
  // Ende Attribute
  
  // Anfang Methoden
  
  public void schuetzeAusWarteschlangeEntfernen(){
    if(!this.istSchlangeLeer()){  // Schlange ist leer, nichts zu tun
    
      if(this.ersterKontainer == this.letzterKontainer){    //genau ein Schütze steht an? Dann einfach 2 Referenzen auf null
        this.ersterKontainer = null;
        this.letzterKontainer = null;
        }
      else{
          this.ersterKontainer = this.ersterKontainer.getNaechsterKontainer();
        
        }
      
      }
    
    
    }
  
  public void schuetzeAnstellen(Schuetze pSchuetze){
  
     Kontainer temp = new Kontainer(pSchuetze);
    
    if(this.istSchlangeLeer() == false){
       this.letzterKontainer.setNaechsterKontainer(temp);
       this.letzterKontainer = temp;;
       }
    
    else
    {
      this.ersterKontainer = temp;
      this.letzterKontainer = temp;
      }
    
    }
  
  public boolean istSchlangeLeer(){
       if(this.ersterKontainer == null){
       return true;
         }
    else{
      return false;
      }
    }
  
  
  public Schuetze getErsterSchuetze() {
    return this.ersterKontainer.getSchuetze();
  }

 
  // Ende Methoden
} // end of Warteschlange

