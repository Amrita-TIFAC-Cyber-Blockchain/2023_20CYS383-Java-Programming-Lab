package com.amrita.jpl.cys21009.ex;

import java.util.Scanner;

/**
 *
 * A Simple implementation of interface program in the form of a basic calculator
 *
 * @author Aravind
 * @version 1
 */
interface Calc {
    void add(double a, double b);
    void subtract(double a, double b);
    void multiply(double a, double b);
    void divide(double a, double b);

    /**
     * @param a formal parameter
     * @param b formal parameter
     */
}
class BasicCalculator implements Calc {
    public void add(double a, double b) {
        double result = a + b;
        System.out.println("Addition: " + result);
    }
    public void subtract(double a, double b) {
        double result = a - b;
        System.out.println("Subtraction: " + result);
    }
    public void multiply(double a, double b) {
        double result = a * b;
        System.out.println("Multiplication: " + result);
    }
    public void divide(double a, double b) {
        double result=0;
        result = a / b;
        if(b==0){
            System.out.println("Division by zero error!");
            result= -1;
        }
        System.out.println("Division: " + result);
    }

    /**
     * @param result Stores output of all the operations
     */
}


public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        Calc calculator = new BasicCalculator();
        calculator.add(num1, num2);
        calculator.subtract(num1, num2);
        calculator.multiply(num1, num2);
        calculator.divide(num1, num2);
    }
    /**
     *
     * @param args command line arguments
     * @param num1 double input 1
     * @param num2 double input 2
     *
     */

}