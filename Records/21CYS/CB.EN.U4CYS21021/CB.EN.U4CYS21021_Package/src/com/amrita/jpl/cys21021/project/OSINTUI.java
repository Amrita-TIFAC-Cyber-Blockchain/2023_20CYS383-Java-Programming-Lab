package com.amrita.jpl.cys21021.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class OSINTUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField urlField;
    private JTextArea resultArea;

    public OSINTUI() {
        super("OSINT UI");

        // Create components
        urlField = new JTextField(70);
        JButton fetchButton = new JButton("Fetch");
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setPreferredSize(new Dimension(600, 400));

        // Create panel for URL input
        JPanel inputPanel = new JPanel();
        inputPanel.add(urlField);
        inputPanel.add(fetchButton);

        // Create panel for the logo
        JPanel logoPanel = new JPanel();
        ImageIcon logoIcon = new ImageIcon("Java Lab Final/Logo.jpeg"); // Replace "logo.png" with the actual path to your logo image
        Image scaledLogoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoPanel.add(logoLabel);

        // Create main panel to hold input panel and logo panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(logoPanel, BorderLayout.WEST);
        mainPanel.add(inputPanel, BorderLayout.EAST);

        // Add components to the frame
        add(mainPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Add action listener to the fetch button
        fetchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fetchURLContents();
            }
        });
    }

    private void fetchURLContents() {
        try {
            String urlText = urlField.getText();
            URL url = new URL(urlText);

            // Open a connection and read the contents of the URL
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append("\n");
            }
            reader.close();

            // Display the fetched content in the result area
            resultArea.setText(content.toString());
        } catch (Exception e) {
            e.printStackTrace();
            resultArea.setText("Error fetching URL contents.");
        }
    }

    public static void main(String[] args) {
        OSINTUI osintUI = new OSINTUI();
        osintUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        osintUI.pack();
        osintUI.setVisible(true);
    }
}