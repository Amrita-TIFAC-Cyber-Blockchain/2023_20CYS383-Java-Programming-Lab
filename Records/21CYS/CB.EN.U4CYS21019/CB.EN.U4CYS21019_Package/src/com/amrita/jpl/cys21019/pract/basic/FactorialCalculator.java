package com.amrita.jpl.cys21019.pract.basic;

/**
 * @author Gokulachselvan C D
 * This class calculates the factorial of a number.
 */
public class FactorialCalculator {

    /**
     * Calculates the factorial of a given number.
     *
     * @param number The number to calculate the factorial of.
     * @return The factorial of the given number.
     */
    public int calculateFactorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        } else {
            int factorial = 1;
            for (int i = 2; i <= number; i++) {
                factorial *= i;
            }
            return factorial;
        }
    }

    /**
     * Main method to test the FactorialCalculator class.
     *
     * @param args Command-line arguments (unused).
     */
    public static void main(String[] args) {
        FactorialCalculator calculator = new FactorialCalculator();
        int number = 5;
        int factorial = calculator.calculateFactorial(number);
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
}
