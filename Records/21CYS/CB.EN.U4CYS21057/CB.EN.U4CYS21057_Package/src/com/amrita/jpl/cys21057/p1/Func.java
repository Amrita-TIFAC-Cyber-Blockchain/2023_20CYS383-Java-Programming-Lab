package com.amrita.jpl.cys21057.p1;

import java.util.Scanner;
public class Func {

    //prime test
    int prime_test() {

        Scanner obj = new Scanner(System.in);

        System.out.println("Enter the value u want to check : ");
        int val = obj.nextInt();

        if (val == 1 || val == 0) {
            System.out.println("Neither a prime nor composite");
        }

        for (int i = 2; i <= val / 2; i++) {
            if (val % i == 0)
                return 1;
        }
        return 0;
    }

    //Sum of n numbers
    int sum_n_no(){

        Scanner obj1 = new Scanner(System.in);

        System.out.println("Enter the n value : ");
        int n = obj1.nextInt();

        int i;
        int sum = 0;
        for(i=0;i<=n;i++){
            sum = sum + i;
        }
        return sum;
    }

    //Factorial of a number
    int fact(){

        Scanner obj2 = new Scanner(System.in);

        System.out.println("Enter the value u want to find the factorial of : ");
        int val = obj2.nextInt();

        int i;
        int fac = 1;
        for(i=1;i<=val;i++){
            fac = fac * i;
        }
        return fac;

    }

    //Fibonacci
    void fibo(){

        Scanner obj = new Scanner(System.in);

        System.out.println("Enter the value u want to print upto : ");
        int n = obj.nextInt();

        int q1 = 0;
        int q2 = 1;

        int next = q1 + q2;

        for(int i =3;i<n;i++){

            System.out.print(next + " ");

            q1 = q2;
            q2 = next;
            next = q1 + q2;
        }
    }
}
