package com.amrita.jpl.cys21017.pract.interfaces;

import java.util.Scanner;

/**
 * Define the calculator interface
 */

interface Calculator {
    void calculate(int num1, int num2);
}

    /**
     * Implement the calculator interface for addition
     */
class Add implements Calculator {
    @Override
    public void calculate(int num1, int num2) {
        System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
    }
}

/**
 * Implement the calculator interface for subtraction
 */

class Subtract implements Calculator {
    @Override
    public void calculate(int num1, int num2) {
        System.out.println(num1 + " -  " + num2 + " = " + (num1-num2));
    }
}

    /**
     * Implement the calculator interface for multiplication
     */
class Multiply implements Calculator {
    @Override
    public void calculate(int num1, int num2) {
        System.out.println(num1 + " * " + num2 + " = " + (num1*num2));
    }
}

/**
 * Implement the calculator interface for division
 */
class Divide implements Calculator {
    @Override
    public void calculate(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        System.out.println(num1 + " / " + num2 + " = " + (num1/num2));
    }
}

// Usage example
public class calcInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter the operation (+, -, *, /): ");
        String op = scanner.next();

        Calculator calc;

        // Create the appropriate calculator based on the operation
        switch (op) {
            case "+":
                calc = new Add();
                calc.calculate(num1,num2);
                break;
            case "-":
                calc = new Subtract();
                calc.calculate(num1,num2);
                break;
            case "*":
                calc = new Multiply();
                calc.calculate(num1,num2);
                break;
            case "/":
                calc = new Divide();
                calc.calculate(num1,num2);
                break;
            default:
                System.out.println("Invalid operation");
                return;
        }
    }
}