package com.amrita.jpl.cys21027.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateBallotPage extends JFrame {
    private JTextField titleField;
    private JTextArea contestantsTextArea;

    public CreateBallotPage() {
        setTitle("Create Ballot");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField();
        JLabel contestantsLabel = new JLabel("Contestants (one per line):");
        contestantsTextArea = new JTextArea();

        JButton createButton = new JButton("Create Ballot");
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String contestants = contestantsTextArea.getText();

                // Save the ballot details in the database
                // ...
                JOptionPane.showMessageDialog(null, "Ballot created successfully.");
                dispose();
            }
        });

        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(contestantsLabel);
        panel.add(new JScrollPane(contestantsTextArea));
        panel.add(new JLabel());
        panel.add(createButton);

        getContentPane().add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CreateBallotPage();
            }
        });
    }
}
