package com.amrita.jpl.cys21031.practice.simple;

import java.util.*;

/**
 * @author Kishanth K
 * @version 0.5
 *
 * A Java program to convert a decimal number to a binary
 */
public class DecToBin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the decimal number to convert: ");
        int dec = sc.nextInt();
        if (dec < 0) {
            System.out.println("Decimal number cannot be negative");

        } else {
            String bin = Integer.toBinaryString(dec);
            String hex = Integer.toHexString(dec);
            System.out.println("Binary equivalent: " + bin);
            System.out.println("Hexadecimal equivalent: " + hex);
        }
    }
}