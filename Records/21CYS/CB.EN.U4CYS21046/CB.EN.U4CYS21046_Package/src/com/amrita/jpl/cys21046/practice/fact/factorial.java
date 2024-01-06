package com.amrita.jpl.cys21046.practice.fact;

/**
 * This class calculates the factorial of a given number.
 */
public class factorial {

    /**
     * The main method that calculates and prints the factorial of a number.
     *
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {

        int num = 5; // The number for which factorial is calculated
        long factorial = 1; // Variable to store the factorial

        // Loop to calculate the factorial
        for (int i = 1; i <= num; ++i) {
            factorial *= i; // factorial = factorial * i;
        }

        // Printing the factorial
        System.out.printf("Factorial of %d = %d", num, factorial);
    }
}
