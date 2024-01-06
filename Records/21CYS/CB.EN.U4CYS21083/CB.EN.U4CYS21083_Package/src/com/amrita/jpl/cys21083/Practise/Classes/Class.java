package com.amrita.jpl.cys21083.Practise.Classes;

/**
 * @author Revan Nagireddy-CB.EN.U4CYS21083
 */

public class Class {
    double assignGrade;
    String studentName;
    String rollNo;
    static double Grade;
    static String Name;
    static String roll;
    public static void publishResult() {
        System.out.println("Results are Published");
    }

    /**
     * Assign the Grade of the Student
     * @param grd Grade Assigned to the Student
     */
    public static void grade(double grd){
        System.out.println("Grade: "+grd);
    }

    /**
     * Assign the Name of the Student
     * @param studName Name of the Student
     */
    public void name(String studName) {
        System.out.println("Student Name: "+studName);
    }

    /**
     * Assign the RollNo of the Student
     * @param roln RollNo of the Student
     */
    public void rollNo(String roln){
        System.out.println("RollNumber: "+roln);
    }

    public static void main(String[] args) {
        Class student1 = new Class();

        // when the function is static we can directly call the function name without object name.
        // when function is not static then we need to call with object name -- Ex: myclass.publishResult();
        //static variables can be overwritten in any object of a class but if we don't re-assign the value to static variable then it considers the first assigned values.

        //Non- Static Variables:
        publishResult();
        student1.studentName = "Revan Nagireddy";
        student1.assignGrade = 7.75;
        student1.rollNo = "CB.EN.U4CYS21083";
        student1.name(student1.studentName);
        student1.rollNo(student1.rollNo);
        student1.grade(student1.assignGrade);

        System.out.println("\n");
        Class student2 = new Class();
        //Static Variables:
        publishResult();
        student2.Name = "Venkata";
        student2.Grade = 8.00;
        student2.roll = "CB.EN.U4CYS21091";
        student2.name(Name);
        student2.rollNo(roll);
        student2.grade(Grade);
        grade(Grade);

        System.out.println("\n");
        Class student3 = new Class();
        //Static Variables:
        publishResult();
        student3.Name = "Nagireddy";
        student3.Grade = 7.79;
        student3.roll = "CB.EN.U4CYS21092";
        student3.name(Name);
        student3.rollNo(roll);
        student3.grade(Grade);
        grade(Grade);

        //data overwritten in static variable from latest object(student3)
        System.out.println("\n");
        Class student4 = new Class();
        //Static Variables:
        publishResult();
        student4.name(Name);
        student4.rollNo(roll);
        student4.grade(Grade);
        grade(Grade);


        student2.name(Name); // static variable will be completed changed once we overwrite the data.

    }
}
