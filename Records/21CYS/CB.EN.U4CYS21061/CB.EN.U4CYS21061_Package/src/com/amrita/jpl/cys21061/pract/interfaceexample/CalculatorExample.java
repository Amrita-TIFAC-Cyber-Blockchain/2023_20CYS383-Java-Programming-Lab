package com.amrita.jpl.cys21061.pract.interfaceexample;
/**
 * @author Roshni-CYS21061
 */

import java.util.Scanner;

public class CalculatorExample {
    public CalculatorExample() {
    }

    public static void main(String[] args) {
        Calculator calculator = new BasicCalculator();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        double result1 = calculator.add(num1, num2);
        System.out.println("Result of addition: " + result1);
        double result2 = calculator.subtract(num1, num2);
        System.out.println("Result of subtraction: " + result2);
        double result3 = calculator.multiply(num1, num2);
        System.out.println("Result of multiplication: " + result3);

        try {
            double result4 = calculator.divide(num1, num2);
            System.out.println("Result of division: " + result4);
        } catch (ArithmeticException var15) {
            System.out.println("Error: " + var15.getMessage());
        }

        scanner.close();
    }
}
