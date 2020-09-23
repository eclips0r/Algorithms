public class InsertionSort implements Sort {
    int[] array;

    /**
     * @param array = int[] auf das die gewuenschten Methoden angewendet werden
     *              sollen
     **/
    public InsertionSort(int[] array) {
        this.array = array;
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
     * @param array = zu sortierendes Array
     * @return aufsteigend sortiertes Array
     * 
     * 
     **/
    public int[] sort(int[] array) {
        int key;
        int i;

        for (int j = 1; j <= array.length; j++) {
            key = array[j - 1];
            i = j - 1;
            while (i > 0 && array[i - 1] > key) {
                array[i] = array[i - 1];
                i--;
            }
            array[i] = key;
        }
        return array;
    }

    @Override
    public int[] sort(int[] array, int start, int end) {
        System.out.println("Please use sort-method without start- and endpoint!");
        return null;
    }

}
