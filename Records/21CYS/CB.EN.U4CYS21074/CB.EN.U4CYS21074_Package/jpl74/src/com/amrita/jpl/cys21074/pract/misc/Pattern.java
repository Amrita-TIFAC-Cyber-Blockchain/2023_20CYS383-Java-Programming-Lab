package com.amrita.jpl.cys21074.pract.misc;

/**
 * The {@code Pattern} class prints a pattern consisting of asterisks and equal signs.
 */
public class Pattern {
    public static void main(String[] args) {
        // Print the first part of the pattern
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                System.out.println("* * * * * * ==================================");
            } else {
                System.out.println("* * * * *  ===================================");
            }
        }

        // Print the second part of the pattern
        for (int i = 0; i < 6; i++) {
            System.out.println("==============================================");
        }
    }
}
