package com.amrita.jpl.cys21042.exercises;
/**
 * @Author : Mittul R
 * @Rollno : CB.EN.U4CYS21042
 */

import java.util.Scanner;

abstract class Calculator1 {
    protected int num1;
    protected int num2;

    public Calculator1(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public abstract void calculate();
}
class Addition extends Calculator1 {
    public Addition(int num1, int num2) {
        super(num1, num2);
    }
    @Override
    public void calculate() {
        int result = num1 + num2;
        System.out.println("Sum: " + result);
    }
}
class Subtraction extends Calculator1 {
    public Subtraction(int num1, int num2) {
        super(num1, num2);
    }
    @Override
    public void calculate() {
        int result = num1 - num2;
        System.out.println("Difference: " + result);
    }
}
class Multiplication extends Calculator1 {
    public Multiplication(int num1, int num2) {
        super(num1, num2);
    }
    @Override
    public void calculate() {
        int result = num1 * num2;
        System.out.println("Product: " + result);
    }
}
class Division extends Calculator1 {
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
public class Abstractcalc {
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
