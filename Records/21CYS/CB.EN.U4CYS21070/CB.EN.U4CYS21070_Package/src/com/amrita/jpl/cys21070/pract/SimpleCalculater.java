package com.amrita.jpl.cys21070.pract;

import java.util.*;
public class SimpleCalculater{
    public static void main(String[] args) { //Implementation of Simple Calculater
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the first number : ");
        int a = sc.nextInt();
        System.out.println("PLease enter the second number : ");
        int b = sc.nextInt();
        System.out.println("Please enter the operation you want to execute : ");
        char ch = sc.next().charAt(0);

        switch(ch){
            case '+' : System.out.println(a+b); break;
            case '-' : System.out.println(a-b); break;
            case '*' : System.out.println(a*b); break;
            case '/' : System.out.println(a/b); break;
            default: System.out.println("Invalid Input");
        }


    }
}