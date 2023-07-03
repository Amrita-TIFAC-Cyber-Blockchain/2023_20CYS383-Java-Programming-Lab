package com.amrita.jpl.cys21069.practice.assignments;

import java.util.Scanner;
/**
 * The NumberConversion class represents a simple program to convert an decimal number to hexadecimal and binary numbers.
 *
 * @author Seran Pandiyan I P   CB.EN.U4CYS21069
 * @version 0.1
 */

public class NumberConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the decimal number to convert: ");
        int num = 0;
        num = scanner.nextInt();

        if (num < 0) {
            System.out.println("Error: Decimal number cannot be negative!");
        }
        else {
            String binary = Integer.toBinaryString(num);
            String hexadecimal = Integer.toHexString(num);

            System.out.println("Binary equivalent: " + binary);
            System.out.println("Hexadecimal equivalent: " + hexadecimal);
        }
    }
}
