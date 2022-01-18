package sortAlgorithms;

import util.Measurement;

/**
 * Interface for our sort algorithms to quickly implement sort algorithms
 *
 * @author Tim Irmler
 * @version 1.0
 * @since 04-01-2022
 */
public interface Sorter {
    /**
     * Sorts an array and returns statistics
     *
     * @param array array to be sorted
     * @return statistics about the sort
     */
    Measurement sort(int[] array);
    void reset();
}
