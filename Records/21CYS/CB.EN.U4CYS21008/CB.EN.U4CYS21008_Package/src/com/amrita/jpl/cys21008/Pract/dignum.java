package com.amrita.jpl.cys21008.Pract;

public class dignum {
    public static void main(String[] args) {

        int a = 1234;
        int count = 0;
        while(a>0){
            a = a/10;
            count = count + 1;
        }
        System.out.println("The number of digits in 1234 are: "+count);
    }
}
