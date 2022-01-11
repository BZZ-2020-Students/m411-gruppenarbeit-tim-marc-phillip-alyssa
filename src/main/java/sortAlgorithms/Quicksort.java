package sortAlgorithms;

/**
 * Quicksort algorithm
 * An implementation of the quicksort algorithm in
 *
 * @author Phillip Jerebic
 * @version 1.0
 * @since 04-01-2022
 */

import util.Measurement;
import util.Time;


// TODO: 04.01.2022 get memory usage
public class Quicksort implements Sorter {
    Measurement measure = new Measurement();

    /**
     * Override Measurement
     */
    @Override
    public Measurement sort(int[] array) {

        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long time = Time.currentTime();

        sort(array, 0, array.length - 1);

        measure.setTime(Time.calculateElapsed(time));
        measure.setMemory((runtime.totalMemory() - runtime.freeMemory()) - usedMemoryBefore);

        return measure;
    }

    /**
     * Swaps the two given indexes in the given array.
     *
     * @param array the array where the elements are to be swapped
     * @param a     left index
     * @param b     right index
     */
    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * Recursive function that sorts the given array
     *
     * @param arr    the array which will be sorted
     * @param links  left boundary
     * @param rechts right boundary
     */
    private void sort(int[] arr, int links, int rechts) {
        measure.increaseIterations();
        measure.increaseComparisons();
        if (links < rechts) {
            int split = teile(arr, links, rechts);
            sort(arr, links, split - 1);
            sort(arr, split + 1, rechts);
        }
    }

    /**
     * Splits the given array into left and right depending on the pivot
     *
     * @param arr    given array to be split
     * @param links  left boundary
     * @param rechts right boundary
     * @return the left index
     */
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
