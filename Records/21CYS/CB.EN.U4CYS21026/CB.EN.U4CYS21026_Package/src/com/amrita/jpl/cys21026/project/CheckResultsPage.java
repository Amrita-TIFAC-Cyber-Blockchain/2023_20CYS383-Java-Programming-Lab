package com.amrita.jpl.cys21026.project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckResultsPage {
    private JFrame frame;

    public CheckResultsPage() {
        frame = new JFrame("Check Results Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel(new BorderLayout());

        JTextArea resultsTextArea = new JTextArea();
        JButton endVotingButton = new JButton("End Voting");

        endVotingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Process end of voting
                JOptionPane.showMessageDialog(frame, "Voting ended!");
                // Display winner
                resultsTextArea.setText("Winner: Party manoj");
            }
        });

        panel.add(resultsTextArea, BorderLayout.CENTER);
        panel.add(endVotingButton, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
