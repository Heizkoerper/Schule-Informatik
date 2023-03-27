/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 10.11.2022
 * @author 
 */

public class Kontainer {
  
  // Anfang Attribute
  private Sportschueze meinSchuetze;
  private Kontainer naechsterKontainer;
  // Ende Attribute
  
  // Anfang Methoden
  public Kontainer(Schuetze pSchuetze) {
    this.meinSchuetze = pSchuetze;
  }
  
  public void setNaechsterKontainer(Kontainer pKontainer) {
    this.naechsterKontainer = pKontainer;
  }
  
  public Sportschueze getSchuetze() {
    return meinSchuetze;
  }
  
  // Ende Methoden
} // end of Kontainer

