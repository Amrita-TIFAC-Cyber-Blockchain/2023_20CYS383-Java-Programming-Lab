package com.amrita.jpl.cys21019.ex;

/**
 * This program converts a decimal number to binary and hexadecimal representation.
 * Author: Gokulachselvan C D
 */

import java.util.Scanner;

public class convertingDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int num = sc.nextInt();

        // Convert decimal to binary and hexadecimal
        String binary = Integer.toBinaryString(num);
        String hex = Integer.toHexString(num).toUpperCase();

        // Print the results
        System.out.println("Binary: " + binary);
        System.out.println("Hexadecimal: " + hex);
    }
}