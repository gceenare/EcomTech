package com.curiousity.tech.util;

import java.util.Scanner;
import java.util.UUID;

public class Helper {
    private static Scanner scanner = new Scanner(System.in);

    public static String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int getIntInput(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return 0;
        }
    }

    public static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return 0.0;
        }
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printError(String error) {
        System.err.println("ERROR: " + error);
    }

    public static void printSuccess(String success) {
        System.out.println("✓ " + success);
    }

    public static void printSeparator() {
        System.out.println("=========================================");
    }

    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }

    // Factory Helper Methods
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static String generateShortId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public static String formatCurrency(double amount) {
        return String.format("$%.2f", amount);
    }

    public static boolean validateEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    public static boolean validatePassword(String password) {
        return password != null && password.length() >= 6;
    }

    // Logging Methods
    public static void logInfo(String message) {
        System.out.println("[INFO] " + message);
    }

    public static void logDebug(String message) {
        System.out.println("[DEBUG] " + message);
    }

    public static void logWarning(String message) {
        System.out.println("[WARNING] " + message);
    }
}
