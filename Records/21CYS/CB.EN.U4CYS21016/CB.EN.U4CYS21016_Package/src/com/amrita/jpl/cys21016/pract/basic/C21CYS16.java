package com.amrita.jpl.cys21016.pract.basic;//import java.util.Scanner;

/**
* @author Hem Sagar
*
* */
public class C21CYS16 {
    double assignedGrade; // if set as static , in main function instance is not required to use.
    static String name;
    static String roll;
    //Scanner input = new Scanner(System.in);

    public void publishResult(){
        System.out.print("The Results have been Published!.\n");
    }
    public C21CYS16(String Name,String Roll,double grade){
        /**
         * Constructor to get the inputs of name,roll,grade.
         * @param Name Name of the Student
        * @param Roll Roll number of the Student
        * @param grade Grade of the Student
         */

        //System.out.print("Enter the Student Name: ");
        //name = input.next();
        name = Name;

        //System.out.print("Enter your Roll Number: ");
        roll = Roll;
        //roll = input.next();
        //System.out.print("Enter your Grade: ");
        this.assignedGrade = grade;
        //this.assignedGrade= input.nextInt();
    }
    public void graded(){
        /*
        *  Prints the Grade of the Student.
        * */
        System.out.print("The student grade is: "+this.assignedGrade);
    }
    public void details(){
        /*
        * Prints the details of the Student.
        */
        System.out.println("Student Name: "+name);
        System.out.println("Roll No: "+roll);

    }
    public static void main(String[] args){
        C21CYS16 Stu1 = new C21CYS16("Hem Sagar","cb.en.u4cys21016",9.32);
        Stu1.publishResult();
        //Stu1.assignedGrade = 9.32; // in case of static variable just assignGrade=9.32 is enough.
        Stu1.details();
        Stu1.graded(); // assignGrade is enough if it is static.

    }
}
