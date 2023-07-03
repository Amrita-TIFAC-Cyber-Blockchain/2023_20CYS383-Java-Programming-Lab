package com.amrita.jpl.cys21063.project;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class Epoliceportal {
    private static JFrame frame;
    private static JPanel mainPanel;
    private static JPanel reportCrimePanel;
    private static JPanel crimeRecordPanel;
    private static JPanel homePagePanel;
    private static JButton submitButton;
    private static List<String> crimeRecords = new ArrayList<>();

    public static void main(String[] args) {
        // Create and configure the main frame
        frame = new JFrame("E-Crime Investigation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(800, 600);

        // Create the main content panel
        mainPanel = new JPanel(new CardLayout());
        frame.add(mainPanel, BorderLayout.CENTER);

        // Create and configure the report crime panel
        reportCrimePanel = createReportCrimePanel();

        // Create and configure the crime record panel
        crimeRecordPanel = createCrimeRecordPanel();

        // Create and configure the home page panel
        homePagePanel = createHomePagePanel();

        // Add panels to the main panel
        mainPanel.add(reportCrimePanel, "reportCrime");
        mainPanel.add(crimeRecordPanel, "crimeRecord");
        mainPanel.add(homePagePanel, "homePage");

        // Show the home page initially
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "homePage");

        // Create and configure navigation buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton reportCrimeButton = new JButton("Report a Crime");
        JButton crimeRecordButton = new JButton("Crime Records");
        JButton homePageButton = new JButton("Home Page");
        buttonPanel.add(reportCrimeButton);
        buttonPanel.add(crimeRecordButton);
        buttonPanel.add(homePageButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners to the buttons
        reportCrimeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "reportCrime");
            }
        });

        crimeRecordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "crimeRecord");
            }
        });

        homePageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "homePage");
            }
        });


        // Customize the colors, fonts, and styles
        mainPanel.setBackground(Color.WHITE);
        reportCrimePanel.setBackground(Color.white);
        reportCrimePanel.setForeground(Color.BLACK);
        reportCrimePanel.setFont(new Font("Arial", Font.BOLD, 18));
        crimeRecordPanel.setBackground(Color.white);
        crimeRecordPanel.setForeground(Color.BLACK);
        crimeRecordPanel.setFont(new Font("Arial", Font.BOLD, 18));
        homePagePanel.setBackground(Color.WHITE);
        homePagePanel.setForeground(Color.BLACK);
        homePagePanel.setFont(new Font("Arial", Font.PLAIN, 18));

        // Get the screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // Set the size of the frame to the screen size
        frame.setSize(screenWidth, screenHeight);

        // Make the frame full screen
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Show the frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    private static JPanel createReportCrimePanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.GRAY, 3), "Report a Crime"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Add text fields and components for reporting a crime
        JLabel typeOfCrimeLabel = new JLabel("Type of Crime:");
        JTextField typeOfCrimeField = new JTextField(20);
        panel.add(typeOfCrimeLabel, gbc);
        gbc.gridx++;
        panel.add(typeOfCrimeField, gbc);

        // Location details input
        JLabel locationLabel = new JLabel("Location Details:");
        JTextField locationField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(locationLabel, gbc);
        gbc.gridx++;
        panel.add(locationField, gbc);

        // Perpetrator description input
        JLabel perpetratorLabel = new JLabel("Perpetrator Description:");
        JTextArea perpetratorTextArea = new JTextArea(4, 20);
        perpetratorTextArea.setLineWrap(true);
        JScrollPane perpetratorScrollPane = new JScrollPane(perpetratorTextArea);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(perpetratorLabel, gbc);
        gbc.gridx++;
        panel.add(perpetratorScrollPane, gbc);

        // Incident description input
        JLabel incidentLabel = new JLabel("Incident Description:");
        JTextArea incidentTextArea = new JTextArea(4, 20);
        incidentTextArea.setLineWrap(true);
        JScrollPane incidentScrollPane = new JScrollPane(incidentTextArea);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(incidentLabel, gbc);
        gbc.gridx++;
        panel.add(incidentScrollPane, gbc);

        // Witnesses input
        JLabel witnessesLabel = new JLabel("Witnesses:");
        JTextField witnessesField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(witnessesLabel, gbc);
        gbc.gridx++;
        panel.add(witnessesField, gbc);

        // Evidence upload button
        JButton evidenceButton = new JButton("Upload Evidence");
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(evidenceButton, gbc);

        // Contact preference input
        JLabel contactPreferenceLabel = new JLabel("Contact Preference:");
        JComboBox<String> contactPreferenceComboBox = new JComboBox<>(new String[]{"Secure Chat", "Burner Email"});
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        panel.add(contactPreferenceLabel, gbc);
        gbc.gridx++;
        panel.add(contactPreferenceComboBox, gbc);

        // Mode of communication input
        JLabel communicationModeLabel = new JLabel("Mode of Communication:");
        JComboBox<String> communicationModeComboBox = new JComboBox<>(new String[]{"Physical Interaction", "Phone Call", "Online Platform"});
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(communicationModeLabel, gbc);
        gbc.gridx++;
        panel.add(communicationModeComboBox, gbc);

        // Surrounding circumstances input
        JLabel circumstancesLabel = new JLabel("Surrounding Circumstances:");
        JTextField circumstancesField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(circumstancesLabel, gbc);
        gbc.gridx++;
        panel.add(circumstancesField, gbc);

        // Impact on victim input
        JLabel impactLabel = new JLabel("Impact on victim:");
        JTextField impactInput = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(impactLabel, gbc);
        gbc.gridx++;
        panel.add(impactInput, gbc);

        // Pattern and trends input
        JLabel patternLabel = new JLabel("Impact on victim:");
        JTextField patterInput = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(patternLabel, gbc);
        gbc.gridx++;
        panel.add(patterInput, gbc);

        // Perpetrator's vehicle information input
        JLabel perpetratorVehicleLabel = new JLabel("Perpetrator Vehicle Number:");
        JTextField perpetratorVehicleInput = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(perpetratorVehicleLabel, gbc);
        gbc.gridx++;
        panel.add(perpetratorVehicleInput, gbc);

        // byStander involvement input
        JLabel byStanderInvolvementLabel = new JLabel("bystander information:");
        JTextField byStanderInvolvementInput = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(byStanderInvolvementLabel, gbc);
        gbc.gridx++;
        panel.add(byStanderInvolvementInput, gbc);

        // Submit button
        submitButton = new JButton("Submit");
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(submitButton, gbc);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the values from the input fields
                String typeOfCrime = typeOfCrimeField.getText();
                String locationDetails = locationField.getText();
                String perpetratorDescription = perpetratorTextArea.getText();
                String incidentDescription = incidentTextArea.getText();
                String witnesses = witnessesField.getText();
                String contactPreference = (String) contactPreferenceComboBox.getSelectedItem();
                String communicationMode = (String) communicationModeComboBox.getSelectedItem();
                String surroundingCircumstances = circumstancesField.getText();
                String impactOnVictim = impactInput.getText();
                String patternAndTrends = patterInput.getText();
                String perpetratorVehicleNumber = perpetratorVehicleInput.getText();
                String bystanderInvolvement = byStanderInvolvementInput.getText();

                // Construct the crime details string
                StringBuilder crimeDetails = new StringBuilder();
                crimeDetails.append("Type of Crime: ").append(typeOfCrime).append("\n");
                crimeDetails.append("Location Details: ").append(locationDetails).append("\n");
                crimeDetails.append("Perpetrator Description: ").append(perpetratorDescription).append("\n");
                crimeDetails.append("Incident Description: ").append(incidentDescription).append("\n");
                crimeDetails.append("Witnesses: ").append(witnesses).append("\n");
                crimeDetails.append("Contact Preference: ").append(contactPreference).append("\n");
                crimeDetails.append("Mode of Communication: ").append(communicationMode).append("\n");
                crimeDetails.append("Surrounding Circumstances: ").append(surroundingCircumstances).append("\n");
                crimeDetails.append("Impact on Victim: ").append(impactOnVictim).append("\n");
                crimeDetails.append("Pattern and Trends: ").append(patternAndTrends).append("\n");
                crimeDetails.append("Perpetrator Vehicle Number: ").append(perpetratorVehicleNumber).append("\n");
                crimeDetails.append("Bystander Involvement: ").append(bystanderInvolvement);

                // Add the crime details to the crimeRecords list
                crimeRecords.add(crimeDetails.toString());

                // Create a new crime record panel with the updated records
                JPanel updatedCrimeRecordPanel = createCrimeRecordPanel();

                // Replace the existing crime record panel with the updated one
                mainPanel.remove(crimeRecordPanel);
                crimeRecordPanel = updatedCrimeRecordPanel;
                mainPanel.add(crimeRecordPanel, "crimeRecord");

                // Show the crime record panel
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "crimeRecord");

                typeOfCrimeField.setText("");
                locationField.setText("");
                perpetratorTextArea.setText("");
                incidentTextArea.setText("");
                witnessesField.setText("");
                contactPreferenceComboBox.setSelectedIndex(0);
                communicationModeComboBox.setSelectedIndex(0);
                circumstancesField.setText("");
                impactInput.setText("");
                patterInput.setText("");
                perpetratorVehicleInput.setText("");
                byStanderInvolvementInput.setText("");
            }

        });


        return panel;
    }



    private static JPanel createCrimeRecordPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.GRAY, 2), "Crime Records"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Add crime records
        for (int i = 0; i < crimeRecords.size(); i++) {
            int k = i+1;
            JLabel recordLabel = new JLabel("Crime ID: " + k);
            JTextArea recordTextArea = new JTextArea(crimeRecords.get(i), 10, 40);
            recordTextArea.setEditable(false);
            recordTextArea.setLineWrap(true);
            recordTextArea.setBorder(BorderFactory.createEtchedBorder());
            JScrollPane scrollPane = new JScrollPane(recordTextArea);

            gbc.gridx = 0;
            gbc.gridy = i * 2;
            gbc.gridwidth = 2;
            panel.add(recordLabel, gbc);
            gbc.gridy++;
            panel.add(scrollPane, gbc);
        }

        return panel;
    }

    private static JPanel createHomePagePanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.GRAY, 2), "Home Page"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Search bar
        JLabel searchLabel = new JLabel("Search:");
        JTextField searchField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(searchLabel, gbc);
        gbc.gridx++;
        panel.add(searchField, gbc);

        // Contact E-Crime Unit button
        JButton contactButton = new JButton("Contact E-Crime Unit");
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(contactButton, gbc);

        // Report E-Crime button
        JButton reportCrimeButton = new JButton("Report E-Crime");
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(reportCrimeButton, gbc);

        reportCrimeButton.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
            cardLayout.show(mainPanel, "reportCrime");
        });

        // Donate to E-Crime Unit button
        JButton donateButton = new JButton("Donate to E-Crime Unit");
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(donateButton, gbc);

        donateButton.addActionListener(e -> {
            try {
                // Change the URL to the actual donation website
                String donationUrl = "https://www.example.com/donate";
                java.awt.Desktop.getDesktop().browse(java.net.URI.create(donationUrl));
            } catch (java.io.IOException ex) {
                // Handle the exception if the browser cannot be opened
                ex.printStackTrace();
            }
        });

        return panel;
    }
}
