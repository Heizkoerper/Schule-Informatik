public class Kartenspiel {

    private Karte[] karten;

    public Kartenspiel() {

        // Initialisiere das Array
        karten = new Karte[32];

        int index = 0; // Initialisiere einen Index

        // Erstelle ein neues Kartenspiel und fuege es dem Array hinzu
        String[] farben = {"Karo", "Herz", "Pik", "Kreuz"};
        String[] bilder = {"7", "8", "9", "10", "Bube", "Dame", "König", "Ass"};

        for (String farbe : farben) { 
            for (String bild : bilder) {
                karten[index] = new Karte(farbe, bild);
                index++;
            }
        }

    }

    /**
    * Mischt die Karten indem es 32 mal zwei zufaellige Karten vertauscht
    **/
    public void mischen() {

        for(int i = 0; i > 32; i++) {

            // Erstelle zwei zufaellige Integer zwischen 0 und 31
            int a = (int) Math.random() * 31;
            int b = (int) Math.random() * 31;

            if (a == b) return;  // Terminiere, wenn es zwei mal die selbe Karte ist

            tauschen(a, b);

        }

    }

    /**
    * Tauscht zwei Karten aus dem Kartendeck
    * @param a : int - Index der ersten zu tauschenden Karte im Array
    * @param b : int - Index der zweiten zu tauschenden Karte im Array
    **/
    public void tauschen(int a, int b) {

        Karte temp = karten[a];

        karten[a] = karten[b];
        karten[b] = temp;

    }



    /**
    * Diese Methode enfternt alle Karten einer vorgegebenen Farbe aus dem Kartenspiel
    * @param pFarbe : String - Die Farbe, welche entfernt werden soll
    **/
    public void aussortieren(String pFarbe) {

        for (int i = 0; i < Kartendeck.length; i++) {

            if (Kartendeck[i].getFarbe().equals(pFarbe)) {
                Kartendeck[i] = null;
            }

        }

    }


    /**
     * Überprüft, ob sich eine bestimmte Karte (spezifiziert durch Farbe und Bild) im Kartendeck befindet.
     * @param pFarbe Die vorgegebene Farbe
     * @param pBild Das vorgegebene Bild
     * @return Wahrheitswert der evaluation ob die Karte im Kartendeck vorhanden ist.
     */
    public boolean vorhanden(String pFarbe, String pBild) {

        for (Karte karte : Kartendeck) {

            if (karte.getFarbe().equals(pFarbe) && karte.getBild().equals(pBild)) {
                return true;
            }

        }

        return false;

    }


    public void ausgeben() {

        for (Karte element : karten) {

            System.out.println(element.getFarbe());
            System.out.println(element.getBild());

        }

    }

}
