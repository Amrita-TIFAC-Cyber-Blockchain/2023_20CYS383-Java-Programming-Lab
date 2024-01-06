package com.amrita.jpl.cys21046.ex;

import java.util.Scanner;

/**
 * This interface defines the basic calculator operations.
 */
interface Calculator {
    /**
     * Adds two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the sum of the two numbers
     */
    public double add(double a, double b);

    /**
     * Subtracts the second number from the first number.
     *
     * @param a the first number
     * @param b the second number
     * @return the difference between the two numbers
     */
    public double subtract(double a, double b);

    /**
     * Multiplies two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the product of the two numbers
     */
    public double multiply(double a, double b);

    /**
     * Divides the first number by the second number.
     *
     * @param a the numerator
     * @param b the denominator
     * @return the quotient of the division, or -1.0 if division by zero occurs
     */
    public double divide(double a, double b);
}

/**
 * This class provides an implementation of the Calculator interface.
 */
class BasicCalculator implements Calculator {
    /**
     * Adds two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the sum of the two numbers
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts the second number from the first number.
     *
     * @param a the first number
     * @param b the second number
     * @return the difference between the two numbers
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the product of the two numbers
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides the first number by the second number.
     *
     * @param a the numerator
     * @param b the denominator
     * @return the quotient of the division, or -1.0 if division by zero occurs
     */
    public double divide(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Division by zero error!");
            return -1.0;
        }
    }
}

/**
 * This class contains the main method to perform calculator operations.
 */
public class CalculatorStuff {
    /**
     * The main method that reads user input and performs calculator operations.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        double num1 = obj.nextDouble();
        double num2 = obj.nextDouble();

        BasicCalculator Obj1 = new BasicCalculator();

        double result1 = Obj1.add(num1, num2);
        System.out.println("Addition: " + result1);

        double result2 = Obj1.subtract(num1, num2);
        System.out.println("Subtraction: " + result2);

        double result3 = Obj1.multiply(num1, num2);
        System.out.println("Multiplication: " + result3);

        double result4 = Obj1.divide(num1, num2);
        System.out.println("Division: " + result4);
    }
}
