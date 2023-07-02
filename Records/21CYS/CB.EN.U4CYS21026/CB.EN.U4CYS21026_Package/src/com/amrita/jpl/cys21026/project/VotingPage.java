package com.amrita.jpl.cys21026.project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VotingPage {
    private JFrame frame;

    public VotingPage() {
        frame = new JFrame("Voting Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel(new GridLayout(4, 1));

        JLabel partyLabel = new JLabel("Select Party:");
        JRadioButton party1RadioButton = new JRadioButton("Party manoj");
        JRadioButton party2RadioButton = new JRadioButton("Party dinesh");
        JRadioButton party3RadioButton = new JRadioButton("Party nitin");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(party1RadioButton);
        buttonGroup.add(party2RadioButton);
        buttonGroup.add(party3RadioButton);

        JButton castVoteButton = new JButton("Cast Vote");
        castVoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Process vote
                JOptionPane.showMessageDialog(frame, "Vote cast successfully!");
                frame.dispose();
            }
        });

        panel.add(partyLabel);
        panel.add(party1RadioButton);
        panel.add(party2RadioButton);
        panel.add(party3RadioButton);
        panel.add(castVoteButton);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
