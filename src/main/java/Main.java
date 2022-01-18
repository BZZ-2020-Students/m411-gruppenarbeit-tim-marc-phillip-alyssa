import sortAlgorithms.*;
import util.Export;
import util.InputReader;
import util.Measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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

        int iter = 0;
        int totalIters = inputsamples.length * 4;

        for (int[] is : inputsamples) {
            var sorters = createSorters();

            for (var sorter : sorters) {
                iter++;
                printProgress(iter, totalIters);
                var isCopy = Arrays.copyOf(is, is.length);

                var m = sorter.sort(isCopy);

                m.setSorterName(sorter.getClass().getSimpleName());
                m.setSampleSize(is.length);
                m.setTimeInMs(m.getTimeInNs() / 1_000_000);

                measurements.add(m);
            }
        }

        return measurements;
    }

    private void printProgress(int iter, int total) {
        int progressLength = Math.min(total * 4, 100);

        int progress = progressLength / total * iter;
        double progressInCent = 100f / progressLength * progress;
        System.out.printf("\rTesting Sorters: [%s%s] %.0f%%",
                "=".repeat(progress),
                " ".repeat(progressLength - progress),
                progressInCent
        );
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
