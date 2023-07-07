package com.amrita.jpl.cys21073.exercise;


import java.util.Scanner;

interface Calculator {
    void add(int a, int b);
    void subtract(int a, int b);
    void multiply(int a, int b);
    void divide(int a, int b);
}
class BasicCalculator implements Calculator {
    public void add(int a, int b) {
        int result = a + b;
        System.out.println("Addition : " + result);
    }
    public void subtract(int a, int b) {
        int result = a - b;
        System.out.println("Subtraction : " + result);
    }
    public void multiply(int a, int b) {
        int result = a * b;
        System.out.println("Multiplication :" + result);
    }
    public void divide(int a, int b) {
        if (b != 0) {
            int result = a / b;
            System.out.println("Divison : " + result);
        } else {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
}

public class Interface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Value for A : ");
        int a = scanner.nextInt();

        System.out.print("Enter the Value for B : ");
        int b = scanner.nextInt();

        Calculator calculator = new BasicCalculator();

        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();
        switch(choice) {
            case 1:
                calculator.add(a, b);
                break;
            case 2:
                calculator.subtract(a, b);
                break;
            case 3:
                calculator.multiply(a, b);
                break;
            case 4:
                calculator.divide(a, b);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}