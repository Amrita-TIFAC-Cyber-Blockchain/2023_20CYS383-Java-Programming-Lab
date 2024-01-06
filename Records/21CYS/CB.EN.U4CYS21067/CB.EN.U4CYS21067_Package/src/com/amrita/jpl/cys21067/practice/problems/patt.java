package com.amrita.jpl.cys21067.practice.problems;

/**
 * The `patt` class prints a pattern consisting of asterisks and separators.
 */
public class patt {

    /**
     * Prints the pattern.
     *
     * <p>The pattern consists of alternating sections of asterisks and separators.
     * Each section contains a fixed number of asterisks followed by a separator line.
     */
    public static void main(String[] args) {
        // First, print the top section of the pattern
        int count = 1;
        do {
            if (count % 2 != 0) {
                for (int i = 1; i <= 6; i++) {
                    System.out.print("* ");
                }
                System.out.println("==================================");
            }
            count++;
            if (count == 10) {
                break;
            }
            if (count % 2 == 0) {
                for (int j = 1; j <= 5; j++) {
                    System.out.print("* ");
                }
                System.out.println(" ===================================");
            }
            count++;
        } while (count < 10);

        // Then, print the bottom section of the pattern
        for (int k = 1; k <= 6; k++) {
            System.out.println("==============================================");
        }
    }
}
