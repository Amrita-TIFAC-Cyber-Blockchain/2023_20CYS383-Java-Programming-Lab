package com.amrita.jpl.cys21004.practice.basic;

import java.util.Scanner;

/**
 * @author Aishwarya GS
 */

public class Factorial {
    public static void main(String[] args) {
        /**
         * Factorial
         * @param args default argument
         */
        int num, fact = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        num = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        System.out.println("Factorial of " + num + " is: " + fact);
    }
}



