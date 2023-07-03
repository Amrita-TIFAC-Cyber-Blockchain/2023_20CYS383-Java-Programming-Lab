package com.amrita.jpl.cys21064.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CP_GUI extends JFrame {
    private JTextArea textArea;
    private JButton[] buttons;

    private Map<String, List<String>> code;

    private void loadCode()
    {
        String filePath = "src\\com\\amrita\\jpl\\cys21015\\project\\JavaCP.java";
        try {
            // Read the file content as a single string
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // Split the content into an array of strings by new line character
            String[] tmp_lines = content.split("\\r?\\n");
            List<String> lines = new ArrayList<>();
            tmp_lines = Arrays.copyOfRange(tmp_lines, 4, tmp_lines.length-1);

            // Print each line in the array
            for (String line : tmp_lines) {
                try {
                    lines.add(line.substring(4));
                } catch (StringIndexOutOfBoundsException e) {
                    lines.add(line);
                }
            }

            lines.add("");
            lines.add("");

            List<String> tmp = new ArrayList<>();
            int switchFlag = 0;
            String algoName = "";
            code = new HashMap<>();
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).startsWith("// *")) {
                    switchFlag = 1;
                    algoName = lines.get(i).substring(4,lines.get(i).length()-1);
                } else if (lines.get(i).equals("}") && lines.get(i + 1).equals("") && lines.get(i + 2).equals("")) {
                    switchFlag = 0;
                    tmp.add(lines.get(i));
                    code.put(algoName, new ArrayList<>(tmp));
                    tmp.clear();
                }
                if (switchFlag == 1) {
                    tmp.add(lines.get(i));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CP_GUI() {
        // Create the JFrame
        super("CP Library");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 1000);
        setLayout(new BorderLayout());

        loadCode();

        // Create the title label
        JLabel titleLabel = new JLabel("CP Library - All Codes In One Place", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        add(titleLabel, BorderLayout.NORTH);

        // Create the buttons
        buttons = new JButton[5];
        buttons[0] = new JButton("Searching");
        buttons[1] = new JButton("Sorting");
        buttons[2] = new JButton("Arrays");
        buttons[3] = new JButton("Graphs");
        buttons[4] = new JButton("Miscellaneous");

        // Create the text area
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setRows(30);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 0, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 70, 20, 70));
        for (JButton button : buttons) {
            button.setPreferredSize(new Dimension(80, 30));
            buttonPanel.add(button);
        }

        // Create a panel for the text area with a border layout
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        textPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Add the button panel and text panel to the JFrame
        add(buttonPanel, BorderLayout.CENTER);
        add(textPanel, BorderLayout.SOUTH);

        // Add action listeners to the buttons
        for (JButton button : buttons) {
            button.addActionListener(new ButtonActionListener());
        }
    }

    private class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String[] options;

            // Set the options based on the button pressed
            if (source == buttons[0]) {
                options = new String[]{"Linear Search", "Binary Search"};
            } else if (source == buttons[1]) {
                options = new String[]{"Selection Sort", "Bubble Sort", "Insertion Sort", "Merge Sort", "Quick Sort"};
            } else if (source == buttons[2]) {
                options = new String[]{"Sum of Elements", "Frequency Map", "Kadane's Algorithm"};
            } else if (source == buttons[3]) {
                options = new String[]{"Breadth First Search", "Breadth First Search", "Dijsktra"};
            } else {
                options = new String[]{"Next Permutation", "Power Modulo", "Sieve of Eratosthenes"};
            }

            // Display the options and get user selection
            String selectedOption = (String) JOptionPane.showInputDialog(
                    CP_GUI.this,
                    "Select an algorithm:",
                    "Algorithms",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]);

            // Set the selected option in the text area
            if (selectedOption != null) {
                String output =  String.join("\n", code.get(selectedOption));
                textArea.setText("");
                textArea.insert(output,0);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CP_GUI app = new CP_GUI();
                app.setVisible(true);
            }
        });
    }
}
