/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 15.08.2022
 * @author 
 */
 
import java.io.*;
import java.util.*;

public class CD_Regal {
  
  // Anfang Attribute
  CD[] cds = new CD[50]; 
  // Ende Attribute
  
  // Anfang Methoden
    /*public void CD_Regal() {
        cds = new CD[50];
    }*/

    /*public void cdEinfuegen(String pTitel, int pStelle) throws Excepion {
        // Überprüfen ob Liste noch nicht voll ist
        if (cds.length >= 50) {
            throw new Exception();
        }
    }*/
  
    public CD_Regal() {
      try {
          this.sammlungEinlesen(); 
      } catch(IOException e) {
        assert true;
      }
    }
  
  
    public boolean cdEinfuegenStelle(CD pCd, int pStelle) {
        if (cds.length >= 50) {
            return false;
        }
          
        if (cds[pStelle] != null) {                     
           cds[pStelle] = pCd;
           return true;
        }  
        else {
             return false;
        }
    }
  
  
    public boolean cdEinfuegen(CD pCd) {
        if (Arrays.stream(cds).filter(e -> e != null).count() >= 50) {
           System.out.println(String.valueOf(Arrays.stream(cds).filter(e -> e != null).count()));
           return false;
        }
          
        int frei = (int) Arrays.stream(cds).filter(e -> e != null).count();
        cds[frei] = pCd;
    
        return true;
    }


    public int cdSuchen(String pTitel, String pInterpret) {
           for (int i = 0; i < cds.length; i++) {
               CD cd = cds[i];
      
               if (cd.getTitel() == pTitel && cd.getInterpret() == pInterpret) {
                  return i;
               }
               else {
                    return 0;
               }
           }
           
           return 0;
    }

    public void cdEntfernen(String pTitel) {

    }

    public void alleTitelAusgeben() {
        System.out.println(Arrays.toString(cds));
    }
  
    public void /*CD[]*/ nachInerpretenFiltern() {
    }
  
    public void sammlungSpeichern() throws IOException, ClassCastException {
         try {
            FileWriter fw = new FileWriter("sammlung.txt");
            BufferedWriter bw = new BufferedWriter(fw);
  
            for (int i = 0; i <= cds.length; i++) {
                if (cds[i] != null) {
                   String titel = cds[i].getTitel();
                   String interpret = cds[i].getInterpret();
                   String jahr = Integer.toString(cds[i].getErscheinungsjahr());
  
                   bw.write(titel+"\n");
                   bw.write(interpret+"\n");
                   bw.write(jahr+"\n");
                }
                else {
                   bw.close();
                   break;
                }
            }
        }
        catch(IOException e) {
            System.out.println("Please provide a valid file, or a file at all...");
            System.out.println("Well, anyways, Im gone!");
            System.exit(1);
        }
    }
  
    public void sammlungEinlesen() throws IOException, ClassCastException {
        try {
            System.out.println("Test");
            FileReader fr = new FileReader("sammlung.txt");
            BufferedReader br = new BufferedReader(fr);
        
            for (int i = 0; i <= cds.length; i++) {
                String zeile1 = br.readLine();
                String zeile2 = br.readLine();
                String zeile3 = br.readLine();
        
                System.out.println(zeile1);
          
                if (zeile1 != null && zeile2 != null && zeile3 != null) {
                   CD temp = new CD(zeile1, zeile2, Integer.valueOf(zeile3));
                   cdEinfuegen(temp);
                }
                else {
                    br.close();
                    break;
                }  
            }
        }
        catch(IOException e) {
            System.out.println("Please provide a valid file, or a file at all...");
            System.out.println("Well, anyways, Im gone!");
        }
        catch(ClassCastException e) {
            System.out.println("Please provide a file with valid content...");
            System.out.println("Well, anyways, Im gone!");
        }
    }
  
    /*public void cdSortierenErscheinungsjahr() {
           int len = (int) Arrays.stream(cds).filter(e -> e != null).count();
          
           while(len > 1) {
              for (int i = 0; i <= len-2; i++) {
                  if (cds[len] != null && cds[len].getErscheinungsjahr() > cds[len+1].getErscheinungsjahr()) {
                     cdsTauschen(len, len+1);
                  }
              }
           }
        }*/
  
        public void cdSortierenErscheinungsjahr() {
            int len = cds.length;
    
            for(int i = 0; i < (len-1); i++) {
                for(int j = 0; j<(len-1-i); j++) {
                    if(cds[j] != null && cds[j+1] != null) {
                        if( cds[i].getErscheinungsjahr() > cds[i+1].getErscheinungsjahr()) {
                            cdsTauschen(j, j+1);
                        }
                    }
                }
            }
        }
    
        private void cdsTauschen(int pos1, int pos2) {
           CD temp = cds[pos2]; //Zwischenspeichern
           cds[pos2] = cds[pos1]; //pos2 durch pos1 ersetzen
           cds[pos1] = temp; //pos1 durch temp ersetzen
        }

  // Ende Methoden

}

