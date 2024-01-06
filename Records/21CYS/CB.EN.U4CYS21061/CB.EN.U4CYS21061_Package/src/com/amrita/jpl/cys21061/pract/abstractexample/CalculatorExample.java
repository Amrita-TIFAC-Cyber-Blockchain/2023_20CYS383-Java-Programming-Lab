package com.amrita.jpl.cys21061.pract.abstractexample;
import java.util.Scanner;
/**
 * @author Roshni-CYS21061
 */
/**
 * This class demonstrates the use of calculator operations.
 */
public class CalculatorExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        int choice = scanner.nextInt();

        System.out.println("Enter two numbers:");
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();

        Calculator calculator;

        switch (choice) {
            case 1:
                calculator = new AdditionCalculator();
                break;
            case 2:
                calculator = new SubtractionCalculator();
                break;
            case 3:
                calculator = new MultiplicationCalculator();
                break;
            case 4:
                calculator = new DivisionCalculator();
                break;
            default:
                System.out.println("Invalid choice. Exiting the calculator...");
                return;
        }

        double result = calculator.calculate(num1, num2);
        calculator.displayResult(result);

        scanner.close();
    }
}
