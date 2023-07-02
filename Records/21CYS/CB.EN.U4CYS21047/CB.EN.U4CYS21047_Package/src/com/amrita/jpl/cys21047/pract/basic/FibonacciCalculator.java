package com.amrita.jpl.cys21047.pract.basic;

import java.util.Scanner;

public class FibonacciCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int numberOfTerms = scanner.nextInt();

        if (numberOfTerms <= 0) {
            System.out.println("Error: Number of terms should be a positive integer.");
        } else {
            System.out.println("Fibonacci series up to " + numberOfTerms + " terms:");
            for (int i = 0; i < numberOfTerms; i++) {
                int fibonacci = calculateFibonacci(i);
                System.out.print(fibonacci + " ");
            }
        }
    }

    public static int calculateFibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int fibMinus2 = 0;
            int fibMinus1 = 1;
            int fibonacci = 0;

            for (int i = 2; i <= n; i++) {
                fibonacci = fibMinus1 + fibMinus2;
                fibMinus2 = fibMinus1;
                fibMinus1 = fibonacci;
            }

            return fibonacci;
        }
    }
}
