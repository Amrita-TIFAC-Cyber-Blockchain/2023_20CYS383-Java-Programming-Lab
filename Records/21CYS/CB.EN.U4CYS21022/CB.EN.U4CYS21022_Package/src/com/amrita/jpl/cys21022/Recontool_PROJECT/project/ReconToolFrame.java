package com.amrita.jpl.cys21051.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReconToolFrame extends JFrame {

    public ReconToolFrame() {
        setTitle("Recon Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10); // Add padding

        // Add components to the main panel using GridBagLayout
        JLabel titleLabel = new JLabel("Recon Tool");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JButton portScannerButton = new JButton("Port Scanner");
        portScannerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PortScannerFrame portScannerFrame = new PortScannerFrame();
                portScannerFrame.setVisible(true);
            }
        });

        JButton subdomainFinderButton = new JButton("Subdomain Finder");
        subdomainFinderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SubdomainSearchFrame subdomainFrame = new SubdomainSearchFrame();
                subdomainFrame.setVisible(true);
            }
        });

        JButton linkscraperBUtton = new JButton("Data Scraping");
        linkscraperBUtton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LinkScraperFrame linkFrame = new LinkScraperFrame();
                linkFrame.setVisible(true);
            }
        });

        // Add components to the main panel using GridBagConstraints
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        mainPanel.add(titleLabel, constraints);

        constraints.gridy = 1;
        constraints.gridwidth = 1;
        mainPanel.add(portScannerButton, constraints);

        constraints.gridx = 1;
        mainPanel.add(subdomainFinderButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        mainPanel.add(linkscraperBUtton, constraints);

        // Add the main panel to the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReconToolFrame reconToolFrame = new ReconToolFrame();
            reconToolFrame.setVisible(true);
        });
    }
}
