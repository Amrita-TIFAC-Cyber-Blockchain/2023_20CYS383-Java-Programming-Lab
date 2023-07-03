package com.amrita.jpl.cys21054.practice;

/**
 * A program to calculate the factorial of a number.
 */
public class factorial {

    /**
     * Calculates the factorial of a given number.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int num = 5;
        long factorial = 1;
        for(int i = 1; i <= num; ++i)
        {
            factorial *= i;
        }
        System.out.printf("Factorial of %d = %d", num, factorial);
    }
}
