package com.amrita.jpl.cys21003.ex;

import java.util.Scanner;
/**
 * This class demonstrates the calculator program
 *
 * @author Aishwarya G
 * @version 1.0
 */
interface Calculator {
    /**
     *The function add two number
     * @param num1
     * @param num2
     * @return added value
     */
    double add(double num1, double num2);

    /**
     * the function subtract two number
     * @param num1
     * @param num2
     * @return subtracted value
     */
    double subtract(double num1, double num2);

    /**
     * the function multiply two number
     * @param num1
     * @param num2
     * @return multiplied value
     */
    double multiply(double num1, double num2);
    double divide(double num1, double num2);
}


class BasicCalculator implements Calculator {
    /**
     *
     * @param num1
     * @param num2
     * @return
     */
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    /**
     *
     * @param num1
     * @param num2
     * @return
     */
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
            System.out.println("Division by zero error!");
            return -1.0;
        }
    }
}

public class InterfaceCalculator1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator BasicCalculatorExample = new BasicCalculator();

        double num1 = scanner.nextDouble();

        double num2 = scanner.nextDouble();

        double result = 0.0;

        result = BasicCalculatorExample.add(num1, num2);
        System.out.println("Addition: " + result);

        result = BasicCalculatorExample.subtract(num1, num2);
        System.out.println("Subtraction: " + result);

        result = BasicCalculatorExample.multiply(num1, num2);
        System.out.println("Multiplication: " + result);

        result = BasicCalculatorExample.divide(num1, num2);
        System.out.println("Division: " + result);

    }
}

