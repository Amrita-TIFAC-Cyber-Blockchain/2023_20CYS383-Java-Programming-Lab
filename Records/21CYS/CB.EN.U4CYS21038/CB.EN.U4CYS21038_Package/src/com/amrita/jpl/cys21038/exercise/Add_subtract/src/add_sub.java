package com.amrita.jpl.cys21038.exercise.Add_subtract.src;
import java.util.*;
/**
 * @author Madhav H
 */
public class add_sub {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int a,b,sum;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first Number:");
        a = sc.nextInt();
        System.out.println("Enter the second Number:");
        b = sc.nextInt();
        sc.close();
        sum = a+b;
        System.out.println("Sum of two numbers is: "+sum);
    }
}