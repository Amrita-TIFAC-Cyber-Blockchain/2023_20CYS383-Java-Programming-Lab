package com.amrita.jpl.cys21004.practice.basic;

import java.util.Scanner;

/**
 * @author Aishwarya GS
 */


public class Prime {
    public static void main(String[] args) {

        /**
         * Prime number
         * @param args default argument
         */

        int num;
        boolean isPrime = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        num = sc.nextInt();

        if (num <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        if (isPrime) {
            System.out.println(num + " is a prime number");
        } else {
            System.out.println(num + " is not a prime number");
        }
    }
}
