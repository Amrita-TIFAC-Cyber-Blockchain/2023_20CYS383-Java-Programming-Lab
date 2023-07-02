package com.amrita.jpl.cys21003.ex;

import java.util.*;
/**
 * Simple Calculator
 *
 * @author Aishwarya G
 * @version 1.0
 */
public class qi_calculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1st number: ");
        int a=sc.nextInt();
        if(a>=0){
            System.out.println("Enter 2nd number: ");
            int b=sc.nextInt();
            if(b>=0){
                System.out.println("Enter the operation: ");
                String c=sc.next();
                if(c.equals("+")){
                    int t=a+b;
                    System.out.println("Addition = "+t);
                }
                else if(c.equals("-")){
                    int t=a-b;
                    System.out.println("Subraction = "+t);
                }
                else if(c.equals("*")){
                    int t=a*b;
                    System.out.println("Product = "+t);
                }
                else if(c.equals("/")){
                    int t=a/b;
                    System.out.println("Division = "+t);
                }
                else{
                    System.out.println("Enter valid operator:");
                }
            }else{
                System.out.println("Enter a positive number");
            }
        }else{
            System.out.println("Enter a positive number");
        }
    }
}