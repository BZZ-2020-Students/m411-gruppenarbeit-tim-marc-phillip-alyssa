package sortAlgorithms;

import util.Measurement;

public interface Sorter {
    Measurement measure = new Measurement();
    Measurement sort(int[] array);
}
