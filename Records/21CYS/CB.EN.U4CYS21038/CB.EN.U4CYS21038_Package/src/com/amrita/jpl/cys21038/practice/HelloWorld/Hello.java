package com.amrita.jpl.cys21038.practice.HelloWorld;
/**
 * @author Madhav H
 */
public class Hello{
    /**
     *
     * @param args
     */
//    int x=20;
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int x=20;
        System.out.println(x);
        add(4,6);
    }

    /**
     *
     * @param a
     * @param b
     */
    public static void add(Integer a,Integer b)
    {
        System.out.println("Sum of 2 numbers is:"+(a+b));
    }
}
