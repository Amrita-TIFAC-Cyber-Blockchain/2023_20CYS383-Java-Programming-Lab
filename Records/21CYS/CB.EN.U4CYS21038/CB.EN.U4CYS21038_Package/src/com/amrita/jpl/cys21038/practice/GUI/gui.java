package com.amrita.jpl.cys21038.practice.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Madhav H
 */
class guiDemo implements ActionListener {
    JFrame frame = new JFrame("This is My Sample GUI");
    JButton button1 = new JButton("Welcome MADHAV HARIKUMAR");

    guiDemo() {

        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setBounds(400,400,400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1.setBounds(130,200,150,40);
        frame.getContentPane().add(button1);
        frame.setVisible(true);
        button1.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Changing Background Color
        frame.getContentPane().setBackground(Color.ORANGE);

    }

}

public class gui {
    /**
     *
     * @param args
     */
    public static void main(String[] args){

        new guiDemo();
        }
    }
