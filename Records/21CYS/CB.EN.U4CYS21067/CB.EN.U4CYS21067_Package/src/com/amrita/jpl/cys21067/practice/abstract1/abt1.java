package com.amrita.jpl.cys21067.practice.abstract1;

/**
 * Represents a person.
 */
abstract class Person {
    protected String name;
    protected int age;

    /**
     * Constructs a person object with the given name and age.
     *
     * @param name the name of the person
     * @param age  the age of the person
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Displays information about the person.
     */
    public abstract void displayInfo();
}

/**
 * Represents a student that extends the Person class.
 */
class Student extends Person {
    private int studentId;

    /**
     * Constructs a student object with the given name, age, and student ID.
     *
     * @param name      the name of the student
     * @param age       the age of the student
     * @param studentId the student ID
     */
    public Student(String name, int age, int studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    /**
     * Displays information about the student, including the name, age, and student ID.
     */
    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Student ID: " + studentId);
    }
}

/**
 * A sample class to demonstrate abstract classes and usage of the Person and Student classes.
 */
public class abt1 {
    /**
     * The main method that demonstrates the usage of the classes.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student student = new Student("John", 20, 12345);
        student.displayInfo();
    }
}
