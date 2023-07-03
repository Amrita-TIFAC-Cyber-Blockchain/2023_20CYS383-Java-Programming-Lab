package com.amrita.jpl.cys21061.pract.gui;
/**
 * @author Roshni-CYS21061
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GuiDemo implements ActionListener {
    JFrame frame = new JFrame("20CYS383 - Java Programming Lab");
    JButton button1 = new JButton("Click Me!");

    GuiDemo() {
        // Setting layout to null
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setBounds(400, 400, 400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting button position and adding it to the content pane
        button1.setBounds(130, 200, 150, 40);
        frame.getContentPane().add(button1);
        frame.setVisible(true);
        button1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Changing Background Color to blue
        frame.getContentPane().setBackground(Color.BLUE);
    }
}

public class Gui {
    public static void main(String args[]) {
        new GuiDemo();
    }
}
