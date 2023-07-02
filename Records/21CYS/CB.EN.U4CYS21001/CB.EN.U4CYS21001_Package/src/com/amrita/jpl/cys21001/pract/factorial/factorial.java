package com.amrita.jpl.cys21001.pract.factorial;
/**
 * A factorial computing program
 * @author Abinesh G
 * @version 1.0
 * */
import java.util.*;
public class factorial {
    public static void main(String[] args){
        /**
         * The main function
         * @param args -> commandline arguments.
        * */
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int number = scn.nextInt();
        scn.close();
        int tmp = number;
        int product = 1;
        while(tmp!=0){
            product = product * tmp;
            tmp = tmp - 1;
        }
        System.out.println("The Factorial of "+number+" is: "+product);

    }
}
