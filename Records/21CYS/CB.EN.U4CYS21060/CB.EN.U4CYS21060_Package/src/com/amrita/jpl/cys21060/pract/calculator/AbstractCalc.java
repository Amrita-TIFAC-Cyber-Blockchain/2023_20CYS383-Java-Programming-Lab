package com.amrita.jpl.cys21060.pract.calculator;

import java.util.Scanner;

// Define the abstract Calculator class
abstract class Calculator {
    abstract double calculate(double a, double b);
}

// Implement the Calculator abstract class
class BasicCalculator extends Calculator {
    @Override
    double calculate(double a, double b) {
        // Implement the calculation logic here
        return 0;  // Placeholder value, needs to be implemented
    }
}

class AdditionCalculator extends Calculator {
    @Override
    double calculate(double a, double b) {
        return a + b;
    }
}

class SubtractionCalculator extends Calculator {
    @Override
    double calculate(double a, double b) {
        return a - b;
    }
}

class MultiplicationCalculator extends Calculator {
    @Override
    double calculate(double a, double b) {
        return a * b;
    }
}

class DivisionCalculator extends Calculator {
    @Override
    double calculate(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
    }
}

// Usage example with menu-driven implementation
public class AbstractCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Calculator Menu:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter two numbers: ");
                double num1 = scanner.nextDouble();
                double num2 = scanner.nextDouble();

                double result;
                switch (choice) {
                    case 1:
                        Calculator additionCalculator = new AdditionCalculator();
                        result = additionCalculator.calculate(num1, num2);
                        System.out.println("Addition: " + result);
                        break;
                    case 2:
                        Calculator subtractionCalculator = new SubtractionCalculator();
                        result = subtractionCalculator.calculate(num1, num2);
                        System.out.println("Subtraction: " + result);
                        break;
                    case 3:
                        Calculator multiplicationCalculator = new MultiplicationCalculator();
                        result = multiplicationCalculator.calculate(num1, num2);
                        System.out.println("Multiplication: " + result);
                        break;
                    case 4:
                        try {
                            Calculator divisionCalculator = new DivisionCalculator();
                            result = divisionCalculator.calculate(num1, num2);
                            System.out.println("Division: " + result);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                }
                System.out.println();
            } else if (choice != 0) {
                System.out.println("Invalid choice. Please try again.");
                System.out.println();
            }
        } while (choice != 0);

        System.out.println("Goodbye!");
    }
}
