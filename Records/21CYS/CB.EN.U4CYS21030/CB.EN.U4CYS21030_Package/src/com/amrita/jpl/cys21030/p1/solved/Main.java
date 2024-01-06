package com.amrita.jpl.cys21030.p1.solved;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your choice:");
        System.out.println("1. Factorial (fact)");
        System.out.println("2. Fibonacci (fibo)");
        System.out.println("3. The sum of 'n' numbers (sum n no)");
        System.out.println("4. Prime Test (prime test)");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter a number to calculate factorial: ");
                int num = scanner.nextInt();
                if (num >= 0) {
                    long factorial = calculateFactorial(num);
                    System.out.println("Factorial of " + num + " is " + factorial);
                } else {
                    System.out.println("Invalid input. Please enter a non-negative number.");
                }
                break;
            case 2:
                System.out.print("Enter the count of Fibonacci numbers to generate: ");
                int count = scanner.nextInt();
                if (count >= 0) {
                    System.out.println("Fibonacci series:");
                    generateFibonacci(count);
                } else {
                    System.out.println("Invalid input. Please enter a non-negative number.");
                }
                break;
            case 3:
                System.out.print("Enter the count of numbers to sum: ");
                int n = scanner.nextInt();
                if (n >= 0) {
                    int sum = calculateSum(n);
                    System.out.println("Sum of " + n + " numbers is " + sum);
                } else {
                    System.out.println("Invalid input. Please enter a non-negative number.");
                }
                break;
            case 4:
                System.out.print("Enter a number to test for primality: ");
                int number = scanner.nextInt();
                if (number >= 2) {
                    boolean isPrime = checkPrime(number);
                    if (isPrime) {
                        System.out.println(number + " is a prime number.");
                    } else {
                        System.out.println(number + " is not a prime number.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number greater than or equal to 2.");
                }
                break;
            default:
                System.out.println("Invalid choice. Please enter a number from 1 to 4.");
                break;
        }

        scanner.close();
    }

    public static long calculateFactorial(int num) {
        long factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void generateFibonacci(int count) {
        int first = 0;
        int second = 1;
        System.out.print(first + " " + second + " ");

        for (int i = 2; i < count; i++) {
            int next = first + second;
            System.out.print(next + " ");

            first = second;
            second = next;
        }

        System.out.println();
    }

    public static int calculateSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static boolean checkPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
