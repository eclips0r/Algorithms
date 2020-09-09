public class MergeSort {
    int[] numbers;

    /**
     * @param numbers = int[] auf das die gewuenschten Methoden angewendet werden
     *                sollen
     **/
    public MergeSort(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * Sortiert mittels rekursiven Aufruf ein uebergebenes Array.<br>
     * </br>
     * 
     * 
     * Merge-Sort besitzt Laufzeit Theta(n*log(n))<br>
     * </br>
     * 
     * @param numbers = zu sortierendes Array
     * @param p       = Anfangspunkt (Index) der Sortierung
     * @param r       = Endpunkt (Index) der Sortierung
     * 
     **/
    public int[] mergeSort(int[] numbers, int p, int r) {
        int q;
        if (p < r) {
            q = (int) Math.floor((p + r) / 2);
            mergeSort(numbers, p, q);
            mergeSort(numbers, q + 1, r);
            merge(numbers, p, q, r);
        }
        return numbers;
    }

    /**
     * <b>Invariante:</b> Vor Durchlauf der for-Schleife mit Index k enthaelt das
     * Array A[p...k - 1] die k - p kleinsten Zahlen aus den Arrays left und right
     * in sortierter Reihenfolge. Außerdem sind left[i] und right[j] jeweils die
     * kleinsten noch nicht einsortieten Elemente in den Arrays left bzw. right.<br>
     * </br>
     * <b>Initialisierung:</b> Vor Durchlauf mit k = p ist das Array A[p...k - 1]
     * leer. Daher ist die Invariante erfuellt.<br>
     * </br>
     * <b>Erhaltung:</b> Es gelte left[i] <= right[j]. Dann ist left[i] kleinstes
     * noch nicht einsortiertes Element. Damit enthaelt A[p...k] die k - p + 1
     * kleisnten Elemente. Zusammen mit der Erhoehung der Zaehler i, k garantiert
     * dies die Erhaltung der Invariante. Analog im Fall left[i] > right[j]. <br>
     * </br>
     * <b>Terminierung:</b> Nach Ende der Schleife enthaelt A[p...r] die r - p + 1
     * kleinsten Elemente sortiert. Array wurde vollstaendig sortiert. <br>
     * </br>
     * 
     * <b>merge Laufzeit Theta(n)</b> <br>
     * </br>
     * Laufzeit-Analyse auf S. 92 ff., II<br>
     * </br>
     * 
     * @param numbers = zu sortierendes Array
     * @param p       = linker Index (Anfang)
     * @param q       = Mitte wo Array geteilt wird
     * @param r       = rechter Index (Ende)
     * @return aufsteigend sortiertes Array (mittels rekursiven Aufruf in
     *         mergeSort())
     * 
     * 
     **/
    public void merge(int[] numbers, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        // Erzeuge TeilArrays L und R
        int[] left = new int[n1 + 1];
        for (int i = 0; i < n1; i++) {
            left[i] = numbers[p + i];
        }

        int[] right = new int[n2 + 1];
        for (int j = 0; j < n2; j++) {
            right[j] = numbers[q + j + 1];
        }

        left[n1] = Integer.MAX_VALUE; // in case of double: Double.POSITIVE_INFINITY
        right[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        for (int k = p; k <= r; k++) {
            if (left[i] <= right[j]) {
                numbers[k] = left[i];
                i++;
            } else {
                numbers[k] = right[j];
                j++;
            }
        }
    }
}
