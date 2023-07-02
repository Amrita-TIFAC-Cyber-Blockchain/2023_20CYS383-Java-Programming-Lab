package com.amrita.jpl.cys21038.practice.Factorial;
/**
 * @author Madhav H
 */
public class fact_practice {
    /**
     *
     * @param args Main
     */
    //int x = 20;
    public static void main(String[] args) {
        int i,fact=1;
        int x=5;
        for(i=1;i<=x;i++){
            fact=fact*i;
        }
        System.out.println("Factorial of "+x+" is: "+fact);
    }
}