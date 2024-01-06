import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankingSystemUI extends JFrame {

    private String username;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BankingSystemUI ui = new BankingSystemUI();
            ui.createLoginPage();
        });
    }

    private void createLoginPage() {
        setTitle("Banking System - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Create components
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");

        // Set icon for login button
        loginButton.setIcon(new ImageIcon("login_icon.png"));

        // Create layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        // Add action listener for the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform login authentication here
                // You can navigate to the next page if authentication is successful
                username = usernameField.getText();
                createAccountOverviewPage();
            }
        });

        // Set panel as content pane
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createAccountOverviewPage() {
        getContentPane().removeAll();
        setTitle("Banking System - Account Overview");

        // Create components
        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!");
        JButton transactionButton = new JButton("Make a Transaction");
        JButton userProfileButton = new JButton("User Profile");
        JButton logoutButton = new JButton("Logout");

        // Set icons for buttons
        transactionButton.setIcon(new ImageIcon("transaction_icon.png"));
        userProfileButton.setIcon(new ImageIcon("user_icon.png"));
        logoutButton.setIcon(new ImageIcon("logout_icon.png"));

        // Create layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(welcomeLabel);
        panel.add(transactionButton);
        panel.add(userProfileButton);
        panel.add(logoutButton);

        // Add action listener for the transaction button
        transactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate to the transaction page
                createTransactionPage();
            }
        });

        // Add action listener for the user profile button
        userProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate to the user profile page
                createUserProfilePage();
            }
        });

        // Add action listener for the logout button
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform logout operations here
                // You can navigate back to the login page
                createLoginPage();
            }
        });
        // Set panel as content pane and set background color
        panel.setBackground(new Color(240, 240, 240));
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createTransactionPage() {
        getContentPane().removeAll();
        setTitle("Banking System - Make a Transaction");

        // Create components
        JLabel amountLabel = new JLabel("Amount:");
        JTextField amountField = new JTextField(10);
        JButton confirmButton = new JButton("Confirm");
        JButton cancelButton = new JButton("Cancel");

        // Set icons for buttons
        confirmButton.setIcon(new ImageIcon("confirm_icon.png"));
        cancelButton.setIcon(new ImageIcon("cancel_icon.png"));

        // Create layout
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(confirmButton);
        panel.add(cancelButton);

        // Add action listener for the confirm button
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform transaction here
                // Display success or failure message
                JOptionPane.showMessageDialog(BankingSystemUI.this, "Transaction successful!");
                // You can navigate back to the account overview page
                createAccountOverviewPage();
            }
        });

        // Add action listener for the cancel button
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // You can navigate back to the account overview page
                createAccountOverviewPage();
            }
        });

        // Set panel as content pane and set background color
        panel.setBackground(new Color(240, 240, 240));
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createUserProfilePage() {
        getContentPane().removeAll();
        setTitle("Banking System - User Profile");

        // Create components
        JLabel profileLabel = new JLabel("User Profile");
        JLabel nameLabel = new JLabel("Name: John Doe");
        JLabel emailLabel = new JLabel("Email: johndoe@example.com");
        JButton backButton = new JButton("Back");

        // Set icons for buttons
        backButton.setIcon(new ImageIcon("back_icon.png"));

        // Create layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(profileLabel);
        panel.add(nameLabel);
        panel.add(emailLabel);
        panel.add(backButton);

        // Add action listener for the back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate back to the account overview page
                createAccountOverviewPage();
            }
        });

        // Set panel as content pane and set background color
        panel.setBackground(new Color(240, 240, 240));
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
