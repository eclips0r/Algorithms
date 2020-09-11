public class MinSearch {
    int[] array;

    /**
     * @param array = int[] auf das die gewuenschten Methoden angewendet werden
     *              sollen
     **/
    public MinSearch(int[] array) {
        this.array = array;
    }

    /**
     * <b>Invariante:</b> vor Schleifendurchlauf mit Index I ist A[min] kleinstes
     * Element in A[0...i+1]. <br>
     * </br>
     * <b>Initialisierung:</b> Der kleinste Index fuer die Schleife ist i = 1. Davor
     * ist A[min] = A[0]. <br>
     * </br>
     * <b>Erhaltung:</b> if-Abfrage ersetzt korrekt Minumum, wenn zusaetzlich A[i]
     * betrachtet wird. <br>
     * </br>
     * <b>Terminierung:</b> Vor Durchlauf mit i = n + 1 ist A[min] das Minimum der
     * Zahlen in A[0...n]. <br>
     * </br>
     * 
     * <b>Min-Search Laufzeit O(n)</b><br>
     * </br>
     * Beispiel auch auf S. 54 bezueglich Laufzeit<br>
     * </br>
     * 
     * @param array = zu durchlaufendes Array
     * @return Index der kleinsten Zahl
     * 
     * 
     **/
    public int minSearch(int[] array) {
        int min = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[min]) {
                min = i;
            }
        }
        return min;
    }
}
