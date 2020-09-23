import java.util.concurrent.ThreadLocalRandom;

public class RandomQuickSort extends QuickSort {
    int[] array;

    public RandomQuickSort(int[] array) {
        this.array = array;
    }

    /**
     * Erwartete Laufzeit ist Theta(n*log(n)) - diese wird aus Zufallsexperimente in
     * randomizedPartition genommen
     * 
     * @param A = zu sortierendes Array
     * @param p = Anfangspunkt der Sortierung (Index)
     * @param r = Endpunkt der Sortierung (Index)
     **/
    public int[] sort(int[] A, int p, int r) {
        if (p < r) {
            int q = randomizedPartition(A, p, r);
            sort(A, p, q - 1);
            sort(A, q + 1, r);
        }
        return A;
    }

    /**
     * Bevor hier tatsaechlich partitioniert wird, werden zwei zufaellige Zahlen
     * innerhalb des Arrays ausgetauscht
     * 
     * @param A = zu sortierendes Array
     * @param p = Anfangspunkt der Sortierung (Index)
     * @param r = Endpunkt der Sortierung (Index)
     **/
    public int randomizedPartition(int[] A, int p, int r) {
        // generiert eine zufaellige Zahl innerhalb der angegebenen Range (p...r)
        int i = ThreadLocalRandom.current().nextInt(p, r + 1);
        int temp = A[r];
        A[r] = A[i];
        A[i] = temp;
        return partition(A, p, r);
    }
}
