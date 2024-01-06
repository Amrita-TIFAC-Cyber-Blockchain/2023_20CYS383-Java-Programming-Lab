package com.amrita.jpl.cys21014.pract.extra;
/**
 * @author Deepthi Jayanth
 */
public class java_variables{
    public static void main(String[] args){
        String name = "Deepthi ";
        char initial = 'J';
        String degree_year = "B.Tech '2nd year', "; //use escape sequence if required
        String branch = " CSE (CYS)";
        String study = degree_year + branch;
        final int mark = 90; //final keyword ensures that this variable cannot be modified.
        int bit1, bit2, bit3, bit4;
        bit1 = bit2 = bit3 = bit4 = 1;
        float average = 85.50F;
        boolean pass = true;
        System.out.print("Student: \n" + name);
        System.out.println(initial);
        System.out.println(study);
        System.out.println(mark);
        System.out.println(average);
        System.out.println(pass);
        System.out.println("========================");
        String x="10";
        String y="20";
        int m=4;
        int n=5;
       System.out.println(x+y);
       System.out.println(x+m);
       System.out.println(m+n);
       System.out.println(m+y);
    }
}