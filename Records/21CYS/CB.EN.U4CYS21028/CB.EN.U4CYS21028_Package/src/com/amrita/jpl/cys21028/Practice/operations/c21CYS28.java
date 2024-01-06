package com.amrita.jpl.cys21028.Practice.operations;
/**
 * @author Hitesh manjunath K cys21028
 * This program is an intro to the classes and objects
 */
public class c21CYS28 {
    //declare variables
    static double assignGrade;
    static int rolll = 28;

    static String name = "Hitesh";
    //create a PublishResult() method
    public void publishResult(){
        System.out.println("Results are published");

    }
    // create a graded() method
        public void graded(double grade){
        System.out.println("Grade is :"+grade);
        }

        public void rolll() {

            System.out.println("Roll no is : " + rolll);
        }
      public void name(){
        System.out.println("My name is "+name);
        }

         public void age(){
        int age = 19;
        System.out.println("my age is "+ age);
         }

    /**Modify the attribute and call the methods on myClass object
     * @param args this is main function
     */
    public static void main(String[] args) {
        c21CYS28 myClass = new c21CYS28();
        myClass.publishResult();

        myClass.assignGrade = 9.8;
        myClass.graded(assignGrade);
        myClass.rolll();
        myClass.name();
        myClass.age();
    }

}