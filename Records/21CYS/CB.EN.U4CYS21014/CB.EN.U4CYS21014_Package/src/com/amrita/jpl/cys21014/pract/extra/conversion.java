package com.amrita.jpl.cys21014.pract.extra;
/**
 * @author Deepthi Jayanth
 */

import java.util.Scanner;

public class conversion{
    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the value to be converted: ");
        int n = obj.nextInt();
        int m =n;
        int j = 0;
        System.out.println("Decimal value of "+ n +" :");
        int[] bin = new int[40];
        while(n > 0){
            bin[j++] = n%2;
            n /= 2;
        }
        for(int i = j-1;i >= 0;i--){
            System.out.print(bin[i]);
        }

        System.out.println("\nHex value of "+ m +" :");
        int r;
        String hex="";
        char[] hexchars ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(m>0)
        {
            r=m%16;
            hex=hexchars[r]+hex;
            m=m/16;
        }
        System.out.println(hex);

    }
}
