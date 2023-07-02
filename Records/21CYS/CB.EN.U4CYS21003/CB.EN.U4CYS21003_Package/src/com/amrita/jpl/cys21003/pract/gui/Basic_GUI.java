package com.amrita.jpl.cys21003.pract.gui;

import javax.swing.*;
/**
 * Basic GUI
 *
 * @author Aishwarya G
 * @version 1.0
 */


public class Basic_GUI extends JFrame {

    public Basic_GUI() {
        setTitle("GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Basic_GUI();
    }
}