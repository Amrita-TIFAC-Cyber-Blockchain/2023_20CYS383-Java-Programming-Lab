package com.amrita.jpl.cys21060.pract.calculator;

import java.util.Scanner;

    // Define the Calculator interface
    interface calculator {
    double add(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);
}

// Implement the Calculator interface
class Basiccalculator implements calculator {
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
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
    }
}

// Usage example with menu-driven implementation
public class Calc_interface {
    public static void main(String[] args) {
        calculator calculator = new Basiccalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculator Menu:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("0. Exit");

        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter two numbers: ");
                double num1 = scanner.nextDouble();
                double num2 = scanner.nextDouble();

                double result;
                switch (choice) {
                    case 1:
                        result = calculator.add(num1, num2);
                        System.out.println("Addition: " + result);
                        break;
                    case 2:
                        result = calculator.subtract(num1, num2);
                        System.out.println("Subtraction: " + result);
                        break;
                    case 3:
                        result = calculator.multiply(num1, num2);
                        System.out.println("Multiplication: " + result);
                        break;
                    case 4:
                        try {
                            result = calculator.divide(num1, num2);
                            System.out.println("Division: " + result);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                }
            } else if (choice != 0) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        System.out.println("Goodbye!");
    }
}
