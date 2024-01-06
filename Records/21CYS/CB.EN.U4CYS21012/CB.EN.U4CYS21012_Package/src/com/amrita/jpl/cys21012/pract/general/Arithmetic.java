package com.amrita.jpl.cys21012.pract.general;

import java.util.*;

/**
 * The Arithmetic class is a basic Java program that performs arithmetic operations on two numbers entered by the user.
 * It calculates the sum, difference, product, and quotient of the two numbers.
 * @author Ashwin Anand
 */
public class Arithmetic {

    /**
     * The main method is the entry point of the program.
     * It prompts the user to enter two numbers and performs arithmetic operations on them.
     *
     * @param args The command-line arguments passed to the program (not used in this code).
     */
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Scanner read = new Scanner(System.in);
        int x, y;

        System.out.print("Enter the first number: ");
        x = read.nextInt();

        System.out.print("Enter the second number: ");
        y = read.nextInt();

        read.close();

        System.out.println("The sum is " + (x + y));
        System.out.println("The difference is " + (x - y));
        System.out.println("The product is " + (x * y));
        System.out.println("The quotient is " + (x / y));
    }
}

