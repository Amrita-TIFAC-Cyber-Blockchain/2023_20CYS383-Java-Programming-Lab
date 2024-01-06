package com.amrita.jpl.cys21028.Practice.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecureEVotingUI extends JFrame {

    public SecureEVotingUI() {
        setTitle("Secure E-Voting System");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        JLabel candidateLabel = new JLabel("Select Candidate:");
        JComboBox<String> candidateComboBox = new JComboBox<>();
        candidateComboBox.addItem("Hitesh");
        candidateComboBox.addItem("Anu");
        candidateComboBox.addItem("Suhitha");
        JButton voteButton = new JButton("Vote");

        // Add components to the content pane
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(3, 1));
        contentPane.add(candidateLabel);
        contentPane.add(candidateComboBox);
        contentPane.add(voteButton);

        // Action listener for the vote button
        voteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform actions when the vote button is clicked
                String selectedCandidate = (String) candidateComboBox.getSelectedItem();
                System.out.println("Voted for: " + selectedCandidate);
                // Perform further processing like cryptographic operations and database updates
            }
        });

        // Make the window visible
        setVisible(true);
        /**
         * @param setVisible set's the window
         */

    }

    public static void main(String[] args) {
        new SecureEVotingUI();
    }
}