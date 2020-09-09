public class InsertionSort {
    int[] numbers;

    /**
     * @param numbers = int[] auf das die gewuenschten Methoden angewendet werden
     *                sollen
     **/
    public InsertionSort(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * <b>Invariante:</b> Vor Durchlauf der for-Schleife fuer Index j gilt, dass
     * A[0...j-1] die j - 1 Eingabezahlen in sortierter Reihenfolge enthaelt. <br>
     * </br>
     * <b>Initialisierung:</b> j = 1 und A[1] ist sortiert, da es nur eine Zahl
     * enthaelt <br>
     * </br>
     * <b>Erhaltung:</b> while-Schleife zusammen mit letzter Zuweisung sortiert A[j]
     * korrekt ein <br>
     * </br>
     * <b>Terminierung:</b> Vor Durchlauf mit j = A.length + 1 ist A[0...A.length-1]
     * sortiert <br>
     * </br>
     * 
     * <b>Insertion-Sort Laufzeit Theta(n^2)</b> <br>
     * </br>
     * Laufzeit-Analyse auf S. 65, II<br>
     * </br>
     * 
     * @param numbers = zu sortierendes Array
     * @return aufsteigend sortiertes Array
     * 
     * 
     **/
    public int[] insertionSort(int[] numbers) {
        int key;
        int i;

        for (int j = 1; j <= numbers.length; j++) {
            key = numbers[j - 1];
            i = j - 1;
            while (i > 0 && numbers[i - 1] > key) {
                numbers[i] = numbers[i - 1];
                i--;
            }
            numbers[i] = key;
        }
        return numbers;
    }

}
