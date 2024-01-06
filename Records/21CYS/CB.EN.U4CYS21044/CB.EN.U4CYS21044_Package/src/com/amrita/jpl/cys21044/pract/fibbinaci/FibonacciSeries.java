package com.amrita.jpl.cys21044.pract.fibbinaci;
import java.util.Scanner;

/**
 * @author ravi
 * @version 1.0
 */
public class FibonacciSeries {

    /**
     * @param limit - the upper limit of the series (inclusive)
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
     * @param args - command line arguments
     */
    public static void main(String[] args) {
        FibonacciSeries fibonacciSeries = new FibonacciSeries();
        Scanner a = new Scanner(System.in);
        System.out.print("Enter a Limit : ");
        int num = a.nextInt();
        fibonacciSeries.generateSeries(num); // Example usage: Generate Fibonacci series up to 100
    }
}
