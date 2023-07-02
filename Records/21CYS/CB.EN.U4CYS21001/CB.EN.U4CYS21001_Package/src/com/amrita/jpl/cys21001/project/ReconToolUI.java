package com.amrita.jpl.cys21001.project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ReconToolUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField targetField;
    private JTextArea resultArea;
    private JButton runButton;
    private JButton cancelButton;
    private JProgressBar progressBar;
    private ReconTask reconTask;
    private DefaultTableModel tableModel;
    private JTable resultTable;

    public ReconToolUI() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });

        // Create layout
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel());
        loginPanel.add(loginButton);

        // Add components to the frame
        getContentPane().add(loginPanel);
    }

    private void performLogin() {
        String username = usernameField.getText();
        char[] password = passwordField.getPassword();

        // Replace with your authentication logic
        if (isValidCredentials(username, password)) {
            openReconTool();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }

        // Clear the password field
        passwordField.setText("");
    }

    private boolean isValidCredentials(String username, char[] password) {
        // Replace with your authentication validation logic
        // Here, we simply check if the username is "admin" and the password is "password"
        return username.equals("admin") && new String(password).equals("password");
    }

    private void openReconTool() {
        setTitle("Recon Tool");
        setSize(400, 400);
        getContentPane().removeAll();

        // Create components
        JLabel targetLabel = new JLabel("Target:");
        targetField = new JTextField(30);
        runButton = new JButton("Run");
        runButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performRecon();
            }
        });


        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelRecon();
            }
        });
        cancelButton.setEnabled(false);
        progressBar = new JProgressBar();
        resultArea = new JTextArea();
        resultArea.setEditable(false);

        // Create table model
        // Create table model
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Target Name");
        tableModel.addColumn("Result");
        resultTable = new JTable(tableModel);
        resultTable.setDefaultEditor(Object.class, null);
        JScrollPane tableScrollPane = new JScrollPane(resultTable);
        // Create layout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(targetLabel, BorderLayout.WEST);
        panel.add(targetField, BorderLayout.CENTER);
        panel.add(runButton, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(cancelButton);

        JPanel progressPanel = new JPanel();
        progressPanel.setLayout(new BorderLayout());
        progressPanel.add(progressBar, BorderLayout.NORTH);
        progressPanel.add(buttonPanel, BorderLayout.CENTER);

        // Add components to the frame
        getContentPane().add(panel, BorderLayout.NORTH);
        getContentPane().add(tableScrollPane, BorderLayout.CENTER);
        getContentPane().add(progressPanel, BorderLayout.SOUTH);




        runButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String target = targetField.getText().trim();
                if (target.isEmpty()) {
                    JOptionPane.showMessageDialog(ReconToolUI.this, "Please enter a target.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(ReconToolUI.this, "Starting recon on target: " + target, "Recon Started", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        });


        revalidate();
        repaint();
    }

    private void performRecon() {
        String target = targetField.getText().trim();
        if (target.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a target.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        runButton.setEnabled(false);
        cancelButton.setEnabled(true);
        progressBar.setValue(0);
        resultArea.setText("Running recon on target: " + target);

        reconTask = new ReconTask(target);
        reconTask.addPropertyChangeListener(new ProgressListener());
        reconTask.execute();
    }

    private void cancelRecon() {
        if (reconTask != null && !reconTask.isDone()) {
            reconTask.cancel(true);
            runButton.setEnabled(true);
            cancelButton.setEnabled(false);
            resultArea.append("\nRecon operation cancelled.");
        }
    }

    private class ReconTask extends SwingWorker<Void, Integer> {
        private String target;

        public ReconTask(String target) {
            this.target = target;
        }

        @Override
        protected Void doInBackground() throws Exception {
            // Simulating a long-running recon operation
            for (int progress = 0; progress <= 100; progress++) {
                Thread.sleep(100);
                publish(progress);
                if (isCancelled()) {
                    break;
                }
            }

            // Replace this with your actual recon code

            return null;
        }

        @Override
        protected void process(java.util.List<Integer> chunks) {
            int latestProgress = chunks.get(chunks.size() - 1);
            progressBar.setValue(latestProgress);
        }

        @Override
        protected void done() {
            runButton.setEnabled(true);
            cancelButton.setEnabled(false);
            progressBar.setValue(100);
            try {
                get(); // Retrieve the result if needed
                resultArea.append("\nRecon completed for target: " + target);

                // Add entry to the table
                tableModel.addRow(new Object[]{target, "Scan Completed"});
            } catch (Exception ex) {
                resultArea.append("\nRecon operation encountered an error: " + ex.getMessage());
            }
        }
    }

    private class ProgressListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if ("progress".equals(evt.getPropertyName())) {
                int progress = (Integer) evt.getNewValue();
                progressBar.setValue(progress);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ReconToolUI ui = new ReconToolUI();
                ui.setVisible(true);
            }
        });
    }
}
