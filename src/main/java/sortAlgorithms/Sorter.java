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

    /**
     * Used to reset sorter for example if instance has variables which need to be reset after sorting
     */
    void reset();
}
