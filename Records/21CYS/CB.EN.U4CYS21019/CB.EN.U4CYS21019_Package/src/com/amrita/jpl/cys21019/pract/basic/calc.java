package com.amrita.jpl.cys21019.pract.basic;

/**
 * This program performs basic arithmetic operations on two numbers.
 * Author: Gokulachselvan C D
 */

import java.util.Scanner;

public class calc {
    public static void main(String[] args) {
        int a, b;
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter the first number
        System.out.println("Enter First number:");
        a = sc.nextInt();

        // Prompt the user to enter the second number
        System.out.println("Enter Second number:");
        b = sc.nextInt();

        // Perform arithmetic operations and display the results
        System.out.println("Sum is: " + (a + b));
        System.out.println("Difference is: " + (a - b));
        System.out.println("Product is: " + (a * b));
        System.out.println("Quotient is: " + (b / a));
        System.out.println("Remainder is: " + (a % b));
    }
}
