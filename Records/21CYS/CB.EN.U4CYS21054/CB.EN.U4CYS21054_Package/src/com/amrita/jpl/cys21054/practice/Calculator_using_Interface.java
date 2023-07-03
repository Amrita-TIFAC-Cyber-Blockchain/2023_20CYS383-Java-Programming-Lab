package com.amrita.jpl.cys21054.practice;

import java.util.Scanner;

/**
 * Represents a calculator with basic arithmetic operations.
 */
interface Calculator {
    /**
     * Adds two numbers.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the sum of the two numbers
     */
    double add(double num1, double num2);

    /**
     * Subtracts the second number from the first number.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the difference between the two numbers
     */
    double subtract(double num1, double num2);

    /**
     * Multiplies two numbers.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the product of the two numbers
     */
    double multiply(double num1, double num2);

    /**
     * Divides the first number by the second number.
     *
     * @param num1 the numerator
     * @param num2 the denominator
     * @return the result of the division
     * @throws IllegalArgumentException if the denominator is zero
     */
    double divide(double num1, double num2) throws IllegalArgumentException;
}

/**
 * Represents a basic calculator that implements the Calculator interface.
 */
class BasicCalculator implements Calculator {
    @Override
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public double divide(double num1, double num2) throws IllegalArgumentException {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
    }
}

/**
 * Main class to perform arithmetic calculations using a calculator.
 */
public class Calculator_using_Interface {
    /**
     * Reads user input, performs arithmetic calculations using a calculator, and displays the result.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new BasicCalculator();

        System.out.println("Select operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        double result;
        switch (choice) {
            case 1:
                result = calculator.add(num1, num2);
                System.out.println("Sum of two numbers is: " + result);
                break;
            case 2:
                result = calculator.subtract(num1, num2);
                System.out.println("Subtraction of two numbers is: " + result);
                break;
            case 3:
                result = calculator.multiply(num1, num2);
                System.out.println("Product of two numbers is: " + result);
                break;
            case 4:
                try {
                    result = calculator.divide(num1, num2);
                    System.out.println("Division of two numbers is: " + result);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}
