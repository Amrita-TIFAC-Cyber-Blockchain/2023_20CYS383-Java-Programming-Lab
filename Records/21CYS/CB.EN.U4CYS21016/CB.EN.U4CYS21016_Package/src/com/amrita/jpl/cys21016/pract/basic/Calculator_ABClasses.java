package com.amrita.jpl.cys21016.pract.basic; /**
 * @author Hem Sagar
 * Simple Calculator program using Abstract Classes.
 * */
import java.util.Scanner;

abstract class Calculator {
    protected int num1;
    protected int num2;

    public Calculator(int num1, int num2) {
        /**
         * @param num1 - first number
         * @param num2 - second number*/
        this.num1 = num1;
        this.num2 = num2;
    }

    public abstract void calculate();
}
class Addition extends Calculator {
    public Addition(int num1, int num2) {
        /**
         * @param num1 - first number
         * @param num2 - second number*/
        super(num1, num2);
    }
    @Override
    public void calculate() {
        /**
         * @param num1 - first number
         * @param num2 - second number*/
        int result = num1 + num2;
        System.out.println("Sum: " + result);
    }
}
class Subtraction extends Calculator {
    public Subtraction(int num1, int num2) {
        super(num1, num2);
    }
    @Override
    public void calculate() {
        /**
         * @param num1 - first number
         * @param num2 - second number*/
        int result = num1 - num2;
        System.out.println("Difference: " + result);
    }
}
class Multiplication extends Calculator {
    public Multiplication(int num1, int num2) {
        super(num1, num2);
    }
    @Override
    public void calculate() {
        /**
         * @param num1 - first number
         * @param num2 - second number*/
        int result = num1 * num2;
        System.out.println("Product: " + result);
    }
}
class Division extends Calculator {
    public Division(int num1, int num2) {
        super(num1, num2);
    }
    @Override
    public void calculate() {
        /**
         * @param num1 - first number
         * @param num2 - second number*/
        if (num2 != 0) {
            double result = (double) num1 / num2;
            System.out.println("Quotient: " + result);
        } else {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
}
public class Calculator_ABClasses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        Calculator calculator;

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