package com.amrita.jpl.cys21058.pract;

import java.util.Scanner;

public class convertingDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int num = sc.nextInt();


        String binary = Integer.toBinaryString(num);
        String hex = Integer.toHexString(num).toUpperCase();

        System.out.println("Binary: " + binary);
        System.out.println("Hexadecimal: "+hex);
    }
}

//author Siddharth Krishna R
//@version 0.1