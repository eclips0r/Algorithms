/**
 * Hier koennen alle Sortieralgorithmen ausprobiert und getestet werden. Dazu
 * muss zuerst ein Objekt der jeweiligen Klasse/ des jeweiligen Verfahrens
 * erstellt werden und danach kann auf die entsprechenden Methoden zugegriffen
 * werden <br>
 * </br>
 * Die Zahlenfolge sowie die print-Methode koennen nach Belieben angepasst und
 * veraendert werden
 **/
public class Algorithmen {
    public static void main(String[] args) {

        int[] numbers = { 31, 41, 59, 26, 51, 48, 909, 10, 40, 39, 22, 23, 22, };
        int[] test = { 8, 15, 3, 14, 7, 6, 121, 3 };
        printArray(numbers);
        HeapSort heap = new HeapSort(numbers);
        printArray(heap.heapSort(numbers));

        printArray(numbers);
        QuickSort quick = new QuickSort(numbers);
        printArray(quick.quicksort(numbers, 0, numbers.length - 1));

        MinSearch min = new MinSearch(test);
        System.out.println(min.minSearch(test));

        MergeSort merge = new MergeSort(numbers);
        printArray(merge.mergeSort(numbers, 0, numbers.length - 1));

        InsertionSort ins = new InsertionSort(numbers);
        printArray(ins.insertionSort(numbers));
    }

    /** Printet uebergebenes Array in die Konsole **/
    public static void printArray(int[] numbers) {
        String s = "";

        for (int i = 0; i < numbers.length - 1; i++) {
            s += numbers[i] + " ";
        }
        System.out.println(s + numbers[numbers.length - 1]);
    }
}