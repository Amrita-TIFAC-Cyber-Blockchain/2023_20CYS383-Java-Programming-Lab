package com.amrita.jpl.cys21064.pract.oop;

import java.util.Scanner;

import java.util.Scanner;

/**
 * This class represents a calculator program that performs basic arithmetic operations.
 * It includes an interface `Calci` that defines the basic arithmetic operations as abstract methods.
 * The `Calculator1` class implements the `Calci` interface and provides the implementation for the arithmetic operations.
 * The main class `calculator_interface` provides a menu-driven program to interact with the calculator.
 *
 * Note: The division operation checks for division by zero and returns a special value (NaN) in that case.
 *
 * @author Rajendraprasad S
 */
interface Calci {
    double add(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);
}

class Calculator1 implements Calci {
    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Error: Division by zero");
            return Double.NaN;
        }
    }
}

// Main class with menu-driven program
public class calculator_interface {
    /**
     * The main method of the calculator_interface class.
     * It provides a menu-driven program to perform arithmetic operations using the Calculator1 class.
     *
     * @param args The command-line arguments passed to the program (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator1 calc = new Calculator1();

        int choice;
        double num1, num2;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextDouble();
                    System.out.println("Result: " + calc.add(num1, num2));
                    break;
                case 2:
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextDouble();
                    System.out.println("Result: " + calc.subtract(num1, num2));
                    break;
                case 3:
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextDouble();
                    System.out.println("Result: " + calc.multiply(num1, num2));
                    break;
                case 4:
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextDouble();
                    System.out.println("Result: " + calc.divide(num1, num2));
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            System.out.println();
        } while (choice != 0);

    }
}
