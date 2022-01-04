package sortAlgorithms;

import util.Measurement;

// TODO: 04.01.2022 get memory usage
public class Quicksort implements Sorter {
    @Override
    public Measurement sort(int[] array) {
        long time = System.currentTimeMillis();
        sort(array, 0, array.length - 1);
        measure.setTime(System.currentTimeMillis() - time);

        return measure;
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private void sort(int[] arr, int links, int rechts) {
        measure.increaseIterations();
        measure.increaseComparisons();
        if (links < rechts) {
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

        measure.increaseComparisons();
        while (i < j) { // solange i an j nicht vorbeigelaufen ist
            // Suche von links ein Element, welches größer oder gleich dem Pivotelement ist
            measure.increaseComparisons();
            while (i < rechts && arr[i] < pivot) {
                i = i + 1;
            }

            // Suche von rechts ein Element, welches kleiner als das Pivotelement ist
            measure.increaseComparisons();
            while (j > links && arr[j] >= pivot) {
                j = j - 1;
            }

            measure.increaseComparisons();
            if (i < j) {
                swap(arr, i, j);
            }
        }

        // Tausche Pivotelement (daten[rechts]) mit neuer endgültiger Position (daten[i])
        // und gib die neue Position des Pivotelements zurück, beende Durchlauf
        measure.increaseComparisons();
        if (arr[i] > pivot) {
            swap(arr, i, rechts);
        }
        return i;
    }
}
