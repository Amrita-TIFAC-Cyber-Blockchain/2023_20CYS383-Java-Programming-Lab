package Com.Amrita.Jpl.cys21082;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class p2 {
    private JTextArea textArea;

    public p2() {
        JFrame frame = new JFrame("Simple Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        textArea = new JTextArea();
        frame.getContentPane().add(textArea, BorderLayout.CENTER);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new SaveButtonListener());
        JButton loadButton = new JButton("Load");
        loadButton.addActionListener(new LoadButtonListener());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private class SaveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String fileName = JOptionPane.showInputDialog("Enter file name:");
            if (fileName != null && !fileName.isEmpty()) {
                try {
                    FileWriter fileWriter = new FileWriter(fileName);
                    fileWriter.write(textArea.getText());
                    fileWriter.close();
                    JOptionPane.showMessageDialog(null, "File saved successfully!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving file: " + ex.getMessage());
                }
            }
        }
    }

    private class LoadButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String fileName = JOptionPane.showInputDialog("Enter file name to load:");
            if (fileName != null && !fileName.isEmpty()) {
                try {
                    FileReader fileReader = new FileReader(fileName);
                    BufferedReader reader = new BufferedReader(fileReader);
                    StringBuilder contents = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        contents.append(line);
                        contents.append(System.lineSeparator());
                    }
                    reader.close();
                    textArea.setText(contents.toString());
                    JOptionPane.showMessageDialog(null, "File loaded successfully!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error loading file: " + ex.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new p2();
            }
        });
    }
}