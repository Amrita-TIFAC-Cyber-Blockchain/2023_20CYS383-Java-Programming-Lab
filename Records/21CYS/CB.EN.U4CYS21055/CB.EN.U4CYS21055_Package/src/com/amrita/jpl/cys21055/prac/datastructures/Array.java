package com.amrita.jpl.cys21055.prac.datastructures;

import javax.lang.model.element.Name;

/**
 * The ArrayExample class demonstrates the usage of an array to store and display names.
 * It creates an array of names and prints each roll number using a for loop.
 * This class provides a basic example of working with arrays in Java.
 *
 * Usage:
 * - The program creates an array of names with a specified size.
 * - It assigns names to array elements.
 * - It uses a for loop to iterate through the array and print each roll number.
 *
 * Note: This example assumes a fixed size for the array and assigns values manually.
 *
 * Dependencies:
 * - None
 *
 * @author Penugonda V S Ganasekhar
 * @version 0.5
 */
public class Array{
    /**
     * The main method is the entry point of the program.
     * It creates an array of names and prints each roll number using a for loop.
     *
     * @param args command line arguments
     */
    public static void main(String args[]) {
        String Names[] = new String[5];

        Names[0] = "Hamilton";
        Names[1] = "George";
        Names[2] = "Alice";
        Names[3] = "Bob";
        Names[4] = "Henry";

        for (int i = 0; i < Names.length; i++) {
            System.out.println(Names[i]);
        }
    }
}

