/**

 * The Factorial class calculates the factorial of a given number.
  * @author K Sri Sai Nitin
  * @version 0.5
 */
package com.amrita.jpl.cys21027.practice.factorial;

import java.util.Scanner;

public class Factorial {
    /**
     * Main method that prints factorial to the console.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        Scanner sc =  new Scanner(System.in);
        System.out.print("Enter a number to print factorial: ");
        int num = sc.nextInt();
        long fact = 1;

        for (int i = 1; i <= num; ++i) {
            fact = fact * i;
        }

        System.out.println("Factorial of " + num + " is equal to = " + fact);
    }
}