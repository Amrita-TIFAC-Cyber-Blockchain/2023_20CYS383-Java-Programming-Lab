package com.amrita.jpl.cys21072.hpoj;

import java.util.Scanner;

/**
 * @author Sri Sai Tanvi Sonti  CB.EN.U4CYS21072
 */

//basic Calculator using Interface CLass

interface Calculator {
    double add(double num1, double num2);
    double subtract(double num1, double num2);
    double multiply(double num1, double num2);
    double divide(double num1, double num2);
}

class BasicCalculator implements Calculator {

    /**
     *
     * @param num1 first number for operation
     * @param num2 second number for operation
     * @return returns the add of the num1  and num2
     */
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    /**
     *
     * @param num1 first number for operation
     * @param num2 second number for operation
     * @return returns the subtraction of the num1  and num2
     */
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    /**
     *
     * @param num1 first number for operation
     * @param num2 second number for operation
     * @return returns the multiplication of the num1  and num2
     */
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    /**
     *
     * @param num1 first number for operation
     * @param num2 second number for operation
     * @return returns the division of the num1  and num2
     */
    public double divide(double num1, double num2){
        return num1 / num2;
    }
}

public class BasicCalculatorQ{
    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();
        Scanner input = new Scanner(System.in);

        double result;

        System.out.print("Enter the first number: ");
        double num1 = input.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = input.nextDouble();

        //  System.out.print("Enter the operation (+, -, *, /): ");
        // char operation = input.next().charAt(0);

        result = calculator.add(num1, num2);
        System.out.println("Addition: " + result);

        result = calculator.subtract(num1, num2);
        System.out.println("Subtraction: " + result);

        result = calculator.multiply(num1, num2);
        System.out.println("Multiplication: " + result);

        try {
            if (num2 != 0) {
                result = calculator.divide(num1, num2);
                System.out.println("Division" + result);
            } else {
                System.out.println("Cannot divide by zero");
            }
        }catch (ArithmeticException e) {
            System.out.println("Cannot Divide");
        }

        input.close();
    }
}