package com.amrita.jpl.cys21072.practice;
/**
 * @author Sri Sai Tanvi Sonti CB.EN.U4CYS21072
 */
class Data {
    private String name;

    // getter method
    public String getName() {
        return this.name;
    }
    // setter method
    public void setName(String name) {
        this.name= name;
    }
}
public class AccessSpecifiers {
    public static void main(String[] main){
        Data d = new Data();

        // access the private variable using the getter and setter
        d.setName("Tanvi");
        System.out.println(d.getName());
    }
}