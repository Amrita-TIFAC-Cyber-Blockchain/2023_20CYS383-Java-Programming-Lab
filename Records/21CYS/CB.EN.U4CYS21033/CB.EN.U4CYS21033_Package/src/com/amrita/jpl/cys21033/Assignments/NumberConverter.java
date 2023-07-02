package com.amrita.jpl.cys21033.Assignments;

import java.util.Scanner;

public class NumberConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        if (scanner.hasNextInt()) {
            int decimal = scanner.nextInt();

            if (decimal >= 0) {
                String binary = Integer.toBinaryString(decimal);
                String hexadecimal = Integer.toHexString(decimal);

                System.out.println("Binary: " + binary);
                System.out.println("Hexadecimal: " + hexadecimal);
            } else {
                System.out.println("Error: Negative numbers are not accepted.");
            }
        } else {
            System.out.println("Error: Invalid input. Please enter an integer.");
        }
    }
}
