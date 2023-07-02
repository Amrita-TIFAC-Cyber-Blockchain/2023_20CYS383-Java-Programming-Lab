package com.amrita.jpl.cys21030.practice;
import java.util.Scanner;

public class FibonacciCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of terms: ");
        int n = scanner.nextInt();

        System.out.println("Fibonacci Series:");
        for (int i = 0; i < n; i++) {
            int fibonacci = calculateFibonacci(i);
            System.out.print(fibonacci + " ");
        }
    }

    public static int calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int fibNMinus2 = 0;
        int fibNMinus1 = 1;
        int fibonacci = 0;

        for (int i = 2; i <= n; i++) {
            fibonacci = fibNMinus2 + fibNMinus1;
            fibNMinus2 = fibNMinus1;
            fibNMinus1 = fibonacci;
        }

        return fibonacci;
    }
}
