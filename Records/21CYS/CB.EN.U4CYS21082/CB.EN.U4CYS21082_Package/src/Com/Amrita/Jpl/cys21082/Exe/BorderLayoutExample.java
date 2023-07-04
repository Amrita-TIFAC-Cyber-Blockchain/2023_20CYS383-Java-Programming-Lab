package Com.Amrita.Jpl.cys21082.Exe;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample extends JFrame {

    public BorderLayoutExample() {
        setTitle("BorderLayout Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a JPanel for the center content
        JPanel centerPanel = new JPanel(new BorderLayout());

        // Header Label
        JLabel headerLabel = new JLabel("Welcome to Java Programming Lab", JLabel.CENTER);
        centerPanel.add(headerLabel, BorderLayout.NORTH);

        // Content TextArea
        JTextArea contentTextArea = new JTextArea();
        centerPanel.add(contentTextArea, BorderLayout.CENTER);

        // Add the centerPanel to the frame
        add(centerPanel, BorderLayout.CENTER);

        // Submit Button
        JButton submitButton = new JButton("Submit Feedback");
        add(submitButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BorderLayoutExample();
    }
}
