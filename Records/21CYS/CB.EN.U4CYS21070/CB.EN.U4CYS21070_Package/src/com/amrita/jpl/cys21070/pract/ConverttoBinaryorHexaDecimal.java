package com.amrita.jpl.cys21070.pract;

import java.util.*;
public class ConverttoBinaryorHexaDecimal{
    public static String ConverttoHexaDecimal(int x){ //Function converting integer to Hexadecimal Value
        int a;
        String hex="";
        char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(x>0)
        {
            a=x%16;
            hex=hexchars[a]+hex;
            x=x/16;
        }
        return hex;
    }

    public static void ConverttoBinary(int x){ // Function converting integer to Binary number
        int binary[] = new int[40];
        int itr = 0;
        while(x > 0){
            binary[itr++] = x%2;
            x = x/2;
        }
        for(int i = itr-1;i >= 0;i--){
            System.out.print(binary[i]);
        }
        System.out.println();//new line
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter H to convert decimal to hexadecimal");
        System.out.println("Please enter B to convert decimal to Binary");
        char ch = sc.next().charAt(0);
        System.out.println("Please enter the decimal");
        int x = sc.nextInt();
        if(ch=='H'){
            System.out.println(ConverttoHexaDecimal(x));
        } else if (ch == 'B') {

            ConverttoBinary(x);
        }
        else{
            System.out.println("Invalid Input");
        }
    }
}