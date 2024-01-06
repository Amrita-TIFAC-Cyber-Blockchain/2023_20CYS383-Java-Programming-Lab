package com.amrita.jpl.cys21070.pract;

public class Flag{
    public static void main(String[] args) { //Prints the Flags
        for(int i=0;i<9;i++){
            for(int f=0;f<39;f++){
                if(f<6){
                    System.out.print("* ");
                }
                else {
                    System.out.print("=");
                }
            } System.out.println();
            for(int f=0;f<40;f++){
                if(f<5){
                    System.out.print("* ");
                }
                else {
                    System.out.print("=");
                }
            }
            System.out.println();
        }
        for(int i=0;i<6;i++){
            for(int f=0;f<45;f++){
                System.out.print("=");
            }
            System.out.println();
        }
    }
}