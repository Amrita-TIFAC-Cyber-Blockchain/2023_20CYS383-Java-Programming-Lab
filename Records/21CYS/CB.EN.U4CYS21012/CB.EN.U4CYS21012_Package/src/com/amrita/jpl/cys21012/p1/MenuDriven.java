/**
 * Program placed in required package
 */
package com.amrita.jpl.cys21012.p1;

/**
 * Important libraries imported
 */

import java.util.*;
import java.lang.Math;

/**
 * Class created with a sensible name
 */
public class MenuDriven {
    /**
     * The reverse_num function reverses the given integer.  If negative, the absolute value is reversed, keeping the negative symbol intact.
     * @param n - input number
     * @return reversed number
     */
    public int reverse_num(int n){

        int x_rev = 0;
        while (n != 0){
            x_rev = x_rev*10 + n%10;
            n = (int) n/10;
        }
        return (x_rev);
    }

    /**
     * large3num function is used to find the largest number among 3.  Regardless of repetitions, largest is returned.
     * @param a - The first number
     * @param b - The second number
     * @param c - The third number
     * @return The largest of the 3 numbers
     */
    public int large3num(int a,int b,int c){
        if (a>b && a>c){
            return a;
        }
        else{
            if (b>a && b>c){
                return b;
            }
            else{
                return c;
            }
        }
    }

    /**
     * perfect_square_check is a void function that checks whether a number is a perfect square
     * @param n - input number
     */
    public void perfect_square_check(int n){
        if (n < 0){
            System.out.println("Negative numbers cannot be perfect squares");
        }
        else {
            int k = (int) Math.sqrt(n);
            if (k * k == n) {
                System.out.println("It is a perfect square\n");
            } else {
                System.out.println("It is not a perfect square\n");
            }
        }
    }

    /**
     * prime_test is a void function that checks whether a number is prime
     * @param n - input number
     */
    public void prime_test(int n){
        if (n < 0){
            System.out.println("Negative numbers are not prime");
        }
        else {
            boolean flag = true;
            for (int i = 2; i < (int) n / 2; i++) {
                if (n % i == 0) {
                    System.out.println("The number is not a prime");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("The number is a prime");
            }
        }
    }

    public static void main(String[] args) {

        System.out.print("1.Reverse a number\n2.Largest of 3 numbers\n3.Perfect square test\n4.Prime test\n\nEnter your choice:");

        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        int ans;
        int n;
        /**
         * Here an object is created to access the non-static functions of the class
         */
        MenuDriven obj = new MenuDriven();
        /**
         * Menu-driven program to use choice and print the output
         */
        switch (choice) {
            case 1 -> {
                System.out.println("Enter a number : ");
                n = s.nextInt();
                ans = obj.reverse_num(n);
                System.out.println("The number reversed is " + ans + "\n");
            }
            case 2 -> {
                System.out.println("Enter 3 numbers : ");
                int a = s.nextInt();
                int b = s.nextInt();
                int c = s.nextInt();
                ans = obj.large3num(a, b, c);
                System.out.println("The largest among the three numbers is " + ans + "\n");
            }
            case 3 -> {
                System.out.println("Enter a number to check if square : ");
                n = s.nextInt();
                obj.perfect_square_check(n);
            }
            case 4 -> {
                System.out.println("Enter a number to check if prime: ");
                n = s.nextInt();
                obj.prime_test(n);
            }
        }

    }
}
