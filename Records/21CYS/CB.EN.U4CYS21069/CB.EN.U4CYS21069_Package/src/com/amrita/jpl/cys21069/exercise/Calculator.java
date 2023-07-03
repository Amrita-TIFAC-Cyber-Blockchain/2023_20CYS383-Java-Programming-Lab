package com.amrita.jpl.cys21069.exercise;

import java.util.*;
/**
 * The calculator class represents a simple menu driven program.
 * It has four function defined in it.
 * Usage:
 * -addition
 * -subtraction
 * -multiplication
 * -division
 *
 * @author Seran Pandiyan I P   CB.EN.U4CYS21069
 * @version 0.1
 */
public class Calculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter first number: ");
        int a=sc.nextInt();
        System.out.println("Enter Second number: ");
        int b=sc.nextInt();
        System.out.println("Enter the required operation: ( +  -  *  / )");
        String c=sc.next();
        if(c.equals("+")){
            int t=a+b;
            System.out.println("Sum of the given numbers is : "+t);
        }
        else if(c.equals("-")){
            int t=a-b;
            System.out.println("Difference of the given numbers is  "+t);
        }
        else if(c.equals("*")){
            int t=a*b;
            System.out.println("Product of the given numbers is "+t);
        }
        else if(c.equals("/")){
            int t=a/b;
            System.out.println("Divisor of the given numbers is  "+t);
        }
        else{
            System.out.println("Enter valid operator symbol");
        }
    }
}

