package com.amrita.jpl.cys21005.pract.basicprograms;

import java.util.Scanner;

/**
 * @author Alagu Soundarya G
 * @version 1.0
 * Basic Odd or Even Program
 */


public class OddEven {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = reader.nextInt();

        if(num % 2 == 0)
            System.out.println(num + " is even");
        else
            System.out.println(num + " is odd");
    }
}