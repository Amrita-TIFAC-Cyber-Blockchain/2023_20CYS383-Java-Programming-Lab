package com.amrita.jpl.cys21070.pract;

public class HelloWorld{

    double grade;
    String name;
    int rollNo;
    String laptop;
    String hobby;

    /**
     * @param name takes name and sets it for object instance
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param laptop laptop name of the user
     */
    public void setLaptop(String laptop) {
        this.laptop = laptop;
    }

    /**
     * @param rollNo takes user roll number and assigns to instance
     */
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    /**
     * @param hobby takes user hobbies and adds to instance variable
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    // create a graded() method with a parameter

    public void setGrade(double grade) {
        this.grade = grade;
    }

    /**
     * prints User Object details
     */
    public void printDetails() {
        System.out.println("Name : " + name);
        System.out.println("Roll number is " + rollNo);
        System.out.println("Grades are " + grade);
        System.out.println(name + "'s laptop is " + laptop);
        System.out.println(name + "'s hobby is " + hobby);
    }


    public static void main(String[] args) {

        HelloWorld om = new HelloWorld();
        om.setName("Shree Om Sharma");
        om.setGrade(7.00);
        om.setHobby("staying in terminal");
        om.setLaptop("Asus Zephyrus G14 2021");
        om.setRollNo(21070);
        om.printDetails();
    }
}