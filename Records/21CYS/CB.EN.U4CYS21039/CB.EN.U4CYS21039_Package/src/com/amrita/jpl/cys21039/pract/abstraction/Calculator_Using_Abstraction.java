package com.amrita.jpl.cys21039.pract.abstraction;

import java.util.Scanner;

/**
 * The abstract class representing a calculator.
 *
 * @author Manbendra Satpathy
 */
abstract class Calculator_Abstraction {
    double num1;
    double num2;

    /**
     * Constructs a calculator with two numbers.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     */
    public Calculator_Abstraction(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    /**
     * Calculates the result of the operation.
     *
     * @return The result of the calculation.
     */
    abstract double calculate();

    /**
     * Gets the symbol representing the operation.
     *
     * @return The symbol representing the operation.
     */
    abstract String getOperationSymbol();
}

/**
 * The class representing the addition operation.
 */
class Addition_Abstraction extends Calculator_Abstraction {
    /**
     * Constructs an addition operation with two numbers.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     */
    public Addition_Abstraction(double num1, double num2) {
        super(num1, num2);
    }

    @Override
    double calculate() {
        return num1 + num2;
    }

    @Override
    String getOperationSymbol() {
        return "+";
    }
}

/**
 * The class representing the subtraction operation.
 */
class Subtraction_Abstraction extends Calculator_Abstraction {
    /**
     * Constructs a subtraction operation with two numbers.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     */
    public Subtraction_Abstraction(double num1, double num2) {
        super(num1, num2);
    }

    @Override
    double calculate() {
        return num1 - num2;
    }

    @Override
    String getOperationSymbol() {
        return "-";
    }
}

/**
 * The class representing the multiplication operation.
 */
class Multiplication_Abstraction extends Calculator_Abstraction {
    /**
     * Constructs a multiplication operation with two numbers.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     */
    public Multiplication_Abstraction(double num1, double num2) {
        super(num1, num2);
    }

    @Override
    double calculate() {
        return num1 * num2;
    }

    @Override
    String getOperationSymbol() {
        return "*";
    }
}

/**
 * The class representing the division operation.
 */
class Division_Abstraction extends Calculator_Abstraction {
    /**
     * Constructs a division operation with two numbers.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     */
    public Division_Abstraction(double num1, double num2) {
        super(num1, num2);
    }

    @Override
    double calculate() {
        return num1 / num2;
    }

    @Override
    String getOperationSymbol() {
        return "/";
    }
}

/**
 * The main class for the calculator program.
 */
public class Calculator_Using_Abstraction {
    /**
     * The main method is the entry point of the program.
     * It takes user input for two numbers and an operation, performs the operation, and prints the result.
     *
     * @param args The command line arguments. It is not used in this program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("Choose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        Calculator_Abstraction calculator = null;

        switch (choice) {
            case 1:
                calculator = new Addition_Abstraction(num1, num2);
                break;
            case 2:
                calculator = new Subtraction_Abstraction(num1, num2);
                break;
            case 3:
                calculator = new Multiplication_Abstraction(num1, num2);
                break;
            case 4:
                calculator = new Division_Abstraction(num1, num2);
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
                return;
        }

        double result = calculator.calculate();
        String operationSymbol = calculator.getOperationSymbol();
        System.out.println("Result: " + num1 + " " + operationSymbol + " " + num2 + " = " + result);

        scanner.close();
    }
}
