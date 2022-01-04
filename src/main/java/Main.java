import sortAlgorithms.BubbleSort;
import sortAlgorithms.BubbleSortAdvanced;
import sortAlgorithms.Quicksort;
import util.Measurement;

public class Main {
    public static void main(String[] args) {
        int[] array = {4, 1, 2, 8, 6, 5, 7, 12};
        Quicksort quicksort = new Quicksort();
        Measurement measure = quicksort.sort(array);
        System.out.println("measure = " + measure);

        array = new int[]{4, 1, 2, 8, 6, 5, 7, 12};
        BubbleSortAdvanced bubbleSortAdvanced = new BubbleSortAdvanced();
        measure = bubbleSortAdvanced.sort(array);
        System.out.println("measure = " + measure);

        array = new int[]{4, 1, 2, 8, 6, 5, 7, 12};
        BubbleSort bubbleSort = new BubbleSort();
        measure = bubbleSort.sort(array);
        System.out.println("measure = " + measure);
    }
}
