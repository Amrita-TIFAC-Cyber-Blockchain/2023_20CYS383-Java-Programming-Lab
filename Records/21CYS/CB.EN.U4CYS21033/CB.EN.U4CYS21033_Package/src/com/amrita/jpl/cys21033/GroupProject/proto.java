package com.amrita.jpl.cys21033.GroupProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/***
 * This is a E-Voting Application program using java swing
 * @author Suhitha K, Hitesh Manjunath K , Anuvarshini M K
 * */
public class proto extends JFrame {

    private Map<String, String> registeredVoters; // Store registered voters (voterID -> password)
    private List<String> candidates; // Store the list of candidates
    private Map<String, Integer> voteCounts; // Store vote counts for each candidate

    private JTabbedPane tabbedPane;
    private JTextField voterIDField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JComboBox<String> candidateComboBox;
    private JButton voteButton;
    private JButton countVotesButton;

    public proto() {
        registeredVoters = new HashMap<>();
        candidates = new ArrayList<>();
        voteCounts = new HashMap<>();

        // Initialize Swing components
        voterIDField = new JTextField(20);
        passwordField = new JPasswordField(20);
        registerButton = new JButton("Register");
        candidateComboBox = new JComboBox<>();
        voteButton = new JButton("Vote");
        countVotesButton = new JButton("Count Votes");

        // Set layout
        setLayout(new GridLayout(1, 1));

        // Create tabbed pane
        tabbedPane = new JTabbedPane();

        // Create registration tab
        JPanel registrationPanel = new JPanel(new FlowLayout());
        registrationPanel.add(new JLabel("Voter ID:"));
        registrationPanel.add(voterIDField);
        registrationPanel.add(new JLabel("Password:"));
        registrationPanel.add(passwordField);
        registrationPanel.add(registerButton);
        tabbedPane.addTab("Registration", registrationPanel);

        // Create voting tab
        JPanel votingPanel = new JPanel(new FlowLayout());
        votingPanel.add(new JLabel("Voter ID:"));
        JTextField voterIDFieldVoting = new JTextField(20);
        votingPanel.add(voterIDFieldVoting);
        votingPanel.add(new JLabel("Password:"));
        JPasswordField passwordFieldVoting = new JPasswordField(20);
        votingPanel.add(passwordFieldVoting);
        votingPanel.add(new JLabel("Select Candidate:"));
        votingPanel.add(candidateComboBox);
        votingPanel.add(voteButton);
        tabbedPane.addTab("Voting", votingPanel);

        // Create results tab
        JPanel resultsPanel = new JPanel(new FlowLayout());
        resultsPanel.add(countVotesButton);
        tabbedPane.addTab("Results", resultsPanel);

        // Add tabbed pane to the frame
        add(tabbedPane);

        // Add action listeners
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String voterID = voterIDField.getText();
                String password = new String(passwordField.getPassword());
                register(voterID, password);
            }
        });

        voteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String voterID = voterIDFieldVoting.getText();
                String password = new String(passwordFieldVoting.getPassword());

                // Verify the voter ID and password
                if (!registeredVoters.containsKey(voterID) || !registeredVoters.get(voterID).equals(password)) {
                    JOptionPane.showMessageDialog(proto.this, "Invalid voter ID or password. Please try again.");
                    return;
                }

                String selectedCandidate = (String) candidateComboBox.getSelectedItem();
                vote(selectedCandidate);
            }
        });

        countVotesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countVotes();
            }
        });
    }

    private void register(String voterID, String password) {
        if (registeredVoters.containsKey(voterID)) {
            JOptionPane.showMessageDialog(this, "Voter ID already exists. Please choose a different Voter ID.");
        } else {
            registeredVoters.put(voterID, password);
            JOptionPane.showMessageDialog(this, "Registration successful!");
            voterIDField.setText("");
            passwordField.setText("");
        }
    }

    private void vote(String candidate) {
        if (!voteCounts.containsKey(candidate)) {
            voteCounts.put(candidate, 1);
        } else {
            int count = voteCounts.get(candidate);
            voteCounts.put(candidate, count + 1);
        }

        JOptionPane.showMessageDialog(this, "Vote cast successfully!");
        candidateComboBox.setSelectedIndex(0);
    }

    private void countVotes() {
        StringBuilder result = new StringBuilder("Vote Counts:\n");
        for (Map.Entry<String, Integer> entry : voteCounts.entrySet()) {
            result.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        JOptionPane.showMessageDialog(this, result.toString());

        // Save vote counts to file
        saveVoteCountsToFile();
    }

    private void saveVoteCountsToFile() {
        Path filePath = Path.of("vote.txt");
        try {
            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
            }

            StringBuilder fileContent = new StringBuilder();
            for (Map.Entry<String, Integer> entry : voteCounts.entrySet()) {
                fileContent.append(entry.getKey()).append(",").append(entry.getValue()).append(System.lineSeparator());
            }

            Files.write(filePath, fileContent.toString().getBytes(), StandardOpenOption.APPEND);
            JOptionPane.showMessageDialog(this, "Vote counts saved to file successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving vote counts to file: " + e.getMessage());
        }
    }

    public void addCandidateName(String candidateName) {
        candidates.add(candidateName);
        candidateComboBox.addItem(candidateName);
    }

    public static void main(String[] args) {
        proto application = new proto();

        // Prompt the user to enter the number of candidates
        int numCandidates = Integer.parseInt(JOptionPane.showInputDialog(application, "Enter the number of candidates:"));
        for (int i = 1; i <= numCandidates; i++) {
            String candidateName = JOptionPane.showInputDialog(application, "Enter candidate name " + i + ":");
            application.addCandidateName(candidateName);
        }

        application.setSize(400, 200);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setVisible(true);
    }
}