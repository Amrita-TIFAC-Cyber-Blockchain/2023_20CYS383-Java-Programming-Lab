package com.amrita.jpl.cys21087.p1;

/**
 * - This is a simple menu driven program that i did for the periodical1 exam
 * - This has 4 options like factorial, fibonacci, sum of n numbers and to check if a number is prime or not.
 * @author Vishnu
 * @version 1.0
 */

import java.util.Scanner;
public class periodical {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            System.out.println("Enter your choice: ");
            System.out.println("1. Factorial");
            System.out.println("2. Fibonacci");
            System.out.println("3. Sum of n numbers");
            System.out.println("4. Prime");
            System.out.println("5. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("enter a number to find factorial:");
                    int num1 = scanner.nextInt();
                    if (num1 <= 0) {
                        System.out.println("error: cannot find factorial for negative number or 0.");
                        break;
                    }
                    else {
                        long fact = factorial(num1);
                        System.out.println("factorial of " + num1 + " is " + fact);
                    }
                    break;
                case 2:
                    System.out.println("enter a number to find fibonacci series: ");
                    int num2 = scanner.nextInt();
                    if (num2 <= 0) {
                        System.out.println("error: cannot find fibonacci for a negative number of 0.");
                        break;
                    }
                    System.out.println("fibonacci series up to " + num2 + " is:");
                    fibonacci(num2);
                    break;
                case 3:
                    System.out.println("enter the value of n for sum of n numbers:");
                    int n = scanner.nextInt();
                    if (n <= 0) {
                        System.out.println("error: cannot find sum of numbers for a negative number of 0.");
                        break;
                    }
                    int sum = sumofnnumbers(n);
                    System.out.println("sum of first " + n + " numbers is " + sum);
                    break;
                case 4:
                    System.out.println("enter a number to check if its prime or not:");
                    int num3 = scanner.nextInt();
                    if (num3 <= 0) {
                        System.out.println("error: cannot do prime number test for a negative number or 0.");
                        break;
                    }
                    boolean isPrime = isPrime(num3);
                    if (isPrime) {
                        System.out.println(num3 + " is a prime number.");
                    } else {
                        System.out.println(num3 + " is not a prime number.");
                    }
                    break;
                case 5:
                    System.out.println("Bye Bye...!");
                    break;
                default:
                    System.out.println("error: invalid choice.");
                    break;
            }
            System.out.println();
        }
        scanner.close();
    }

    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void fibonacci(int n) {
        int a = 0, b = 1, c;
        System.out.print(a + " " + b);
        for (int i = 2; i <= n; i++) {
            c = a + b;
            System.out.print(" " + c);
            a = b;
            b = c;
        }
        System.out.println();
    }

    public static int sumofnnumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static boolean isPrime(int n) {
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

