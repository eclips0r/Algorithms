import java.util.concurrent.ThreadLocalRandom;

public class RandomQuickSort extends QuickSort {
    int[] array;

    public RandomQuickSort(int[] array) {
        this.array = array;
    }

    public int[] randomizedQuicksort(int[] A, int p, int r) {
        if (p < r) {
            int q = randomizedPartition(A, p, r);
            randomizedQuicksort(A, p, q - 1);
            randomizedQuicksort(A, q + 1, r);
        }
        return A;
    }

    public int randomizedPartition(int[] A, int p, int r) {
        // generiert eine zufaellige Zahl innerhalb der angegebenen Range (p...r)
        int i = ThreadLocalRandom.current().nextInt(p, r + 1);
        int temp = A[r];
        A[r] = A[i];
        A[i] = temp;
        return partition(A, p, r);
    }

}
