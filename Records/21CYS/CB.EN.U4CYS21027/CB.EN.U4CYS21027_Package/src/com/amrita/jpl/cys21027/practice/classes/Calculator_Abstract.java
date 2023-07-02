package com.amrita.jpl.cys21027.practice.classes;

import java.util.Scanner;

/**
 * The `CalculatorAbstract` class is an abstract class that defines the common behavior for different operations.
 * It declares an abstract `calculate()` method that performs the specific operation.
 * This class serves as a base for implementing specific operation classes.
 *
 * Usage:
 * - Subclasses should provide an implementation for the `calculate()` method.
 *
 * Note: This example includes the `Addition`, `Subtraction`, `Multiplication`, and `Division` classes that inherit from `CalculatorAbstract`.
 *
 * Dependencies:
 * - None
 *
 * @author K Sri Sai Nitin
 * @version 0.5
 */
abstract class CalculatorAbstract {
    /**
     * Calculates the result of the operation.
     * Subclasses must provide their own implementation.
     *
     * @param n1 The first number.
     * @param n2 The second number.
     * @return The result of the operation.
     */
    abstract double calculate(double n1, double n2);
}

/**
 * The `Addition` class represents the addition operation.
 * It extends the `CalculatorAbstract` class and provides an implementation for the `calculate()` method.
 */
class Addition extends CalculatorAbstract {
    /**
     * Calculates the sum of two numbers.
     *
     * @param n1 The first number.
     * @param n2 The second number.
     * @return The sum of `n1` and `n2`.
     */
    double calculate(double n1, double n2) {
        return n1 + n2;
    }
}

/**
 * The `Subtraction` class represents the subtraction operation.
 * It extends the `CalculatorAbstract` class and provides an implementation for the `calculate()` method.
 */
class Subtraction extends CalculatorAbstract {
    /**
     * Calculates the difference between two numbers.
     *
     * @param n1 The first number.
     * @param n2 The second number.
     * @return The difference between `n1` and `n2`.
     */
    double calculate(double n1, double n2) {
        return n1 - n2;
    }
}

/**
 * The `Multiplication` class represents the multiplication operation.
 * It extends the `CalculatorAbstract` class and provides an implementation for the `calculate()` method.
 */
class Multiplication extends CalculatorAbstract {
    /**
     * Calculates the product of two numbers.
     *
     * @param n1 The first number.
     * @param n2 The second number.
     * @return The product of `n1` and `n2`.
     */
    double calculate(double n1, double n2) {
        return n1 * n2;
    }
}

/**
 * The `Division` class represents the division operation.
 * It extends the `CalculatorAbstract` class and provides an implementation for the `calculate()` method.
 */
class Division extends CalculatorAbstract {
    /**
     * Calculates the division of two numbers.
     *
     * @param n1 The numerator.
     * @param n2 The denominator.
     * @return The division result of `n1` divided by `n2`.
     */
    double calculate(double n1, double n2) {
        if (n2 != 0) {
            return n1 / n2;
        } else {
            System.out.println("Cannot divide by zero");
        }
        return 0;
    }
}

/**
 * The `Calculator_Abstract` class is the entry point of the program.
 * It demonstrates the usage of abstract classes and inheritance to perform different operations on numbers.
 */
public class Calculator_Abstract {
    /**
     * The main method is the entry point of the program.
     * It prompts the user to enter two numbers, select an operation, and performs the selected operation using the appropriate class.
     *
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2;
        int choice;

        System.out.print("Enter the first number: ");
        num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        num2 = scanner.nextDouble();

        System.out.println("Select an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();

        CalculatorAbstract calculator;
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
            default:
                System.out.println("Invalid choice. Exiting...");
                return;
        }

        double result = calculator.calculate(num1, num2);
        System.out.println("Result: " + result);
    }
}
