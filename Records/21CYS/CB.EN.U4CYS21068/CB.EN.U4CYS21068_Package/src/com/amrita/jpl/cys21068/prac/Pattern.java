package com.amrita.jpl.cys21068.prac;

/**
 * Represents a pattern printing class that prints a specific pattern.
 */
public class Pattern {
    /**
     * The main method that executes the pattern printing logic.
     */
    public static void main(String[] args) {
        // Loop through the rows
        for (int i = 1; i <= 29; i++) {
            // Loop through the columns
            for (int j = 1; j <= 47; j++) {
                if (i == 19 || i == 21 || i == 23 || i == 25 || i == 27 || i == 29) {
                    // Print "=" for specific rows
                    System.out.print("=");
                } else if ((i == 1 || i == 5 || i == 9 || i == 13 || i == 17) && (j == 1 || j == 3 || j == 5 || j == 7 || j == 9 || j == 11)) {
                    // Print "* " for specific rows and columns
                    System.out.print("* ");
                } else if ((i == 3 || i == 7 || i == 11 || i == 15) && (j == 1 || j == 3 || j == 5 || j == 7)) {
                    // Print "* " for specific rows and columns
                    System.out.print("* ");
                } else if ((i == 1 || i == 5 || i == 9 || i == 13 || i == 17) && (j >= 13)) {
                    // Print "=" for specific rows and columns
                    System.out.print("=");
                } else if ((i == 3 || i == 7 || i == 11 || i == 15) && (j >= 9)) {
                    // Print "=" for specific rows and columns
                    System.out.print("=");
                } else if (j == 47) {
                    // Print "=" at the end of each row
                    System.out.println("=");
                }
            }
        }
    }
}
