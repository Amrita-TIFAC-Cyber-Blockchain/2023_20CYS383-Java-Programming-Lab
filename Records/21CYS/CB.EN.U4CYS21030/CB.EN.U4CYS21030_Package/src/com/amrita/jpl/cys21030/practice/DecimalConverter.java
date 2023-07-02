package com.amrita.jpl.cys.21030.practice;

import java.util.Scanner;

public class DecimalConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimal = scanner.nextInt();

        if (decimal < 0) {
            System.out.println("Error: Decimal number must be non-negative.");
        } else {
            // Convert decimal to binary
            int[] binary = new int[32];
            int index = 0;
            while (decimal > 0) {
                binary[index++] = decimal % 2;
                decimal = decimal / 2;
            }
            System.out.print("Binary: ");
            for (int i = index - 1; i >= 0; i--) {
                System.out.print(binary[i]);
            }
            System.out.println();

            // Convert decimal to hexadecimal
            char[] hex = new char[8];
            int i = 0;
            while (decimal > 0) {
                int remainder = decimal % 16;
                if (remainder < 10) {
                    hex[i++] = (char) ('0' + remainder);
                } else {
                    hex[i++] = (char) ('A' + remainder - 10);
                }
                decimal = decimal / 16;
            }
            System.out.print("Hexadecimal: ");
            if (i == 0) {
                System.out.print('0');
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    System.out.print(hex[j]);
                }
            }
            System.out.println();
        }
    }
}
