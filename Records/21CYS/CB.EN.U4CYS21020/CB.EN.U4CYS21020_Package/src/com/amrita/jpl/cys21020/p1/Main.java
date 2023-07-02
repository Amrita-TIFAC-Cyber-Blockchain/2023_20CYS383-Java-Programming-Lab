package com.amrita.jpl.cys21020.p1;

import java.util.Scanner;

/**
 * @author Hemesh sai
 * @version 1.0
 * The Main class contains a menu-driven program that allows the user to choose from various mathematical operations.
 */
public class Main {

    /**
     * The main method is the entry point of the program.
     * It displays a menu and prompts the user for a choice.
     * Based on the choice, it performs the corresponding operation.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choice:");
        System.out.println("1. Factorial ");
        System.out.println("2. Fibonacci ");
        System.out.println("3. sum n no");
        System.out.println("4. prime test");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter the number:");
                int num = scanner.nextInt();
                if (num < 0) {
                    System.out.println(" Invalid ");
                    return;
                }
                long factorial = fact(num);
                System.out.println("Factorial  " + num + " is " + factorial);
                break;
            case 2:
                System.out.println("Enter the numbers:");
                int n = scanner.nextInt();
                if (n < 0) {
                    System.out.println(" Invalid ");
                    return;
                }
                fibo(n);
                break;
            case 3:
                System.out.println("Enter the numbers:");
                int m = scanner.nextInt();
                if (m < 0) {
                    System.out.println(" Invalid ");
                    return;
                }
                int sum = sum_n_numbers(m);
                System.out.println("The sum of first " + m + " numbers is " + sum);
                break;
            case 4:
                System.out.println("Enter the number:");
                int x = scanner.nextInt();
                if (x < 0) {
                    System.out.println("Invalid ");
                    return;
                }
                boolean isPrime = prime_test(x);
                if (isPrime) {
                    System.out.println(x + "  prime number.");
                } else {
                    System.out.println(x + "  not a prime number.");
                }
                break;
            default:
                System.out.println("  please enter a number between 1 to 4.");
                break;
        }
    }

    /**
     * Calculates the factorial of a given number.
     *
     * @param n The number for which factorial needs to be calculated.
     * @return The factorial of the given number.
     */
    public static long fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    /**
     * Generates the Fibonacci series up to a specified number of terms.
     *
     * @param n The number of terms in the Fibonacci series.
     */
    public static void fibo(int n) {
        int a = 0, b = 1;
        System.out.print("Fibonacci series of first " + n + " terms: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
    }

    /**
     * Calculates the sum of the first 'n' numbers.
     *
     * @param n The number up to which the sum needs to be calculated.
     * @return The sum of the first 'n' numbers.
     */
    public static int sum_n_numbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * Checks if a given number is prime.
     *
     * @param n The number to be tested for primality.
     * @return true if the number is prime, false otherwise.
     */
    public static boolean prime_test(int n) {
        if (n == 1 || n == 0) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
