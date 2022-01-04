package sortAlgorithms;

import util.Measurement;

import java.util.Arrays;

public class Quicksort implements Sorter {
    @Override
    public Measurement sort(int[] array) {
        sort(array, 0, array.length-1);
        System.out.println("array = " + Arrays.toString(array));

        return null;
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private void sort(int[] arr, int links, int rechts) {
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

        while (i < j) { // solange i an j nicht vorbeigelaufen ist
            // Suche von links ein Element, welches größer oder gleich dem Pivotelement ist
            while (i < rechts && arr[i] < pivot) {
                i = i + 1;
            }

            // Suche von rechts ein Element, welches kleiner als das Pivotelement ist
            while (j > links && arr[j] >= pivot) {
                j = j - 1;
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }

        // Tausche Pivotelement (daten[rechts]) mit neuer endgültiger Position (daten[i])
        // und gib die neue Position des Pivotelements zurück, beende Durchlauf
        if (arr[i] > pivot) {
            swap(arr, i, rechts);
        }
        return i;
    }
}
