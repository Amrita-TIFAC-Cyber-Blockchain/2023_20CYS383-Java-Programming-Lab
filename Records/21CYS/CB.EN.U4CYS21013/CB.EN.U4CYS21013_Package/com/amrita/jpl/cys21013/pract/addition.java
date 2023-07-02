package com.amrita.jpl.cys21013.pract;

import java.util.Scanner;

/**
 * @author Basi Reddy Rohith Reddy
 * @version 1.0
 * The Addition class performs addition of two numbers and displays the sum.
 */
public class addition {
    /**
     * The main method reads two numbers from the user and calculates their sum.
     * It then displays the sum on the console.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int input_1, input_2, my_sum;
        Scanner my_scanner = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        input_1 = my_scanner.nextInt();

        System.out.println("Enter the second number: ");
        input_2 = my_scanner.nextInt();

        my_scanner.close();

        my_sum = input_1 + input_2;

        System.out.println("Sum of the two numbers is: ");
        System.out.println(my_sum);
    }
}
