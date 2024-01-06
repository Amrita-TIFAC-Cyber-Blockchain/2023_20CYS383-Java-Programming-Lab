package com.amrita.jpl.cys21043.p2;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SimpleTextEditor {
    private JTextArea textArea;

    public SimpleTextEditor() {
        JFrame frame = new JFrame("Java Swing Simple Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new SaveButtonListener());

        JButton loadButton = new JButton("Load");
        loadButton.addActionListener(new LoadButtonListener());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);



        frame.add(scrollPane);
        frame.add(buttonPanel, "South");
        frame.pack();
        frame.setVisible(true);

    }


    private class SaveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String fileName = JOptionPane.showInputDialog("Enter File Name:");
            if (fileName != null && !fileName.trim().isEmpty()) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                    writer.write(textArea.getText());
                    JOptionPane.showMessageDialog(null, "File saved successfully.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private class LoadButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String fileName = JOptionPane.showInputDialog("Enter File Name:");
            if (fileName != null && !fileName.trim().isEmpty()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                    StringBuilder content = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content.append(line).append("\n");
                    }
                    textArea.setText(content.toString());
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "File not found: " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error loading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimpleTextEditor();
            }
        });
    }
}

