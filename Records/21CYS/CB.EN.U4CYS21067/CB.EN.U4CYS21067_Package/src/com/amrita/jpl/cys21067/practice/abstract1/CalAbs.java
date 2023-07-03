package com.amrita.jpl.cys21067.practice.abstract1;

import java.util.Scanner;

/**
 * The abstract Calculator class represents a calculator with a calculate method that performs an operation on two numbers.
 */
abstract class Calculator {
    /**
     * Performs a calculation on the given numbers.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     * @return The result of the calculation.
     */
    public abstract double calculate(double num1, double num2);
}

/**
 * The Addition class represents the addition operation.
 */
class Addition extends Calculator {
    /**
     * Performs addition on the given numbers.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     * @return The result of the addition.
     */
    public double calculate(double num1, double num2) {
        return num1 + num2;
    }
}

/**
 * The Subtraction class represents the subtraction operation.
 */
class Subtraction extends Calculator {
    /**
     * Performs subtraction on the given numbers.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     * @return The result of the subtraction.
     */
    public double calculate(double num1, double num2) {
        return num1 - num2;
    }
}

/**
 * The Multiplication class represents the multiplication operation.
 */
class Multiplication extends Calculator {
    /**
     * Performs multiplication on the given numbers.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     * @return The result of the multiplication.
     */
    public double calculate(double num1, double num2) {
        return num1 * num2;
    }
}

/**
 * The Division class represents the division operation.
 */
class Division extends Calculator {
    /**
     * Performs division on the given numbers.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     * @return The result of the division.
     */
    public double calculate(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Division by zero is not allowed");
        }
        return num1 / num2;
    }
}

/**
 * The CalAbs class demonstrates the usage of the Calculator and its implementations.
 */
public class CalAbs {
    /**
     * The main method creates a calculator and performs operations based on user input.
     *
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1, num2;
        int choice;
        Calculator calculator;

        do {
            System.out.println("......Simple Calculator.....");

            System.out.println("Select an operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter the first number: ");
            num1 = scanner.nextDouble();

            System.out.print("Enter the second number: ");
            num2 = scanner.nextDouble();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    calculator = new Addition();
                    break;
                case 2:
                    calculator = new Subtraction();
                    break;
                case 3:
                    calculator = new Multiplication();
                    break;
                case 4:
                    calculator = new Division();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    continue;
                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            double result = calculator.calculate(num1, num2);
            System.out.println("Result: " + result);
        } while (choice != 5);

        scanner.close();
    }
}
