/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 15.08.2022
 * @author 
 */

public class CD {
  
  // Anfang Attribute
  private String titel;
  private String interpret;
  private int erscheinungsjahr;
  // Ende Attribute
  
  public CD(String pTitel, String pInterpret, int pErscheinungsjahr) {
    this.titel = pTitel;
    this.interpret = pInterpret;
    this.erscheinungsjahr = pErscheinungsjahr;
  }

  // Anfang Methoden
  public String getTitel() {
    return this.titel;
  }

  public String getInterpret() {
    return this.interpret;
  }

  public int getErscheinungsjahr() {
    return this.erscheinungsjahr;
  }

  // Ende Methoden
} // end of CD

