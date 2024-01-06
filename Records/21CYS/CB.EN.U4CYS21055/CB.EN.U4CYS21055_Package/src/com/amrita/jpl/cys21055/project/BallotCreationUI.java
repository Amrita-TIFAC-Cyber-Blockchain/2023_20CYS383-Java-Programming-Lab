package com.amrita.jpl.cys21055.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BallotCreationUI extends JFrame {
    private JLabel titleLabel;
    private JTextField titleTextField;
    private JButton addCandidateButton;
    private JTextArea candidateTextArea;
    private JButton createBallotButton;

    private List<String> candidateList;

    public BallotCreationUI() {
        setTitle("Ballot Creation and Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        titleLabel = new JLabel("Ballot Title:");
        titleTextField = new JTextField();

        addCandidateButton = new JButton("Add Candidate");
        candidateTextArea = new JTextArea(5, 20);
        JScrollPane candidateScrollPane = new JScrollPane(candidateTextArea);

        createBallotButton = new JButton("Create Ballot");

        formPanel.add(titleLabel);
        formPanel.add(titleTextField);
        formPanel.add(new JLabel());
        formPanel.add(addCandidateButton);
        formPanel.add(candidateScrollPane);
        formPanel.add(new JLabel());
        formPanel.add(new JLabel());
        formPanel.add(createBallotButton);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);

        candidateList = new ArrayList<>();

        // ActionListener for Add Candidate Button
        addCandidateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String candidateName = JOptionPane.showInputDialog(BallotCreationUI.this, "Enter Candidate Name:");
                if (candidateName != null && !candidateName.isEmpty()) {
                    candidateList.add(candidateName);
                    candidateTextArea.append(candidateName + "\n");
                }
            }
        });

        // ActionListener for Create Ballot Button
        createBallotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleTextField.getText();

                if (!title.isEmpty() && candidateList.size() > 0) {
                    // Perform ballot creation logic here
                    StringBuilder result = new StringBuilder();
                    result.append("Ballot Title: ").append(title).append("\n");
                    result.append("Candidates:").append("\n");
                    for (String candidate : candidateList) {
                        result.append(candidate).append("\n");
                    }

                    JOptionPane.showMessageDialog(BallotCreationUI.this, "Ballot created successfully!\n\n" + result.toString());
                } else {
                    JOptionPane.showMessageDialog(BallotCreationUI.this, "Ballot creation failed! Please provide a title and at least one candidate.", "Creation Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        pack();
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BallotCreationUI();
            }
        });
    }
}
