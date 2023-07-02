package com.amrita.jpl.cys21001.pract.assignment;

/**
 * @Author Abinesh CB.EN.U4CYS21001
 */
public class pattern {
    public static void main(String[] args) {
        int flag=0;
        for(int i=1;i<=15;i++){
            for(int j=1;j<40;j++){
                if(i<10 && j<7){
                    if(i%2==0 && j==5){
                        flag++;
                        continue;
                    }
                    System.out.print("*");
                }
                else {
                    System.out.print("=");
                }
            }
            if(flag==1){
                System.out.print("=");
                flag=0;
            }
            System.out.println();
        }
    }
}