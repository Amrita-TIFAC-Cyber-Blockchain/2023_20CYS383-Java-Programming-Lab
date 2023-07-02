package com.amrita.jpl.cys21002.ex;
import java.util.Scanner;

/**
 * The Calculator interface defines basic arithmetic operations.
 */
interface Calculator {
    /**
     * Adds two numbers.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the addition result
     */
    double add(double num1, double num2);
    /**
     * Subtracts the second number from the first number.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the subtraction result
     */
    double subtract(double num1, double num2);
    /**
     * Multiplies two numbers.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the multiplication result
     */
    double multiply(double num1, double num2);
    /**
     * Divides the first number by the second number.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the division result
     * @throws ArithmeticException if the second number is zero
     */
    double divide(double num1, double num2) throws ArithmeticException;
}
/**
 * The BasicCalculator class implements the Calculator interface and provides
 * basic arithmetic operations.
 */

// Implement the Calculator interface in BasicCalculator
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
    public double divide(double num1, double num2) throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return num1 / num2;
    }
}

/**
 * The BasicCalculatorExample class demonstrates the usage of the BasicCalculator class.
 * It takes two numbers as input from the user and performs basic arithmetic operations.
 * The result of each operation is printed to the console.
 */
public class BasicCalculatorExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BasicCalculator calculator = new BasicCalculator();

        //System.out.print("Enter the first number: ");
        double number1 = scanner.nextDouble();

        //System.out.print("Enter the second number: ");
        double number2 = scanner.nextDouble();

        double additionResult = calculator.add(number1, number2);
        System.out.println("Addition: " + additionResult);

        double subtractionResult = calculator.subtract(number1, number2);
        System.out.println("Subtraction: " + subtractionResult);

        double multiplicationResult = calculator.multiply(number1, number2);
        System.out.println("Multiplication: " + multiplicationResult);

        try {
            double divisionResult = calculator.divide(number1, number2);
            System.out.println("Division: " + divisionResult);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}

