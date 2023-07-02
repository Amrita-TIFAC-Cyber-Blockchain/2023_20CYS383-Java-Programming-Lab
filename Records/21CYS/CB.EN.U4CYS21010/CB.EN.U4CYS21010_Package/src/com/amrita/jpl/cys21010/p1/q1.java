package com.amrita.jpl.cys21010.p1;

import java.lang.reflect.Type;
import java.util.*;

/**
 * @author Arjun C Santosh
 */

class fun_class {
    /**
     *
     * @param x
     * @return temp
     */
    public String revnum(int x) {
        if (x < 0) {
            System.err.println("Can not Reverse a negative number");
//            break;
            return null;

        } else {
            int num = 0;
            String temp = "";
            while (x != 0) {
                int v = x % 10;
                x = (x - v) / 10;
                temp = temp + v;
//            System.out.println(temp);
            }

            return temp;
        }
    }

    /**
     *
     * @param a
     * @param b
     * @param c
     * @return large
     */
    public int large3num(int a, int b, int c) {
        int large = Math.max(a, b);
        large = Math.max(large, c);
        return large;
    }

    /**
     *
     * @param n
     */

    public void perfect_square_check(int n) {
        double a = Math.sqrt(n) * Math.sqrt(n);
        if (a == n) {
            System.out.println("It is perfect square\n");
        } else {
            System.out.println("it is not a perfect square\n");
        }


    }

    /**
     *
     * @param n
     */
    public void primeTest(int n) {
        int flag = 0;
        if (n < 0) {
            System.err.println("Negative number passed \n");
        } else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    flag = 1;
                }
            }

            if (flag == 1) {
                System.out.println(String.format("%d is not a prime number\n" , n));
            } else {
                System.out.println(String.format("%d is  a prime number\n", n));
            }
        }


    }
}

/**
 * The main class
 */
public class q1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        fun_class obj = new fun_class();
        int choice;
        while (true) {
            System.out.println("1. Reverse of a number (reverse num)\n2. Largest of three numbers(large3num),\n3. Perfect Square (perfect square check)\n4. Prime Test (prime test)\n5. Exit");
            System.out.println("Enter you Choice");
            choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("Enter number to reverse:-");
                int n = scan.nextInt();
                System.out.println(String.format("The Reversed number is %s\n", obj.revnum(n)));


            } else if (choice == 2) {
                System.out.println("Enter 3 numbers to find largest:-");
                int a = scan.nextInt();
                int b = scan.nextInt();
                int c = scan.nextInt();

                System.out.println(String.format("The Largest number is %d\n", obj.large3num(a, b, c)));

            } else if (choice == 3) {
                System.out.println("Enter a number to check:-");
                int n = scan.nextInt();
                obj.perfect_square_check(n);
            } else if (choice == 4) {
                System.out.println("Enter a number to check:-");
                int n = scan.nextInt();
                obj.primeTest(n);
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Enter a valid choice\n");

            }


        }
    }

}