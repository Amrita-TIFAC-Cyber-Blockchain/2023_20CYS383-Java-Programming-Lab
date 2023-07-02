package com.amrita.jpl.cys21014.pract.datastructures;

/**
 * The ArrayExample class demonstrates the usage of an array to store and display roll numbers.
 * It creates an array of roll numbers and prints each roll number using a for loop.
 * This class provides a basic example of working with arrays in Java.
 *
 * Usage:
 * - The program creates an array of roll numbers with a specified size.
 * - It assigns roll numbers to array elements.
 * - It uses a for loop to iterate through the array and print each roll number.
 *
 * Note: This example assumes a fixed size for the array and assigns values manually.
 *
 * Dependencies:
 * - None
 *
 * @author Deepthi J
 * @version 1.0
 */
public class arrays {
    /**
     * The main method is the entry point of the program.
     * It creates arrays of different data types and prints the elements using different looping techniques.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // String array
        String[] names = {"deepthi", "jayanth", "bhuvana", "sarvesh"};
        System.out.println("Printing string array :");
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println();

        // Double array
        double[] values = {11.11, 12.12, 13.13, 14.14, 15.15};
        System.out.println("Printing double array :");
        for (double value : values) {
            System.out.println(value);
        }
        System.out.println();

         // Integer array
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Printing integer array :");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        System.out.println();

        // Char array
        char[] characters = {'A', 'B', 'C', 'D'};
        System.out.println("Printing char array :");
        int index = 0;
        while (index < characters.length) {
            System.out.println(characters[index]);
            index++;
        }
        System.out.println();
    }
}
