package com.amrita.jpl.cys21005.exercise;

import java.util.Scanner;
/**
 * @author Alagu Soundarya G
 * @version 1.0
 * Interface Calculator Program
 */
interface Calculator {
    double add(double num1, double num2);
    double subtract(double num1, double num2);
    double multiply(double num1, double num2);
    double divide(double num1, double num2);
}

class BasicCalculator implements Calculator {

    public double add(double num1, double num2) {
        return num1 + num2;
    }


    public double subtract(double num1, double num2) {
        return num1 - num2;
    }


    public double multiply(double num1, double num2) {
        return num1 * num2;
    }


    public double divide(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            System.out.println("Division by zero error!");
            return -1.0;
        }
    }
}

public class Calculator1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator BasicCalculatorExample = new BasicCalculator();


        double num1 = scanner.nextDouble();

        double num2 = scanner.nextDouble();

        double result = 0.0;

        result = BasicCalculatorExample.add(num1, num2);
        System.out.println("Addition: " + result);

        result = BasicCalculatorExample.subtract(num1, num2);
        System.out.println("Subtraction: " + result);

        result = BasicCalculatorExample.multiply(num1, num2);
        System.out.println("Multiplication: " + result);

        result = BasicCalculatorExample.divide(num1, num2);
        System.out.println("Division: " + result);

    }
}