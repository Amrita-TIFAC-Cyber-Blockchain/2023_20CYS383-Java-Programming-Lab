package com.amrita.jpl.cys21060.project;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EPoliceCrimeInvestigationSystem extends JFrame implements ActionListener, ListSelectionListener {
    private JTextField crimeField;
    private JTextField placeField;
    private JTextField timeField;
    private JTextField dateField;
    private JTextArea descriptionArea;
    private JTable crimeTable;
    private DefaultTableModel crimeTableModel;
    private JButton reportButton;
    private JButton clearButton;
    private JButton viewButton;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JButton generateReportButton;
    private ArrayList<Crime> crimeLog;
    private Map<String, String> crimeDescriptionMap;

    public EPoliceCrimeInvestigationSystem() {
        setTitle("E-police Crime Investigation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        JLabel crimeLabel = new JLabel("Crime:");
        crimeField = new JTextField(15);
        JLabel placeLabel = new JLabel("Place:");
        placeField = new JTextField(15);
        JLabel timeLabel = new JLabel("Time:");
        timeField = new JTextField(15);
        JLabel dateLabel = new JLabel("Date:");
        dateField = new JTextField(15);
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionArea = new JTextArea(5, 20);
        reportButton = new JButton("Report");
        clearButton = new JButton("Clear");
        viewButton = new JButton("View");
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        searchButton = new JButton("Search");
        generateReportButton = new JButton("Generate Report");

        crimeTableModel = new DefaultTableModel();
        crimeTableModel.addColumn("Crime");
        crimeTableModel.addColumn("Place");
        crimeTableModel.addColumn("Time");
        crimeTableModel.addColumn("Date");
        crimeTable = new JTable(crimeTableModel);
        JScrollPane tableScrollPane = new JScrollPane(crimeTable);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(crimeLabel);
        inputPanel.add(crimeField);
        inputPanel.add(placeLabel);
        inputPanel.add(placeField);
        inputPanel.add(timeLabel);
        inputPanel.add(timeField);
        inputPanel.add(dateLabel);
        inputPanel.add(dateField);
        inputPanel.add(descriptionLabel);
        inputPanel.add(new JScrollPane(descriptionArea));

        JPanel actionPanel = new JPanel(new FlowLayout());
        actionPanel.add(viewButton);
        actionPanel.add(addButton);
        actionPanel.add(updateButton);
        actionPanel.add(deleteButton);
        actionPanel.add(generateReportButton);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(inputPanel, BorderLayout.CENTER);
        topPanel.add(actionPanel, BorderLayout.SOUTH);

        JPanel logPanel = new JPanel(new BorderLayout());
        logPanel.add(tableScrollPane, BorderLayout.CENTER);

        crimeLog = new ArrayList<>();
        crimeDescriptionMap = new HashMap<>();

        add(topPanel, BorderLayout.NORTH);
        add(logPanel, BorderLayout.CENTER);

        reportButton.addActionListener(this);
        clearButton.addActionListener(this);
        viewButton.addActionListener(this);
        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        searchButton.addActionListener(this);
        generateReportButton.addActionListener(this);
        crimeTable.getSelectionModel().addListSelectionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reportButton) {
            String crime = crimeField.getText();
            String place = placeField.getText();
            String time = timeField.getText();
            String date = dateField.getText();
            String description = descriptionArea.getText();
            if (!crime.isEmpty() && !place.isEmpty() && !time.isEmpty() && !date.isEmpty()) {
                Crime newCrime = new Crime(crime, place, time, date, description);
                crimeLog.add(newCrime);
                crimeDescriptionMap.put(crime, description);
                addCrimeToTable(newCrime);
                JOptionPane.showMessageDialog(this, "Crime reported: " + crime);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Please enter all the required information.");
            }
        } else if (e.getSource() == clearButton) {
            clearFields();
        } else if (e.getSource() == viewButton) {
            int selectedRow = crimeTable.getSelectedRow();
            if (selectedRow != -1) {
                String selectedCrime = (String) crimeTableModel.getValueAt(selectedRow, 0);
                String description = crimeDescriptionMap.get(selectedCrime);
                JOptionPane.showMessageDialog(this, "Crime Description:\n" + description);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a crime from the table.");
            }
        } else if (e.getSource() == addButton) {
            String crime = crimeField.getText();
            String place = placeField.getText();
            String time = timeField.getText();
            String date = dateField.getText();
            String description = descriptionArea.getText();
            if (!crime.isEmpty() && !place.isEmpty() && !time.isEmpty() && !date.isEmpty()) {
                Crime newCrime = new Crime(crime, place, time, date, description);
                crimeLog.add(newCrime);
                crimeDescriptionMap.put(crime, description);
                addCrimeToTable(newCrime);
                JOptionPane.showMessageDialog(this, "Crime added: " + crime);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Please enter all the required information.");
            }
        } else if (e.getSource() == updateButton) {
            int selectedRow = crimeTable.getSelectedRow();
            if (selectedRow != -1) {
                String updatedCrime = crimeField.getText();
                String updatedPlace = placeField.getText();
                String updatedTime = timeField.getText();
                String updatedDate = dateField.getText();
                String updatedDescription = descriptionArea.getText();
                if (!updatedCrime.isEmpty() && !updatedPlace.isEmpty() && !updatedTime.isEmpty() && !updatedDate.isEmpty()) {
                    Crime crimeToUpdate = crimeLog.get(selectedRow);
                    crimeToUpdate.setCrime(updatedCrime);
                    crimeToUpdate.setPlace(updatedPlace);
                    crimeToUpdate.setTime(updatedTime);
                    crimeToUpdate.setDate(updatedDate);
                    crimeToUpdate.setDescription(updatedDescription);
                    crimeDescriptionMap.put(updatedCrime, updatedDescription);
                    updateCrimeInTable(selectedRow, crimeToUpdate);
                    JOptionPane.showMessageDialog(this, "Crime updated successfully.");
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter all the required information.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a crime from the table.");
            }
        } else if (e.getSource() == deleteButton) {
            int selectedRow = crimeTable.getSelectedRow();
            if (selectedRow != -1) {
                String deletedCrime = (String) crimeTableModel.getValueAt(selectedRow, 0);
                crimeLog.remove(selectedRow);
                crimeDescriptionMap.remove(deletedCrime);
                crimeTableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Crime deleted successfully.");
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Please select a crime from the table.");
            }
        } else if (e.getSource() == searchButton) {
            String searchTerm = crimeField.getText();
            if (!searchTerm.isEmpty()) {
                ArrayList<String> searchResults = searchCrimes(searchTerm);
                if (searchResults.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No matching crimes found.");
                } else {
                    StringBuilder resultMessage = new StringBuilder("Matching Crimes:\n");
                    for (String result : searchResults) {
                        resultMessage.append(result).append("\n");
                    }
                    JOptionPane.showMessageDialog(this, resultMessage.toString());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a search term.");
            }
        } else if (e.getSource() == generateReportButton) {
            StringBuilder report = new StringBuilder("CRIME REPORT\n\n");
            report.append("Crimes:\n");
            for (Crime crime : crimeLog) {
                report.append("- Crime: ").append(crime.getCrime())
                        .append(", Place: ").append(crime.getPlace())
                        .append(", Time: ").append(crime.getTime())
                        .append(", Date: ").append(crime.getDate())
                        .append("\n");
                report.append("  Description: ").append(crime.getDescription()).append("\n");
            }

            JTextArea reportArea = new JTextArea(report.toString());
            reportArea.setEditable(false);
            JScrollPane reportScrollPane = new JScrollPane(reportArea);
            reportScrollPane.setPreferredSize(new Dimension(500, 300));
            JOptionPane.showMessageDialog(this, reportScrollPane, "Crime Report", JOptionPane.PLAIN_MESSAGE);
        }
    }

    class Crime {
        private String crime;
        private String place;
        private String time;
        private String date;
        private String description;

        public Crime(String crime, String place, String time, String date, String description) {
            this.crime = crime;
            this.place = place;
            this.time = time;
            this.date = date;
            this.description = description;
        }

        public String getCrime() {
            return crime;
        }

        public void setCrime(String crime) {
            this.crime = crime;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }


    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = crimeTable.getSelectedRow();
            if (selectedRow != -1) {
                String selectedCrime = (String) crimeTableModel.getValueAt(selectedRow, 0);
                String selectedPlace = (String) crimeTableModel.getValueAt(selectedRow, 1);
                String selectedTime = (String) crimeTableModel.getValueAt(selectedRow, 2);
                String selectedDate = (String) crimeTableModel.getValueAt(selectedRow, 3);
                String selectedDescription = crimeDescriptionMap.get(selectedCrime);

                crimeField.setText(selectedCrime);
                placeField.setText(selectedPlace);
                timeField.setText(selectedTime);
                dateField.setText(selectedDate);
                descriptionArea.setText(selectedDescription);
            }
        }
    }

    private void addCrimeToTable(Crime crime) {
        Object[] row = {crime.getCrime(), crime.getPlace(), crime.getTime(), crime.getDate()};
        crimeTableModel.addRow(row);
    }

    private void updateCrimeInTable(int rowIndex, Crime crime) {
        crimeTableModel.setValueAt(crime.getCrime(), rowIndex, 0);
        crimeTableModel.setValueAt(crime.getPlace(), rowIndex, 1);
        crimeTableModel.setValueAt(crime.getTime(), rowIndex, 2);
        crimeTableModel.setValueAt(crime.getDate(), rowIndex, 3);
    }

    private void clearFields() {
        crimeField.setText("");
        placeField.setText("");
        timeField.setText("");
        dateField.setText("");
        descriptionArea.setText("");
        crimeTable.clearSelection();
    }

    private ArrayList<String> searchCrimes(String searchTerm) {
        ArrayList<String> searchResults = new ArrayList<>();
        for (Crime crime : crimeLog) {
            if (crime.getCrime().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchResults.add(crime.getCrime());
            }
        }
        return searchResults;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EPoliceCrimeInvestigationSystem();
            }
        });
    }
}
