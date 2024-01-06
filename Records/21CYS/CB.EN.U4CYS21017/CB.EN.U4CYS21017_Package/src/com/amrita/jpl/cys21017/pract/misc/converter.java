package com.amrita.jpl.cys21017.pract.misc;

import java.util.Scanner;

public class converter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the decimal value to convert to binary and hex: ");
        int deci = input.nextInt();

        System.out.println("Binary value = " + Integer.toBinaryString(deci));
        System.out.println("Hexadecimal value = " + Integer.toHexString(deci));

    }
}
