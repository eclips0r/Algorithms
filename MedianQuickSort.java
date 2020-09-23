/** Docs folgen... **/

public class MedianQuickSort extends QuickSort {
    int[] array;

    public MedianQuickSort(int[] array) {
        this.array = array;
    }

    public int[] sort(int[] A, int p, int r) {
        if (p < r) {
            int q = medianPartition(A, p, r);
            sort(A, p, q - 1);
            sort(A, q + 1, r);
        }
        return A;
    }

    public int medianPartition(int[] A, int p, int r) {
        int i = median(A, p, (int) Math.floor((p + r) / 2), r);
        int temp = A[r];
        A[r] = A[i];
        A[i] = temp;
        return partition(A, p, r);
    }

    public int median(int[] A, int i, int j, int k) {
        if (A[i] <= A[j] && A[k] <= A[i]) {
            return i;
        } else if (A[i] <= A[j] && A[k] >= A[j]) {
            return j;
        } else
            return k;
    }
}
