package com.amrita.jpl.cys21021.P1;

import java.util.Scanner;

/**
 * The Main class provides a menu-driven program that performs various mathematical operations.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter a number to find the factorial of the number: ");
                int num1 = scanner.nextInt();
                if (num1 < 0) {
                    System.out.println("Error: Factorial can't be defined for negative numbers.");
                } else {
                    long fact = factorial(num1);
                    System.out.println("Factorial of " + num1 + " is " + fact);
                }
                break;
            case 2:
                System.out.print("Please enter the number of terms for the Fibonacci series: ");
                int num2 = scanner.nextInt();
                if (num2 <= 0) {
                    System.out.println("Error: Number of terms should be a positive integer.");
                } else {
                    fibonacci(num2);
                }
                break;
            case 3:
                System.out.print("Please enter the value of n: ");
                int n = scanner.nextInt();
                if (n <= 0) {
                    System.out.println("Error: n should be a positive integer.");
                } else {
                    int sum = sumOfNNumbers(n);
                    System.out.println("Sum of first " + n + " natural numbers is " + sum);
                }
                break;
            case 4:
                System.out.print("Please enter a number to check if it is prime: ");
                int num3 = scanner.nextInt();
                if (num3 <= 1) {
                    System.out.println("Error: Number should be a positive integer greater than 1.");
                } else if (isPrime(num3)) {
                    System.out.println(num3 + " is a prime number.");
                } else {
                    System.out.println(num3 + " is not a prime number.");
                }
                break;
            default:
                System.out.println("Error: Invalid choice.");
        }

        scanner.close();
    }

    /**
     * Calculates the factorial of a given number.
     *
     * @param n the number for which factorial is to be calculated
     * @return the factorial of the given number
     */
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /**
     * Generates and prints the Fibonacci series up to a specified number of terms.
     *
     * @param n the number of terms in the Fibonacci series
     */
    public static void fibonacci(int n) {
        int num1 = 0, num2 = 1;
        System.out.print(num1 + " " + num2 + " ");
        for (int i = 2; i < n; i++) {
            int sum = num1 + num2;
            System.out.print(sum + " ");
            num1 = num2;
            num2 = sum;
        }
        System.out.println();
    }

    /**
     * Calculates the sum of the first n natural numbers.
     *
     * @param n the number of natural numbers
     * @return the sum of the first n natural numbers
     */
    public static int sumOfNNumbers(int n) {
        return n * (n + 1) / 2;
    }

    /**
     * Checks if a given number is prime.
     *
     * @param n the number to be checked
     * @return true if the number is prime, false otherwise
     */
    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
