package com.amrita.jpl.cys21031.practice.simple;

/**
 * @author Kishanth K
 * @version 1.0
 * Basic Fibonacci Program
 */

public class Fibonacci {
    public static void main(String args[])
    {
        int f1=0,f2=1,f3,i,count=10;
        System.out.print(f1+" "+f2);//printing 0 and 1

        for(i=2;i<count;++i)//loop starts from 2 because 0 and 1 are already printed
        {
            f3=f1+f2;
            System.out.print(" "+f3);
            f1=f2;
            f2=f3;
        }

    }}
