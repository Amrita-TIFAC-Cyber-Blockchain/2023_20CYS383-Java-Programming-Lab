package com.amrita.jpl.cys21039.pract.iface;
import java.util.Scanner;

/**
 * The interface representing a calculator.
 *
 * @author Manbendra Satpathy
 */
interface Calculator_Interface {
    /**
     * Calculates the result of the operation using the given numbers.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     * @return The result of the calculation.
     */
    double calculate(double num1, double num2);

    /**
     * Gets the symbol representing the operation.
     *
     * @return The symbol representing the operation.
     */
    String getOperationSymbol();
}

/**
 * The class representing the addition operation.
 */
class Addition_Interface implements Calculator_Interface {
    @Override
    public double calculate(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public String getOperationSymbol() {
        return "+";
    }
}

/**
 * The class representing the subtraction operation.
 */
class Subtraction_Interface implements Calculator_Interface {
    @Override
    public double calculate(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public String getOperationSymbol() {
        return "-";
    }
}

/**
 * The class representing the multiplication operation.
 */
class Multiplication_Interface implements Calculator_Interface {
    @Override
    public double calculate(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public String getOperationSymbol() {
        return "*";
    }
}

/**
 * The class representing the division operation.
 */
class Division_Interface implements Calculator_Interface {
    @Override
    public double calculate(double num1, double num2) {
        return num1 / num2;
    }

    @Override
    public String getOperationSymbol() {
        return "/";
    }
}

/**
 * The main class for the calculator program.
 */
public class Calculator_Using_Interface {
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

        Calculator_Interface calculator;

        System.out.println("Choose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                calculator = new Addition_Interface();
                break;
            case 2:
                calculator = new Subtraction_Interface();
                break;
            case 3:
                calculator = new Multiplication_Interface();
                break;
            case 4:
                calculator = new Division_Interface();
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
                return;
        }

        double result = calculator.calculate(num1, num2);
        String operationSymbol = calculator.getOperationSymbol();
        System.out.println("Result: " + num1 + " " + operationSymbol + " " + num2 + " = " + result);

        scanner.close();
    }
}
