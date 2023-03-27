public class Sortieren {

    // Erstelle 3 Stapel, von welchen je einer eines der Gleise repräsentiert
    private Stack<Integer> A = new Stack<Integer>;
    private Stack<Integer> B = new Stack<Integer>;
    private Stack<Integer> C = new Stack<Integer>;


    /** Methode zum Bewegen des ersten Waggons eines Gleisen zu einem anderen
      * Nimmt den Buchstaben des Herkunftgleises als ersten Parameter
      * Nimmt den Buchstaben des zweiten Gleises als zweiten Parameter */
    private void fahre(Stack von, Stack nach) {

        if (von.isEmpty) return; // Falls das Gleis leer sein sollte, terminiere die Ausführung der Metode
        
        nach.push(von.top()); // >> Fahre << den Zug zum Zielgleis
        von.pop(); // Entferne den Zug von Herkunftsgleis

    }

    // Methode zum Sortieren der Waggons von Gleis A nach Gleis C, ihrer Größe nach
    private void sortieren() {

        while (!A.isEmpty()) { // Sortiere alle Waggons in umgekehrer Reihenfolge auf Gleis B, solange welche auf Gleis A stehen

            while ((!B.isEmpty) && (A.top > B.top)) { fahre(B, C); } // Solange der Waggon auf Gleis A größer ist werden die Waggons auf Gleis C umgeladen, sodass der Waggon richtig einsortiert werden kann

            fahre(A, B); // Sortiere den Waggon an die richtige Stelle auf Gleis B ein

            while (!C.isEmpty()) { fahre(C, B); } // Bringe die Waggons zurück von Gleis C auf Gleis B

        }

        while (!B.isEmpty()) { fahre(B, C); } // Solange noch Waggons auf Gleis B stehen werden diese auf Gleis C gefahren, wodurch die Reihenfolge invertiert wird

    }

}
