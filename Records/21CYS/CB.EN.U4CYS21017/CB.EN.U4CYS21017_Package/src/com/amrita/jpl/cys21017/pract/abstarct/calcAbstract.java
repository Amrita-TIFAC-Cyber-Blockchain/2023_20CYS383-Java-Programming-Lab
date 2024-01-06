package com.amrita.jpl.cys21017.pract.abstarct;

import java.util.Scanner;

/**
 * defined abstract class
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
 * defined addition class which is inherited from calculator
 */

class Addition extends Calculator1 {
    public Addition(int num1, int num2) {
        super(num1, num2);
    }
    @Override
    public void calculate() {
        int result = num1 + num2;
        System.out.println("Sum = " + result);
    }
}

/**
 * defined subraction class which is inherited from calculator
 */

class Subtraction extends Calculator1 {
    public Subtraction(int num1, int num2) {
        super(num1, num2);
    }
    @Override
    public void calculate() {
        int result = num1 - num2;
        System.out.println("Difference = " + result);
    }
}

/**
 * defined multiplication class which is inherited from calculator
 */

class Multiplication extends Calculator1 {
    public Multiplication(int num1, int num2) {
        super(num1, num2);
    }
    @Override
    public void calculate() {
        int result = num1 * num2;
        System.out.println("Product = " + result);
    }
}

/**
 * defined division class which is inherited from calculator
 */

class Division extends Calculator1 {
    public Division(int num1, int num2) {
        super(num1, num2);
    }
    @Override
    public void calculate() {
        if (num2 != 0) {
            double result = (double) num1 / num2;
            System.out.println("Quotient = " + result);
        } else {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
}

/**
 * created a main function
 */
public class calcAbstract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter the operation (+, -, *, /): ");
        String op = scanner.next();

        Calculator1 calculator;


        switch (op) {
            case "+":
                calculator = new Addition(num1, num2);
                break;
            case "-":
                calculator = new Subtraction(num1, num2);
                break;
            case "*":
                calculator = new Multiplication(num1, num2);
                break;
            case "/":
                calculator = new Division(num1, num2);
                break;
            default:
                System.out.println("Invalid operation.");
                scanner.close();
                return;
        }
        calculator.calculate();
    }
}
