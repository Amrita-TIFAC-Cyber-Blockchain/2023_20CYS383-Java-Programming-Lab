package com.amrita.jpl.cys21023.pract.abstract_interface;

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

    public void calculate() {
        int result = this.num1 + this.num2;
        System.out.println("Sum =  " + result);
    }
}
class Division extends Calculator1 {
    public Division(int num1, int num2) {
        super(num1, num2);
    }

    public void calculate() {
        if (this.num2 != 0) {
            double result = (double)this.num1 / (double)this.num2;
            System.out.println("Quotient =  " + result);
        } else {
            System.out.println("Error: A number can't be divided by zero.");
        }

    }
}
class Multiplication extends Calculator1 {
    public Multiplication(int num1, int num2) {
        super(num1, num2);
    }

    public void calculate() {
        int result = this.num1 * this.num2;
        System.out.println("Product = " + result);
    }
}

class Subtraction extends Calculator1 {
    public Subtraction(int num1, int num2) {
        super(num1, num2);
    }

    public void calculate() {
        int result = this.num1 - this.num2;
        System.out.println("Difference =  " + result);
    }
}

public class Calculator_abstract {
    public Calculator_abstract() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter number 2: ");
        int num2 = scanner.nextInt();
        System.out.println("+  -  Add");
        System.out.println("- -  Subtract");
        System.out.println("* - Multiply");
        System.out.println("/ - Divide");
        System.out.print("Enter a choice : ");
        Object calculator;
        switch (scanner.next()) {
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
                System.out.println("Invalid choice.");
                scanner.close();
                return;
        }

        ((Calculator1)calculator).calculate();
    }
}

