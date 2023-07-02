package com.amrita.jpl.cys21039.pract.beginner;

import java.util.Scanner;

/**
 * This program takes two numbers as input from the user, calculates their sum and difference,
 * and then prints the results.
 *
 * @author Manbendra Satpathy
 */
public class Add_Sub {
    /**
     * The main method is the entry point of the program.
     * It takes user input for two numbers, calculates their sum and difference, and prints the results.
     *
     * @param args The command line arguments. It is not used in this program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        int sum = num1 + num2;
        int difference = num1 - num2;

        System.out.println("The sum of " + num1 + " and " + num2 + " is " + sum);
        System.out.println("The difference of " + num1 + " and " + num2 + " is " + difference);

        scanner.close();
    }
}
