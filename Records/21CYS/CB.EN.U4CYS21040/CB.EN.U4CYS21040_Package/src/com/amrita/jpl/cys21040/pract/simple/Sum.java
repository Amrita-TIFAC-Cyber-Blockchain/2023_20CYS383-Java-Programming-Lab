package com.amrita.jpl.cys21040.pract.simple;

import java.util.*;
/*
* The Sum class is used to implement the sum of n numbers
* by taking the input n from the user
* */
public class Sum {
    public static void main(String args[]) {
        System.out.print("Enter a number");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = 0;
        for (int i = 0; i < n; i++) {

            c = c + i;

        }
        System.out.println("Sum of numbers till " + n + " is " + c);
    }
}
