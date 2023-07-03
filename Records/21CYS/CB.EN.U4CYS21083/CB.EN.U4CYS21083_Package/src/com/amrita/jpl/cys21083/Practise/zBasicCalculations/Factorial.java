package com.amrita.jpl.cys21083.Practise.zBasicCalculations;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("Factorial Program");
        int num = 5;
        int i;
        int fact = 1;
        for(i=1;i<=num;i++) {
            fact = fact * i;
        }
        System.out.println("Factorial of "+ num + "is "+ fact);

    }
}
