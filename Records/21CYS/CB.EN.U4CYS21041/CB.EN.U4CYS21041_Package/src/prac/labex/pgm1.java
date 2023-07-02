package com.amrita.jpl.cys21041.prac.labex;
import java.util.*;
public class pgm1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1st number: ");
        int a=sc.nextInt();
        if(a>=0){
            System.out.println("Enter 2nd number: ");
            int b=sc.nextInt();
            if(b>=0){
                System.out.println("Enter the required operation: ");
                String c=sc.next();
                if(c.equals("+")){
                    int t=a+b;
                    System.out.println("Sum of the given 2 numbers: "+t);
                }
                else if(c.equals("-")){
                    int t=a-b;
                    System.out.println("Difference of the 2 numbers: "+t);
                }
                else if(c.equals("*")){
                    int t=a*b;
                    System.out.println("Product of the 2 numbers: "+t);
                }
                else if(c.equals("/")){
                    int t=a/b;
                    System.out.println("Divisor of the 2 numbers: "+t);
                }
                else{
                    System.out.println("Enter valid operator symbol");
                }
            }else{
                System.out.println("Please give a positive number");
            }
        }else{
            System.out.println("Please give a positive number");
        }
    }
}