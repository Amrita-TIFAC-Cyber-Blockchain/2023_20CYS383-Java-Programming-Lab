/**
 * @author Tanvi Sonti
 * @param simple calculator
 * @return
 * @version 0.5
 */
package com.amrita.jpl.cys21072.exercise.BasicCalculatorExample;
import java.util.Scanner;
interface Calculator {
    double add(double num1, double num2);
    double subtract(double num1, double num2);
    double multiply(double num1, double num2);
    double divide(double num1, double num2);
}
class BasicCalculator implements Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0.0) {
            System.out.println("Division by zero error!");
            return -1.0;
        }
        return a / b;
    }
}

public  class BasicCalculatorExample {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        BasicCalculator calculator = new BasicCalculator();

        double addition = calculator.add(num1, num2);
        double subtraction = calculator.subtract(num1, num2);
        double multiplication = calculator.multiply(num1, num2);
        double division = calculator.divide(num1, num2);

        System.out.println("Addition: " + addition);
        System.out.println("Subtraction: " + subtraction);
        System.out.println("Multiplication: " + multiplication);
        System.out.println("Division: " + division);

        double divisionByZero = calculator.divide(num1, 0.0);

        System.out.println("Division by zero: " + divisionByZero);

        scanner.close();
    }
}


