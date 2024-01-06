package com.amrita.jpl.cys21013.pract;

import java.util.*;

/**
 * The Main class is the entry point of the program.
 * It calculates the factorial of a given number.
 * @author Basi Reddy Rohith Reddy
 * @version 1.0
 *
 */
public class Factorial {
    /**
     * The main method is the entry point of the program.
     * It takes input from the user, calculates the factorial of the number,
     * and prints the result to the console.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        int i = 1;
        int fact = 1;
        while (i <= num) {
            fact = fact * i;
            i++;
        }
        System.out.println("Factorial of the number " + num + " is: " + fact);
    }
}