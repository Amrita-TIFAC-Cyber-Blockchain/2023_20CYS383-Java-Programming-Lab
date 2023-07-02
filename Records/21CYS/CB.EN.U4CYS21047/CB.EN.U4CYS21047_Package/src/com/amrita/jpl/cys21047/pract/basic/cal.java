package com.amrita.jpl.cys21047.pract.basic;
/**
 * This is a small calculator code that uses operations.
 * If we give negative numbers it pops error.
 *
 * @author = Vihal roy
 * @version 0.5
 */
import java.util.*;
public class cal {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First number: ");
        int a=sc.nextInt();
        if(a>=0){
            System.out.println("Enter Second number: ");
            int b=sc.nextInt();
            if(b>=0){
                System.out.println("Enter the required operation: ");
                String c=sc.next();
                if(c.equals("+")){
                    int t=a+b;
                    System.out.println("Sum of the given two numbers: "+t);
                }
                else if(c.equals("-")){
                    int t=a-b;
                    System.out.println("Difference of the two numbers: "+t);
                }
                else if(c.equals("*")){
                    int t=a*b;
                    System.out.println("Product of the two numbers: "+t);
                }
                else if(c.equals("/")){
                    int t=a/b;
                    System.out.println("Divisor of the two numbers: "+t);
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
