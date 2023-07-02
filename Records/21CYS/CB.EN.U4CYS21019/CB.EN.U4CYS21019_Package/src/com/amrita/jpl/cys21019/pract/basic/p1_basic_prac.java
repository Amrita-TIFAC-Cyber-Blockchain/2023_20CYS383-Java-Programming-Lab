package com.amrita.jpl.cys21019.pract.basic;

/**
 * This program provides basic mathematical operations such as factorial, Fibonacci series,
 * sum of 'n' numbers, and prime number testing based on user choice.
 * Author: Gokulachselvan C D
 */

import java.util.Scanner;

public class p1_basic_prac {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.print("Enter a choice (1. Factorial (fact), 2. Fibonacci (fibo), 3. The sum of 'n' numbers (sum n no), 4. Prime Test (prime test)): ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter a number: ");
                int n1 = scanner.nextInt();
                if (n1 < 0) {
                    System.out.println("Invalid input.");
                } else {
                    int fact = fact(n1);
                    if (fact != -1) {
                        System.out.println("Factorial of " + n1 + " is " + fact);
                    }
                }
                break;
            case 2:
                System.out.print("Enter a number: ");
                int n2 = scanner.nextInt();
                if (n2 < 0) {
                    System.out.println("Invalid input.");
                } else {
                    System.out.print("Fibonacci series up to " + n2 + " terms: ");
                    fibo(n2);
                }
                break;
            case 3:
                System.out.print("Enter a number: ");
                int n3 = scanner.nextInt();
                if (n3 < 0) {
                    System.out.println("Invalid input.");
                } else {
                    int sum = sum_n_no(n3);
                    System.out.println("Sum of first " + n3 + " numbers is " + sum);
                }
                break;
            case 4:
                System.out.print("Enter a number: ");
                int n4 = scanner.nextInt();
                if (n4 < 0) {
                    System.out.println("Invalid input.");
                } else {
                    if (prime_test(n4)) {
                        System.out.println(n4 + " is a prime number.");
                    } else {
                        System.out.println(n4 + " is not a prime number.");
                    }
                }
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    /**
     * Calculates the factorial of a given number.
     * @param n the number
     * @return the factorial of the number, or -1 if the input is invalid
     */
    public static int fact(int n) {
        if (n == 0) {
            return 1;
        } else {
            int fact = 1;
            for (int i = 1; i <= n; i++) {
                fact *= i;
            }
            return fact;
        }
    }

    /**
     * Prints the Fibonacci series up to a given number of terms.
     * @param n the number of terms in the series
     */
    public static void fibo(int n) {
        int num1 = 0, num2 = 1, sum = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print(num1 + " ");
            sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }
        System.out.println();
    }

    /**
     * Calculates the sum of 'n' numbers.
     * @param n the number of terms to sum
     * @return the sum of the numbers
     */
    public static int sum_n_no(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * Tests whether a given number is prime.
     * @param n the number to test
     * @return true if the number is prime, false otherwise
     */
    public static boolean prime_test(int n) {
        if (n == 1 || n == 0) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
