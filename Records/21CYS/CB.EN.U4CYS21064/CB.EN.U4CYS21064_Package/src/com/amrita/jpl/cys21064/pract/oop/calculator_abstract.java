package com.amrita.jpl.cys21064.pract.oop;

import java.util.Scanner;
import java.util.Scanner;

/**
 * This class represents a calculator program that performs basic arithmetic operations.
 * It includes an abstract class `Calci2` that defines the basic arithmetic operations as abstract methods.
 * The `Calculator2` class extends `Calci2` and implements the arithmetic operations.
 * The main class `calculator_abstract` provides a menu-driven program to interact with the calculator.
 *
 * Note: The division operation checks for division by zero and returns a special value (NaN) in that case.
 *
 * @author Rajendraprasad S
 */
// Abstract class defining basic arithmetic operations
abstract class Calci2 {
    public abstract double add(double a, double b);
    public abstract double subtract(double a, double b);
    public abstract double multiply(double a, double b);
    public abstract double divide(double a, double b);
}

// Class implementing the calculator functions
class Calculator2 extends Calci2 {
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
public class calculator_abstract {
    /**
     * The main method of the calculator_abstract class.
     * It provides a menu-driven program to perform arithmetic operations using the Calculator2 class.
     *
     * @param args The command-line arguments passed to the program (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator2 calculator = new Calculator2();

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
                    System.out.println("Result: " + calculator.add(num1, num2));
                    break;
                case 2:
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextDouble();
                    System.out.println("Result: " + calculator.subtract(num1, num2));
                    break;
                case 3:
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextDouble();
                    System.out.println("Result: " + calculator.multiply(num1, num2));
                    break;
                case 4:
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextDouble();
                    System.out.println("Result: " + calculator.divide(num1, num2));
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
