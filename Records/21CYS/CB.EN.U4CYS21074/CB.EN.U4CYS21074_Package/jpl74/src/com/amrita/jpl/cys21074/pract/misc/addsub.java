package com.amrita.jpl.cys21074.pract.misc;

import java.util.Scanner;

/**
 * The {@code addsub} class calculates the sum and difference of two numbers.
 */
public class addsub {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = input.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = input.nextInt();

        int sum = num1 + num2; // Calculate the sum
        int diff = num1 - num2; // Calculate the difference

        System.out.println("The sum is " + sum);
        System.out.println("The difference is " + diff);

        input.close();
    }
}
