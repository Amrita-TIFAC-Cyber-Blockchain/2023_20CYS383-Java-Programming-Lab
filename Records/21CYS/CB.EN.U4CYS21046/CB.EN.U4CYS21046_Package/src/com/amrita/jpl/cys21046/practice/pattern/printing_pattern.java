/**
 * This class generates a specific pattern using asterisks and equal signs.
 */
package com.amrita.jpl.cys21046.practice.pattern;

public class printing_pattern {

    /**
     * The main method of the class.
     * It generates the desired pattern.
     *
     * @param args The command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        // Code of Java for loop
        for (int i = 1; i <= 5; i++) {
            System.out.println("* * * * * * ==================================");
            System.out.println("* * * * *  ===================================");
        }

        for (int i = 1; i <= 5; i++) {
            System.out.println("==============================================");
        }
    }
}
