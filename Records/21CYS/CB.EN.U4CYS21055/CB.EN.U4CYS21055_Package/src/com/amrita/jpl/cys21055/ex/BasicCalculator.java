package com.amrita.jpl.cys21055.ex;

import java.util.Scanner;

/**
 * @author Penugonda V S Ganasekhar
 * @version 0.1
 * The Calculator interface defines the basic operations that a calculator can perform.
 */
interface Calculator {
    /**
     * Calculates the result of a mathematical operation using the given operands.
     *
     * @param num1  the first operand
     * @param num2  the second operand
     * @return the result of the calculation
     */
    double calculate(double num1, double num2);

    /**
     * Retrieves the symbol or name of the operation performed by the calculator.
     *
     * @return the symbol or name of the operation
     */
    String getOperationSymbol();
}

/**
 * The Addition class represents the addition operation.
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
 * The Subtraction class represents the subtraction operation.
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
 * The Multiplication class represents the multiplication operation.
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
 * The Division class represents the division operation.
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
 * The BasicCalculator class demonstrates the usage of the Calculator interface and its implementations.
 */
public class BasicCalculator {
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
