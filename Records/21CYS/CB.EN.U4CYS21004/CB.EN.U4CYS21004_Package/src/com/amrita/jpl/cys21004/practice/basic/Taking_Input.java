package com.amrita.jpl.cys21004.practice.basic;

import java.util.Scanner;

/**
 * @author Aishwarya GS
 */

public class Taking_Input {
    public static void main(String[] args) {

        /**
         * Input
         * @param args default argument
         */

        int num1, num2, sum;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number: ");
        num1 = sc.nextInt();

        System.out.println("Enter second Number: ");
        num2 = sc.nextInt();

        sc.close();
        sum = num1 + num2;

        System.out.println("Sum of first and second numbers = "+sum);
    }
}