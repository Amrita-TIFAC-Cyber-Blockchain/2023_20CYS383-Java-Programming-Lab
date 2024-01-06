package com.amrita.jpl.cys21017.pract.misc;

import java.util.Scanner;

public class input {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name:");
        String name = input.next();
        System.out.println("Hello " + name);
        System.out.print("Enter the first number:");
        int a = input.nextInt();
        System.out.print("Enter the second number:");
        int b = input.nextInt();
        System.out.println("Sum:" + (a+b) );
        System.out.println("Subtraction:" + (a-b) );
        System.out.println("Multiplication:" + (a*b) );
        System.out.println("Division:" + (a/b));
    }
}
