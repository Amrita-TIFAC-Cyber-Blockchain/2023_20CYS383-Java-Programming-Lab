package com.amrita.jpl.cys21035.ex;

import java.util.Scanner;

public class converter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the decimal number to convert: ");
        int decimal = 0;
        decimal = scanner.nextInt();


        if (decimal < 0) {
            System.out.println("Decimal number cannot be negative");
            System.exit(0);
        }

        String binary = Integer.toBinaryString(decimal);
        String hexadecimal = Integer.toHexString(decimal);

        System.out.println("Binary equivalent: " + binary);
        System.out.println("Hexadecimal equivalent: " + hexadecimal);

        scanner.close();
    }
}

