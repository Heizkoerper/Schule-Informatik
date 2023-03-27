import java.util.HashMap;


public class Verkehrskontrolle {
  
  private Queue<Fahrzeug> queue;
  private HashMap<String, Integer> mapTypUntauglich;
  
  private int schwellwertUntauglich;
  private int schwellwertGenerell;
  
  private int kontrollierteFahrzeuge = 0;
  
  public Verkehrskontrolle(int pSchwellwertUntauglich, int pSchwellwertGenerell) {
    queue = new Queue<Fahrzeug>();
    mapTypUntauglich = new HashMap<String, Integer>();
    
    schwellwertUntauglich = pSchwellwertUntauglich;
    schwellwertGenerell = pSchwellwertGenerell;
  }
  
  private void herauswinken(Fahrzeug f) {
    queue.enqueue(f);
  }
  
  private void ueberpruefen() {
    Fahrzeug f = queue.front();
    kontrollierteFahrzeuge++;
    
    if(!(f.getVerkehrstauglichkeit())) {
      try {
        int n = mapTypUntauglich.get(f.getModell());
        mapTypUntauglich.remove(f.getModell());
        mapTypUntauglich.put(f.getModell(), n++);
      }
      catch(Exception e) {
        mapTypUntauglich.put(f.getModell(), 1);
      }
    }
    
    int n = 0;
    
    for (Integer i : mapTypUntauglich.values()) {
      n = (int) i + n;
    }
    
    if(schwellwertGenerell == kontrollierteFahrzeuge || schwellwertUntauglich == n) this.kolonneAufloesen();
    else this.weiterwinken();
  }
  
  private void weiterwinken() {
    queue.dequeue();
  }
  
  private void kolonneAufloesen() {
    queue = null;
    System.gc();
  }
 
}

