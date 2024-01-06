package com.amrita.jpl.cys21026.project;

import javax.swing.*;

 class EVotingSystemGUI {
    private JFrame frame;
    private JTabbedPane tabbedPane;

    public EVotingSystemGUI() {
        frame = new JFrame("E-Voting System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        tabbedPane = new JTabbedPane();
        frame.getContentPane().add(tabbedPane);

        tabbedPane.addTab("Registration", new RegistrationPage().getPanel());
        tabbedPane.addTab("Admin Login", new AdminLoginPage().getPanel());

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EVotingSystemGUI();
            }
        });
    }
}
