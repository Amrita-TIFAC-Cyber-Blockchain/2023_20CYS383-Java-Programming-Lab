package com.amrita.jpl.cys21051.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SubdomainSearchFrame extends JFrame {

    private JTextField domainField;
    private JTextArea outputArea;
    private List<String> subdomains;

    public SubdomainSearchFrame() {
        setTitle("Subdomain Finder");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5); // Add padding

        // Add components to the main panel using GridBagLayout
        JLabel domainLabel = new JLabel("Domain:");
        domainField = new JTextField(20);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String domain = domainField.getText();
                searchSubdomains(domain);
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReconToolFrame reconToolFrame = new ReconToolFrame();
                reconToolFrame.setVisible(true);
                dispose(); // Close the current frame
            }
        });

        // Add components to the main panel using GridBagConstraints
        constraints.gridx = 0;
        constraints.gridy = 0;
        mainPanel.add(domainLabel, constraints);

        constraints.gridx = 1;
        mainPanel.add(domainField, constraints);

        constraints.gridy = 1;
        mainPanel.add(searchButton, constraints);

        constraints.gridy = 2;
        mainPanel.add(backButton, constraints);

        // Create output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Add the main panel and output area to the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen

        subdomains = new ArrayList<>();
    }

    public void searchSubdomains(String domain) {
        outputArea.setText(""); // Clear previous output
        subdomains.clear();

        try {
            Process process = Runtime.getRuntime().exec("nslookup -type=CNAME " + domain);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("canonical name")) {
                    String[] parts = line.split("canonical name =");
                    if (parts.length > 1) {
                        String subdomain = parts[1].trim();
                        subdomains.add(subdomain);
                    }
                }
            }
            reader.close();

            if (subdomains.isEmpty()) {
                outputArea.append("No subdomains found.");
            } else {
                for (String subdomain : subdomains) {
                    outputArea.append(subdomain + "\n");
                }
            }
        } catch (IOException e) {
            outputArea.append("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SubdomainSearchFrame().setVisible(true);
            }
        });
    }
}
