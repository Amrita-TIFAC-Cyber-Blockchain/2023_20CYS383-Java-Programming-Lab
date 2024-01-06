package com.amrita.jpl.cys21027.practice.javadoc;

/**
 * @author K Sri Sai Nitin
 * @version 0.5
 */
//Create a Class


public class C21CYS27_JavaDoc{

    //Declare variables(Attributes)

    /**
     * @param name student's name
     * @param roll student's rollnumber
     * @param assignGrade student's grade
     */

    static double assignGrade;
    static String name;
    static String roll;


    //Create a publish result method

    /**
     * Publishes the result
     */
    public static void resultpublish(){
        System.out.println("Results have been Published!!!!\n");
    }

    //Create a grades method with a parameter

    /**
     * Assigns the Grade of the student
     * @param grade Grade assigned to the student
     */
    public void grades(double grade) {
        System.out.println("Grade is : " + grade);
    }

    /**
     * Assigns the Name of the student
     * @param stu Name assigned to the student
     */
    public void sname(String stu) {
        System.out.println("Student Name is : " + stu);
    }

    /**
     * Assigns the Roll number of the student
     * @param rollnum Roll assigned to the student
     */
    public void sroll(String rollnum) {
        System.out.println("Student Roll Number is : " + rollnum);
    }

    /**
     * Main Function
     * @param args Default argument to main function
     */
    public static void main(String[] args) {

        C21CYS27_JavaDoc MyClass = new C21CYS27_JavaDoc();
        MyClass.assignGrade = 8.89;
        MyClass.name = "Nitin";
        MyClass.roll = "CB.EN.U4CYS21027";
        MyClass.resultpublish();
        System.out.println("Student Copy Report:");
        MyClass.sname(name);
        MyClass.sroll(roll);
        MyClass.grades(assignGrade);

    }
}