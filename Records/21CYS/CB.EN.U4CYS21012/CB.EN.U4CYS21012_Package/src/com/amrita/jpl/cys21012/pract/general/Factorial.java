package com.amrita.jpl.cys21012.pract.general;

class FactorialExample{
    public static void main(String args[]){
        int i,fact=1;
        int number=8;//It is the number to calculate factorial
        for(i=1;i<=number;i++){
            fact=fact*i;
        }
        System.out.println("Factorial of "+number+" is: "+fact);
    }
}
