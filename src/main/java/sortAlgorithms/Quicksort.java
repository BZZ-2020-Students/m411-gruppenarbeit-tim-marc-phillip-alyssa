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

        measure.setTimeInNs(Time.calculateElapsed(time));
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
        // Start with j to the left of the pivot element
        int j = rechts - 1;
        int pivot = arr[rechts];

        measure.increaseComparisons();
        while (i < j) { // as long as i has not passed j
            // Search from the left for an element that is greater than or equal to the pivot element
            measure.increaseComparisons();
            while (i < rechts && arr[i] < pivot) {
                i = i + 1;
            }

            // Search from the right for an element that is smaller than the pivot element
            measure.increaseComparisons();
            while (j > links && arr[j] >= pivot) {
                j = j - 1;
            }

            measure.increaseComparisons();
            if (i < j) {
                swap(arr, i, j);
            }
        }

        // Swap pivot element (data[right]) with new final position (data[i])
        // and return the new position of the pivot element, finish run
        measure.increaseComparisons();
        if (arr[i] > pivot) {
            swap(arr, i, rechts);
        }
        return i;
    }
}
