package com.amrita.jpl.cys21031.practice.simple;

import java.util.Scanner;

/**
 * @author Kishanth K
 * @version 0.5
 *
 * A Java program to print the addiion of 2 numbers
 */
public class add2Numbers {
    public static void main(String[] args) {

        int num1, num2, sum;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter First Number: ");

        num1 = sc.nextInt();

        System.out.println("Enter Second Number: ");

        num2 = sc.nextInt();

        sc.close();

        sum = num1 + num2;
        System.out.println("Sum of these numbers: "+sum);

    }

}