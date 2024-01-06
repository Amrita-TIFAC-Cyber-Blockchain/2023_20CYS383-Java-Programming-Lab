package com.amrita.jpl.cys21055.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class VoteCastingUI extends JFrame {
    private JLabel candidateLabel;
    private JComboBox<String> candidateComboBox;
    private JButton castVoteButton;

    private Map<String, Integer> candidateVotes;

    public VoteCastingUI() {
        setTitle("Vote Casting");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        candidateLabel = new JLabel("Candidate:");
        candidateComboBox = new JComboBox<>();
        candidateComboBox.addItem("Candidate 1");
        candidateComboBox.addItem("Candidate 2");
        candidateComboBox.addItem("Candidate 3");

        castVoteButton = new JButton("Cast Vote");

        formPanel.add(candidateLabel);
        formPanel.add(candidateComboBox);
        formPanel.add(new JLabel());
        formPanel.add(castVoteButton);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);

        candidateVotes = new HashMap<>();

        // ActionListener for Cast Vote Button
        castVoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCandidate = (String) candidateComboBox.getSelectedItem();

                // Check if the voter has already cast a vote
                if (!candidateVotes.containsKey(getVoterId())) {
                    // Encrypt and store the vote securely
                    encryptAndStoreVote(selectedCandidate);

                    // Increment the candidate's vote count
                    incrementCandidateVoteCount(selectedCandidate);

                    JOptionPane.showMessageDialog(VoteCastingUI.this, "Vote cast successfully!");
                } else {
                    JOptionPane.showMessageDialog(VoteCastingUI.this, "You have already cast your vote.", "Double Voting Detected", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        pack();
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);
    }

    private String getVoterId() {
        // Implement logic to retrieve the unique voter ID (e.g., from authentication)
        return "Voter1";
    }

    private void encryptAndStoreVote(String selectedCandidate) {
        // Implement logic to encrypt and securely store the vote
        // For simplicity, this example only prints the encrypted vote to the console
        System.out.println("Encrypted vote: " + selectedCandidate);
    }

    private void incrementCandidateVoteCount(String candidate) {
        // Increment the vote count for the selected candidate
        int voteCount = candidateVotes.getOrDefault(candidate, 0);
        candidateVotes.put(candidate, voteCount + 1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VoteCastingUI();
            }
        });
    }
}
