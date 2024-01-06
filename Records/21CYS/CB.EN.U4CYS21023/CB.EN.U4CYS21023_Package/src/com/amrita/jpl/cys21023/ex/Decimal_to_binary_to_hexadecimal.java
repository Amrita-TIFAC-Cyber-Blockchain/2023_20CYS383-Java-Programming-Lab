package com.amrita.jpl.cys21023.ex;

import java.util.Scanner;



public class Decimal_to_binary_to_hexadecimal {

    static void decToBin(int n) {
        int[] binaryNum = new int[1000];

        int i;
        for(i = 0; n > 0; ++i) {
            binaryNum[i] = n % 2;
            n /= 2;
        }

        System.out.print("Binary: ");

        for(int j = i - 1; j >= 0; --j) {
            System.out.print(binaryNum[j]);
        }

        System.out.println();
    }

    static void decToHex(int n) {
        int[] hexNum = new int[100];

        int i;
        for(i = 0; n != 0; ++i) {
            hexNum[i] = n % 16;
            n /= 16;
        }

        System.out.print("Hexadecimal: ");

        for(int j = i - 1; j >= 0; --j) {
            if (hexNum[j] > 9) {
                System.out.print((char)(55 + hexNum[j]));
            } else {
                System.out.print(hexNum[j]);
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Number: ");
        int num = input.nextInt();
        decToBin(num);
        decToHex(num);
    }
}
