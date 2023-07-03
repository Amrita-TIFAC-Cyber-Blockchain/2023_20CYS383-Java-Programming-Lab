package com.amrita.jpl.cys21067.practice.interface1;
/**
 * The Fly interface represents the ability to fly.
 */
interface Fly {

    /**
     * Fly method to perform flying action.
     */
    void fly();
}

/**
 * The Wal interface represents the ability to walk.
 */
interface Wal {

    /**
     * Walk method to perform walking action.
     */
    void walk();
}

/**
 * The Sparrow class represents a sparrow that can fly and walk.
 */
class Sparrow implements Fly, Wal{
    public void fly() {
        System.out.println("Sparrows can fly");
    }

    /**
     * {@inheritDoc}
     */
    public void walk() {
        System.out.println("Sparrows can walk");
    }
}

/**
 * The HummingBird class represents a hummingbird that can fly.
 */
class HummingBird implements Fly {

    /**
     * {@inheritDoc}
     */
    public void fly() {
        System.out.println("Humming Birds can fly");
    }
}

/**
 * The Test class is used to demonstrate the usage of the Sparrow and HummingBird classes.
 */
class Test {

    public static void main(String[] args) {
        Sparrow s = new Sparrow();
        HummingBird hb = new HummingBird();

        s.fly();
        s.walk();
        hb.fly();
    }
}


