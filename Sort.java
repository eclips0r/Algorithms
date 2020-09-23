/**
 * Dieses Interface ermoeglicht eine leichtere Lesbarkeit der einzelnen
 * Algorithmen und stellt Vereinheitlichung der Sortiermethoden dar.
 **/
public interface Sort {

    /**
     * Benoetigt fuer: QuickSort (+ Variationen), MergeSort
     * 
     * @param array - zu sortierendes Array
     * @param start - Index des Anfangspunktes der Sortierung
     * @param end   - Index des Endpunktes der Sortierung
     **/
    public int[] sort(int[] array, int start, int end);

    /**
     * Benoetigt fuer: HeapSort, InsertionSort
     * 
     * @param array - zu sortierendes Array
     **/
    public int[] sort(int[] array);

}
