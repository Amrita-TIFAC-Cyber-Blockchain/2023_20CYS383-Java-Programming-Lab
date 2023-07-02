package com.amrita.jpl.cys21026.project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 class CreateBallotPage {
    private JFrame frame;

    public CreateBallotPage() {
        frame = new JFrame("Create Ballot Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Title:");
        JTextField titleTextField = new JTextField();
        JButton addButton = new JButton("Add Contestant");
        JButton submitButton = new JButton("Submit");

        JPanel contestantPanel = new JPanel();
        contestantPanel.setLayout(new BoxLayout(contestantPanel, BoxLayout.Y_AXIS));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String contestantName = JOptionPane.showInputDialog(frame, "Enter Contestant Name:");
                contestantPanel.add(new JLabel(contestantName));
                frame.revalidate();
                frame.repaint();
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Process ballot creation
                JOptionPane.showMessageDialog(frame, "Ballot created successfully!");
                // Redirect to check results page
                new CheckResultsPage();
                frame.dispose();
            }
        });

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(titleTextField, BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.EAST);
        panel.add(submitButton, BorderLayout.SOUTH);
        panel.add(contestantPanel, BorderLayout.WEST);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
