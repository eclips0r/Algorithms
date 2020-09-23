public class QuickSort implements Sort {
    int[] array;

    // wird fuer RandomQuickSort benoetigt
    public QuickSort() {
    }

    public QuickSort(int[] array) {
        this.array = array;
    }

    /**
     * <b>Laufzeiten: </b><br>
     * </br>
     * <b>worst-case:</b> Theta(n^2)<br>
     * </br>
     * <b>Average-case:</b> Theta(n*log(n))<br>
     * </br>
     * 
     * @param A = zu sortierendes Array
     * @param p = Anfangspunkt der Sortierung (Index)
     * @param r = Endpunkt der Sortierung (Index)
     **/
    public int[] sort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            sort(A, p, q - 1);
            sort(A, q + 1, r);
        }
        return A;
    }

    /**
     * <b>Invariante:</b> Vor Durchlauf der for-Schleife mit Index j gilt fuer jeden
     * Index k:<br>
     * </br>
     * 1. Falls p <= k <= i, dann ist A[k] <= x. <br>
     * </br>
     * 2. Falls i + 1 <= k <= j - 1, dann ist A[k] > pivot. <br>
     * </br>
     * 3. Falls k = r, dann ist A[k] = pivot. <br>
     * </br>
     * <b>Initialisierung:</b> Vor dem ersten Schleifendurchlauf gitl i = p - 1 und
     * j = p. Daher gibt es in diesem FAll keine Indizes zwischen p und i (1.
     * Bedingung) bzw. zwischen i + 1 und j - 1 (2. Bedingung). Die erste Zeile
     * sorgt dafuer, dass die dritte Bedigungn ebenfalls erfuellt ist.<br>
     * </br>
     * <b>Erhaltung:</b> zwei Faelle: <br>
     * </br>
     * 1. A[j] > pivot -- Nur j wird erhoeht. Damit ist die zweite Bedingung auch
     * fuer k = j erfuellt.<br>
     * </br>
     * 2. A[j] <= pivot -- Element A[j] kommt an Position i. Da A[j] <= pivot ist
     * die erste Bedingung weiter erfuellt. Fuer neues A[j-1] gilt nach
     * Voraussetzung A[j-1] > pivot. Damit ist auch die zweite Bedingung erfuellt.
     * <br>
     * </br>
     * <b>Terminierung:</b> Es gilt j = r und alle Elemente des Arrays wurden mit
     * pivot verglichen. Der Tausch ausserhalb der for-Schleife stellt sicher, dass
     * pivot zwischen die Elemente < pivot und die Elemente > pivot platziert wird.
     * Damit genuegt die von partition berechnete Aufteilung immer den Anforderungen
     * von Quicksort. <br>
     * </br>
     * 
     * <b>Partition hat Laufzeit Theta(n)</b> <br>
     * </br>
     * Laufzeit-Analyse auf S. 92 ff., II<br>
     * </br>
     * 
     * @param A = zu sortierendes Array
     * @param p = linker Index (Anfang)
     * @param r = rechter Index (Ende)
     * @return Index, um den sich die Sortierung wendet
     * 
     * 
     **/
    public int partition(int[] A, int p, int r) {
        int temp;
        int i;
        int pivot = A[r];
        i = p - 1;

        for (int j = p; j <= r - 1; j++) {
            if (A[j] <= pivot) {
                i++;
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        temp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = temp;
        return i + 1;
    }

    @Override
    public int[] sort(int[] array) {
        System.out.println("Please use sort-method with start- and endpoint!");
        return null;
    }
}
