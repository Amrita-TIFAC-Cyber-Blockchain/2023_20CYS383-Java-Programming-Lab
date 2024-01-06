package com.amrita.jpl.cys21083.Practise.GUI;

/**
 * @author Revan Nagireddy - CB.EN.U4CYS21083
 */

import javax.swing.*;
import java.awt.*;
public class form extends JFrame{
    public form(){
        setTitle("Anokha Registration Form");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(7,2));

        JLabel label1 = new JLabel("Name of the student", JLabel.CENTER);
        JLabel label2 = new JLabel("Roll Number", JLabel.CENTER);
        JLabel label3 = new JLabel("University E-Mail ID", JLabel.CENTER);
        JLabel label4 = new JLabel("Mobile Number", JLabel.CENTER);
        JLabel label5 = new JLabel("Gender", JLabel.CENTER);
        JLabel label6 = new JLabel("Workshop Name", JLabel.CENTER);

        JTextArea tarea1 = new JTextArea("Revan Nagireddy");
        JTextArea tarea2 = new JTextArea("CB.EN.U4CYS21083");
        JTextArea tarea3 = new JTextArea("cb.en.u4cys21083@cb.students.amrita.edu");
        JTextArea tarea4 = new JTextArea("+91 9587459861");

        JPanel genderPanel = new JPanel();
        genderPanel.setLayout(new GridLayout(1, 3));
        genderPanel.add(new JRadioButton("Male"));
        genderPanel.add(new JRadioButton("Female"));
        genderPanel.add(new JRadioButton("Others"));

        JPanel select = new JPanel();
        select.setLayout(new GridLayout(3, 1));
        select.add(new JCheckBox("EPICtures"));
        select.add(new JCheckBox("Drone Semianr"));
        select.add(new JCheckBox("Scavanger Hunt"));

        add(label1);
        add(tarea1);
        add(label2);
        add(tarea2);
        add(label3);
        add(tarea3);
        add(label4);
        add(tarea4);
        add(label5);
        add(genderPanel);
        add(label6);
        add(select);

        JButton submitButton = new JButton("Submit");
        add(submitButton);

        setVisible(true);

    }

    public static void main(String[] args){
        new form();
    }
}

