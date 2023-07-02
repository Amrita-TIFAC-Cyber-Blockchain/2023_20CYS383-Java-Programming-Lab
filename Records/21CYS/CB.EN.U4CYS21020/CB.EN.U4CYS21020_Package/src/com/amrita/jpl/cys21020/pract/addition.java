//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package com.amrita.jpl.cys21020.pract;
import java.util.Scanner;

/***
 * @author Hemesh sai
 * @version 1.0
 * The addition class calculates the sum of two numbers entered by the user.
 */
public class addition {

    /**
     * The main method of the addition class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the first number
        System.out.print("Enter the first number: ");
        int a = scanner.nextInt();

        // Prompt the user to enter the second number
        System.out.print("Enter the second number: ");
        int b = scanner.nextInt();

        // Calculate the sum of the two numbers
        int sum = a + b;

        // Display the result
        System.out.println("The sum of " + a + " and " + b + " is " + sum);
    }
}
