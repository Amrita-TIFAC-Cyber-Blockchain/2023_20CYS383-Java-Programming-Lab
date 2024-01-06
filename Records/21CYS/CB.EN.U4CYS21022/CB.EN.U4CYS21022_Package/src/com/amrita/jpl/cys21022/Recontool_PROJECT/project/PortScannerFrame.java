package com.amrita.jpl.cys21051.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class PortScannerFrame extends JFrame {

    private JTextField targetField;
    private JTextField startPortField;
    private JTextField endPortField;
    private JTextArea outputArea;

    private List<Integer> openPorts;
    private List<Integer> closedPorts;

    public PortScannerFrame() {
        setTitle("Port Scanner");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5); // Add padding

        // Add components to the main panel using GridBagLayout
        JLabel targetLabel = new JLabel("Target:");
        targetField = new JTextField(10);

        JLabel startPortLabel = new JLabel("Start Port:");
        startPortField = new JTextField(5);

        JLabel endPortLabel = new JLabel("End Port:");
        endPortField = new JTextField(5);

        JButton scanButton = new JButton("Scan");
        scanButton.addActionListener(e -> {
            String target = targetField.getText();
            int startPort = Integer.parseInt(startPortField.getText());
            int endPort = Integer.parseInt(endPortField.getText());
            scanPorts(target, startPort, endPort);
        });

        JButton downloadButton = new JButton("Download Results");
        downloadButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(PortScannerFrame.this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                saveResultsToFile(file);
            }
        });


        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReconToolFrame reconToolFrame = new ReconToolFrame();
                reconToolFrame.setVisible(true);
                dispose(); // Close the current frame
            }
        });

        // Add components to the main panel using GridBagConstraints
        constraints.gridx = 0;
        constraints.gridy = 0;
        mainPanel.add(targetLabel, constraints);

        constraints.gridx = 1;
        mainPanel.add(targetField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        mainPanel.add(startPortLabel, constraints);

        constraints.gridx = 1;
        mainPanel.add(startPortField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        mainPanel.add(endPortLabel, constraints);

        constraints.gridx = 1;
        mainPanel.add(endPortField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        mainPanel.add(scanButton, constraints);

        constraints.gridy = 4;
        mainPanel.add(downloadButton, constraints);

        constraints.gridy = 5;
        mainPanel.add(backButton, constraints);

        // Create output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Add the main panel and output area to the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    public void scanPorts(String target, int startPort, int endPort) {
        outputArea.setText(""); // Clear previous output

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        openPorts = new ArrayList<>();
        closedPorts = new ArrayList<>();

        for (int port = startPort; port <= endPort; port++) {
            int finalPort = port;
            executorService.execute(() -> {
                try {
                    Socket socket = new Socket();
                    socket.setSoTimeout(1000);
                    outputArea.append("Checking port " + finalPort + "\n");
                    socket.connect(new InetSocketAddress(target, finalPort), 1000);
                    socket.close();
                    openPorts.add(finalPort);
                    outputArea.append(finalPort + " port is open\n");
                } catch (IOException e) {
                    closedPorts.add(finalPort);
                }
            });
        }
        executorService.shutdown();
    }

    public void saveResultsToFile(File file) {
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println("Open Ports:");
            for (Integer port : openPorts) {
                writer.println(port);
            }

            writer.println("\nClosed Ports:");
            for (Integer port : closedPorts) {
                writer.println(port);
            }

            writer.flush();
            JOptionPane.showMessageDialog(PortScannerFrame.this, "Results saved successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(PortScannerFrame.this, "Error saving results: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PortScannerFrame portScannerFrame = new PortScannerFrame();
            portScannerFrame.setVisible(true);
        });
    }
}
