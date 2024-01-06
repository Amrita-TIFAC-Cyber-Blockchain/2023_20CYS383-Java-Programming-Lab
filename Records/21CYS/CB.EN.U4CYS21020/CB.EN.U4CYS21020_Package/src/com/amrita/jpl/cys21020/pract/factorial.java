/**
 * @author Hemesh sai
 * @version 1.0
 * The factorial class calculates the factorial of a given number using recursion.
 */

package com.amrita.jpl.cys21020.pract;
public class factorial {

    /**
     * The main method of the factorial class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int n = 5;
        int factorial = factorial(n);
        System.out.println("The factorial of " + n + " is " + factorial);
    }

    /**
     * Calculates the factorial of a given number using recursion.
     *
     * @param n The number for which the factorial needs to be calculated.
     * @return The factorial of the given number.
     */
    public static int factorial(int n) {
        return (n != 0 && n != 1) ? n * factorial(n - 1) : 1;
    }
}
