/**
 * @author Nived Dineshan
 */

package com.amrita.jpl.CYS21053.P1;

import java.util.Scanner;

public class Main {

    /**
     * Factorial function
     * @param fac-> number of which factorial is found
     * @return sum-> the factorial is returned or if invalid input -1 is returned
     */
    static int factorial(int fac){
        if(fac<0){
            return -1;
        }
        else {
            int sum = 1;
            while (fac != 1) {
                sum = sum * fac;
                fac = fac - 1;
            }
            return sum;
        }
    }

    /**
     * sum of n numbers function
     * @param n->number of numbers to be summed together
     * @return sum-> variable that holds the sum of all the numbers
     */
    static int sumofn(int n){
        if(n<=0){
            return -1;
        } else {
            int sum = 0;
            int a;
            Scanner sc = new Scanner(System.in);
            while (n != 0) {
                System.out.println("Enter the number: ");
                a = sc.nextInt();
                sum = sum + a;
                n = n - 1;
            }
            return sum;
        }
    }

    /**
     * primenum function
     * @param p->number to check whether its prime or not
     * @return flag->if its 0 means its prime , 1 means its not prime
     */
    static int primenum(int p){
        if(p<0){
            return -1;
        } else {
            int flag = 0;
            int k = p / 2;
            for (int i = 2; i <= k; i = i + 1) {
                if (p % i == 0) {
                    flag = 1;
                    break;
                }
            }
            return flag;
        }
    }

    /**
     * Fibonacci function
     * @param l->no of iterations of the fibonacci sequence to be displayed
     */
    static void Fibonacci(int l){
        if(l==1){
            System.out.println(1);
        } else if(l==2){
            System.out.println(1);
            System.out.println(1);
        } else {
            int a=1;
            int b=1;
            int c=a+b;
            System.out.println(a);
            System.out.println(b);
            while((l-2)!=0){
                System.out.println(c);
                a=b;
                b=c;
                c=a+b;
                l=l-1;
            }
        }
    }

    /**
     * main function
     */
    public static void main(String[] args) {
        System.out.println("1. Factorial (fact), 2. Fibonacci (fibo), 3. The sum of ’n’ numbers\n" +
                "(sum n no), 4. Prime Test (prime test) ");


        Scanner sc= new Scanner(System.in);
        System.out.println("Enter your choice: ");
        int a = sc.nextInt();
        if(a==1){
            System.out.println("Enter the number for factorial : ");
            int b = sc.nextInt();
            int c= factorial(b);
            if(c==-1){
                System.out.println("Invalid Input");
            } else {
                System.out.println(c);
            }
        } else if (a==3) {
            System.out.println("Enter the total numbers you want to add: ");
            int d = sc.nextInt();
            int e= sumofn(d);
            if(e==-1){
                System.out.println("Invalid Input");
            } else {
                System.out.println(e);
            }
        } else if (a==4){
            System.out.println("Enter the number for prime number check : ");
            int f = sc.nextInt();
            int g= primenum(f);
            if(g==1){
                System.out.println("The number is not prime");
            } else if(g==-1){
                System.out.println("Invalid Input");
            } else{
                System.out.println("The number is prime");
            }
        } else if(a==2){
            System.out.println("Enter the number for fibonacci : ");
            int h = sc.nextInt();
            if(h<1){System.out.println("Invalid Input");}
            else {
                Fibonacci(h);
            }
        }


    }
}

























