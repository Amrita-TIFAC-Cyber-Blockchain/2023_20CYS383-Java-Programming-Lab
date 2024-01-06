package com.amrita.jpl.cys21027.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class VotingPage extends JFrame {
    private ButtonGroup partyGroup;
    private Set<String> votedVoterIds;

    public VotingPage() {
        setTitle("Voting");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JRadioButton party1RadioButton = new JRadioButton("Party 1");
        JRadioButton party2RadioButton = new JRadioButton("Party 2");
        JRadioButton party3RadioButton = new JRadioButton("Party 3");

        partyGroup = new ButtonGroup();
        partyGroup.add(party1RadioButton);
        partyGroup.add(party2RadioButton);
        partyGroup.add(party3RadioButton);

        JButton castVoteButton = new JButton("Cast Vote");
        castVoteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedParty = "";
                if (party1RadioButton.isSelected()) {
                    selectedParty = party1RadioButton.getText();
                } else if (party2RadioButton.isSelected()) {
                    selectedParty = party2RadioButton.getText();
                } else if (party3RadioButton.isSelected()) {
                    selectedParty = party3RadioButton.getText();
                }

                String voterId = getVoterId();

                if (votedVoterIds.contains(voterId)) {
                    JOptionPane.showMessageDialog(null, "You have already voted.");
                } else {
                    // Save the vote in the database
                    saveVote(selectedParty, voterId);
                    votedVoterIds.add(voterId);
                    JOptionPane.showMessageDialog(null, "Vote cast for " + selectedParty);
                    dispose();
                }
            }
        });

        panel.add(party1RadioButton);
        panel.add(party2RadioButton);
        panel.add(party3RadioButton);
        panel.add(castVoteButton);

        getContentPane().add(panel);
        setVisible(true);

        votedVoterIds = new HashSet<>();
    }

    private String getVoterId() {
        String voterId = JOptionPane.showInputDialog("Enter your Voter ID:");
        return voterId;
    }

    private void saveVote(String party, String voterId) {
        System.out.println("Voter ID: " + voterId + " | Voted for: " + party);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VotingPage();
            }
        });
    }
}
