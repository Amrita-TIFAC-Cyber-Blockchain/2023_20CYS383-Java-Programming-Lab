package com.amrita.jpl.cys21069.practice.assignments;


public class StudentReport {
    /**
     * @author Seran
     * @version 0.1
     */
    double assignGrade;
    String name;
    int roll;
    /**
     * Prints the result status
     */
    public void publishResult(){
        System.out.println("Result are published");
    }
    /**
     * Prints the student's grade
     * @param grade Grade of the student
     */
    public void graded(double grade){
        System.out.println("Grade is: "+grade);

    }

    /**
     * Main method
     * @param args Default argument for main function
     * @param name Stores name of Student
     * @param roll Stores the roll number of the Student
     */
    public static void main(String[] args){
        StudentReport obj=new StudentReport();
        obj.publishResult();
        obj.assignGrade=8.27;
        obj.name="Seran Pandiyan";
        obj.roll=69;
        System.out.println("Name: "+obj.name);
        System.out.println("Roll No: CB.EN.U4CYS210"+obj.roll);
        obj.graded(obj.assignGrade);
    }
}
