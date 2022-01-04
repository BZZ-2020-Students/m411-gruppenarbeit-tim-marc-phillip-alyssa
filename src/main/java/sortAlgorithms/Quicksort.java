package sortAlgorithms;

import util.Measurement;

import java.util.Arrays;

// TODO: 04.01.2022 get memory usage 
public class Quicksort implements Sorter {
    @Override
    public Measurement sort(int[] array) {
        long time = System.currentTimeMillis();
        sort(array, 0, array.length - 1);
        measure.setTime(System.currentTimeMillis() - time);
        System.out.println("array = " + Arrays.toString(array));

        return measure;
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private void sort(int[] arr, int links, int rechts) {
        if (links < rechts) {
            measure.increaseIterations();
            measure.increaseComparisons();
            int split = teile(arr, links, rechts);
            sort(arr, links, split - 1);
            sort(arr, split + 1, rechts);
        }
    }

    private int teile(int[] arr, int links, int rechts) {
        int i = links;
        // Starte mit j links vom Pivotelement
        int j = rechts - 1;
        int pivot = arr[rechts];

        while (i < j) { // solange i an j nicht vorbeigelaufen ist
            measure.increaseComparisons();
            // Suche von links ein Element, welches größer oder gleich dem Pivotelement ist
            while (i < rechts && arr[i] < pivot) {
                measure.increaseComparisons();
                i = i + 1;
            }

            // Suche von rechts ein Element, welches kleiner als das Pivotelement ist
            while (j > links && arr[j] >= pivot) {
                measure.increaseComparisons();
                j = j - 1;
            }

            if (i < j) {
                measure.increaseComparisons();
                swap(arr, i, j);
            }
        }

        // Tausche Pivotelement (daten[rechts]) mit neuer endgültiger Position (daten[i])
        // und gib die neue Position des Pivotelements zurück, beende Durchlauf
        if (arr[i] > pivot) {
            measure.increaseComparisons();
            swap(arr, i, rechts);
        }
        return i;
    }
}
