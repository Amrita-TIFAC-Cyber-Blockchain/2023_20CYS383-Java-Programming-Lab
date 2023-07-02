package com.amrita.jpl.cys21033.p1;

import java.util.Scanner;

/**
 * This class provides functionality for calculating various parameters of a given number using Java evaluation.
 * Available calculations include factorial, Fibonacci series, sum of 'n' numbers, and prime number test.
 * Version: 0.5
 * Author: Suhitha K
 */
public class p1question {
    /**
     * The main method that allows the user to choose a calculation and interact with the program.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("Enter your choice: ");
            System.out.println("1. Factorial");
            System.out.println("2. Fibonacci");
            System.out.println("3. The sum of 'n' numbers");
            System.out.println("4. Prime Test");
            System.out.print("Your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a number to find its factorial: ");
                    int num = input.nextInt();
                    if (num < 0) {
                        System.out.println("Factorial is not defined for negative numbers.");
                        break;
                    }
                    long factorial = fact(num);
                    System.out.println("Factorial of " + num + " is " + factorial);
                    break;
                case 2:
                    System.out.print("Enter the number of terms to generate in Fibonacci series: ");
                    int terms = input.nextInt();
                    if (terms <= 0) {
                        System.out.println("Number of terms must be greater than zero.");
                        break;
                    }
                    System.out.print("Fibonacci series: ");
                    fibo(terms);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter the number of terms to sum: ");
                    int n = input.nextInt();
                    if (n <= 0) {
                        System.out.println("Number of terms must be greater than zero.");
                        break;
                    }
                    int sum = sum_n_No(n);
                    System.out.println("Sum of first " + n + " natural numbers is " + sum);
                    break;
                case 4:
                    System.out.print("Enter a number to test if it is prime: ");
                    int numToTest = input.nextInt();
                    if (numToTest <= 1) {
                        System.out.println("A number less than or equal to 1 is not a prime number.");
                        break;
                    }
                    boolean isPrime = prime_Test(numToTest);
                    if (isPrime) {
                        System.out.println(numToTest + " is a prime number.");
                    } else {
                        System.out.println(numToTest + " is not a prime number.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice try again.");
            }

        } while (choice != 0);

        input.close();
    }

    /**
     * Calculates the factorial of a given number recursively.
     *
     * @param num the number to calculate the factorial of
     * @return the factorial of the given number
     */
    public static long fact(int num) {
        if (num == 0) {
            return 1;
        }
        return num * fact(num - 1);
    }

    /**
     * Generates the Fibonacci series up to the specified number of terms.
     *
     * @param terms the number of terms to generate in the Fibonacci series
     */
    public static void fibo(int terms) {
        int a = 0, b = 1;
        for (int i = 1; i <= terms; i++) {
            System.out.print(a + " ");
            int sum = a + b;
            a = b;
            b = sum;
        }
    }

    /**
     * Calculates the sum of the first 'n' natural numbers.
     *
     * @param n the number of terms to sum
     * @return the sum of the first 'n' natural numbers
     */
    public static int sum_n_No(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * Tests if a given number is prime.
     *
     * @param num the number to test
     * @return true if the number is prime, false otherwise
     */
    public static boolean prime_Test(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
