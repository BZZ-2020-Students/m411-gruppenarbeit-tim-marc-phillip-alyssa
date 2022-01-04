public class Measurement {
    private int iterations;
    private int comparisons;
    private long time;
    private int memory;

    public Measurement(int iterations, int comarisons, long time, int memory) {
        this.iterations = iterations;
        this.comparisons = comarisons;
        this.time = time;
        this.memory = memory;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
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
}
