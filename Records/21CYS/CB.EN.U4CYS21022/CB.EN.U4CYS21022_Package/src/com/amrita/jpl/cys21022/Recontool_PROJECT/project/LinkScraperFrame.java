package com.amrita.jpl.cys21051.project;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LinkScraperFrame extends JFrame {
    private JTextArea outputArea;

    public LinkScraperFrame() {
        setTitle("Link Scraper");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(500, 400));

        // Create the main panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel domainLabel = new JLabel("Enter a domain name (e.g., example.com):");
        mainPanel.add(domainLabel, constraints);

        JTextField domainField = new JTextField(30); // Increase the width of the domain field
        constraints.gridx = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER; // Set gridwidth to REMAINDER
        constraints.fill = GridBagConstraints.HORIZONTAL; // Set fill to HORIZONTAL
        mainPanel.add(domainField, constraints);

        pack();
        setLocationRelativeTo(null);

        JButton scrapeButton = new JButton("Scrape Links");
        constraints.gridx = 1;
        constraints.gridy = 1;
        mainPanel.add(scrapeButton, constraints);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.NORTH);

        outputArea = new JTextArea(10, 35);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen

        scrapeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String domain = domainField.getText().trim();
                String url = "http://" + domain;

                try {
                    Document document = Jsoup.connect(url).get();
                    Elements links = document.select("a");

                    displayLinks(links);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton backButton = new JButton("Back");
        getContentPane().add(backButton, BorderLayout.SOUTH);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReconToolFrame reconToolFrame = new ReconToolFrame();
                reconToolFrame.setVisible(true);
                dispose(); // Close the current frame
            }
        });
    }

    private void displayLinks(Elements links) {
        outputArea.setText("Links found on the page:\n");
        for (int i = 0; i < links.size(); i++) {
            Element link = links.get(i);
            String linkText = link.text().trim();
            String linkHref = link.attr("href");
            outputArea.append((i + 1) + ". " + linkText + " - " + linkHref + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LinkScraperFrame linkScraperFrame = new LinkScraperFrame();
            linkScraperFrame.setVisible(true);
        });
    }
}
