package com.amrita.jpl.cys21083.Practise.InterfaceClass;

// Calculator
import java.util.Scanner;

/**
 * @author Revan Nagireddy - CB.EN.U4CYS21083
 */

interface Calculator {
    /**
     *
     * @param num1 First Number Passed by the user while Executing
     * @param num2 Second Number Passed by the user while Executing
     */
    int calculate(int num1, int num2);
}

class Add implements Calculator {
    /**
     *
     * @param num1 First Number Passed by the user while Executing
     * @param num2 Second Number Passed by the user while Executing
     * @return returns the addition of num1 and num2 number
     */
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}

class Subtract implements Calculator {
    /**
     *
     * @param num1 First Number Passed by the user while Executing
     * @param num2 Second Number Passed by the user while Executing
     * @return returns the subtraction of num1 and num2 number
     */
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }
}

class Multiply implements Calculator {
    /**
     *
     * @param num1 First Number Passed by the user while Executing
     * @param num2 Second Number Passed by the user while Executing
     * @return returns the multiplication of num1 and num2 number
     */
    public int calculate(int num1, int num2) {
        return num1 * num2;
    }
}

class Divide implements Calculator {
    /**
     *
     * @param num1 First Number Passed by the user while Executing
     * @param num2 Second Number Passed by the user while Executing
     * @return returns the division of num1 and num2 number
     */
    public int calculate(int num1, int num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new ArithmeticException("Cannot divide by zero!");
        }
    }
}

public class InterfaceClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter the operation (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        Calculator calculator;

        switch (operation) {
            case '+':
                calculator = new Add();
                break;
            case '-':
                calculator = new Subtract();
                break;
            case '*':
                calculator = new Multiply();
                break;
            case '/':
                calculator = new Divide();
                break;
            default:
                System.out.println("Invalid operation!");
                return;
        }

        int result = calculator.calculate(num1, num2);
        System.out.println("Result: " + result);

        scanner.close();
    }
}
