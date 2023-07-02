package com.amrita.jpl.cys21045.practice.problems;
/**
 * @author Dharmik-CB.EN.U4CYS21067
 * The Class1 program implements an application that
 * simply gives an intro about java classes.
 */
public class c21CYS45 {

    //Declare Variable(Attribute)
    static double assignGrade;
    static String name;
    static int roll;

    /**
     * Assigns the Name of the student
     * @param name Name Assigned to the student
     */
    //create a Name() method
    public void Name(String name) {
        System.out.println("My name is : " + name);
    }
    /**
     * Assigns the rollno of the student
     * @param roll rollNo Assigned to the student
     */
    //create a rollNo() method
    public void rollNo(int roll) {
        System.out.println("Roll no is : " + roll);
    }

    /**
     * Prints the statement that Results are published
     * @param
     */
    //create a publishResult() method
    public void publishResult() {
        System.out.println("Results are published");
    }

    /**
     * Assigns the Grade of student
     * @param grade Grade assigned to the student
     */
    public void grade(double grade) {
        System.out.println("Grade is:" + grade + "\n");
    }

    /**
     * Main function
     * @param args Default argument to main function
     */
    //Modify the attribute and Call the methods on myclass object
    public static void main(String[] args) {
        c21CYS45 myclass = new c21CYS45();
        myclass.name = "Monish";
        myclass.Name(name);
        myclass.roll = 45;
        myclass.rollNo(roll);
        myclass.publishResult();
        myclass.assignGrade = 8.0;
        myclass.grade(assignGrade);

        c21CYS45 myclass1 = new c21CYS45();
        myclass1.name = "mtv";
        myclass1.roll = 86;
        myclass1.assignGrade = 7.0;
        myclass1.Name(name);
        myclass1.rollNo(roll);
        myclass1.publishResult();
        myclass1.grade(assignGrade);

    }
    
    /* Declare Variable(Attribute)
    double assignGrade;
    String name;
    int roll ;

    //create a Name() method
    public void Name(String name){ System.out.println("My name is : "+ name);}

    //create a rollNo() method
    public void rollNo(int roll){ System.out.println("Roll no is : "+ roll);}


    //create a publishResult() method
    public void publishResult() {
        System.out.println("Results are published");
    }

    //Create a graded() method with a parameter
    public void grade(double grade) {
        System.out.println("Grade is:"+ grade+"\n");
    }

    //Modify the attribute and Call the methods on myclass object
    public static void main(String[] args) {
        c21CYS67 myclass = new c21CYS67();
        myclass.name="Dharmik";
        myclass.Name(myclass.name);
        myclass.roll = 67;
        myclass.rollNo(myclass.roll);
        myclass.publishResult();
        myclass.assignGrade = 8.0;
        myclass.grade(myclass.assignGrade);

        c21CYS67 myclass1 = new c21CYS67();
        myclass1.name="Scoob";
        myclass1.roll = 86;
        myclass1.assignGrade = 7.0;
        myclass1.Name(myclass1.name);
        myclass1.rollNo(myclass1.roll);
        myclass1.publishResult();
        myclass1.grade(myclass1.assignGrade);

     */


}