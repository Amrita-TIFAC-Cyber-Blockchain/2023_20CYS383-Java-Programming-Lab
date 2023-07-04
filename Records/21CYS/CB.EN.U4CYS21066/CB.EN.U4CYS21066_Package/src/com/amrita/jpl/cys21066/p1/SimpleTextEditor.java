package com.amrita.jpl.cys21066.p1;

import javax.swing.*;
import java.io.*;

public class SimpleTextEditor extends JFrame {
    private JTextArea textArea;
    private JButton saveButton;
    private JButton loadButton;
    public SimpleTextEditor() {
        setTitle("Java Swing Simple Text Editor");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textArea = new JTextArea();
        saveButton = new JButton("Save"); //button name
        loadButton = new JButton("Load"); //button name

        saveButton.addActionListener(e -> saveFile());
        loadButton.addActionListener(e -> loadFile());

        JPanel panel = new JPanel();
        panel.add(saveButton); //add the save button
        panel.add(loadButton); //adds the load button

        getContentPane().add(textArea, "Center");
        getContentPane().add(panel, "South");
    }

    //class for the saving the file
    private void saveFile() {
        String fileName = JOptionPane.showInputDialog(this, "Enter file name:");

        if (fileName != null && !fileName.isEmpty()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(this, "File saved successfully.");
            } catch (IOException e) {
                showError("Error in saving file: " + e.getMessage());
            }
        }
    }

    //class for loading the file
    private void loadFile() {
        String fileName = JOptionPane.showInputDialog(this, "Enter file name:");

        if (fileName != null && !fileName.isEmpty()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                }
                textArea.setText(sb.toString());
                JOptionPane.showMessageDialog(this, "File loaded successfully.");
            } catch (IOException e) {
                showError("Error in  loading file: " + e.getMessage());
            }
        }
    }


    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleTextEditor editor = new SimpleTextEditor();
            editor.setVisible(true);
        });
    }
}

