package me.hsgamer.utils;

import java.util.Scanner;

public class InputUtil {
    private InputUtil() {
        // EMPTY
    }

    public static int getInputInteger(Scanner scanner, String message) {
        Integer input = null;
        while (input == null) {
            try {
                input = Integer.parseInt(getInputString(scanner, message));
            } catch (NumberFormatException e) {
                // EMPTY
            }
        }
        return input;
    }

    public static int getInputInteger(Scanner scanner, String message, int min, int max) {
        Integer input = null;
        while (input == null) {
            input = getInputInteger(scanner, message);
            if (input < min || input > max) {
                input = null;
            }
        }
        return input;
    }

    public static String getInputString(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}
