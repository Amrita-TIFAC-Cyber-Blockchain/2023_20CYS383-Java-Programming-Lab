package com.amrita.jpl.cys21012.pract.general;

import java.util.*;

/**
 * The basics class is a basic Java program that calculates the sum of two numbers entered by the user.
 * @author Ashwin Anand
 */
public class basics {

    /**
     * The main method is the entry point of the program.
     * It prompts the user to enter two numbers and calculates their sum.
     *
     * @param args The command-line arguments passed to the program (not used in this code).
     */
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter first number:");
        int a = read.nextInt();
        System.out.print("Enter second number:");
        int b = read.nextInt();
        System.out.println("Sum is " + (a + b));
    }
}


