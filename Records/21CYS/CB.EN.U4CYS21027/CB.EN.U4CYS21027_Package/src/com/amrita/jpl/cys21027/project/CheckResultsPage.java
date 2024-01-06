package com.amrita.jpl.cys21027.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckResultsPage extends JFrame {
    private JTextArea resultsTextArea;

    public CheckResultsPage() {
        setTitle("Check Results");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Results:");
        resultsTextArea = new JTextArea();

        JButton endVotingButton = new JButton("End Voting");
        endVotingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Voting has ended. Winner: Party X");
                dispose();
            }
        });

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(new JScrollPane(resultsTextArea), BorderLayout.CENTER);
        panel.add(endVotingButton, BorderLayout.SOUTH);

        getContentPane().add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CheckResultsPage();
            }
        });
    }
}
