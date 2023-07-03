package com.amrita.jpl.cys21074.pract.misc;

import java.util.Scanner;

/**
 * The {@code Convertor} class converts a decimal number to binary and hexadecimal representations.
 */
public class Convertor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a decimal number: ");
        int decimalNum = input.nextInt();

        // Check for negative input
        if (decimalNum < 0) {
            System.out.println("Error: Only positive integers accepted.");
        } else {
            // Convert decimal to binary
            System.out.println("Binary: " + Integer.toBinaryString(decimalNum));

            // Convert decimal to hexadecimal
            System.out.println("Hexadecimal: " + Integer.toHexString(decimalNum));
        }
    }
}
