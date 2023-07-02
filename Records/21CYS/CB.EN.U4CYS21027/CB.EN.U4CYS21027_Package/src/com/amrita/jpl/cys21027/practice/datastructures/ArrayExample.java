package com.amrita.jpl.cys21027.practice.datastructures;

import java.util.Scanner;

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
 * @author Karaka Sri Sai Nitin
 * @version 0.5
 */
public class ArrayExample {
    /**
     * The main method is the entry point of the program.
     * It creates an array of roll numbers and prints each roll number using a for loop.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        int rollNumber[];
        rollNumber = new int[6];
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the input for the arrays: ");
        for(int i=0;i<rollNumber.length;i++){
            rollNumber[i] = myObj.nextInt();
        }
        System.out.println("\n");
        System.out.println("The arrays list are: ");
        for (int i = 0; i < rollNumber.length; i++) {
            System.out.println(rollNumber[i]);
        }
    }
}
