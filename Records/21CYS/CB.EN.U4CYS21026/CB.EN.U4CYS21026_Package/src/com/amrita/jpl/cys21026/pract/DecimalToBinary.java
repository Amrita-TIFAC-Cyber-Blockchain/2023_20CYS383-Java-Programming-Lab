package com.amrita.jpl.cys21026.pract;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimalNumber = scanner.nextInt();
        scanner.close();

        String binaryCode = Integer.toBinaryString(decimalNumber);
        System.out.println("Binary code: " + binaryCode);
    }
}
