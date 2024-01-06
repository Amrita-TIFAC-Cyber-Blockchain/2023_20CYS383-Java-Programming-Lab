package com.amrita.jpl.cys21038.P1.CB.EN.U4CYS21038_jpl_P1_MODIFIED;

import java.util.Scanner;

/**
 * @author Madhav H 
 */
public class P1 {

    /**
     * Factorial of a number
      * @return f Factorial
     */
    public static int fact() {
        Scanner obj1 = new Scanner(System.in);
        System.out.println("\nEnter number to check for factorial:");
        int number = obj1.nextInt();
        if(number<0){
            System.out.println("Negative number, Factorial not possible");
        }
        int f = 1;
        for (int i = 1; i <= number; i++) {
            f = f * i;
        }
        return f;
    }

    /**
     * Fibonacci Series
     */
    public static void fibo(){
        Scanner obj1 = new Scanner(System.in);
        System.out.println("\nEnter number to check for fibonacci:");
        int n = obj1.nextInt();
        if(n<0){
            System.out.println("Negative number, Fibonacci not possible");
        }
        int n1=0,n2=1,i,n3;
        System.out.print(n1+" "+n2);
        for(i=2;i<n;++i)
        {
            n3=n1+n2;
            System.out.print(" "+n3);
            n1=n2;
            n2=n3;
        }

    }

    /**
     * Sum of n natural numbers
     * @return s Sum
     */
    public static int sum_n_no(){
        Scanner obj1 = new Scanner(System.in);
        System.out.println("\nEnter number to check for sum of numbers:");
        int x = obj1.nextInt();
        if(x<0){
            System.out.println("Negative number, Sum cannot be found");
        }
        int s=0;
        for (int i = 1; i <= x; i++) {
            s = s + i;
        }
        return s;
    }

    /**
     * Prime number checking
     * @return p Prime
     */
    public static int prime_test() {
        Scanner obj1 = new Scanner(System.in);
        System.out.println("\nEnter number to check for prime:");
        int p = obj1.nextInt();
        int i, m, flag = 0;
        m = p / 2;
        if (p == 0 || p == 1 || p<0) {
            System.out.println(p + " is not prime number");
        }
        else {
            for (i = 2; i <= m; i++)
            {
                if (p % i == 0)
                {
                    System.out.println(p + " is not prime number");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println(p + " is a prime number"); //returning number that is prime
            }
        }
        return p;
    }

    /**
     * Main function
     * @param args Main
     */
    public static void main(String[] args) {
        int choice;
        System.out.println("1.Factorial");
        System.out.println("2.Fibonacci");
        System.out.println("3.Sum of n numbers");
        System.out.println("4.Prime");
        System.out.println("5.Exit");
        Scanner obj1 = new Scanner(System.in);
        System.out.println("\nEnter your choice:");
        choice = obj1.nextInt();
        if(choice==1){
            System.out.println(fact());
        }
        else if(choice==2){
            fibo();
        }
        else if(choice==3) {
            System.out.println(sum_n_no());
        }
        else if(choice==4){
            System.out.println(prime_test());
        }
        else if(choice==5){
            System.out.println("Thank-you!");
        }
        else{
            System.out.println("\nInvalid choice");
        }
    }
}