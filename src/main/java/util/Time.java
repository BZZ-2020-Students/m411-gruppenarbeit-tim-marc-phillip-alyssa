package util;

/**
 * Used to measure time
 *
 * @author Marc Andri Fuchs
 */
public class Time {
    /**
     * @return current System nano Time
     */
    public static long currentTime() {
        return System.nanoTime();
    }

    /**
     * Subtract two nano second times
     *
     * @param a the start of the measurement
     * @return the time between to dates in nanoseconds
     */
    public static long calculateElapsed(long a) {
        return currentTime() - a;
    }
}
