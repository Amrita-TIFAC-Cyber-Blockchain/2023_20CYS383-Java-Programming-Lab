package com.amrita.jpl.cys21039.pt1;

import java.util.Scanner;
/**
 * @author Manbendra Satpathy - CB.EN.U4CYS21039
 */
public class Number_Operations{
    /**
     * Calculates the factorial of a number.
     * @param n The number to calculate the factorial of.
     * @return The factorial of the given number.
     */
    static int fact(int n) {
        if (n == 0)
            return 1;
        else
            return (n * fact(n - 1));
    }
    static int a = 0, b = 1, c = 0;
    /**
     * Prints the Fibonacci series of a number.
     *
     * @param count The number of Fibonacci numbers to be printed.
     */
    static void fibo(int count) {
        if (count > 0) {
            c = a + b;
            a = b;
            b = c;
            System.out.print(" " + c);
            fibo(count - 1);
        }
    }
    /**
     * Calculates the sum of the first 'n' numbers.
     *
     * @param n The value of 'n'.
     * @return The sum of the first 'n' numbers.
     */
    static int sum_n_no(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++)
            sum = sum + i;
        return sum;
    }
    /**
     * Tests whether a number is prime or not.
     *
     * @param n The number to be tested.
     * @return 1 if the number is not prime, 0 if the number is prime.
     */
    static int prime_test(int n) {
        int flag = 0;
        for (int i = 2; i <= n / 2; ++i) {
            if (n % i == 0) {
                flag = 1;
                break;
            }
        }
        return flag;
    }
    /**
     * The entry point for the Java program.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 1. Factorial ");
        System.out.println(" 2. Fibonacci ");
        System.out.println(" 3. Sum of n numbers");
        System.out.println(" 4. Prime Test");
        System.out.print(" Enter your choice : ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println(" You have chosen to calculate the factorial of a number.");
                System.out.print(" Enter a number : ");
                int input1 = scanner.nextInt();
                if (input1 > 0) {
                    int factorial = fact(input1);
                    System.out.println(" The factorial of the number " + input1 + " is " + factorial);
                } else if (input1 == 0) {
                    System.out.println(" Error! You have entered zero.");
                } else {
                    System.out.println(" Error! You have entered a negative number.");
                }
                break;
            case 2:
                System.out.println(" You have chosen to calculate the Fibonacci series of a number.");
                System.out.print(" Enter a number : ");
                int input2 = scanner.nextInt();
                if (input2 > 0) {
                    System.out.println(" The Fibonacci series is as follows:");
                    System.out.print(" " + a + " " + b);
                    fibo(input2 - 2);
                    System.out.println();
                } else if (input2 == 0) {
                    System.out.println(" Error! You have entered zero.");
                } else {
                    System.out.println(" Error! You have entered a negative number.");
                }
                break;
            case 3:
                System.out.println(" You have chosen to calculate the sum of 'n' numbers.");
                System.out.print(" Enter a number : ");
                int input3 = scanner.nextInt();
                if (input3 > 0) {
                    int sum = sum_n_no(input3);
                    System.out.println(" The sum of the first " + input3 + " numbers is " + sum);
                } else if (input3 == 0) {
                    System.out.println(" Error! You have entered zero.");
                } else {
                    System.out.println(" Error! You have entered a negative number.");
                }
                break;
            case 4:
                System.out.println(" You have chosen to check whether a number is prime or not.");
                System.out.print(" Enter a number : ");
                int input4 = scanner.nextInt();
                if (input4 > 0) {
                    int newflag = prime_test(input4);
                    if (input4 == 1) {
                        System.out.println(" 1 is not a prime number.");
                        break;
                    }
                    if (newflag == 1) {
                        System.out.println(" The number " + input4 + " is not a prime number.");
                    } else {
                        System.out.println(" The number " + input4 + " is a prime number.");
                    }
                } else {
                    System.out.println(" Error! You have entered a negative number.");
                }
                break;
            default:
                System.out.println(" Error! Invalid option selected.");
                return;
        }
        scanner.close();
    }
}
