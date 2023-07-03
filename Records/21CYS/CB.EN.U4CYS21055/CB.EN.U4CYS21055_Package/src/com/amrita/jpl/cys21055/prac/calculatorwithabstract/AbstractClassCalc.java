package com.amrita.jpl.cys21055.prac.calculatorwithabstract;
import java.util.Scanner;

abstract class Calculator {
    abstract double calculate(double num1, double num2);
}

class Add extends Calculator {
    double calculate(double num1, double num2) {
        return num1 + num2;
    }
}

class Subtract extends Calculator {
    double calculate(double num1, double num2) {
        return num1 - num2;
    }
}

class Multiply extends Calculator {
    double calculate(double num1, double num2) {
        return num1 * num2;
    }
}

class Divide extends Calculator {
    double calculate(double num1, double num2) {
        return num1 / num2;
    }
}

public class AbstractClassCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("Select an operation:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");

        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();

        Calculator calculator;
        switch (choice) {
            case 1:
                calculator = new Add();
                break;
            case 2:
                calculator = new Subtract();
                break;
            case 3:
                calculator = new Multiply();
                break;
            case 4:
                calculator = new Divide();
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
                return;
        }

        double result = calculator.calculate(num1, num2);
        System.out.println("Result: " + result);

        scanner.close();
    }
}

// Author: Penugonda V S Ganasekhar
// Roll Number: CB.EN.U4CYS21055