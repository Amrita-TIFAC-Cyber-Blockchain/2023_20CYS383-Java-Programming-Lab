package com.amrita.jpl.cys21067.practice.interface1;
/**
 * The Walk interface represents the ability to walk.
 */
interface Walk {

    /**
     * Walk method to perform walking action.
     */
    void walk();
}

/**
 * The Dog class represents a dog that can walk.
 */
class Dog implements Walk {


    public void walk() {
        System.out.println("A dog walks every day");
    }
}

/**
 * The ine1 class is used to demonstrate the usage of the Dog class.
 */
class ine1 {

    public static void main(String[] args) {
        Dog d = new Dog();
        d.walk();
    }
}
