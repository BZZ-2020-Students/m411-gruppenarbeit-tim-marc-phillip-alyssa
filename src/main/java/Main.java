import sortAlgorithms.*;
import util.Measurement;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] array = {4, 1, 2, 8, 6, 5, 7, 12, 34, 123, 12, 3, 5, 234, 123, 123, 23, 423, 123, 534, 56546, 6999, 6755, 4565645, 2343212, 3213, 312};
        Quicksort quicksort = new Quicksort();
        Measurement measure = quicksort.sort(array);
        System.out.println("measure quicksort = " + measure);

        array = new int[]{4, 1, 2, 8, 6, 5, 7, 12, 34, 123, 12, 3, 5, 234, 123, 123, 23, 423, 123, 534, 56546, 6999, 6755, 4565645, 2343212, 3213, 312};
        BubbleSort bubbleSort = new BubbleSort();
        measure = bubbleSort.sort(array);
        System.out.println("measure bubblesort = " + measure);

        array = new int[]{4, 1, 2, 8, 6, 5, 7, 12, 34, 123, 12, 3, 5, 234, 123, 123, 23, 423, 123, 534, 56546, 6999, 6755, 4565645, 2343212, 3213, 312};
        BubbleSortAdvanced bubbleSortAdvanced = new BubbleSortAdvanced();
        measure = bubbleSortAdvanced.sort(array);
        System.out.println("measure bubblesort advanced = " + measure);

        array = new int[]{4, 1, 2, 8, 6, 5, 7, 12, 34, 123, 12, 3, 5, 234, 123, 123, 23, 423, 123, 534, 56546, 6999, 6755, 4565645, 2343212, 3213, 312};
        TreeSort treeSort = new TreeSort();
        measure = treeSort.sort(array);
        System.out.println("measure treesort = " + measure);
    }

    private void measureSorts() {
        var sorters = new ArrayList<Sorter>();

        sorters.add(new BubbleSort());
        sorters.add(new BubbleSortAdvanced());
        sorters.add(new Quicksort());
        sorters.add(new Quicksort());
    }
}
