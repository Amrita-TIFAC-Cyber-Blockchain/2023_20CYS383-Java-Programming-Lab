package com.amrita.jpl.cys21042.practice.assignments;

/**
 * @Author : Mittul R - CB.EN.U4CYS21042
 */
public class Object {

    // Declare Variable(Attribute)
    static double assignGrade;

    //create a publishResult() method
    public void publishResult() {
        System.out.println("Results are published");
    }

    //Create a graded() method with a parameter
    public void grade(double grade) {
        System.out.println("My CGPA Grade is:"+ grade);
    }

    //Modify the attribute and Call the methods on myclass object
    public static void main(String[] args) {
        Object myclass = new Object();
        myclass.publishResult();
        myclass.assignGrade = 8.0;
        myclass.grade(assignGrade);

    }

}
