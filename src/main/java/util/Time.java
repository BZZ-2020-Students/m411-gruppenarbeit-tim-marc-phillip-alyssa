package util;

public class Time {
    public static long currentTime() {
        return System.nanoTime();
    }

    public static long calculateElapsed(long a) {
        return currentTime() - a;
    }
}
