package com.amrita.jpl.cys21005.exercise;

import java.util.Scanner;

/**
 * Decimal to binary and hexadecimal conversion
 *
 * @author Alagu Soundarya G
 * @version 1.0
 * Question 3
 */
public class q3_conversion {
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