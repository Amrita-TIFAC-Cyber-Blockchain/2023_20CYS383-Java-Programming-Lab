package com.amrita.jpl.cys21068.ex;

import java.util.Scanner;
/**
 * Interface representing a calculator with basic operations.
 */
interface Calculator {
/**
 * Adds two numbers.
 * Subtracts two numbers.
 * Multiplies two numbers.
 * Divides two numbers.
 */
    double add(double num1, double num2);
    double subtract(double num1, double num2);
    double multiply(double num1, double num2);
    double divide(double num1, double num2);
}
/**
 * Basic implementation of the Calculator interface.
 */
class BasicCalculator implements Calculator {
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }
    /**
     * Throws an exception if the divisor is zero.
     */
    public double divide(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
    }
}


public class BasicCalculatorExample {
    public static void main(String[] args) {
        /** Create an instance of BasicCalculator
         */
        BasicCalculator calculator = new BasicCalculator();
        /** Create a Scanner object to read user input
         */
        Scanner scanner = new Scanner(System.in);
        /** Prompt the user for the first number
         */
        System.out.print("");
        double num1 = scanner.nextDouble();
        /** Prompt the user for the second number
         */
        System.out.print("");
        double num2 = scanner.nextDouble();

        double sum = calculator.add(num1, num2);
        System.out.println("Addition: " + sum);

        double difference = calculator.subtract(num1, num2);
        System.out.println("Subtraction: " + difference);

        double product = calculator.multiply(num1, num2);
        System.out.println("Multiplication: " + product);

        try {
            double quotient = calculator.divide(num1, num2);
            System.out.println("Division: " + quotient);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        /**Close the Scanner object
         */
        scanner.close();
    }
}