package com.amrita.jpl.cys21008.Ex;

import java.util.Scanner;

/**
 * The `numberconvert` class is used to convert a positive integer to its binary and hexadecimal representations.
 * It prompts the user for a positive integer, performs the conversion, and displays the results.
 * @Author:Anuvarshini M K
 */
public class numberconvert {
    /**
     * The entry point of the program.
     * Prompts the user for a positive integer, converts it to binary and hexadecimal representations,
     * and prints the results.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a positive integer to convert to binary or hexadecimal: ");
        int a = sc.nextInt();

        if (a < 0) {
            System.out.println("Enter only positive numbers!");
            return;
        }

        String binary = Integer.toBinaryString(a);
        String hexadecimal = Integer.toHexString(a);

        System.out.println("Binary: " + binary);
        System.out.println("Hexadecimal: " + hexadecimal);
    }
}

