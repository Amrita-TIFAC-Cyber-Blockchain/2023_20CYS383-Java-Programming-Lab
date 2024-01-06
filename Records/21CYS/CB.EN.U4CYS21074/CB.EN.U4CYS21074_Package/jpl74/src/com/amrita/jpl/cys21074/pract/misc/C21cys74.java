package com.amrita.jpl.cys21074.pract.misc;

/**
 * @author Sudhir.R.T
 */
public class C21cys74{
    double assignGrade;
    static String roll;
    static String name;

    public void publishResult(){
        System.out.println("Results Are published");
    }

    public void getName(String name){
        System.out.println("Name is: "+name);
    }
    /**
     * Assigns the Grade of the student
     * @param assignGrade Grade Assigned to the Student
     */
    public static void graded(double assignGrade){
        System.out.println("Grade is: "+ assignGrade);
    }

    public void getRoll(String roll){
        System.out.println("Roll number is: "+ roll);
    }
    /**
     * Main Function
     * @param args Default argument to main function
     */
    public static void main(String[] args) {
        C21cys74 obj = new C21cys74();
        String x = "Sudhir";
        String y = "CB.EN.U4CYS21074";
        double p = 9.69;
        double t = 9.9;
        obj.getName(x);
        obj.getRoll(y);
        graded(p);
        graded(t);
    }
}