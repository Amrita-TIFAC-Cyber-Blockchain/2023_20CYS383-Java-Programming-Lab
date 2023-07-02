package com.amrita.jpl.cys21016.pract.basic;
public class helloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        greeting();
        result();
    }

    static void greeting(){
        System.out.println("This is Hem Sagar.");
    }

    static void result(){
        System.out.println("The result of addition is :");
        System.out.println(add(5,6));
    }
    static int add(int x, int y){
        int z = x + y;
        return z;
    }
}