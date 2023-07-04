package com.amrita.jpl.cys21066.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SherlockUI extends JFrame {
    private JTextField usernameTextField;
    private JTextArea searchResultTextArea;
    private JButton searchButton;

    public SherlockUI() {
        setTitle("Search Sites for Usernames");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Create components
        usernameTextField = new JTextField(20);
        searchResultTextArea = new JTextArea();
        searchButton = new JButton("Search");

        // Set font for search result text area
        searchResultTextArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));

        // Set layout
        setLayout(new BorderLayout());

        // Create panels
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Add some spacing
        topPanel.add(new JLabel("Enter Username:"));
        topPanel.add(usernameTextField);
        topPanel.add(searchButton);

        // Add components to the frame
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(searchResultTextArea), BorderLayout.CENTER);

        // Register ActionListener for the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performSearch();
            }
        });
    }

    private void performSearch() {
        // Get the username from the text field
        String username = usernameTextField.getText();

        // Check if username is empty
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a username.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // TODO: Implement search logic for the Sherlock Project

        // Simulating search results
        searchResultTextArea.setText("");
        searchResultTextArea.append("Searching for username: " + username + "...\n");
        searchResultTextArea.append("No sites used your username.");

        // Scroll to the top of the search result text area
        searchResultTextArea.setCaretPosition(0);
    }

    public static void main(String[] args) {
        try {
            // Set look and feel to the system's default
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            SherlockUI sherlockUI = new SherlockUI();
            sherlockUI.setVisible(true);
        });
    }
}
