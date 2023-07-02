package com.amrita.jpl.cys21026.pract;
import java.util.Scanner;

// Calculator interface
interface Calculator {
    double calculate(double a, double b);
}

// Addition operation
class AddOperation implements Calculator {
    @Override
    public double calculate(double a, double b) {
        return a + b;
    }
}

// Subtraction operation
class SubtractOperation implements Calculator {
    @Override
    public double calculate(double a, double b) {
        return a - b;
    }
}

// Multiplication operation
class MultiplyOperation implements Calculator {
    @Override
    public double calculate(double a, double b) {
        return a * b;
    }
}

// Division operation
class DivideOperation implements Calculator {
    @Override
    public double calculate(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return a / b;
    }
}

// Usage example
public class intercalc {
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

        Calculator calculator;

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
