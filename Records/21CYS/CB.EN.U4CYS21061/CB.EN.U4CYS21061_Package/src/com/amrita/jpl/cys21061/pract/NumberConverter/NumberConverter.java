package com.amrita.jpl.cys21061.pract.NumberConverter;

import java.util.Scanner;

public class NumberConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        if (scanner.hasNextInt()) {
            int decimal = scanner.nextInt();

            String binary = Integer.toBinaryString(decimal);
            String hexadecimal = Integer.toHexString(decimal);

            System.out.println("Binary: " + binary);
            System.out.println("Hexadecimal: " + hexadecimal);
        } else {
            System.out.println("Error: Invalid input. Only integer input accepted.");
        }

        scanner.close();
    }
}
