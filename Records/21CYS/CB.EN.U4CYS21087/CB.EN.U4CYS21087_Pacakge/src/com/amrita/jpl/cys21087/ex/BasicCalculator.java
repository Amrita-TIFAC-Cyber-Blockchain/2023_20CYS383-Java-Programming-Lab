package com.amrita.jpl.cys21087.ex;
/**
 * /**
 * - This program implements a Basic Calculator that performs arithmetic operations on two numbers.
 * - It supports addition, subtraction, multiplication, and division.
 * - The program uses the Calculator interface and the BasicCalculator class.
 * - The BasicCalculator class provides the implementation for the Calculator interface methods.
 * - The program prompts the user to enter two numbers and performs the requested operations.
 * - The results are displayed to the user.
 *
 * @author vishnu
 * @version 1.0
 */

import java.util.Scanner;

// Calculator Interface
interface Calculator {
    double add(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);
}

// BasicCalculator class that implements the Calculator interface
public class BasicCalculator implements Calculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if(b == 0) {
            System.out.println("Division by zero error!");
            return -1;
        }
        return a / b;
    }

    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter first number:");
        double a = sc.nextDouble();
        System.out.println("Please enter second number:");
        double b = sc.nextDouble();

        double additionResult = calculator.add(a, b);
        double subtractionResult = calculator.subtract(a, b);
        double multiplicationResult = calculator.multiply(a, b);
        double divisionResult = calculator.divide(a, b);

        System.out.println("Addition: " + additionResult);
        System.out.println("Subtraction: " + subtractionResult);
        System.out.println("Multiplication: " + multiplicationResult);
        if(b == 0.0) {
            System.out.println("Division by zero error!");
        } else {
            System.out.println("Division: " + divisionResult);
        }
    }
}

