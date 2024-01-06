package com.amrita.jpl.cys21008.Ex;



import java.util.Scanner;


/**
 * The `Calculator` interface defines the basic arithmetic operations for a calculator.
 * @Author:Anuvarshini M K
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
     * @return the difference between the first and second numbers
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
     * @param num1 the first number
     * @param num2 the second number
     * @return the quotient of the division
     * @throws IllegalArgumentException if the second number is zero
     */
    double divide(double num1, double num2);
}

/**
 * The `CalculatorImpl` class implements the `Calculator` interface and provides the implementation for the arithmetic operations.
 */
class CalculatorImpl implements Calculator {
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
        return num1 / num2;
    }
}

/**
 * The `SimpleCalculator` class is the main class to execute the calculator.
 */
public class SimpleCalculator {
    /**
     * The entry point of the program.
     * Creates an instance of the `CalculatorImpl` class, prompts the user for two numbers,
     * performs arithmetic operations using the calculator, and prints the results.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
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
    }
}



