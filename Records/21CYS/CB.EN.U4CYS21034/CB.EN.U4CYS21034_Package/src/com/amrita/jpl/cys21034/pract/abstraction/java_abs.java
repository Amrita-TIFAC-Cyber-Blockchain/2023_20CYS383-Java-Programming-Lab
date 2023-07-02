package com.amrita.jpl.cys21034.pract.abstraction;

import java.util.Scanner;
/**
 *abstract class Calculator1
 */
abstract class Calculator1 {
    protected int num1;
    protected int num2;

    public Calculator1(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public abstract void calculate();
}
/**
 *class Addition inheriting Calculator1
 */
class Addition extends Calculator1 {
    /**
     * adding two numbers
     * @param num1,num2 numbers that are to be added
     */
    public Addition(int num1, int num2) {
        super(num1, num2);
    }
    @Override
    public void calculate() {
        int result = num1 + num2;
        System.out.println("Sum: " + result);
    }
}
/**
 *class Subtraction inheriting Calculator1
 */
class Subtraction extends Calculator1 {
    /**
     * subtracting two numbers
     * @param num1,num2 numbers that are to be subtracted
     */
    public Subtraction(int num1, int num2) {
        super(num1, num2);
    }
    @Override
    public void calculate() {
        int result = num1 - num2;
        System.out.println("Difference: " + result);
    }
}
/**
 *class Multiplication inheriting Calculator1
 */
class Multiplication extends Calculator1 {
    /**
     * multiplying two numbers
     * @param num1,num2 numbers that are to be multiplied
     */
    public Multiplication(int num1, int num2) {
        super(num1, num2);
    }
    @Override
    public void calculate() {
        int result = num1 * num2;
        System.out.println("Product: " + result);
    }
}
/**
 *class Division inheriting Calculator1
 */
class Division extends Calculator1 {
    /**
     * dividing two numbers
     * @param num1,num2 numbers that are to be divided
     */
    public Division(int num1, int num2) {
        super(num1, num2);
    }
    @Override
    public void calculate() {
        if (num2 != 0) {
            double result = (double) num1 / num2;
            System.out.println("Quotient: " + result);
        } else {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
}
public class java_abs {
    /**
     * The main method is the entry point of the program.
     * It establishes a connection to the server, sends a message, and closes the connection.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        Calculator1 calculator;

        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                calculator = new Addition(num1, num2);
                break;
            case 2:
                calculator = new Subtraction(num1, num2);
                break;
            case 3:
                calculator = new Multiplication(num1, num2);
                break;
            case 4:
                calculator = new Division(num1, num2);
                break;
            default:
                System.out.println("Invalid choice.");
                scanner.close();
                return;
        }
        calculator.calculate();
    }
}

