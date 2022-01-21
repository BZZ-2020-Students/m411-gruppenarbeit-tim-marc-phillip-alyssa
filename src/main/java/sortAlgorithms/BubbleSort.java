package sortAlgorithms;

import util.Measurement;
import util.Time;

/**
 * Bubble Sort Algorithm
 * Sorts adjacent elements in an array one by one until it is sorted
 *
 * @author Alyssa Heimlicher
 * @version 1.0
 * @since 04-01-2022
 */

public class BubbleSort implements Sorter {

    /**
     * Function which needs to be called to sort an int array
     *
     * @param array array to be sorted
     * @return an instance of {@link Measurement} with the test stats
     */
    @Override
    public Measurement sort(int[] array) {
        var measure = new Measurement();

        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long time = Time.currentTime();

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 2; j++) {
                measure.increaseIterations();
                measure.increaseComparisons();
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        measure.setTimeInNs(Time.calculateElapsed(time));
        measure.setMemory((runtime.totalMemory() - runtime.freeMemory()) - usedMemoryBefore);

        return measure;
    }

    /**
     * Implements the reset method
     * Has no use for this sorter
     */
    @Override
    public void reset() {
    }
}
