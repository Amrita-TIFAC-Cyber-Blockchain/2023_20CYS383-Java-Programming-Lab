package com.amrita.jpl.cys21023.mp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Simple_Text_Editor extends JFrame {
    public JTextArea textArea;
    public JButton saveButton;
    public JButton loadButton;

    public Simple_Text_Editor() {
        super("Java Swing Simple Text Editor");

        textArea = new JTextArea();
        saveButton = new JButton("Save File");
        loadButton = new JButton("Load File");

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SaveFile();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoadFile();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void SaveFile() {
        String file = JOptionPane.showInputDialog(this, "Enter file name : ");
        if (file != null) {
            try (PrintWriter txt = new PrintWriter(file)) {
                txt.write(textArea.getText());
                SavedSuccessfully("File Saved Successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void LoadFile() {
        String file = JOptionPane.showInputDialog(this, "Enter the file name:");
        if (file != null) {
            try (BufferedReader read = new BufferedReader(new FileReader(file))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = read.readLine()) != null) {
                    content.append(line).append("\n");
                }
                textArea.setText(content.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

       private void SavedSuccessfully(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Simple_Text_Editor();
            }
        });
    }
}
