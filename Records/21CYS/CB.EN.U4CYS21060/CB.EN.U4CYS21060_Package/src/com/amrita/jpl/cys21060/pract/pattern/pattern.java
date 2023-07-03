package com.amrita.jpl.cys21060.pract.pattern;

class pattern {
    public static void main(String[] args) {
        for(int i=1; i<=15; i++){
            if(i>=9){
                for(int j=1; j<=46; j++)
                    System.out.print("=");
            }
            else{
                for(int j=1; j<=6; j++){
                    if(i%2 == 0 && j==6){
                        System.out.print(" =");
                    }
                    else{
                        System.out.print("* ");
                    }
                }
                for(int k=1; k<=34; k++){
                    System.out.print("=");
                }
            }
            System.out.println(" ");
        }
    }
}