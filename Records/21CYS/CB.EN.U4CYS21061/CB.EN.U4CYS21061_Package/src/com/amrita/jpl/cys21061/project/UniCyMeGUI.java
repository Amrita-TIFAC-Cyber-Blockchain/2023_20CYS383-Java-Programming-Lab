package com.amrita.jpl.cys21061.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class UniCyMeGUI extends JFrame implements ActionListener {
    private JButton selectFileButton;
    private JButton analyzeButton;
    private JLabel imageLabel;
    private JLabel resultLabel;
    private JLabel severityLabel;
    private ImageIcon backgroundImage;
    private String filePath;

    public UniCyMeGUI() {
        setTitle("Image Analyzer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());

        // Load and set the background image
        backgroundImage = new ImageIcon("C:\\Users\\roshn\\OneDrive\\Desktop\\Java Programming\\img.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        add(backgroundLabel);

        // Panel for holding buttons and labels
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new FlowLayout());

        // Tagline label
        JLabel taglineLabel = new JLabel("It's Not just Riding, it's a feeling!");
        taglineLabel.setForeground(Color.BLACK);
        panel.add(taglineLabel);

        // Select File button
        selectFileButton = new JButton("Select File");
        selectFileButton.addActionListener(this);
        panel.add(selectFileButton);

        // Analyze button
        analyzeButton = new JButton("Analyze");
        analyzeButton.addActionListener(this);
        analyzeButton.setEnabled(false); // Disable initially
        panel.add(analyzeButton);

        // Result labels
        resultLabel = new JLabel();
        panel.add(resultLabel);

        severityLabel = new JLabel();
        panel.add(severityLabel);

        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selectFileButton) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                filePath = selectedFile.getAbsolutePath();
                analyzeButton.setEnabled(true);
            }
        } else if (e.getSource() == analyzeButton) {
            // Display the analysis screen
            AnalysisScreen analysisScreen = new AnalysisScreen(this);
            analysisScreen.startAnalysis();
        }
    }

    // Method to display the analysis result
    public void showAnalysisResult(String analysisResult, String severity) {
        resultLabel.setText("Analysis Result: " + analysisResult);
        severityLabel.setText("Severity: " + severity);
    }

    // Method to analyze the file and determine if it's damaged or not
    public String analyzeFile(String filePath) {
        // Replace this with your own analysis logic
        // You can use libraries or custom algorithms based on the file type
        // Here's a placeholder implementation:
        if (filePath != null) {
            String fileType = getFileType(filePath);
            if (fileType.equals("image")) {
                // Perform image analysis
                // Return "Damaged" or "Not Damaged" based on the analysis
                return "Damaged";
            } else if (fileType.equals("document")) {
                // Perform document analysis
                // Return "Damaged" or "Not Damaged" based on the analysis
                return "Not Damaged";
            }
        }
        return "Not Damaged";
    }

    // Method to calculate the severity of the damage in the file
    public String calculateSeverity(String filePath) {
        // Replace this with your own severity calculation logic
        // You can analyze the file contents or metadata to determine the severity
        // Here's a placeholder implementation:
        if (filePath != null) {
            String fileType = getFileType(filePath);
            if (fileType.equals("image")) {
                // Perform image severity calculation
                // Return a severity level (e.g., Low, Medium, High)
                return "Medium";
            } else if (fileType.equals("document")) {
                // Perform document severity calculation
                // Return a severity level (e.g., Low, Medium, High)
                return "Low";
            }
        }
        return "Low";
    }

    // Method to determine the type of the file (image or document)
    public String getFileType(String filePath) {
        // Replace this with your own file type determination logic
        // You can use file extensions or other file properties to determine the type
        String extension = filePath.substring(filePath.lastIndexOf(".") + 1);
        if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("png")) {
            return "image";
        } else if (extension.equalsIgnoreCase("doc") || extension.equalsIgnoreCase("pdf")) {
            return "document";
        }
        return "unknown";
    }

    public static void main(String[] args) {
        // Set the look and feel to Nimbus for a light blue theme
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // Use the default look and feel if Nimbus is not available
        }

        SwingUtilities.invokeLater(UniCyMeGUI::new);
    }
}
