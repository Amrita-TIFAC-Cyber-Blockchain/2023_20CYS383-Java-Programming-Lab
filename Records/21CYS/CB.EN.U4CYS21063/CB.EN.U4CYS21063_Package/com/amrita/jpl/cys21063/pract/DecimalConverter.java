package com.amrita.jpl.cys21063.pract;

import java.util.Scanner;

public class DecimalConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        int decimal = scanner.nextInt();

        if (decimal < 0) {
            System.out.println("Error: Negative numbers are not supported.");
        } else {
            String binary = Integer.toBinaryString(decimal);
            String hexadecimal = Integer.toHexString(decimal);

            System.out.println("Binary: " + binary);
            System.out.println("Hexadecimal: " + hexadecimal);
        }

        scanner.close();
    }
}
