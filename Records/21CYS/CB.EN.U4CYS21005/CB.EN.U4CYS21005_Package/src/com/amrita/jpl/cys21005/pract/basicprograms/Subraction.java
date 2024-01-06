package com.amrita.jpl.cys21005.pract.basicprograms;
/**
 * @author Alagu Soundarya G
 * @version 1.0
 * basic subraction program
 */

import java.util.Scanner;

public class Subraction {
    public Subraction() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter first number");
        int a = sc.nextInt();
        System.out.println("enter second number");
        int b = sc.nextInt();
        sc.close();
        int sub = a - b;
        System.out.println("sub is:" + sub);
    }
}
