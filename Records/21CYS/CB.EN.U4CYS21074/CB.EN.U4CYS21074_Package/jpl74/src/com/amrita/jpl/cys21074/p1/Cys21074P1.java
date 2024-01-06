package com.amrita.jpl.cys21074.p1;
/**
 * @author Sudhir.R.T
 */
import java.util.Scanner;

public class Cys21074P1 {
    /**
     * gives x!
     * @param x no. whose factorial we are finding
     */
    public int fact(int x){
        int f=1,i;

        if(x == 0) return 1;
        if(x<0){
            System.out.println("only +ve input");
            return 0;
        }
        for(i=2;i<=x;i++) f *= i;
        return f;
    }

    /**
     * gives the 1st x fibonacci no.s
     * @param x no. of fibonacci no.s to be printed
     */
    public void fibonacci(int x){
        int n1=0,n2=1,n3,i;

        if(x == 0){
            System.out.print(n1);
            return;
        }
        if(x<0){
            System.out.println("only +ve input");
            return;
        }
        System.out.print(n1+" "+n2);
        for(i=2;i<x;++i)
        {
            n3=n1+n2;
            System.out.print(" "+n3);
            n1=n2;
            n2=n3;
        }
    }

    /**
     * sum of no.s till x
     * @param x the no. till which we need to sum including  the no. itself
     */
    public int sum_n_no(int x){
        int s=0,i;
        if(x<0){
            System.out.println("only +ve input");
            return 0;
        }
        for(i=1;i<=x;i++) s += i;
        return s;
    }

    /**
     * checks prime or not
     * @param n no. to be checked for prime
     */
    public boolean prime_test(int n){
        if (n <= 1)
            return false;

        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    /**
     * Main function
     * @param args Default argument to main function
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter choice no. 1.factorial, 2.fibonacci, 3.sum of n numbers, 4.prime test");
        int choice = s.nextInt();
        int x=0;
        if(choice == 1 || choice==2 || choice==3 || choice==4){
            System.out.println("enter number");
            x = s.nextInt();
        }
        Cys21074P1 obj = new Cys21074P1();
        switch (choice){
            case 1:
                System.out.println("factorial of "+x+" is "+obj.fact(x));
                break;
            case 2:
                obj.fibonacci(x);
                break;
            case 3:
                System.out.println("sum of "+x+" no.s is "+obj.sum_n_no(x));
                break;
            case 4:
                if(obj.prime_test(x)) System.out.println(x+ " is prime");
                else System.out.println("not prime");
                break;
            default:
                System.out.println("enter valid choice");
        }
    }
}