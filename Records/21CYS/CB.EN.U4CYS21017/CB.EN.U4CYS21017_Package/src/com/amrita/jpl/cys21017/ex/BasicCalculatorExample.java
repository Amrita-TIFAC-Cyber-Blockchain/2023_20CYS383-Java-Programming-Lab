package com.amrita.jpl.cys21017.ex;

import java.util.Scanner;

// Define the calculator interface
interface Calculator {
    void add(double num1, double num2);
    void subract(double num1, double num2);
    void multiply(double num1, double num2);
    void divide(double num1, double num2);
}

// Implement the calculator interface
class BasicCalculator implements Calculator {
    @Override
    public void add(double num1, double num2) {
        System.out.println("Addition: " + (num1+num2));
    }
    public void subract(double num1, double num2) {
        System.out.println("Subraction: " + (num1-num2));
    }
    public void multiply(double num1, double num2) {
        System.out.println("Multiplication: "+ (num1*num2));
    }
    public void divide(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Division by zero error!");
        }
        System.out.println("Division: " + (num1/num2));
    }
}

// Usage example
public class BasicCalculatorExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = scanner.nextInt();

        double num2 = scanner.nextInt();


        // Create the appropriate calculator based on the operation
        BasicCalculator calc = new BasicCalculator();
        calc.add(num1,num2);
        calc.subract(num1,num2);
        calc.multiply(num1,num2);
        calc.divide(num1,num2);
        return;

    }
}