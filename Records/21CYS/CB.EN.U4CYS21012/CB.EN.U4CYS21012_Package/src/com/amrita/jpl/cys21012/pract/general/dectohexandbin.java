package com.amrita.jpl.cys21012.pract.general;

import java.util.Scanner;

/**
 * The dectohexandbin class is a basic Java program that converts a decimal number to its binary and hexadecimal representations.
 * @author Ashwin Anand
 */
public class dectohexandbin {

    /**
     * The main method is the entry point of the program.
     * It prompts the user to enter a decimal number and converts it to binary and hexadecimal representations.
     *
     * @param args The command-line arguments passed to the program (not used in this code).
     */
    public static void main(String args[]) {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = read.nextInt();

        System.out.println(n + " in binary is : " + Integer.toBinaryString(n));
        System.out.println(n + " in hexadecimal is : " + Integer.toHexString(n));
    }
}
