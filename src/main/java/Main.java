import sortAlgorithms.*;
import util.Export;
import util.InputReader;
import util.Measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        System.out.print("Please ensure that all input samples are in the \"resources/inputfiles\" folder (enter 'y' to continue) > ");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (!input.equalsIgnoreCase("y")) {
            System.out.println("Programm will stop...");
            return;
        }
        sc.close();

        var main = new Main();

        var inputsamples = InputReader.getFileContent();
        var measurements = main.measureSorts(inputsamples);

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

                System.out.print ("Sort completed: \n");
                System.out.printf("     - Sample Size : %d\n", m.getSampleSize());
                System.out.printf("     - Sorter      : %s\n", m.getSorterName());
                System.out.printf("     - Time        : %d\n", m.getTime());
                System.out.printf("     - Memory Usage: %d\n", m.getMemory());
                System.out.printf("     - Iterations  : %d\n", m.getIterations());
                System.out.printf("     - Comparisons : %d\n", m.getComparisons());
            }
        }

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
