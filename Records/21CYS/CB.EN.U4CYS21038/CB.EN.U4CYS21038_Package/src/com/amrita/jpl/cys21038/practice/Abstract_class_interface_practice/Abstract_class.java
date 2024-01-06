package com.amrita.jpl.cys21038.practice.Abstract_class_interface_practice;

abstract class fun{
    public abstract void sound();
}
class Check extends fun{
    @Override
    public void sound() {
        System.out.println("Hi man how u doing");
    }
}
interface fun1{
    public void new1();
    public void new2();
}

class Check1 implements fun1{
    @Override
    public void new1() {
        System.out.println("This is first function run in interface");
    }

    @Override
    public void new2() {
        System.out.println("This is second function run in interface");
    }
}

public class Abstract_class {
    public static void main(String[] args) {
        Check obj = new Check();
        Check1 obj1 = new Check1();
        obj.sound();
        obj1.new1();
        obj1.new2();
    }
}