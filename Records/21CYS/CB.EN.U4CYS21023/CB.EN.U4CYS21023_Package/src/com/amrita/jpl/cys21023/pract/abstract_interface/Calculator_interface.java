package com.amrita.jpl.cys21023.pract.abstract_interface;

import java.util.Scanner;
interface Calculator {
    void addition(int var1, int var2);

    void subtraction(int var1, int var2);

    void multiplication(int var1, int var2);

    void division(int var1, int var2);
}

class BasicCalculator implements Calculator {
    BasicCalculator() {
    }

    public void addition(int a, int b) {
        int result = a + b;
        System.out.println("Sum = " + result);
    }

    public void subtraction(int a, int b) {
        int result = a - b;
        System.out.println("Difference =  " + result);
    }

    public void multiplication(int a, int b) {
        int result = a * b;
        System.out.println("Product =  " + result);
    }

    public void division(int a, int b) {
        if (b != 0) {
            int result = a / b;
            System.out.println("Quotient =  " + result);
        } else {
            System.out.println("Error: A number can't be divided by zero.");
        }

    }
}

public class Calculator_interface {
    public Calculator_interface() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter number 2 : ");
        int num2 = scanner.nextInt();
        Calculator calculator = new BasicCalculator();
        System.out.println("+  -  Add");
        System.out.println("- -  Subtract");
        System.out.println("* - Multiply");
        System.out.println("/ - Divide");
        System.out.print("Enter a choice : ");
        switch (scanner.next()) {
            case "+":
                calculator.addition(num1, num2);
                break;
            case "-":
                calculator.subtraction(num1, num2);
                break;
            case "*":
                calculator.multiplication(num1, num2);
                break;
            case "/":
                calculator.division(num1, num2);
                break;
            default:
                System.out.println("Invalid choice.");
        }

    }
}
