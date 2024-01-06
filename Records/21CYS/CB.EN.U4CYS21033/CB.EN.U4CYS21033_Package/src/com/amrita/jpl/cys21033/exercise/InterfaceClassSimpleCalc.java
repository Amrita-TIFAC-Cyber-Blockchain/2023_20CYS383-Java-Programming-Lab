package com.amrita.jpl.cys21033.exercise;

import java.util.Scanner;

/**
 * This program demonstrates the use of interfaces and classes to create a simple calculator.
 * It allows the user to perform addition, subtraction, multiplication, and division operations on two numbers.
 *
 * @author Suhitha K
 * @version 1.0
 */
interface Calculator {
    /**
     * Calculates the result of the operation on two numbers.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the calculated result
     */
    double calculate(double num1, double num2);
}

/**
 * Represents the addition operation.
 */
class Add implements Calculator {
    public double calculate(double num1, double num2) {
        return num1 + num2;
    }
}

/**
 * Represents the subtraction operation.
 */
class Subtract implements Calculator {
    public double calculate(double num1, double num2) {
        return num1 - num2;
    }
}

/**
 * Represents the multiplication operation.
 */
class Multiply implements Calculator {
    public double calculate(double num1, double num2) {
        return num1 * num2;
    }
}

/**
 * Represents the division operation.
 */
class Divide implements Calculator {
    public double calculate(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new ArithmeticException("Cannot divide by zero!");
        }
    }
}

/**
 * A simple calculator program that uses the Calculator interface and its implementing classes.
 */
public class InterfaceClassSimpleCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Enter the operation (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        Calculator calculator;

        switch (operation) {
            case '+':
                calculator = new Add();
                break;
            case '-':
                calculator = new Subtract();
                break;
            case '*':
                calculator = new Multiply();
                break;
            case '/':
                calculator = new Divide();
                break;
            default:
                System.out.println("Invalid operation!");
                scanner.close();
                return;
        }

        double result = calculator.calculate(num1, num2);
        System.out.println("Result: " + result);

        scanner.close();
    }
}
