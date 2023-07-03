package com.amrita.jpl.cys21078.p1;

import java.util.Scanner;

/**
 * This is the main class which consists of the switch case to select the program which the user has to run
 */
public class p1file {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice : 1.factorial (fact), 2. Fibonacci (fibo), 3. The sum of 'n' numbers(sum_n_no), 4. Prime Test(prime_test): ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter a number: ");
                int num = scanner.nextInt();
                if (num < 0) {
                    System.out.println("The input is invalid");
                    break;
                }
                long fact = fact(num);
                System.out.println("Factorial of " + num + " is " + fact);
                break;
            case 2:
                System.out.print("Enter a number: ");
                int n = scanner.nextInt();
                if (n < 0) {
                    System.out.println("The input is invalid");
                    break;
                }
                fibo(n);
                break;
            case 3:
                System.out.print("Enter a number: ");
                int limit = scanner.nextInt();
                if (limit <= 0) {
                    System.out.println("The input is invalid");
                    break;
                }
                int sum = sum_n_no(limit);
                System.out.println("Sum of first " + limit + " numbers is " + sum);
                break;
            case 4:
                System.out.print("Enter a number: ");
                int number = scanner.nextInt();
                if (number < 0) {
                    System.out.println("the input is invalid");
                    break;
                }
                boolean isPrime = prime_test(number);
                if (isPrime) {
                    System.out.println(number + " is a prime number");
                } else {
                    System.out.println(number + " is not a prime number");
                }
                break;
            default:
                System.out.println("Enter the valid choice");
        }
    }

    /**
     * This is for factorial of a program
     * @param n is of datatype integer
     * @return if n is 0 returns as 1 otherwise it returns factorial of a number
     */
    public static long fact(int n) {
        if (n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }

    /**
     * This is for fibonacci of a program.Here the intilize values 0 and 1 is assigned to a0,a1
     * @param n is of datatype integer
     */

    public static void fibo(int n) {
        int a0= 0, a1 = 1, a3;
        System.out.print(a0 + " " + a1);
        for (int i = 2; i < n; i++) {
            a3 = a0 + a1;
            System.out.print(" " + a3);
            a0 = a1;
            a1 = a3;
        }
        System.out.println();
    }

    /**
     * this is for sum of n numbers
     * @param n is of datatype integer
     * @return the sum of the n integers
     */
    public static int sum_n_no(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * This is for prime test of a number
     * @param n is of datatype integer
     * @return whether the number is prime or not
     */
    public static boolean prime_test(int n) {
        if (n <= 1) {
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
