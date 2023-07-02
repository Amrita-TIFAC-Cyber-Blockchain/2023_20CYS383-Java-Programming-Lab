package com.amrita.jpl.cys21004.practice.basic;

import java.util.Scanner;

/**
 * @author Aishwarya GS
 */

public class Calculator {

    public static void main(String[] args)
    {

        /**
         * Calculator
         * @param args default argument
         */
        double num1, num2;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number 1: ");
        num1 = sc.nextDouble();

        System.out.println("Enter number 2: ");
        num2 = sc.nextDouble();

        System.out.println("Enter operator (+,-,*,/)");

        char op = sc.next().charAt(0);

        double ans = 0;

        switch (op) {
            case '+':
                ans = num1 + num2;
                break;
            case '-':
                ans = num1 - num2;
                break;
            case '*':
                ans = num1 * num2;
                break;
            case '/':
                ans = num1 / num2;
                break;
            default:
                System.out.println("Invalid input");
        }
        System.out.println(num1 + " " + op + " " + num2 + " = " + ans);
    }
}

