package com.amrita.jpl.cys21078.pract.basic;

import java.util.Scanner;
public class Addition {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter number 1: ");
        int a = Integer.parseInt(myObj.nextLine());
        System.out.println("Enter number 2: ");
        int b = Integer.parseInt(myObj.nextLine());
        // It will return the sum of two arguments.
        int sum = a + b;
        System.out.println("The sum is = " + sum);
    }
}

