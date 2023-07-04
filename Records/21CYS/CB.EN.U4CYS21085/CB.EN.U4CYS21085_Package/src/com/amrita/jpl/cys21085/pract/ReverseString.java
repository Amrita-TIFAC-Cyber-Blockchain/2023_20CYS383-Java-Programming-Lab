package com.amrita.jpl.cys21085.pract;

import java.util.Scanner;
/**
 * @authhor - Vinoth Kumar C [CB.EN.U4CYS21085]
 * This program reverses a given string.
 * It creates a new string by appending the characters of the original string in reverse order.
 */
public class ReverseString {

    /**
     * The main method allows the user to input a string and reverses it.
     * It iterates through the characters of the original string in reverse order
     * and appends them to a new string to create the reversed string.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        StringBuilder reversed = new StringBuilder();

        // Iterate through the characters of the original string in reverse order
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }

        // Print the reversed string
        System.out.println("Reversed string: " + reversed.toString());
    }
}
