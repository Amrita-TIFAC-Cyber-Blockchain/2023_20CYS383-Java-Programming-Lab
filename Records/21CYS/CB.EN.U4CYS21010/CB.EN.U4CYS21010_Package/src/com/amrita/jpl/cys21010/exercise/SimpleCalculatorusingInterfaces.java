package com.amrita.jpl.cys21010.exercise;

import java.util.*;

/**
 *  a class SimpleCalculatorusingInterfaces
 */
public class SimpleCalculatorusingInterfaces {
    /**
     * the main function of the class
     * @param args
     */
    public static void main(String[] args) {
        Calculator obj = new Calculator();
        Scanner scan = new Scanner(System.in);
        float x, y, re;
        int c;


        // System.out.println("Enter Value for x");
        x = scan.nextFloat();

        // System.out.println("Enter Value for y");
        y = scan.nextFloat();

        System.out.println("Addition: " + obj.add(x, y));

        // else if (c==2) {
        System.out.println("Subtraction: " + obj.sub(x, y));

        // }
        // else if (c==3) {
        System.out.println("Multiplication: " + obj.mul(x, y));

        // }
        // else if (c==4) {
        System.out.println("Division: " + obj.div(x, y));

        // }
        // else if (c==5){
        //     break;
        // }

        // }}
    }

    /**
     * interface of Calci
     */
    interface Calci {
        float add(float x, float y);

        float sub(float x, float y);

        float mul(float x, float y);

        float div(float x, float y);
    }

    /**
     * Class Calculator usees the intrface Calci
     */
    static class Calculator implements Calci {
        @Override
        public float add(float x, float y) {
            return x + y;
        }

        @Override
        public float sub(float x, float y) {
            return x - y;
        }

        @Override
        public float mul(float x, float y) {
            return x * y;
        }

        @Override
        public float div(float x, float y) {
            if (y == 0) {
                System.out.println("Division by zero error!");
                return -1;
            } else {
                return x / y;
            }


        }
    }
}