package com.amrita.jpl.cys21061.ex.grade;
/**
 * @author Roshni-CYS21061
 */
public class C21CYS61 {
    double assignGrade;

    /**
     * instantiate variable
     */
    public void publishResult() {
        System.out.println("Results Published!");
    }

    /**
     * assign grade
     * @param grade Grade of student
     */
    public void graded(double grade) {
        System.out.println("Grade is " + grade);
    }

    /**
     * Main Function
     * @param args Default argument to Main function
     */
    public static void main(String[] args) {
        C21CYS61 myClass = new C21CYS61();
        myClass.publishResult();
        myClass.assignGrade = 9.96;
        myClass.graded(myClass.assignGrade);
    }
}
