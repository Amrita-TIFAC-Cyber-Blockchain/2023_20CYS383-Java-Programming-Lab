package com.amrita.jpl.cys21035.pract;

public class C21CYS35 {
    double assignGrade;

    /**
     * Publishes Result
     */
    public void publishResult() {
        System.out.println("Results are published");
    }

    /**
     * Assigns Grade
     * @param grade Grade assigned to the student
     */
    public void graded(double grade) {
        System.out.println("Grade is: " + grade);
    }

    public static void main(String[] args) {
        C21CYS35 myClass = new C21CYS35();
        myClass.publishResult();
        myClass.assignGrade = 9.69;
        myClass.graded(myClass.assignGrade);
    }
}
