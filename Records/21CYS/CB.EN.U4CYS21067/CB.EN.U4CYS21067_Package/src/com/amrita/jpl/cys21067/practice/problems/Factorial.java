package com.amrita.jpl.cys21067.practice.problems;

/**
 * The Factorial class calculates the factorial of a number.
 */
public class Factorial {

    /**
     * The main method is the entry point of the program.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int num = 10;
        long factorial = 1;

        for (int i = 1; i <= num; ++i) {
            factorial *= i;
        }

        System.out.printf("Factorial of %d = %d", num, factorial);
    }
}
