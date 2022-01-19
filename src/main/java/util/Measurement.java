package util;

/**
 * Dataclass to track the performance of sorting algorithms
 *
 * @author Marc Andri Fuchs
 * @version 1.0
 * @since 04-01-2022
 */
public class Measurement {
    /**
     * The amount of iterations the sort took
     */
    private long iterations;

    /**
     * The amount of comparisons made in the sort
     */
    private long comparisons;

    /**
     * The time the sort took in Ns
     */
    private long timeInNs;

    /**
     * The amount of memory the sort used
     */
    private long memory;

    /**
     * The name of the sorter
     */
    private String sorterName;

    /**
     * The amount of ints sorted
     */
    private long sampleSize;

    /**
     * Default Constructor
     */
    public Measurement() {
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "iterations=" + iterations +
                ", comparisons=" + comparisons +
                ", time=" + timeInNs +
                ", memory=" + memory +
                ", sorterName='" + sorterName + '\'' +
                ", sampleSize=" + sampleSize +
                '}';
    }

    public void increaseIterations() {
        this.iterations++;
    }

    public long getIterations() {
        return iterations;
    }

    public void setIterations(long iterations) {
        this.iterations = iterations;
    }

    public void increaseComparisons() {
        this.comparisons++;
    }

    public long getComparisons() {
        return comparisons;
    }

    public void setComparisons(long comparisons) {
        this.comparisons = comparisons;
    }

    public long getTimeInNs() {
        return timeInNs;
    }

    public void setTimeInNs(long timeInNs) {
        this.timeInNs = timeInNs;
    }

    public long getMemory() {
        return memory;
    }

    public void setMemory(long memory) {
        this.memory = memory;
    }

    public String getSorterName() {
        return sorterName;
    }

    public void setSorterName(String sorterName) {
        this.sorterName = sorterName;
    }

    public long getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(long sampleSize) {
        this.sampleSize = sampleSize;
    }
}
