package com.amrita.jpl.cys21066.EX;

import java.util.Scanner;

public class DecimalConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        if (scanner.hasNextInt()) {
            int decimal = scanner.nextInt();

            if (decimal >= 0) {
                String binary = Integer.toBinaryString(decimal);
                String hexadecimal = Integer.toHexString(decimal).toUpperCase();

                System.out.println("Binary: " + binary);
                System.out.println("Hexadecimal: " + hexadecimal);
            } else {
                System.out.println("Error: Negative input not supported.");
            }
        } else {
            System.out.println("Error: Invalid input. Only integer input accepted.");
        }

        scanner.close();
    }
}
