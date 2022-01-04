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
    private int iterations;

    /**
     * The amount of comparisons made in the sort
     */
    private int comparisons;

    /**
     * The time the sort took
     */
    private long time;

    /**
     * The amount of memory the sort used
     */
    private int memory;

    /**
     * Default Constructor
     */
    public Measurement() {
    }

    /**
     * Constructor with all params
     *
     * @param iterations  The amount of iterations the sort took
     * @param comparisons The amount of comparisons made in the sort
     * @param time        The time the sort took
     * @param memory      The amount of memory the sort used
     */
    public Measurement(int iterations, int comparisons, long time, int memory) {
        this.iterations = iterations;
        this.comparisons = comparisons;
        this.time = time;
        this.memory = memory;
    }

    public void increaseIterations() {
        this.iterations++;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public void increaseComparisons() {
        this.comparisons++;
    }

    public int getComparisons() {
        return comparisons;
    }

    public void setComparisons(int comparisons) {
        this.comparisons = comparisons;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "iterations=" + iterations +
                ", comparisons=" + comparisons +
                ", time=" + time + "ms" +
                ", memory=" + memory +
                '}';
    }
}
