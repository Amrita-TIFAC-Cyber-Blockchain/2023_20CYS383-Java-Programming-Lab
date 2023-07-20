# 20CYS383 Java Programming Lab
![](https://img.shields.io/badge/Batch-21CYS-lightgreen) ![](https://img.shields.io/badge/UG-blue) ![](https://img.shields.io/badge/Subject-JPL-blue)
 
## OSINT Tool

### Project Description

<p text-align: justify;>This is a simple Java based user interface for an OSINT tool model to search for an username using Email, Social Media Platform, Phone Number. After entering the given the details and when clicked search buttom the input will get saved in a text document..</p>

### Code

#### OSINTtoolUI.java
```
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Kishanth K - [CB.EN.U4CYS21031] , Aishwarya GS - [CB.EN.U4CYS21004] ,Sri Sai Tanvi Sonti - [CB.EN.U4CYS21072]
 */
public class OSINTToolUI {
    private static final String FILE_NAME = "osint_tool_inputs.txt";

    private static void saveInputsToFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("OSINT Tool");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        JButton homeButton = new JButton("Home");
        JButton aboutButton = new JButton("About");
        JButton contactButton = new JButton("Contact");
        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Signup");

        topPanel.add(homeButton);
        topPanel.add(aboutButton);
        topPanel.add(contactButton);
        topPanel.add(loginButton);
        topPanel.add(signupButton);

        frame.add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());

        JLabel searchLabel = new JLabel("Search Details:");

        JLabel typeLabel = new JLabel("Type:");
        String[] types = {"Email", "Social Media Platform", "Phone Call"};
        JComboBox<String> typeComboBox = new JComboBox<>(types);

        JLabel socialMediaLabel = new JLabel("Social Media:");
        String[] socialMediaOptions = {"Instagram", "Facebook", "Twitter", "Reddit"};
        JComboBox<String> socialMediaComboBox = new JComboBox<>(socialMediaOptions);
        socialMediaComboBox.setEnabled(false);

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameTextField = new JTextField(20);

        JLabel emailLabel = new JLabel("Email Address:");
        JTextField emailTextField = new JTextField(20);

        JLabel phoneLabel = new JLabel("Phone Number:");
        JTextField phoneTextField = new JTextField(20);

        JLabel searchWebLabel = new JLabel("Search Web:");
        JCheckBox searchWebCheckBox = new JCheckBox();

        JLabel traceIPLabel = new JLabel("Trace IP address:");
        JCheckBox traceIPCheckBox = new JCheckBox();

        JLabel enterIPLabel = new JLabel("Enter IP:");
        JTextField ipTextField = new JTextField(20);
        ipTextField.setEnabled(false);

        JLabel searchIndustryLabel = new JLabel("Search for industry:");
        JCheckBox searchIndustryCheckBox = new JCheckBox();

        JLabel enterDomainLabel = new JLabel("Enter possible domain:");
        JTextField domainTextField = new JTextField(20);
        domainTextField.setEnabled(false);

        JButton searchButton = new JButton("Search");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        centerPanel.add(searchLabel, gbc);

        gbc.gridy = 1;
        centerPanel.add(typeLabel, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(typeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        centerPanel.add(socialMediaLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(socialMediaComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        centerPanel.add(usernameLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(usernameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        centerPanel.add(emailLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(emailTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        centerPanel.add(phoneLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(phoneTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        centerPanel.add(searchWebLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(searchWebCheckBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        centerPanel.add(traceIPLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(traceIPCheckBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        centerPanel.add(enterIPLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(ipTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        centerPanel.add(searchIndustryLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(searchIndustryCheckBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        centerPanel.add(enterDomainLabel, gbc);
        gbc.gridx = 1;
        centerPanel.add(domainTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        centerPanel.add(searchButton, gbc);

        frame.add(centerPanel, BorderLayout.CENTER);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog loginDialog = new JDialog(frame, "Login", true);
                loginDialog.setSize(300, 200);
                loginDialog.setLayout(new GridBagLayout());

                JLabel nameLabel = new JLabel("Name:");
                JTextField nameTextField = new JTextField(20);

                JLabel usernameLabel = new JLabel("Username:");
                JTextField usernameTextField = new JTextField(20);

                JLabel passwordLabel = new JLabel("Password:");
                JPasswordField passwordField = new JPasswordField(20);

                JButton loginDialogButton = new JButton("Log in");

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.anchor = GridBagConstraints.WEST;
                gbc.insets = new Insets(5, 5, 5, 5);

                loginDialog.add(nameLabel, gbc);
                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                loginDialog.add(nameTextField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.fill = GridBagConstraints.NONE;
                loginDialog.add(usernameLabel, gbc);
                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                loginDialog.add(usernameTextField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.fill = GridBagConstraints.NONE;
                loginDialog.add(passwordLabel, gbc);
                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                loginDialog.add(passwordField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 3;
                gbc.gridwidth = 2;
                gbc.anchor = GridBagConstraints.CENTER;
                loginDialog.add(loginDialogButton, gbc);

                loginDialog.setLocationRelativeTo(frame);
                loginDialogButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(loginDialog, "Login Successful");
                        loginDialog.dispose();
                    }
                });

                loginDialog.setVisible(true);
            }
        });

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog signupDialog = new JDialog(frame, "Sign Up", true);
                signupDialog.setSize(400, 350);
                signupDialog.setLayout(new GridBagLayout());

                JLabel nameLabel = new JLabel("Name:");
                JTextField nameTextField = new JTextField(20);

                JLabel ageLabel = new JLabel("Age:");
                JSpinner ageSpinner = new JSpinner(new SpinnerNumberModel(18, 1, 120, 1));

                JLabel designationLabel = new JLabel("Designation:");
                String[] designations = {"Worker", "Student"};
                JComboBox<String> designationComboBox = new JComboBox<>(designations);

                JLabel phoneNumberLabel = new JLabel("Phone Number:");
                JTextField phoneNumberTextField = new JTextField(20);

                JLabel usernameLabel = new JLabel("Username:");
                JTextField usernameTextField = new JTextField(20);

                JLabel passwordLabel = new JLabel("Password:");
                JPasswordField passwordField = new JPasswordField(20);

                JLabel retypePasswordLabel = new JLabel("Retype Password:");
                JPasswordField retypePasswordField = new JPasswordField(20);

                JButton signupDialogButton = new JButton("Sign up");

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.anchor = GridBagConstraints.WEST;
                gbc.insets = new Insets(5, 5, 5, 5);

                signupDialog.add(nameLabel, gbc);
                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                signupDialog.add(nameTextField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.fill = GridBagConstraints.NONE;
                signupDialog.add(ageLabel, gbc);
                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                signupDialog.add(ageSpinner, gbc);

                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.fill = GridBagConstraints.NONE;
                signupDialog.add(designationLabel, gbc);
                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                signupDialog.add(designationComboBox, gbc);

                gbc.gridx = 0;
                gbc.gridy = 3;
                gbc.fill = GridBagConstraints.NONE;
                signupDialog.add(phoneNumberLabel, gbc);
                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                signupDialog.add(phoneNumberTextField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 4;
                gbc.fill = GridBagConstraints.NONE;
                signupDialog.add(usernameLabel, gbc);
                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                signupDialog.add(usernameTextField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 5;
                gbc.fill = GridBagConstraints.NONE;
                signupDialog.add(passwordLabel, gbc);
                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                signupDialog.add(passwordField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 6;
                gbc.fill = GridBagConstraints.NONE;
                signupDialog.add(retypePasswordLabel, gbc);
                gbc.gridx = 1;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                signupDialog.add(retypePasswordField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 7;
                gbc.gridwidth = 2;
                gbc.anchor = GridBagConstraints.CENTER;
                signupDialog.add(signupDialogButton, gbc);

                signupDialogButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(signupDialog, "Successfully Signed Up!");
                        signupDialog.dispose();
                    }
                });

                signupDialog.setLocationRelativeTo(frame);
                signupDialog.setVisible(true);
            }
        });

        contactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog contactDialog = new JDialog(frame, "Contact", true);
                contactDialog.setSize(300, 200);
                contactDialog.setLayout(new BorderLayout());

                JLabel contactLabel = new JLabel("<html>For further details, contact<br>XX, this is a dummy address,<br>for example purpose, PINXXX<br>email: 123example@gmail.com<br>phone: +91XXXXXXXXXX</html>");
                contactLabel.setHorizontalAlignment(JLabel.CENTER);

                contactDialog.add(contactLabel, BorderLayout.CENTER);
                contactDialog.setLocationRelativeTo(frame);
                contactDialog.setVisible(true);
            }
        });

        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog aboutDialog = new JDialog(frame, "About", true);
                aboutDialog.setSize(300, 150);
                aboutDialog.setLayout(new BorderLayout());

                JLabel aboutLabel = new JLabel("<html>This is a simple Java based user interface for an OSINT tool model<br>Authors:<br>Aishwarya GS<br>Kishanth K<br>Sri Sai Tanvi Sonti</html>");
                aboutLabel.setHorizontalAlignment(JLabel.CENTER);

                aboutDialog.add(aboutLabel, BorderLayout.CENTER);
                aboutDialog.setLocationRelativeTo(frame);
                aboutDialog.setVisible(true);
            }
        });

        typeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) typeComboBox.getSelectedItem();
                socialMediaComboBox.setEnabled(selectedType.equals("Social Media Platform"));
                emailTextField.setEnabled(selectedType.equals("Email"));
                usernameTextField.setEnabled(selectedType.equals("Social Media Platform") || selectedType.equals("Phone Call"));
                phoneTextField.setEnabled(selectedType.equals("Phone Call"));
            }
        });

        traceIPCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ipTextField.setEnabled(traceIPCheckBox.isSelected());
            }
        });

        searchIndustryCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                domainTextField.setEnabled(searchIndustryCheckBox.isSelected());
            }
        });

        // Inside the "Search" button ActionListener
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Collect user inputs
                String type = (String) typeComboBox.getSelectedItem();
                String socialMedia = (String) socialMediaComboBox.getSelectedItem();
                String username = usernameTextField.getText();
                String email = emailTextField.getText();
                String phone = phoneTextField.getText();
                boolean searchWeb = searchWebCheckBox.isSelected();
                boolean traceIP = traceIPCheckBox.isSelected();
                String ip = ipTextField.getText();
                boolean searchIndustry = searchIndustryCheckBox.isSelected();
                String domain = domainTextField.getText();

                // Construct the content to save to the file
                StringBuilder content = new StringBuilder();
                content.append("Type: ").append(type).append("\n");
                if (type.equals("Social Media Platform")) {
                    content.append("Social Media: ").append(socialMedia).append("\n");
                }
                content.append("Username: ").append(username).append("\n");
                content.append("Email: ").append(email).append("\n");
                content.append("Phone: ").append(phone).append("\n");
                content.append("Search Web: ").append(searchWeb).append("\n");
                content.append("Trace IP: ").append(traceIP).append("\n");
                if (traceIP) {
                    content.append("IP Address: ").append(ip).append("\n");
                }
                content.append("Search Industry: ").append(searchIndustry).append("\n");
                if (searchIndustry) {
                    content.append("Domain: ").append(domain).append("\n");
                }

                // Save the inputs to the file
                saveInputsToFile(content.toString());

                // Perform search based on the selected options (You can add your search logic here)

                // Optionally, show a message dialog to indicate successful search
                JOptionPane.showMessageDialog(frame, "Search Completed and Inputs Saved to File!");
            }
        });

        // ... (rest of the code remains the same)

        frame.setVisible(true);
    }
}

```
### Demo
#### Screenshots

<p align="center">
<img width="470" alt="S1" src="https://github.com/kishanthkavi/20CYS383-Java-Programming-Lab/assets/92970289/ca51d46d-8363-4c17-8bcd-9901480557cd">
<img width="470" alt="S" src="https://github.com/kishanthkavi/20CYS383-Java-Programming-Lab/assets/92970289/8b65f9cb-a15e-4fae-afca-72cef264a475">
<img width="470" alt="L" src="https://github.com/kishanthkavi/20CYS383-Java-Programming-Lab/assets/92970289/299350be-c518-4865-9341-fb6606cc7e3b">
<img width="470" alt="L1" src="https://github.com/kishanthkavi/20CYS383-Java-Programming-Lab/assets/92970289/18baed9e-f995-45cb-948e-cb0eeb9b677b">
<img width="470" alt="L2" src="https://github.com/kishanthkavi/20CYS383-Java-Programming-Lab/assets/92970289/948bc708-3266-44c7-b82d-e20763d21f77">
<img width="470" alt="L3" src="https://github.com/kishanthkavi/20CYS383-Java-Programming-Lab/assets/92970289/9f20e362-267a-4a05-96c0-76a2aea12315">
<img width="470" alt="S2" src="https://github.com/kishanthkavi/20CYS383-Java-Programming-Lab/assets/92970289/283621dc-8a8e-433c-8d9d-d6e98556ec66">
<img width="470" alt="S3" src="https://github.com/kishanthkavi/20CYS383-Java-Programming-Lab/assets/92970289/5ead5488-561b-431c-b4b0-312acad41f7c">
<img width="470" alt="S4" src="https://github.com/kishanthkavi/20CYS383-Java-Programming-Lab/assets/92970289/a1cc28d5-e4fa-431f-8c83-5b1ae0bbc516">
<img width="470" alt="S5" src="https://github.com/kishanthkavi/20CYS383-Java-Programming-Lab/assets/92970289/c0b234ee-7454-47ac-906f-14eb801be2b4">
<img width="470" alt="S6" src="https://github.com/kishanthkavi/20CYS383-Java-Programming-Lab/assets/92970289/5674c6d2-f2b1-4a4d-875b-4090030b921a">

</p>

#### Video
<p align="center">
<img width="470" alt="S6" src="https://github.com/kishanthkavi/20CYS383-Java-Programming-Lab/assets/92970289/b1db668c-2ee3-4e0c-969b-bed3428d5ba8">
</p>
