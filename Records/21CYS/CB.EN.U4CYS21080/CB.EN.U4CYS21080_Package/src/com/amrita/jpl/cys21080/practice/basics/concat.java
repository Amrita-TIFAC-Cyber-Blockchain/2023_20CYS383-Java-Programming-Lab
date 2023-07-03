package com.amrita.jpl.cys21080.practice.basics;
/**
 * @author T pavan Kumar Reddy
 */

import java.util.Scanner;

/**
 * This class demonstrates string concatenation by taking two strings as input and printing their concatenation.
 */
public class concat {
    /**
     * Main method of the program.
     * Takes user input for two strings and prints their concatenation.
     *
     * @param args Command-line arguments (unused)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = scanner.nextLine();

        System.out.print("Enter second string: ");
        String s2 = scanner.nextLine();

        System.out.println("Concatenation of two strings: " + s1 + " " + s2);

        scanner.close();
    }
}