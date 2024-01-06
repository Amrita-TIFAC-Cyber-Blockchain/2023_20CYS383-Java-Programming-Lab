package com.amrita.jpl.cys21016.ex;
/**
 * Generate the given pattern
 * @author G H Hem Sagar
 * @version 1.0
 * */
public class Pattern {
    public static void main(String[] args) {
        /**
         * Prints the pattern provided in the question
         * @param args -> commandline arguments
         * */
        System.out.println("Pattern :");
        for(int i=1 ; i<=10 ; i++)
        {
            if(i<=5)
            {
                System.out.println("* * * * * * ==================================");
            }
            if(i<=4)
            {
                System.out.println("* * * * *  ===================================");
            }
            if(i>=5)
            {
                System.out.println("==============================================");
            }
        }
    }
}
