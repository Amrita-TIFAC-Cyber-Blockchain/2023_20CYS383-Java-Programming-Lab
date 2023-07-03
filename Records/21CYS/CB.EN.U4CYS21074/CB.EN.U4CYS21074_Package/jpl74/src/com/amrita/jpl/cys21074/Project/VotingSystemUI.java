package com.amrita.jpl.cys21074.pract.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The {@code VotingSystemUI} class represents a GUI for an online secure voting system.
 */
public class VotingSystemUI extends JFrame {
    private JLabel titleLabel;
    private JLabel candidateLabel;
    private JComboBox<String> candidateComboBox;
    private JButton voteButton;

    /**
     * Constructs a new VotingSystemUI object.
     * Sets up the window, initializes UI components, and adds event listeners.
     */
    public VotingSystemUI() {
        // Set window properties
        setTitle("Online Secure Voting System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Initialize UI components
        titleLabel = new JLabel("Welcome to the Online Voting System");
        candidateLabel = new JLabel("Select a candidate:");
        candidateComboBox = new JComboBox<>(new String[]{"Candidate 1", "Candidate 2", "Candidate 3"});
        voteButton = new JButton("Vote");

        // Add components to the frame
        add(titleLabel);
        add(candidateLabel);
        add(candidateComboBox);
        add(voteButton);

        // Set event listener for the vote button
        voteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform vote processing logic here
                String selectedCandidate = (String) candidateComboBox.getSelectedItem();
                JOptionPane.showMessageDialog(VotingSystemUI.this, "You voted for " + selectedCandidate);
            }
        });

        // Set frame properties
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Main method to launch the application.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        // Create an instance of the UI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VotingSystemUI();
            }
        });
    }
}
