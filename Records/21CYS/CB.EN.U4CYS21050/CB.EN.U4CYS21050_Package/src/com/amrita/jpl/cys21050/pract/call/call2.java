package com.amrita.jpl.cys21050.pract.call;

import java.util.*;
public class call2 {
    public static void main(String[] args) {
        Calculator obj = new Calculator();
        Scanner scan = new Scanner(System.in);
        float x,y,re;
        int c;
        while(true){
            System.out.println("Menu \n1)Add\n2)Subtract\n3)Mul\n4)Div\n5)Exit");

            System.out.println("Enter your option");
            c = scan.nextInt();


            System.out.println("Enter Value for x");
            x = scan.nextFloat();

            System.out.println("Enter Value for y");
            y = scan.nextFloat();

            if (c==1){
                System.out.println(obj.add(x,y));
            }
            else if (c==2) {
                System.out.println(obj.sub(x,y));

            }
            else if (c==3) {
                System.out.println(obj.mul(x,y));

            }
            else if (c==4) {
                System.out.println(obj.div(x,y));

            }
            else if (c==5){
                break;
            }

        }}
}

interface Calci{
    float add(float x,float y);
    float sub(float x,float y);
    float mul(float x,float y);
    float div(float x,float y) ;
}

class Calculator implements  Calci{
    public float add(float x,float y){
        return x+y;
    }


    public float sub(float x,float y) {
        return x-y;
    }


    public float mul(float x,float y) {
        return x*y;
    }


    public float div(float x,float y) {
        if (y == 0){
            System.out.println("CanNot Divide By 0");
            return Float.NaN;
        }
        else{
            return x/y;
        }
    }}