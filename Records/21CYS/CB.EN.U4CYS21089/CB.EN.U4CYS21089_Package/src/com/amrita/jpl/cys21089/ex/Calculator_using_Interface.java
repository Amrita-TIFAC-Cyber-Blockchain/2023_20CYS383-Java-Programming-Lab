/**
 * The Calculator_using_Interface class provides a calculator functionality using an interface.
 * It allows the user to perform addition, subtraction, multiplication, and division operations.
 * The user can enter the desired operation and input numbers to perform the calculation.
 * The result is displayed to the console.
 * The user can exit the calculator by choosing the exit option.
 *
 * @author Yaswanth Gadamsetti
 */

package com.amrita.calculator.cys21089;

import java.util.Scanner;

interface Calculator1 {
    double add(double num1, double num2);
    double subtract(double num1, double num2);
    double multiply(double num1, double num2);
    double divide(double num1, double num2);
}

class BasicCalculator1 implements Calculator1 {

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
        return num1 / num2;
    }
}

public class Calculator_using_Interface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator1 calculator = new BasicCalculator1();

        while (true) {
            System.out.println("=--- Options ---=");
            System.out.println("1 =-=-> Add");
            System.out.println("2 =-=-> Subtract");
            System.out.println("3 =-=-> Multiply");
            System.out.println("4 =-=-> Divide");
            System.out.println("5 =-=-> Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 5) {
                break;
            }

            System.out.print("Enter 1st number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter 2nd number: ");
            double num2 = scanner.nextDouble();

            double result;
            switch (choice) {
                case 1 -> {
                    result = calculator.add(num1, num2);
                    System.out.println("Addition of given two numbers: " + result);
                }
                case 2 -> {
                    result = calculator.subtract(num1, num2);
                    System.out.println("Subtraction of given two numbers: " + result);
                }
                case 3 -> {
                    result = calculator.multiply(num1, num2);
                    System.out.println("Multiplication of given two numbers: " + result);
                }
                case 4 -> {
                    result = calculator.divide(num1, num2);
                    System.out.println("Division of given two numbers: " + result);
                }
                default -> System.out.println("Invalid choice!");
            }
            System.out.println();
        }
    }
}
