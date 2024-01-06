package com.amrita.jpl.cys21027.practice.classes;

import java.util.Scanner;

/**
 * The `Calculator` interface defines the contract for classes that perform mathematical calculations.
 * It declares methods for basic arithmetic operations like addition, subtraction, multiplication, and division.
 * This interface provides a common structure for implementing different calculator classes.
 *
 * Usage:
 * - Classes that implement the `Calculator` interface should provide implementations for the arithmetic methods.
 *
 * Note: This example includes the `BasicCalculator` class that implements the `Calculator` interface.
 *
 * Dependencies:
 * - None
 *
 * @author Karaka Sri Sai Nitin
 * @version 0.5
 */
interface Calculator {
    double add(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);
}

/**
 * The `BasicCalculator` class is an implementation of the `Calculator` interface.
 * It provides implementations for the arithmetic methods defined in the interface.
 */
class BasicCalculator implements Calculator {
    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("Cannot divide by zero!");
        }
    }
}

/**
 * The `CalculatorInterface` class is the entry point of the program.
 * It demonstrates the usage of interfaces and implementing classes to perform basic arithmetic operations.
 * The user is prompted to enter two numbers, and the operations are performed using the `BasicCalculator` class.
 * The results are displayed to the user.
 *
 * Author: Karaka Sri Sai Nitin
 * Version: 0.5
 */
public class CalculatorInterface {
    /**
     * The main method is the entry point of the program.
     * It prompts the user to enter two numbers, performs basic arithmetic operations using the `Calculator` interface,
     * and displays the results.
     *
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        Calculator calculator = new BasicCalculator();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        double sum = calculator.add(num1, num2);
        double difference = calculator.subtract(num1, num2);
        double product = calculator.multiply(num1, num2);
        double quotient = calculator.divide(num1, num2);

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);

        scanner.close();
    }
}
