package com.amrita.jpl.cys21045.exercises;
import java.util.Scanner;

/**
 * The Calculator interface provides methods for performing basic arithmetic operations.
 */
interface Calculator {
    /**
     * Adds two numbers.
     *
     * @param a The first number.
     * @param b The second number.
     * @return The sum of the two numbers.
     */
    double add(double a, double b);

    /**
     * Subtracts the second number from the first number.
     *
     * @param a The first number.
     * @param b The second number.
     * @return The result of the subtraction.
     */
    double subtract(double a, double b);

    /**
     * Multiplies two numbers.
     *
     * @param a The first number.
     * @param b The second number.
     * @return The product of the two numbers.
     */
    double multiply(double a, double b);

    /**
     * Divides the first number by the second number.
     *
     * @param a The first number.
     * @param b The second number.
     * @return The result of the division.
     */
    double divide(double a, double b);
}

/**
 * The BasicCalculator class implements the Calculator interface and provides basic arithmetic operations.
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
            System.out.println("Division by zero error!");
            return -1;
        }
    }
}

/**
 * The BasicCalculatorExample class demonstrates the usage of the BasicCalculator class.
 */
public class BasicCalculatorExample {
    /**
     * The main method receives user input and performs arithmetic operations using the BasicCalculator class.
     *
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BasicCalculator calc = new BasicCalculator();

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("Addition: " + calc.add(num1, num2));
        System.out.println("Subtraction: " + calc.subtract(num1, num2));
        System.out.println("Multiplication: " + calc.multiply(num1, num2));
        System.out.println("Division: " + calc.divide(num1, num2));
    }
}
