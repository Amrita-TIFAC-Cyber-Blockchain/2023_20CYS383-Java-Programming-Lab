package com.amrita.jpl.cys21074.pract.Abstract;

import java.util.Scanner;

/**
 * The {@code Calculator} abstract class represents a calculator and defines abstract methods for calculator operations.
 */
abstract class Calculator {
    /**
     * Adds two numbers.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the sum of num1 and num2
     */
    public abstract double add(double num1, double num2);

    /**
     * Subtracts two numbers.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the difference between num1 and num2
     */
    public abstract double subtract(double num1, double num2);

    /**
     * Multiplies two numbers.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the product of num1 and num2
     */
    public abstract double multiply(double num1, double num2);

    /**
     * Divides two numbers.
     *
     * @param num1 the dividend
     * @param num2 the divisor
     * @return the quotient of num1 divided by num2
     * @throws ArithmeticException if num2 is zero
     */
    public abstract double divide(double num1, double num2) throws ArithmeticException;

    /**
     * Template method to perform calculations.
     * Prompts the user for input and performs the selected operation.
     */
    public final void calculate() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        double result;

        System.out.println("Select operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                result = add(num1, num2);
                System.out.println("Addition: " + result);
                break;
            case 2:
                result = subtract(num1, num2);
                System.out.println("Subtraction: " + result);
                break;
            case 3:
                result = multiply(num1, num2);
                System.out.println("Multiplication: " + result);
                break;
            case 4:
                try {
                    result = divide(num1, num2);
                    System.out.println("Division: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}

/**
 * The {@code BasicCalculator} class extends the {@code Calculator} class and provides concrete implementations for the calculator operations.
 */
class BasicCalculator extends Calculator {
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
    public double divide(double num1, double num2) throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return num1 / num2;
    }
}

/**
 * The {@code abst_calc} class is the main class to run the calculator.
 */
public class abst_calc {
    public static void main(String[] args) {
        Calculator calculator = new BasicCalculator();
        calculator.calculate();
    }
}
