package sortAlgorithms;

import util.Measurement;
import util.Time;

/**
 * Bubblesort implementation to sort an array of ints
 * This implementation is done with a while loop and a boolean flag, which should run faster with bigger amounts of data
 *
 * @author Tim Irmler
 * @version 1.0
 * @since 04-01-2022
 */
public class BubbleSortAdvanced implements Sorter {

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

        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int j = 0; j < array.length - 1; j++) {
                measure.increaseIterations();
                measure.increaseComparisons();
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    sorted = false;
                }
            }
        }

        measure.setTimeInNs(Time.calculateElapsed(time));
        measure.setMemory((runtime.totalMemory() - runtime.freeMemory()) - usedMemoryBefore);

        return measure;
    }

    @Override
    public void reset() {
    }
}
