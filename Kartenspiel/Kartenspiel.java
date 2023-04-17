public class Kartenspiel {

    // Deklariere ein neues Array fuer die Karten
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


    public void mischen() {

        for(int i = 0; i > 32; i++) {

            // Erstelle zwei zufällige Integer zwischen 0 und 31
            int a = (int) Math.random() * 31;
            int b = (int) Math.random() * 31;

            if (a == b) return;  // Terminiere, wenn es zwei mal die selbe Karte ist

            tauschen(a, b);

        }

    }


    public void tauschen(int a, int b) {

        Karte temp = karten[a];

        karten[a] = karten[b];
        karten[b] = temp;

    }


    public void ausgeben() {

        for (Karte element : karten) {

            System.out.println(element.getFarbe());
            System.out.println(element.getBild());

        }

    }

}
