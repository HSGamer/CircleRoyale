package me.hsgamer.utils;

public class ThreadUtil {
    private ThreadUtil() {
        // EMPTY
    }

    public static void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
