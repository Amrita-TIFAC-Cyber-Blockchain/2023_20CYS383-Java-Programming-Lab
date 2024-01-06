package com.amrita.jpl.cys21068.prac.calculator_;
import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double number1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double number2 = scanner.nextDouble();

        Calculation addition = new Addition();
        double result = addition.calculate(number1, number2);
        System.out.println("Addition: " + number1 + " + " + number2 + " = " + result);

        Calculation subtraction = new Subtraction();
        result = subtraction.calculate(number1, number2);
        System.out.println("Subtraction: " + number1 + " - " + number2 + " = " + result);

        Calculation multiplication = new Multiplication();
        result = multiplication.calculate(number1, number2);
        System.out.println("Multiplication: " + number1 + " * " + number2 + " = " + result);

        Calculation division = new Division();
        try {
            result = division.calculate(number1, number2);
            System.out.println("Division: " + number1 + " / " + number2 + " = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Division error: " + e.getMessage());
        }
    }
}