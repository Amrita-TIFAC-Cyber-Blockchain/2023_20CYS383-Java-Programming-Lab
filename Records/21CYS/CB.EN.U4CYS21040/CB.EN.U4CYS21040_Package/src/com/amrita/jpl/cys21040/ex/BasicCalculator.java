package com.amrita.jpl.cys21040.ex;

import java.util.Scanner;

/**
 * The interface calculator contains the functions
 * add, subtract, multiply and divide.*/
interface Calculator{

    static double add(double a,double b){
        return a+b;

    }
    static double subtract(double a,double b){
        return a-b;
    }
    static double multiply(double a,double b){
        return a*b;
    }
    static double divide(double a,double b){
        return a/b;
    }

}
/**
 * The class BasicCalculator implements the
 * interface Calculator and it contains the main function
 * The main function takes in the input and uses the functions
 * in the interface Calculator */
public class BasicCalculator implements Calculator{


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double a,b,c;
        double d,e,f;
        a = getInput(sc);
        b = getInput(sc);

        sc.close();



        d=Calculator.add(a,b);
        e=Calculator.subtract(a,b);

        f=Calculator.multiply(a,b);

        c=Calculator.divide(a,b);
        System.out.println("Addition: " + d);
        System.out.println("Subtraction: " + e);
        System.out.println("Multiplication: " + f);
        if(b==0.0){
            System.out.println("Division by zero error!");
            System.out.println("Division: " + -1.0);
        }
        else{
            System.out.println("Division: " +c);
        }

    }
    static double getInput(Scanner sc){
        return sc.nextDouble();
    }

}
