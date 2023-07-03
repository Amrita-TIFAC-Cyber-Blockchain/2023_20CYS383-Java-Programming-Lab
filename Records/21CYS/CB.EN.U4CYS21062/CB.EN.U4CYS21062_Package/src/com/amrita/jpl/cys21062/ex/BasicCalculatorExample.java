package com.amrita.jpl.cys21062.ex;

import java.util.Scanner;

/**
 * @author Ruthwik Krishna Bandreddy
 * The Calculator interface defines the contract for performing basic mathematical operations.
 */
interface Calculator {
    double add(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b) throws ArithmeticException;
}

/**
 * The BasicCalculator class implements the Calculator interface to perform basic mathematical operations.
 */
class BasicCalculator implements Calculator {
    //@Override
    public double add(double a, double b) {
        return a + b;
    }

    //@Override
    public double subtract(double a, double b) {
        return a - b;
    }

    //@Override
    public double multiply(double a, double b) {
        return a * b;
    }

    //@Override
    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero error!");
        }
        return a / b;
    }
}

/**
 * The BasicCalculatorExample class demonstrates the usage of the BasicCalculator class.
 */
public class BasicCalculatorExample {
    public static void main(String[] args) {
        Calculator calculator = new BasicCalculator();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
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
