package com.amrita.jpl.cys21048.p1;

import java.util.Scanner;

public class lab {
    /**
     * main function starts
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("1. Reverse of a number (reverse num), 2. Largest of three numbers (large3num), 3.Perfect Square(perfect square check), 4. Prime Test (prime test)");
        Scanner v = new Scanner(System.in);
        int choice = v.nextInt();
        /**
         * switch case
         */
        switch (choice) {
            case 1:
                System.out.println("enter the value for reversal of a number");
                int n = v.nextInt();
                System.out.printf("%d", reverse_num(n));
                break;
            case 2:
                System.out.println("enter the value for largest of 3 numbers");
                int y = v.nextInt();
                int x = v.nextInt();
                int z = v.nextInt();
                System.out.printf("%d", large3num(y, x, z));
                break;

            case 3:
                System.out.println("enter the value for perfect square check");
                int t = v.nextInt();
                perfect_square_check(t);
                break;

            case 4:
                System.out.println("enter the value for prime test");
                int b = v.nextInt();
                prime_test(b);
                break;
        }
    }

    /**
     * functions for calculation starts
     * @param n
     * @return
     */
    public static int reverse_num(int n){
        int  reverse = 0;
        while(n != 0)
        {
            int rem = n % 10;
            reverse = reverse * 10 + rem;
            n = n/10;
        }
        return reverse;
    }
    public static void prime_test(int n) {
        boolean flag = false;
        for (int p = 2; p <= n / 2; ++p) {
            if (n % p == 0) {
                flag = true;

                break;
            }
        }
        System.out.println(flag);
    }

    public static void perfect_square_check(int n){
        double s = Math.sqrt(n);
        System.out.println((s - Math.floor(s)) == 0);
    }
    public static int large3num(int y,int x,int z){
        if(y>x && y>z){
            return y;
        } else if (x>y && x>z) {
            return x;
        }
        else {
            return z;
        }
    }
}