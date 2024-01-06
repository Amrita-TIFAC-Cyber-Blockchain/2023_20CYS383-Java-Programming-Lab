package com.amrita.jpl.cys21074.pract.Interface;

import java.util.Scanner;

/**
 * The {@code calculator} interface represents a calculator operation.
 */
interface calculator {
    /**
     * Performs a calculation on the given numbers.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @return the result of the calculation
     */
    double calculate(double num1, double num2);
}

/**
 * The {@code Addition} class represents the addition operation of a calculator.
 */
class Addition implements calculator {
    @Override
    public double calculate(double num1, double num2) {
        return num1 + num2;
    }
}

/**
 * The {@code Subtraction} class represents the subtraction operation of a calculator.
 */
class Subtraction implements calculator {
    @Override
    public double calculate(double num1, double num2) {
        return num1 - num2;
    }
}

/**
 * The {@code Multiplication} class represents the multiplication operation of a calculator.
 */
class Multiplication implements calculator {
    @Override
    public double calculate(double num1, double num2) {
        return num1 * num2;
    }
}

/**
 * The {@code Division} class represents the division operation of a calculator.
 */
class Division implements calculator {
    @Override
    public double calculate(double num1, double num2) {
        return num1 / num2;
    }
}

/**
 * The {@code interface_calc} class is the main class to run the calculator program.
 */
public class interface_calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("Select the operation: ");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();

        calculator calculator;

        switch (choice) {
            case 1:
                calculator = new Addition();
                break;
            case 2:
                calculator = new Subtraction();
                break;
            case 3:
                calculator = new Multiplication();
                break;
            case 4:
                calculator = new Division();
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        double result = calculator.calculate(num1, num2);
        System.out.println("Result: " + result);

        scanner.close();
    }
}
