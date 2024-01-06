package com.amrita.jpl.cys21028.p1;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        /**
         * @param choice for taking choice in
         */

        do {
            System.out.println("\t\t\t\t\t\t-----Choose an operation from Below-----");
            System.out.println("1) Factorial\t\t2)Fibonacci\t\t\t3) The sum of \'n\' numbers\t\t 4)Prime Test");
            choice = sc.nextInt();
        } while(choice < 1||choice > 4);
        switch(choice){
            case 1:
                System.out.print("Enter a number: ");
                int num = sc.nextInt();
                if (num < 0) {
                    System.out.println(" Number must be non-negative.");
                    return;
                }
                 int fact = fact(num);
                if (fact == -1) {
                    System.out.println("Number too large.");
                    return;
                }
                System.out.println("Factorial of   is " + fact + ".");
                break;

            case 2:
                System.out.println("Enter a number: ");
                int n = sc.nextInt();
                if (n < 0) {
                    System.out.println("Number must be non-negative.");
                    return;
                }
                System.out.print("Fibonacci series up to " + n + " terms: ");
                fibo(n);
                break;
            case 3:
                System.out.print("Enter the number of terms: ");
                int nos = sc.nextInt();
                int sum = sum_n_no(nos);
                System.out.println("Sum of first " + nos + " numbers is " + sum);
                break;
            case 4:
                System.out.print("Enter a number: ");
                int prime = sc.nextInt();
                if (prime < 1) {
                    System.out.println("Number must be positive.");
                    return;
                }
                boolean prime_test = prime_test(prime);
                if (prime_test) {
                    System.out.println(prime + " is a prime number.");
                } else {
                    System.out.println(prime + " is not a prime number.");
                }
                break;
            default:
                System.out.println("Oops...Invalid choice!");
                break;
        }
    }
    /** To create a fact() method
     * @param num to calculate the factorial of the given number.
     * */
    public static int fact(int num){
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
            if (fact < 0) {
                return -1;
            }
        }
        return fact;
    }
    /**  To create a fibo() method
     * */
    public static void fibo(int n){
        int x= 0, y = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(x + " ");
            int sum = x + y;
            x = y;
            y = sum;
        }
        System.out.println();

    }
    /** create a name() method
     * @param nos to add the first numbers
     */
    public static int sum_n_no(int nos){
        int sum = 0;
        for (int i = 1; i <= nos; i++) {
            sum += i;
        }
        return sum;
    }

    /** create a prime_test() method
     * @param number to check if a number is prime or not
     */
    public static boolean prime_test(int number){
        if (number == 1) {
            return false;
        }
        for (int i = 2; i <= number/2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }



}