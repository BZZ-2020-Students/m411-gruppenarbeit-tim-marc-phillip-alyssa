import sortAlgorithms.*;
import util.Export;
import util.InputReader;
import util.Measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] array = {4, 1, 2, 8, 6, 5, 7, 12};
//        Quicksort quicksort = new Quicksort();
//        Measurement measure = quicksort.sort(array);
//        System.out.println("measure quicksort = " + measure);
//
//        array = new int[]{4, 1, 2, 8, 6, 5, 7, 12};
//        BubbleSort bubbleSort = new BubbleSort();
//        measure = bubbleSort.sort(array);
//        System.out.println("measure bubblesort = " + measure);
//
//        array = new int[]{4, 1, 2, 8, 6, 5, 7, 12};
//        BubbleSortAdvanced bubbleSortAdvanced = new BubbleSortAdvanced();
//        measure = bubbleSortAdvanced.sort(array);
//        System.out.println("measure bubblesort advanced = " + measure);
//
//        array = new int[]{4, 1, 2, 8, 6, 5, 7, 12};
//        TreeSort treeSort = new TreeSort();
//        measure = treeSort.sort(array);
//        System.out.println("measure treesort = " + measure);

        System.out.print("Please ensure that all input samples are in the \"resources/inputfiles\" folder (enter 'y' to continue) > ");

        var main = new Main();

        var inputsamples = InputReader.getFileContent();
        var measurements = main.measureSorts(inputsamples);

        System.out.println(measurements);

        var export = new Export();

        try {
            export.export(measurements);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Measurement> measureSorts(int[][] inputsamples) {
        var measurements = new ArrayList<Measurement>();

        for (int[] is : inputsamples) {
            var sorters = createSorters();

            for (var sorter : sorters) {
                var isCopy = Arrays.copyOf(is, is.length);

                var m = sorter.sort(isCopy);

                m.setSorterName(sorter.getClass().getSimpleName());
                m.setSampleSize(is.length);

                measurements.add(m);

                System.out.println(m);
            }

        }

        System.out.println(measurements);

        return measurements;
    }

    private ArrayList<Sorter> createSorters() {
        var sorters = new ArrayList<Sorter>();

        sorters.add(new BubbleSort());
        sorters.add(new BubbleSortAdvanced());
        sorters.add(new Quicksort());
        sorters.add(new TreeSort());

        return sorters;
    }
}
