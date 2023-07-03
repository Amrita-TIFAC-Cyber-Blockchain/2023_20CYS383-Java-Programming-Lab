import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserAuthenticationUI extends JFrame {
    private JLabel usernameLabel;
    private JTextField usernameTextField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;

    public UserAuthenticationUI() {
        setTitle("User Authentication");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        usernameLabel = new JLabel("Username:");
        usernameTextField = new JTextField();

        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        loginButton = new JButton("Login");

        formPanel.add(usernameLabel);
        formPanel.add(usernameTextField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(new JLabel());
        formPanel.add(loginButton);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);

        // Footer Panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.LIGHT_GRAY);
        JLabel footerLabel = new JLabel("© 2023 User Authentication System. All rights reserved.");
        footerPanel.add(footerLabel);
        add(footerPanel, BorderLayout.SOUTH);

        // ActionListener for Login Button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = new String(passwordField.getPassword());

                // Perform authentication logic here (e.g., check against a database)
                if (username.equals("admin") && password.equals("password")) {
                    JOptionPane.showMessageDialog(UserAuthenticationUI.this, "Login successful!");
                    // Proceed to authorized functionality
                    openAuthorizedFunctionality();
                } else {
                    JOptionPane.showMessageDialog(UserAuthenticationUI.this, "Invalid username or password!", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        pack();
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);
    }

    private void openAuthorizedFunctionality() {
        // Implement the functionality that is accessible to authorized users
        JOptionPane.showMessageDialog(this, "Welcome, authorized user! You can proceed to authorized functionality.");
        // Add your code here for the authorized functionality or open a new UI window
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserAuthenticationUI();
            }
        });
    }
}
