package com.amrita.jpl.cys21035.p1;

import java.util.Scanner;

public class funcP1 {
    public funcP1() {
    }

    public static int fact(int n) {
        return n != 0 && n != 1 ? n * fact(n - 1) : 1;
    }

    public static void fibo(int n) {
        int prev = 0;
        int curr = 1;
        System.out.print("" + prev + " " + curr);

        for(int i = 2; i < n; ++i) {
            int next = prev + curr;
            System.out.print(" " + next);
            prev = curr;
            curr = next;
        }

    }

    public static int sum_n_no(int n) {
        int sum = 0;

        for(int i = 0; i < n; ++i) {
            Scanner snum = new Scanner(System.in);
            int num = snum.nextInt();
            sum += num;
        }

        return sum;
    }

    public static int prime_test(int n) {
        boolean flag = false;
        if (n == 0 || n == 1) {
            flag = true;
        }

        for(int i = 2; i <= n / 2; ++i) {
            if (n % i == 0) {
                flag = true;
                break;
            }
        }

        return !flag ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println("1. Factorial (fact)\n2. Fibonacci (fibo)\n3. The sum of ’n’ numbers (sum n no)\n4. Prime Test (prime test)\n");
        Scanner schoice = new Scanner(System.in);
        System.out.print("Enter choice: ");
        int choice = schoice.nextInt();
        Scanner sn;
        int n;
        switch (choice) {
            case 1:
                sn = new Scanner(System.in);
                System.out.print("Enter number: ");
                n = sn.nextInt();
                System.out.println("Factorial: " + fact(n));
                break;
            case 2:
                sn = new Scanner(System.in);
                System.out.print("Enter number: ");
                n = sn.nextInt();
                fibo(n);
                break;
            case 3:
                sn = new Scanner(System.in);
                System.out.print("Enter number: ");
                n = sn.nextInt();
                System.out.println("Sum: " + sum_n_no(n));
                break;
            case 4:
                sn = new Scanner(System.in);
                System.out.print("Enter number: ");
                n = sn.nextInt();
                if (prime_test(n) == 1) {
                    System.out.print("It is a Prime");
                } else {
                    System.out.print("It is not a Prime");
                }
                break;
            default:
                System.out.println("Invalid choice");
        }

    }
}

