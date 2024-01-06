package com.amrita.jpl.cys21013.Ex;

import java.util.Scanner;
/**
 * A simple calculator program with the operations of addition, subtraction, multiplication, division with also a error exception
 * for trying to divide any number with 0.
 * @author rohit
 * @version 1.0
 */
/**
 * The Calculator interface defines basic arithmetic operations.
 */
interface Calculator {
    double add(double num1, double num2);
    double subtract(double num1, double num2);
    double multiply(double num1, double num2);
    double divide(double num1, double num2) throws ArithmeticException;
}

/**
 * The BasicCalculator class implements the Calculator interface.
 * It provides the implementation for the basic arithmetic operations.
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
    public double divide(double num1, double num2) throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("Error: Division by zero");
        }
        return num1 / num2;
    }
}

/**
 * The BasicCalculatorExample class demonstrates the usage of the BasicCalculator class.
 * It takes user input for two numbers and performs arithmetic operations using the BasicCalculator.
 */
public class BasicCalculatorExample {
    /**
     * The main method is the entry point of the program.
     * It takes user input for two numbers and performs addition, subtraction, multiplication, and division using the BasicCalculator.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        double addition = calculator.add(num1, num2);
        System.out.println("Addition: " + addition);

        double subtraction = calculator.subtract(num1, num2);
        System.out.println("Subtraction: " + subtraction);

        double multiplication = calculator.multiply(num1, num2);
        System.out.println("Multiplication: " + multiplication);

        try {
            double division = calculator.divide(num1, num2);
            System.out.println("Division: " + division);
        } catch (ArithmeticException e) {
            double err = -1.0;
            System.out.println("Division by zero error!");
            System.out.println("Division: " + err);
        }

        scanner.close();
    }
}
