package com.amrita.jpl.cys21061.pract.abstractexample;
/**
 * @author Roshni-CYS21061
 */

/**
 * Abstract class representing a calculator.
 */
abstract class Calculator {
    /**
     * Calculates the result based on the given numbers.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the calculated result
     */
    abstract double calculate(double num1, double num2);

    /**
     * Displays the result to the console.
     *
     * @param result the result to be displayed
     */
    void displayResult(double result) {
        System.out.println("Result: " + result);
    }
}
