package com.amrita.jpl.cys21080.practice.basics;

import java.util.Scanner;

/**
 * The FibonacciSeries class generates the Fibonacci series up to a specified limit.
 * It demonstrates the iterative approach to generate the Fibonacci numbers.
 * Fibonacci series starts with 0 and 1, and each subsequent number is the sum of the two preceding ones.
 *
 * Usage:
 * - Create an instance of the FibonacciSeries class.
 * - Call the generateSeries method with the desired limit to generate the Fibonacci series.
 * - The generated series will be printed to the console.
 *
 * Note: The limit should be a positive integer.
 *
 * @author T Pavan Kumar Reddy
 * @version 1.0
 */
public class FibonacciSeries {

    /**
     * Generates the Fibonacci series up to the specified limit.
     *
     * @param limit the upper limit of the series (inclusive)
     */
    public void generateSeries(int limit) {
        int num1 = 0;
        int num2 = 1;

        System.out.println("Fibonacci series up to " + limit + ":");
        System.out.print(num1 + " ");

        while (num2 <= limit) {
            System.out.print(num2 + " ");

            int nextNum = num1 + num2;
            num1 = num2;
            num2 = nextNum;
        }

        System.out.println();
    }

    /**
     * The main method is the entry point of the program.
     * It creates an instance of the FibonacciSeries class and generates the Fibonacci series.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        FibonacciSeries fibonacciSeries = new FibonacciSeries();
        Scanner a = new Scanner(System.in);
        System.out.print("Enter a Limit : ");
        int num = a.nextInt();
        fibonacciSeries.generateSeries(num); // Example usage: Generate Fibonacci series up to 100
    }
}

