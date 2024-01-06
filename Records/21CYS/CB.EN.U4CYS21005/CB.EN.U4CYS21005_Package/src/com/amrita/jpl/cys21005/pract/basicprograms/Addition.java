package com.amrita.jpl.cys21005.pract.basicprograms;
/**
 * @author Alagu Soundarya G
 * @version 1.0
 * basic addition program
 */

import java.util.Scanner;

public class Addition {
    public Addition() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter first number");
        int a = sc.nextInt();
        System.out.println("enter second number");
        int b = sc.nextInt();
        sc.close();
        int sum = a + b;
        System.out.println("sum is:" + sum);
    }
}
