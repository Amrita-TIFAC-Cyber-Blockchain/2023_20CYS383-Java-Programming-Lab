package com.amrita.jpl.cys21003.pract.basics;

import java.util.Scanner;

public class Subraction {
    /**
     * This class demonstrates the basic java addition program.
     *
     * @author Aishwarya G
     * @version 1.0
     */

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
