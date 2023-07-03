package com.amrita.jpl.cys21064.p1;

import java.util.*;
import java.lang.Math;

/**
 * @author  Rajendraprasad S
 * @since   2023-05-02
 * This class implements 4 functions.
 */
public class q1 {

    /**
     * Funtion to reverse a number.
     * @param n  The number to be reversed.
     */
    int reverse_num(int n)
    {
        int f = 0;
        if (n < 0)
        {
            f = 1;
            n *= -1;
        }

        int num = 0;
        while(n > 0)
        {
            num *= 10;
            num += n%10;
            n /= 10;
        }
        if (f == 1)
            return -num;
        else
            return num;
    }

    /**
     * Funtion to find largest of 3 numbers.
     * @param a first number.
     * @param b second number.
     * @param c third number.
     */
    int large3num(int a, int b, int c)
    {
        if (a >= b && a >= c)
            return a;
        if (b >= a && b >= c)
            return b;
        return c;
    }

    /**
     * Funtion to check if a number is a perfect square.
     * @param n  The number to be checked.
     */
    void perfect_square_check(int n)
    {
        int tmp = (int)Math.sqrt(n);
        if (tmp*tmp == n)
        {
            System.out.println(n+" is a perfect square.");
        }
        else
        {
            System.out.println(n+" is not a perfect square.");
        }
    }

    /**
     * Funtion to check if a number is prime.
     * @param n  The number to be checked.
     */
    void prime_test(int n)
    {
        if (n < 2)
        {
            System.out.println(n + " is not prime.");
            return;
        }

        for(int i=2;i<n;i++)
        {
            if(n%i == 0) {
                System.out.println(n + " is not prime.");
                return;
            }
        }
        System.out.println(n+" is prime.");
    }

    public static void main(String args[])
    {
        Scanner read = new Scanner(System.in);

        int choice;
        do {
            System.out.println("1. Reverse the number.");
            System.out.println("2. Largest of 3 numbers.");
            System.out.println("3. Perfect Square.");
            System.out.println("4. Prime test.");
            System.out.println("5. Quit.");
            System.out.print("Enter your choice: ");
            choice = read.nextInt();


            q1 obj = new q1();

            if(choice == 1)
            {
                System.out.print("Enter the number to be reversed: ");
                int n = read.nextInt();
                System.out.println(obj.reverse_num(n));
            }

            else if(choice == 2)
            {
                System.out.print("Enter three numbers: ");
                int a = read.nextInt();
                int b = read.nextInt();
                int c = read.nextInt();
                System.out.println("The largest of the three is :"+ obj.large3num(a,b,c));
            }

            else if(choice == 3)
            {
                System.out.print("Enter a number: ");
                int n = read.nextInt();
                obj.perfect_square_check(n);
            }

            else if(choice == 4)
            {
                System.out.print("Enter a number: ");
                int n = read.nextInt();
                obj.prime_test(n);
            }
        }while(choice != 5);
    }
}
