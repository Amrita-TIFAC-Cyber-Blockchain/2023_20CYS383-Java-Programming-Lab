package com.amrita.jpl.cys21044.pract.factorial;
/**
 *
 * @author ravi
 */

import java.util.*;


public class Factorial {
    /**
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
