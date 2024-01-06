package com.amrita.jpl.cys21034.project;

import javax.swing.*;
import java.awt.*;

/**
 * The NesamaniApp class represents the main application window for the Nesamani application.
 */
public class NesamaniApp extends JFrame {
    /**
     * Constructs a NesamaniApp object.
     */
    public NesamaniApp() {
        setTitle("Nesamani");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top Bar
        JPanel topBarPanel = new JPanel();
        topBarPanel.setBackground(Color.darkGray);
        topBarPanel.setPreferredSize(new Dimension(getWidth(), 50));
        topBarPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel clockIcon = new JLabel(new ImageIcon("path/to/clock-icon.png"));
        JLabel clockLabel = new JLabel("8:00 - 9:00");
        JLabel clockText = new JLabel("Mon - Fri");
        topBarPanel.add(clockIcon);
        topBarPanel.add(clockLabel);
        topBarPanel.add(clockText);

        JLabel phoneIcon = new JLabel(new ImageIcon("path/to/phone-icon.png"));
        JLabel phoneLabel = new JLabel("+91-8667761623");
        JLabel phoneText = new JLabel("For Appointment");
        topBarPanel.add(phoneIcon);
        topBarPanel.add(phoneLabel);
        topBarPanel.add(phoneText);

        add(topBarPanel, BorderLayout.NORTH);

        // Nav Bar
        JPanel navBarPanel = new JPanel();
        navBarPanel.setBackground(Color.darkGray);
        navBarPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel logoLabel = new JLabel("Ne");
        logoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        logoLabel.setForeground(Color.white);

        JLabel nesamaniLabel = new JLabel("samani");
        nesamaniLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        nesamaniLabel.setForeground(Color.white);

        navBarPanel.add(logoLabel);
        navBarPanel.add(nesamaniLabel);

        JButton homeButton = new JButton("Home");
        JButton aboutButton = new JButton("About");
        JButton priceButton = new JButton("Price");
        JButton contactButton = new JButton("Contact");
        JButton loginButton = new JButton("Login");

        navBarPanel.add(homeButton);
        navBarPanel.add(aboutButton);
        navBarPanel.add(priceButton);
        navBarPanel.add(contactButton);
        navBarPanel.add(loginButton);

        add(navBarPanel, BorderLayout.CENTER);

        // Hero Section
        JPanel heroPanel = new JPanel();
        heroPanel.setLayout(new BorderLayout());

        JLabel heroText = new JLabel("Find your dream job here");
        heroText.setFont(new Font("Arial", Font.BOLD, 32));

        JLabel heroDesc = new JLabel("Make a quick hire, ease your talent acquisition");
        heroDesc.setFont(new Font("Arial", Font.PLAIN, 18));

        JButton findJobButton = new JButton("Find a job");
        JButton hireButton = new JButton("Hire now");

        JPanel heroButtonPanel = new JPanel();
        heroButtonPanel.add(findJobButton);
        heroButtonPanel.add(hireButton);

        heroPanel.add(heroText, BorderLayout.NORTH);
        heroPanel.add(heroDesc, BorderLayout.CENTER);
        heroPanel.add(heroButtonPanel, BorderLayout.SOUTH);

        add(heroPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * The main method that starts the Nesamani application.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NesamaniApp().setVisible(true);
            }
        });
    }
}
