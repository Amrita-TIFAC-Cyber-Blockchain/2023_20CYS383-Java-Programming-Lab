package com.amrita.jpl.cys21003.pract.basics;

import java.util.Scanner;

abstract class calculator {
    public abstract double add(double num1, double num2);
    public abstract double subtract(double num1, double num2);
    public abstract double multiply(double num1, double num2);
    public abstract double divide(double num1, double num2);
}

class calc extends calculator {

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
            System.out.println("denominator can't be zero");
            return 0.0;
        }
    }
}

public class abstract_class {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        calc calculator = new calc();

        while (true) {

            System.out.println("choose 1 to perform Addition");
            System.out.println("choose 2 to perform Subtraction");
            System.out.println("choose 3 to perform Multiplication");
            System.out.println("choose 4 to perform Division");
            System.out.println("choose 5 to Exit");

            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Exit");
                break;
            }

            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            double result = 0.0;
            switch (choice) {
                case 1:
                    result = calculator.add(num1, num2);
                    break;
                case 2:
                    result = calculator.subtract(num1, num2);
                    break;
                case 3:
                    result = calculator.multiply(num1, num2);
                    break;
                case 4:
                    result = calculator.divide(num1, num2);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println("Result: " + result);
        }
    }
}
