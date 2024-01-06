package com.amrita.jpl.cys21054.exercise;

import java.util.Scanner;

/**
 * Represents a calculator with basic arithmetic operations.
 */
interface Calculator {
    /**
     * Calculates the result of the arithmetic operation using the given numbers.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the result of the arithmetic operation
     */
    double calculate(double num1, double num2);

    /**
     * Gets the symbol representing the arithmetic operation.
     *
     * @return the symbol representing the arithmetic operation
     */
    String getOperationSymbol();
}

/**
 * Represents an addition operation.
 */
class Addition implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public String getOperationSymbol() {
        return "Addition";
    }
}

/**
 * Represents a subtraction operation.
 */
class Subtraction implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public String getOperationSymbol() {
        return "Subtraction";
    }
}

/**
 * Represents a multiplication operation.
 */
class Multiplication implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public String getOperationSymbol() {
        return "Multiplication";
    }
}

/**
 * Represents a division operation.
 */
class Division implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Division by zero error!");
            return -1;
        }
        return num1 / num2;
    }

    @Override
    public String getOperationSymbol() {
        return "Division";
    }
}

/**
 * Main class to perform arithmetic calculations using different calculators.
 */
public class Calculator_using_Interface {
    /**
     * Reads two numbers from the user and performs arithmetic calculations using different calculators.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        scanner.close();

        Calculator[] calculators = {new Addition(), new Subtraction(), new Multiplication(), new Division()};

        for (Calculator calculator : calculators) {
            try {
                double result = calculator.calculate(num1, num2);
                String operation = calculator.getOperationSymbol();
                System.out.println(operation + ": " + result);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
