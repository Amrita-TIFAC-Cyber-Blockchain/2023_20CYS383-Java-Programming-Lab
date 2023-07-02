package com.amrita.jpl.cys21003.ex;

public class q2_pattern {
    public static void main(String[] args) {
        int i,j;
        for(i=1;i<=15;i++){
            for(j=1;j<40;j++){
                if(i<10 && j<7){
                    if(i%2==0 && j==5){
                        continue;
                    }
                    System.out.print("*");
                }
                else {
                    System.out.print("=");
                }
            }
            System.out.println();
        }
    }
}