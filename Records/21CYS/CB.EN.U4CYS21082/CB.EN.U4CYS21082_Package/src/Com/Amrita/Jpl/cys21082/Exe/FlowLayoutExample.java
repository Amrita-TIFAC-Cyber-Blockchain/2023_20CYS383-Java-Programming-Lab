package Com.Amrita.Jpl.cys21082.Exe;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutExample extends JFrame {

    public FlowLayoutExample() {
        setTitle("FlowLayout Example");
        setSize(400, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create a JPanel to hold the components
        JPanel panel = new JPanel();

        // Set the layout manager for the panel
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        // Create and add components to the panel
        panel.add(new JLabel(" Full Name"));
        panel.add(new JButton("kavya us"));
        panel.add(new JLabel("Roll Number"));
        panel.add(new JButton("CB.EN.u4CYS21081"));
        panel.add(new JLabel("Rate"));
        panel.add(new JButton("4"));
        panel.add(new JButton("Submit"));

        // Add the panel to the content pane
        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayoutExample();
    }
}
