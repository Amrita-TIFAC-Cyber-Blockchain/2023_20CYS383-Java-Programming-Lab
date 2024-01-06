/**
 * The Calculator_using_Interface class provides a calculator functionality using an interface.
 * It allows the user to perform addition, subtraction, multiplication, and division operations.
 * The user can enter the desired operation and input numbers to perform the calculation.
 * The result is displayed to the console.
 * The user can exit the calculator by choosing the exit option.
 *
 * @author Yaswanth Gadamsetti
 */

package com.amrita.jpl.cys21014.ex;

import java.util.Scanner;

/**
 * @author Deepthi J
 * @version 1.0
 */
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
            System.out.println("Press '1' for Addition");
            System.out.println("Press '2' for Subtract");
            System.out.println("Press '3' for  Multiply");
            System.out.println("Press '4' for Divide");
            System.out.println("Press '5' for Exit");
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
                    System.out.println("Sum of given two numbers: " + result);
                }
                case 2 -> {
                    result = calculator.subtract(num1, num2);
                    System.out.println("Difference of given two numbers: " + result);
                }
                case 3 -> {
                    result = calculator.multiply(num1, num2);
                    System.out.println("Product of given two numbers: " + result);
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
