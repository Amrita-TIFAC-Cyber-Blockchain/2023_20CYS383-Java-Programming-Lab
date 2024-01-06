package com.amrita.jpl.cys21067.p1;
import java.util.Scanner;
/**
 * @author Dharmik-CB.EN.U4CYS21067
 * The program implements a menu-driven program
 * with four classes
 */

class Factorial {
    /**
     * Calculates the Factorial of the number
     * @param n return the result of the factorial of a number
     */
    public int fact(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}


class Fibonacci {
    /**
     * Calculates the Fibonacci series of the number
     * @param  n  the result of the fibonacci series of a number will be printed
     */
    public void fibo(int n) {
        int a = 0, b = 1, c;
        System.out.print("Fibonacci series up to " + n + " terms:");
        for (int i = 1; i <= n; i++) {
            System.out.print(" " + a);
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
    }
}

class SumN {
    /**
     * Calculates the Sum of n numbers
     * @param  n return the result of the sum of n numbers
     */
    public int sum_n_no(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}

class PrimeTest {
    /**
     * Primetest of the number
     * @param n return the result of the primetest of a number
     */
    public boolean prime_test(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= n/2 ; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

public class quesperiodical1 {
    public static void main(String[] args) {
        System.out.println("------Menu Driven Program ------");
        System.out.println("1.Factorial of a number");
        System.out.println("2.Fibonacci series of a number");
        System.out.println("3.Sum of n numbers");
        System.out.println("4.Primetest of a number");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Factorial selected.");
                System.out.print("Enter a number: ");
                int num1 = input.nextInt();
                if (num1 < 0) {
                    System.out.println("Error: Number must be non-negative.");
                } else {
                    Factorial f = new Factorial();
                    int factorial = f.fact(num1);
                    System.out.println("Factorial of " + num1 + " is " + factorial + ".");
                }
                break;
            case 2:
                System.out.println("Fibonacci selected.");
                System.out.print("Enter a number: ");
                int num2 = input.nextInt();
                if (num2 < 0) {
                    System.out.println("Error: Number must be non-negative.");
                } else {
                    Fibonacci fib = new Fibonacci();
                    fib.fibo(num2);
                }
                break;
            case 3:
                System.out.println("Sum n no selected.");
                System.out.print("Enter a number: ");
                int num3 = input.nextInt();
                if (num3 < 1) {
                    System.out.println("Error: Number must be positive.");
                } else {
                    SumN sn = new SumN();
                    int sum = sn.sum_n_no(num3);
                    System.out.println("Sum of first " + num3 + " numbers is " + sum + ".");
                }
                break;
            case 4:
                System.out.println("Prime test selected.");
                System.out.print("Enter a number: ");
                int num4 = input.nextInt();
                PrimeTest pt = new PrimeTest();
                if (pt.prime_test(num4)) {
                    System.out.println(num4 + " is a prime number.");
                } else {
                    System.out.println(num4 + " is not a prime number.");
                }
                break;
            default:
                System.out.println("Error: Invalid choice.");
        }
    }
}
