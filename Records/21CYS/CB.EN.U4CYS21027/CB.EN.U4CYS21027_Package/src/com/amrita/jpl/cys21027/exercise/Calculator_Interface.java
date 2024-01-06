/**

 This program demonstrates a basic calculator that implements the Calculator interface.
 It allows users to input two numbers and perform arithmetic operations such as addition,
 subtraction, multiplication, and division.

 @author K Sri Sai Nitin
 @version 1.0

 */
package com.amrita.jpl.cys21027.exercise;

import java.util.Scanner;

/**

 The Calculator interface defines the basic arithmetic operations that a calculator can perform.
 */
interface Calculator {

    /**

     Adds two numbers and returns the result.
     @param a the first number
     @param b the second number
     @return the sum of the two numbers
     */
    double add(double a, double b);
    /**

     Subtracts the second number from the first number and returns the result.
     @param a the first number
     @param b the second number
     @return the difference between the two numbers
     */
    double subtract(double a, double b);
    /**

     Multiplies two numbers and returns the result.
     @param a the first number
     @param b the second number
     @return the product of the two numbers
     */
    double multiply(double a, double b);
    /**

     Divides the first number by the second number and returns the result.
     Throws an ArithmeticException if the second number is zero.
     @param a the first number
     @param b the second number
     @return the quotient of the two numbers
     @throws ArithmeticException if the second number is zero
     */
    double divide(double a, double b);
}
/**

 The BasicCalculator class implements the Calculator interface and provides

 the implementation for the basic arithmetic operations.
 */
class BasicCalculator implements Calculator {

    /**

     Adds two numbers and returns the result.
     @param a the first number
     @param b the second number
     @return the sum of the two numbers
     */
    public double add(double a, double b) {
        return a + b;
    }
    /**

     Subtracts the second number from the first number and returns the result.
     @param a the first number
     @param b the second number
     @return the difference between the two numbers
     */
    public double subtract(double a, double b) {
        return a - b;
    }
    /**

     Multiplies two numbers and returns the result.
     @param a the first number
     @param b the second number
     @return the product of the two numbers
     */
    public double multiply(double a, double b) {
        return a * b;
    }
    /**

     Divides the first number by the second number and returns the result.
     Throws an ArithmeticException if the second number is zero.
     @param a the first number
     @param b the second number
     @return the quotient of the two numbers
     @throws ArithmeticException if the second number is zero
     */
    public double divide(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("Division by zero error!");
        }
    }
}
/**

 The Calculator_Interface class is the main class that allows users to input two numbers

 and perform arithmetic operations using the BasicCalculator class.
 */
public class Calculator_Interface {

    public static void main(String[] args) {

        Calculator calculator = new BasicCalculator();

        Scanner scanner = new Scanner(System.in);
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();

        double sum = calculator.add(num1, num2);
        double difference = calculator.subtract(num1, num2);
        double product = calculator.multiply(num1, num2);
        double quotient = 0;

        System.out.println("Addition: " + sum);
        System.out.println("Subtraction: " + difference);
        System.out.println("Multiplication: " + product);
        try {
            quotient = calculator.divide(num1, num2);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            quotient = -1;
        }
        System.out.println("Division: " + quotient);

        scanner.close();
    }
}