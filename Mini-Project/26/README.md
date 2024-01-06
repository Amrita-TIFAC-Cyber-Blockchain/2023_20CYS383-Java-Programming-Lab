# 20CYS383 Java Programming Lab
![](https://img.shields.io/badge/Batch-21CYS-lightgreen) ![](https://img.shields.io/badge/UG-blue) ![](https://img.shields.io/badge/Subject-JPL-blue)
 
## E - Voting

### Project Description

<p text-align: justify;>The E-Voting System is an electronic voting application built in Java. It gives a user-friendly GUI enabling users to register as voters, register candidates, cast votes, and view voting results. The process seeks to ensure secure and precise vote counting while simplifying the voting process.</p>

### Module Split-up
| Name | Topic |
|------|-------|
| Ravi | Secure E-Voting Fragments |
| Ravi | Count of Votes |
| Mittul | Login Page |
| Mittul | Registration Page |
| Dharmik | Secure E-Voting Fragments |
| Dharmik | Party Registration Page |

### Code

#### EVoting.java
```
package com.amrita.jpl.cys21067.PROJECT;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class represents a secure voting system application.
 * It allows users to register, log in, and vote for a party.
 */

class SecureVotingSystem extends JFrame implements ActionListener {
    private JLabel titleLabel, ageLabel, voterIdLabel, fullNameLabel, contactNumberLabel, genderLabel, cityLabel, partyLabel;
    private JTextField ageTextField, voterIdTextField, fullNameTextField, contactNumberTextField;
    private JRadioButton maleRadioButton, femaleRadioButton, otherRadioButton;
    private JComboBox<String> cityComboBox, partyComboBox;
    private JButton submitButton;
    private Map<String, String> registeredVoters;
    private Set<Integer> voterIds;
    private Map<String, Integer> voteCountMap;
    private ButtonGroup partyButtonGroup;

    /**
     * Constructs a new SecureVotingSystem object and initializes the UI components.
     */

    public SecureVotingSystem(Map<String, String> registeredVoters) {
        setTitle("Secure Voting System");
        setSize(600, 500);
        setLayout(null);

        this.registeredVoters = registeredVoters;
        voterIds = new HashSet<>();
        voteCountMap = new HashMap<>();

        titleLabel = new JLabel("Secure E - Voting System");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setBounds(180, 10, 250, 40);
        add(titleLabel);

        ageLabel = new JLabel("Age");
        ageLabel.setBounds(50, 60, 100, 20);
        add(ageLabel);

        ageTextField = new JTextField();
        ageTextField.setBounds(200, 60, 150, 20);
        add(ageTextField);

        voterIdLabel = new JLabel("Voter ID");
        voterIdLabel.setBounds(50, 100, 150, 20);
        add(voterIdLabel);

        voterIdTextField = new JTextField();
        voterIdTextField.setBounds(200, 100, 150, 20);
        add(voterIdTextField);

        fullNameLabel = new JLabel("Full Name");
        fullNameLabel.setBounds(50, 140, 100, 20);
        add(fullNameLabel);

        fullNameTextField = new JTextField();
        fullNameTextField.setBounds(200, 140, 150, 20);
        add(fullNameTextField);

        contactNumberLabel = new JLabel("Contact Number");
        contactNumberLabel.setBounds(50, 180, 100, 20);
        add(contactNumberLabel);

        contactNumberTextField = new JTextField();
        contactNumberTextField.setBounds(200, 180, 150, 20);
        add(contactNumberTextField);

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(50, 220, 60, 20);
        add(genderLabel);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(200, 220, 60, 20);
        add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(280, 220, 80, 20);
        add(femaleRadioButton);

        otherRadioButton = new JRadioButton("Other");
        otherRadioButton.setBounds(370, 220, 80, 20);
        add(otherRadioButton);

        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);
        genderButtonGroup.add(otherRadioButton);

        cityLabel = new JLabel("City");
        cityLabel.setBounds(50, 260, 100, 20);
        add(cityLabel);

        String[] cities = {"Delhi", "Bangalore", "Mumbai", "Hyderabad", "Kolkata", "Chennai", "Pune"};
        cityComboBox = new JComboBox<>(cities);
        cityComboBox.setBounds(200, 260, 150, 20);
        add(cityComboBox);

        partyLabel = new JLabel("Select Party");
        partyLabel.setBounds(50, 300, 100, 20);
        add(partyLabel);

        String[] parties = {"BJP", "TRS", "AIDMK"};
        partyComboBox = new JComboBox<>(parties);
        partyComboBox.setBounds(200, 300, 150, 20);
        add(partyComboBox);

        submitButton = new JButton("Submit");
        submitButton.setBounds(250, 350, 100, 30); // Adjust the Y position to avoid overlapping
        submitButton.addActionListener(this);
        add(submitButton);

        setVisible(true);
    }

    /**
     * Handles the actionPerformed event for the submitButton.
     * Collects user input, validates it, and processes the vote.
     *
     * @param e The ActionEvent instance.
     */

    public void actionPerformed(ActionEvent e) {
        String ageText = ageTextField.getText();
        String voterIdText = voterIdTextField.getText();
        String fullName = fullNameTextField.getText();
        String contactNumber = contactNumberTextField.getText();
        String gender = "";
        if (maleRadioButton.isSelected()) {
            gender = "Male";
        } else if (femaleRadioButton.isSelected()) {
            gender = "Female";
        } else if (otherRadioButton.isSelected()) {
            gender = "Other";
        }
        String city = (String) cityComboBox.getSelectedItem();
        String selectedParty = (String) partyComboBox.getSelectedItem();

        if (ageText.isEmpty() || voterIdText.isEmpty() || fullName.isEmpty() || contactNumber.isEmpty() || gender.isEmpty() || city.isEmpty() || selectedParty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill in all the details first, including selecting a party.", "Incomplete Form", JOptionPane.ERROR_MESSAGE);
        } else {
            if (!isNumeric(voterIdText)) {
                JOptionPane.showMessageDialog(this, "Invalid voter ID. Please enter a numeric value.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int age = Integer.parseInt(ageText);
            int voterId = Integer.parseInt(voterIdText);

            if (age < 18) {
                JOptionPane.showMessageDialog(this, "Age below 18. Not eligible to vote.", "Age Restriction", JOptionPane.ERROR_MESSAGE);
            } else {
                if (voterIds.contains(voterId)) {
                    JOptionPane.showMessageDialog(this, "This voter ID is already registered. Please enter a unique voter ID.", "Duplicate Voter ID", JOptionPane.ERROR_MESSAGE);
                } else {
                    voterIds.add(voterId);
                    incrementVoteCount(selectedParty); // Increment the vote count for the selected party
                    JOptionPane.showMessageDialog(this, "Thank you for your vote!");
                    displayVoteCounts(); // Display the current vote counts (optional, for testing)
                }
            }


            // Clear the text fields
            ageTextField.setText("");
            voterIdTextField.setText("");
            fullNameTextField.setText("");
            contactNumberTextField.setText("");

            // Clear the radio buttons
            maleRadioButton.setSelected(false);
            femaleRadioButton.setSelected(false);
            otherRadioButton.setSelected(false);

            // Clear the combo box selection
            cityComboBox.setSelectedIndex(0);
        }
    }

    /**
     * Checks if a given string is numeric.
     *
     * @param str The string to check.
     * @return true if the string is numeric, false otherwise.
     */

    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    /**
     * Increments the vote count for a given party.
     *
     * @param party The party to increment the vote count for.
     */

    private void incrementVoteCount(String party) {
        voteCountMap.put(party, voteCountMap.getOrDefault(party, 0) + 1);
    }

    /**
     * Displays the vote counts for all parties.
     */

    private void displayVoteCounts() {
        for (Map.Entry<String, Integer> entry : voteCountMap.entrySet()) {
            String party = entry.getKey();
            int voteCount = entry.getValue();
            System.out.println(party + ": " + voteCount);
        }
    }
}

/**
 * This class represents the registration user interface for the voting system.
 * It allows users to register by providing their details.
 */
class RegistrationUI {
    private JFrame frame;
    private JTextField nameTextField, phoneTextField;
    private JPasswordField passwordField;
    private JTextField boothIDTextField;
    private Map<String, String> registeredUsers;

    /**
     * Constructs a new RegistrationUI object and initializes the registration UI components.
     */
    public RegistrationUI() {
        frame = new JFrame("Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 220);
        frame.setLayout(new BorderLayout());

        registeredUsers = new HashMap<>();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameTextField = new JTextField();

        JLabel phoneLabel = new JLabel("Pincode:");
        phoneTextField = new JTextField();

        JLabel boothIDLabel = new JLabel("Booth ID:");
        boothIDTextField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String phone = phoneTextField.getText();
                String boothID = boothIDTextField.getText();
                char[] password = passwordField.getPassword();

                // Add your registration logic here
                if (name.isEmpty() || phone.isEmpty() || boothID.isEmpty() || password.length == 0) {
                    JOptionPane.showMessageDialog(frame, "Fill in all the details first.", "Incomplete Form", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (!isNumeric(boothID)) {
                        JOptionPane.showMessageDialog(frame, "Invalid Booth ID. Please enter a numeric value.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Register the user and store the information
                    registeredUsers.put(boothID, new String(password));
                    JOptionPane.showMessageDialog(frame, "Registration successful! You can now log in.");
                    frame.dispose(); // Close the registration window

                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new LoginUI(registeredUsers);
                        }
                    });
                }

                // Clear the text fields
                nameTextField.setText("");
                phoneTextField.setText("");
                boothIDTextField.setText("");
                passwordField.setText("");
            }
        });

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the registration window
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new LoginUI(registeredUsers);
                    }
                });
            }
        });

        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(phoneLabel);
        panel.add(phoneTextField);
        panel.add(boothIDLabel);
        panel.add(boothIDTextField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(registerButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(loginButton, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}

/**
 * This class represents the login user interface for the voting system.
 * It allows registered users to log in to the system.
 **/

class LoginUI {
    private JFrame frame;
    private JTextField boothIDoneField;
    private JPasswordField passwordField;
    private Map<String, String> registeredUsers;

    public LoginUI(Map<String, String> registeredUsers) {
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new BorderLayout());

        this.registeredUsers = registeredUsers;

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel boothIDoneLabel = new JLabel("Booth ID:");
        boothIDoneField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton submitButton = new JButton("Login");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String boothID = boothIDoneField.getText();
                char[] password = passwordField.getPassword();

                // Add your authentication logic here
                String storedPassword = registeredUsers.get(boothID);
                if (storedPassword == null || !storedPassword.equals(new String(password))) {
                    JOptionPane.showMessageDialog(frame, "Invalid Booth ID or password. Please try again.");
                    return;
                } else {
                    frame.dispose(); // Close the login window
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new SecureVotingSystem(registeredUsers);
                        }
                    });
                }
            }
        });

        panel.add(boothIDoneLabel);
        panel.add(boothIDoneField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(submitButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

/**
 * The main class that starts the secure voting system application.
 */
public class EVoting {
    /**
     * The main entry point of the application.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistrationUI();
            }
        });
    }
}


```
#### PartyRegistration.java
```
package com.amrita.jpl.cys21067.PROJECT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

/**
 * This class represents the party registration form.
 * It allows users to register a new political party by providing the party details and logo.
 */
class PartyRegistration extends JFrame implements ActionListener {
    JLabel titleLabel, partyNameLabel, partyLogoLabel, partyLeaderLabel, partySymbolLabel;
    JTextField partyNameTextField, partyLeaderTextField, partySymbolTextField;
    JButton browseButton, submitButton;
    JLabel selectedLogoLabel;
    File selectedLogoFile;

    /**
     * Constructs a new PartyRegistration object and initializes the party registration UI components.
     */
    public PartyRegistration() {
        setTitle("Party Registration");
        setSize(400, 350);
        setLayout(null);

        titleLabel = new JLabel("Party Registration");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setBounds(110, 10, 250, 40);
        add(titleLabel);

        partyNameLabel = new JLabel("Party Name");
        partyNameLabel.setBounds(50, 60, 100, 20);
        add(partyNameLabel);

        partyNameTextField = new JTextField();
        partyNameTextField.setBounds(160, 60, 150, 20);
        add(partyNameTextField);

        partyLogoLabel = new JLabel("Party Logo");
        partyLogoLabel.setBounds(50, 100, 100, 20);
        add(partyLogoLabel);

        browseButton = new JButton("Browse");
        browseButton.setBounds(160, 100, 80, 20);
        browseButton.addActionListener(this);
        add(browseButton);

        selectedLogoLabel = new JLabel();
        selectedLogoLabel.setBounds(250, 100, 100, 100);
        add(selectedLogoLabel);

        partyLeaderLabel = new JLabel("Party Leader");
        partyLeaderLabel.setBounds(50, 220, 100, 20);
        add(partyLeaderLabel);

        partyLeaderTextField = new JTextField();
        partyLeaderTextField.setBounds(160, 220, 150, 20);
        add(partyLeaderTextField);

        partySymbolLabel = new JLabel("Party Symbol");
        partySymbolLabel.setBounds(50, 260, 100, 20);
        add(partySymbolLabel);

        partySymbolTextField = new JTextField();
        partySymbolTextField.setBounds(160, 260, 150, 20);
        add(partySymbolTextField);

        submitButton = new JButton("Register");
        submitButton.setBounds(140, 300, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        setVisible(true);
    }

    /**
     * Handles the actionPerformed event for the browseButton and submitButton.
     * Performs actions based on the event source.
     *
     * @param e The ActionEvent instance.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == browseButton) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedLogoFile = fileChooser.getSelectedFile();
                ImageIcon logoIcon = new ImageIcon(selectedLogoFile.getPath());
                selectedLogoLabel.setIcon(logoIcon);
            }
        } else if (e.getSource() == submitButton) {
            String partyName = partyNameTextField.getText();
            String partyLeader = partyLeaderTextField.getText();
            String partySymbol = partySymbolTextField.getText();

            if (partyName.isEmpty() || partyLeader.isEmpty() || partySymbol.isEmpty() || selectedLogoFile == null) {
                JOptionPane.showMessageDialog(this, "Fill in all the details first.", "Incomplete Form", JOptionPane.ERROR_MESSAGE);
            } else {
                // Add your code here to handle party registration
                // ...

                JOptionPane.showMessageDialog(this, "Party registered successfully!");
                partyNameTextField.setText("");
                partyLeaderTextField.setText("");
                partySymbolTextField.setText("");
                selectedLogoLabel.setIcon(null);
                selectedLogoFile = null;
            }
        }
    }

    /**
     * The main entry point of the application.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        new PartyRegistration();
    }
}

```

### Demo
#### Screenshots

<p align="center">
<img src = "Assets/S2.png" width=400> <br/>
<img src = "Assets/S3.png" width=400> <br/>
<img src = "Assets/S4.png" width=400> <br/>
<img src = "Assets/S1.png" width=400> <br/>
</p>

#### Video

<p align="center">
<img src = "Assets/demo1.gif" width=500> <br/>
<img src = "Assets/demo2.gif" width=500> <br/>
</p>
