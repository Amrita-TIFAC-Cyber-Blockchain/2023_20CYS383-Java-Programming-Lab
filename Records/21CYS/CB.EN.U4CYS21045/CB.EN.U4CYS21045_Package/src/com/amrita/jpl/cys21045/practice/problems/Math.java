package com.amrita.jpl.cys21045.practice.problems;

import java.util.Scanner;

/**
 * The Math class performs basic mathematical operations on two numbers.
 */
public class Math {

    /**
     * The main method is the entry point of the program.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = input.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = input.nextInt();

        int sum = num1 + num2;
        System.out.println("The sum of " + num1 + " and " + num2 + " is " + sum);

        int diff = num1 - num2;
        System.out.println("The difference of " + num1 + " and " + num2 + " is " + diff);
    }
}
