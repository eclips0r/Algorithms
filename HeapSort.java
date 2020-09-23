public class HeapSort implements Sort {
    int[] array;
    int heapSize; // Elemente in Array

    public HeapSort(int[] array) {
        this.array = array;
        this.heapSize = array.length - 1;
    }

    /**
     * 
     * <b>Laufzeit</b> von HeapSort ist O(n*log(n)).
     * 
     * @param A - zu sortierendes Array
     * @return sortiertes Array in aufsteigender Reihenfolge
     */
    public int[] sort(int[] A) {
        buildMaxHeap(A);
        for (int i = heapSize; i > 0; i--) {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            heapSize--; // rechtestes Element in richtiger Position, wird nicht mehr betrachtet
            maxHeapify(A, 0);
        }
        return A;
    }

    /**
     * <b>Invariante:</b> ohne Beschraenkung der Allgemeinheit gilt i = 1 <br>
     * </br>
     * Vor jedem Aufruf von maxHeapify(A, largest) wird die max-Heap-Eigenschaft,
     * wenn ueberhaupt, nur von getLeft(largest) und/oder getRight(largest)
     * verletzt.<br>
     * </br>
     * Des Weiteren gilt: getParent(largest) >= getLeft(largest) &&
     * getParent(largest) >= getRight(largest). <br>
     * </br>
     * <b>Analyse:</b><br>
     * </br>
     * 1. ist h die Hoehe des Teilbaums mit Wurzel i im Heap A, so hat maxHeapify(A,
     * i) Laufzeit Theta(h). <br>
     * </br>
     * 2. ist n die Groesse des Teilsbaums mit Wurzel i im Heap A, so hat
     * maxHeapify(A, i) Laufzeit Theta(log(n)).
     **/
    public void maxHeapify(int[] A, int i) {
        int largest;
        int left = getLeft(i);
        int right = getRight(i);
        if (left <= heapSize && A[left] > A[i]) {
            largest = left;
        } else {
            largest = i;
        }
        if (right <= heapSize && A[right] > A[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            maxHeapify(A, largest);
        }
    }

    /**
     * <b>Invariante:</b> Vor Durchlauf der for-Schliefe mit Index i sind die Knoten
     * i + 1,...,n Wurzeln von max-Heaps.<br>
     * </br>
     * <b>Initialisierung:</b> Zu Beginn gilt i = floor(n/2). Knoten i > floor(n/2)
     * sind Blaetter und damit Wurzeln von max-Heaps. <br>
     * </br>
     * <b>Erhaltung:</b> maxHeapify(A, i) stellt max-Heap-Eigenschaft bei Knoten i
     * her und erhaelt max-Heap-Eigenschaft bei Knoten j > i. <br>
     * </br>
     * <b>Terminierung:</b> Knoten 1 ist Wurzel eines max-Heaps. Damit ist der
     * Algorithmus korrekt. <br>
     * </br>
     * <b>Laufzeit</b> von maxHeapify ist O(n).
     * 
     * @param A = unstrukturiertes Array
     * @return max-Heap ueber A
     **/
    public void buildMaxHeap(int[] A) {
        for (int i = (int) Math.floor(heapSize / 2); i >= 0; i--) {
            maxHeapify(A, i);
        }
    }

    /**
     * @param i startpoint in the tree
     * @return index of Parent-Node from index i
     */
    public int getParent(int i) {
        return (i - 1) / 2;
    }

    /**
     * @param i startpoint in the tree
     * @return index of left child from index i
     */
    public int getLeft(int i) {
        return (2 * i) + 1;
    }

    /**
     * @param i startpoint in the tree
     * @return index of right child from index i
     */
    public int getRight(int i) {
        return (2 * i) + 2;
    }

    @Override
    public int[] sort(int[] array, int start, int end) {
        System.out.println("Please use sort-method without start- and endpoint!");
        return null;
    }
}
