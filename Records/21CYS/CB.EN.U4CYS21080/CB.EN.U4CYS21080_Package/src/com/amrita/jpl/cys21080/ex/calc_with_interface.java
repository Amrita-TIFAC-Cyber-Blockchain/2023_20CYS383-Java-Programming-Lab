package com.amrita.jpl.cys21080.ex;
import java.util.Scanner;

/**
 * @author T Pavan Kumar Reddy
 * @version 1.0
 */

interface Calculator {
    /**
     * Adds two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the result of the addition
     */
    double add(double a, double b);

    /**
     * Subtracts two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the result of the subtraction
     */
    double subtract(double a, double b);

    /**
     * Multiplies two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the result of the multiplication
     */
    double multiply(double a, double b);

    /**
     * Divides two numbers.
     *
     * @param a the numerator
     * @param b the denominator
     * @return the result of the division
     * @throws ArithmeticException if the denominator is zero
     */
    double divide(double a, double b) throws ArithmeticException;
}

class BasicCalculator implements Calculator {
    /**
     * Adds two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the result of the addition
     */
    @Override
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the result of the subtraction
     */
    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the result of the multiplication
     */
    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides two numbers.
     *
     * @param a the numerator
     * @param b the denominator
     * @return the result of the division
     * @throws ArithmeticException if the denominator is zero
     */
    @Override
    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero error!");
        }
        return a / b;
    }
}

public class calc_with_interface {
    /**
     * The main method is the entry point of the calculator with interface application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Calculator calculator = new BasicCalculator();
        Scanner scanner = new Scanner(System.in);

        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();

        double addition = calculator.add(num1, num2);
        double subtraction = calculator.subtract(num1, num2);
        double multiplication = calculator.multiply(num1, num2);
        double division;
        try {
            division = calculator.divide(num1, num2);
            System.out.println("Addition: " + addition);
            System.out.println("Subtraction: " + subtraction);
            System.out.println("Multiplication: " + multiplication);
            System.out.println("Division: " + division);
        } catch (ArithmeticException e) {
            System.out.println("Addition: " + addition);
            System.out.println("Subtraction: " + subtraction);
            System.out.println("Multiplication: " + multiplication);
            System.out.println("Division by zero error!");
            System.out.println("Division: -1.0");
        }
    }
}
