package com.amrita.jpl.cys21026.pract;
import java.util.Scanner;

// Calculator abstract class
abstract class Calc {
    public abstract double calculate(double a, double b);
}

// Add operation
class AddOperation extends Calculator {
    @Override
    public double calculate(double a, double b) {
        return a + b;
    }
}

// Subtract operation
class SubtractOperation extends Calc {
    @Override
    public double calculate(double a, double b) {
        return a - b;
    }
}

// Multiply operation
class MultiplyOperation extends Calc {
    @Override
    public double calculate(double a, double b) {
        return a * b;
    }
}

// Divide operation
class DivideOperation extends Calc {
    @Override
    public double calculate(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return a / b;
    }
}

// Usage example
public class abstcalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("Select an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        Calc calculator;

        switch (choice) {
            case 1:
                calculator = new AddOperation();
                System.out.println("Addition: " + calculator.calculate(num1, num2));
                break;
            case 2:
                calculator = new SubtractOperation();
                System.out.println("Subtraction: " + calculator.calculate(num1, num2));
                break;
            case 3:
                calculator = new MultiplyOperation();
                System.out.println("Multiplication: " + calculator.calculate(num1, num2));
                break;
            case 4:
                calculator = new DivideOperation();
                System.out.println("Division: " + calculator.calculate(num1, num2));
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }

        scanner.close();
    }
}