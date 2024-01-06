package com.amrita.jpl.cys21038.practice.simplecalc;
/**
 * @author Madhav H
 */
import java.util.*;
public class Simple_calc {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int a,b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to calculator\n");
        System.out.println("Enter the first number:\n");
        a = sc.nextInt();
        System.out.println("Enter the second number:\n");
        b= sc.nextInt();
        System.out.print("Select operation (+, -, *, /): ");
        String operation = sc.next();
        double x;
        switch(operation){
            case "+":
                x = a+b;
                break;
            case "-":
                x = a-b;
                break;
            case "*":
                x = a*b;
                break;
            case "/":
                if(b==0){
                    System.out.println("Error: Division by zero is not allowed");
                    return;
                }
                x = a/b;
                break;
            default:
                System.out.println("Error: Invalid operation selected");
                return;
        }
        System.out.println("Result: " + x);
    }
}