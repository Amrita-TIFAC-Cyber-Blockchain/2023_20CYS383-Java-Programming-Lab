import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JLabel targetUrlLabel;
    private JTextField targetUrlTextField;
    private JButton startAuditButton;

    public Main() {
        setTitle("E-Voting System Auditor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.DARK_GRAY);
        JLabel titleLabel = new JLabel("E-Voting System Auditor");
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        targetUrlLabel = new JLabel("Target URL:");
        targetUrlTextField = new JTextField(20);
        startAuditButton = new JButton("Start Audit");

        formPanel.add(targetUrlLabel);
        formPanel.add(targetUrlTextField);
        formPanel.add(startAuditButton);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);

        // Footer Panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.DARK_GRAY);
        JLabel footerLabel = new JLabel("\u00a9 2023 E-Voting System Auditor. All rights reserved.");
        footerLabel.setForeground(Color.WHITE);
        footerPanel.add(footerLabel);
        add(footerPanel, BorderLayout.SOUTH);

        // ActionListener for Start Audit Button
        startAuditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String targetUrl = targetUrlTextField.getText();
                // Perform security audit logic here
                System.out.println("Starting security audit for URL: " + targetUrl);
            }
        });

        pack();
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}
