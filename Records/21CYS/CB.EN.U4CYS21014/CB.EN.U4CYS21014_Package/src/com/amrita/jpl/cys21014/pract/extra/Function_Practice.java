package com.amrita.jpl.cys21014.pract.extra;
import java.util.Scanner;

/**
* @author Deepthi Jayanth
 */
public class Function_Practice {
    String Name;
    float Mark1, Mark2, Mark3;
    float Average;

    /**
    * Publish
     */
    public void publishResults() {
        System.out.println("Results published.\n"+Name+" has scored an average of "+Average);
    }
    /**
     * Calculating Average
     */
    public void average(){
        Average=(Mark1+Mark2+Mark3)/3;
    }
    public static void main(String[] args) {
        Scanner myinput = new Scanner(System.in);
        Function_Practice myclass = new  Function_Practice() ;
        System.out.println("Enter your name: ");
        myclass.Name=myinput.nextLine();
        System.out.println("Enter MARK-1: ");
        myclass.Mark1=myinput.nextFloat();
        System.out.println("Enter MARK-2: ");
        myclass.Mark2= myinput.nextFloat();
        System.out.println("Enter MARK-3: ");
        myclass.Mark3=myinput.nextFloat();
        myclass.average();
        myclass.publishResults();
    }
}
