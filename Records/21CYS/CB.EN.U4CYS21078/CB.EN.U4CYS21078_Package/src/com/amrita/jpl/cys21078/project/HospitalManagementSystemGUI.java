package com.amrita.jpl.cys21078.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Aishwarya G - [CB.EN.U4CYS21003]
 * @author Alagu Soundarya G - [CB.EN.U4CYS21005]
 * @author Suvetha D P - [CB.EN.U4CYS21078]
 */
public class HospitalManagementSystemGUI {
    private JFrame frame;
    private List<Patient> patients;

    public HospitalManagementSystemGUI() {
        patients = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Hospital Management System");
        frame.setBounds(100, 100, 400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnDoctor = new JButton("Doctor");
        btnDoctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDoctorLoginPage();
            }
        });
        frame.getContentPane().add(btnDoctor);

        JButton btnPatient = new JButton("Patient");
        btnPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPatientLoginPage();
            }
        });
        frame.getContentPane().add(btnPatient);


    }
    private void showPatientLoginPage() {
        JFrame loginFrame = new JFrame("Patient Login");
        loginFrame.setBounds(100, 100, 300, 200);
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginFrame.getContentPane().setLayout(new BorderLayout());

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameTextField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = new String(passwordField.getPassword());

                // Add your authentication logic here
                boolean authenticated = authenticatePatient(username, password);

                if (authenticated) {
                    loginFrame.dispose();
                    showPatientPage();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
                }
            }
        });

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameTextField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel());
        loginPanel.add(loginButton);

        loginFrame.getContentPane().add(loginPanel, BorderLayout.CENTER);
        loginFrame.setVisible(true);
    }
    private boolean authenticatePatient(String username, String password) {
        // Add your authentication logic here
        // For demonstration purposes, let's assume there is a doctor with username "admin" and password "password"

        return username.equals("patient") && password.equals("password");
    }

    private void showDoctorLoginPage() {
        JFrame loginFrame = new JFrame("Doctor Login");
        loginFrame.setBounds(100, 100, 300, 200);
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginFrame.getContentPane().setLayout(new BorderLayout());

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameTextField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = new String(passwordField.getPassword());

                // Add your authentication logic here
                boolean authenticated = authenticateDoctor(username, password);

                if (authenticated) {
                    loginFrame.dispose();
                    showDoctorPage();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
                }
            }
        });

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameTextField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel());
        loginPanel.add(loginButton);

        loginFrame.getContentPane().add(loginPanel, BorderLayout.CENTER);
        loginFrame.setVisible(true);
    }


    private boolean authenticateDoctor(String username, String password) {
        // Add your authentication logic here
        // For demonstration purposes, let's assume there is a doctor with username "admin" and password "password"

        return username.equals("doctor") && password.equals("password");
    }
    private void showDoctorPage() {
        JFrame doctorFrame = new JFrame("Doctor");
        doctorFrame.setBounds(100, 100, 400, 200);
        doctorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        doctorFrame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnPatientList = new JButton("Patient List");
        btnPatientList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPatientListTable();
            }
        });
        doctorFrame.getContentPane().add(btnPatientList);

        JButton btnAppointments = new JButton("Appointments");
        btnAppointments.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAppointmentsPage();
            }
        });
        doctorFrame.getContentPane().add(btnAppointments);

        doctorFrame.setVisible(true);
    }

    private void showPatientPage() {
        JFrame patientFrame = new JFrame("Patient");
        patientFrame.setBounds(100, 100, 400, 200);
        patientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        patientFrame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnMedicalHistory = new JButton("Medical History");
        btnMedicalHistory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showMedicalHistoryPage();
            }
        });
        patientFrame.getContentPane().add(btnMedicalHistory);

        JButton btnAppointments = new JButton("Appointments");
        btnAppointments.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAppointmentsPage1();
            }
        });
        patientFrame.getContentPane().add(btnAppointments);

        JButton btnTestReports = new JButton("Test Reports");
        btnTestReports.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showTestReportsPage();
            }
        });
        patientFrame.getContentPane().add(btnTestReports);

        patientFrame.setVisible(true);
    }


    private void showPatientListTable() {
        JFrame patientListFrame = new JFrame("Patient List");
        patientListFrame.setBounds(100, 100, 600, 400);
        patientListFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        patientListFrame.getContentPane().setLayout(new BorderLayout());

        String[] columnNames = {"Patient ID", "Name", "Latest Visit", "Visiting Purpose", "Prescribed Medicines"};
        Object[][] data = {
                {"P001", "Aishwarya", "2023-06-25", "Fever", "Paracetamol"},
                {"P002", "Soundarya", "2023-06-27", "Cold and cough", "Cetirizine"}
        };
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        patientListFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        patientListFrame.setVisible(true);
    }


    private void showAppointmentsPage1() {
        JFrame appointmentsFrame = new JFrame("Appointments");
        appointmentsFrame.setBounds(100, 100, 600, 400);
        appointmentsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        appointmentsFrame.getContentPane().setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel newAppointmentsPanel = new JPanel();
        newAppointmentsPanel.setLayout(new BorderLayout());

        String[] newAppointmentsColumnNames = {"Appointment ID", "Patient ID", "Doctor ID", "Date", "Time"};
        Object[][] newAppointmentsData = {
                {"A001", "P001", "D001", "2023-06-25", "10:00 AM"},
                {"A002", "P001", "D002", "2023-06-27", "11:30 AM"}
                // Add more rows as needed
        };

        JTable newAppointmentsTable = new JTable(newAppointmentsData, newAppointmentsColumnNames);
        JScrollPane newAppointmentsScrollPane = new JScrollPane(newAppointmentsTable);
        newAppointmentsPanel.add(newAppointmentsScrollPane, BorderLayout.CENTER);


        tabbedPane.addTab("New Appointments", newAppointmentsPanel);
        appointmentsFrame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

        appointmentsFrame.setVisible(true);
    }

    private void showAppointmentsPage() {
        JFrame appointmentsFrame = new JFrame("Appointments");
        appointmentsFrame.setBounds(100, 100, 600, 400);
        appointmentsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        appointmentsFrame.getContentPane().setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel newAppointmentsPanel = new JPanel();
        newAppointmentsPanel.setLayout(new BorderLayout());

        String[] newAppointmentsColumnNames = {"Appointment ID", "Patient ID", "Doctor ID", "Date", "Time"};
        Object[][] newAppointmentsData = {
                {"A001", "P001", "D001", "2023-06-25", "10:00 AM"},
                {"A002", "P002", "D002", "2023-06-27", "11:30 AM"}
                // Add more rows as needed
        };

        JTable newAppointmentsTable = new JTable(newAppointmentsData, newAppointmentsColumnNames);
        JScrollPane newAppointmentsScrollPane = new JScrollPane(newAppointmentsTable);
        newAppointmentsPanel.add(newAppointmentsScrollPane, BorderLayout.CENTER);

        JPanel oldAppointmentsPanel = new JPanel();
        oldAppointmentsPanel.setLayout(new BorderLayout());

        String[] oldAppointmentsColumnNames = {"Appointment ID", "Patient ID", "Doctor ID", "Date", "Time", "Status"};
        Object[][] oldAppointmentsData = {
                {"A003", "P003", "D003", "2023-06-22", "09:00 AM", "Accepted"},
                {"A004", "P004", "D001", "2023-06-23", "02:30 PM", "Accepted"}
                // Add more rows as needed
        };

        JTable oldAppointmentsTable = new JTable(oldAppointmentsData, oldAppointmentsColumnNames);
        JScrollPane oldAppointmentsScrollPane = new JScrollPane(oldAppointmentsTable);
        oldAppointmentsPanel.add(oldAppointmentsScrollPane, BorderLayout.CENTER);

        tabbedPane.addTab("New Appointments", newAppointmentsPanel);
        tabbedPane.addTab("Old Appointments", oldAppointmentsPanel);

        appointmentsFrame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

        appointmentsFrame.setVisible(true);
    }

    private void showMedicalHistoryPage() {
        JFrame medicalHistoryFrame = new JFrame("Medical History");
        medicalHistoryFrame.setBounds(100, 100, 600, 400);
        medicalHistoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        medicalHistoryFrame.getContentPane().setLayout(new BorderLayout());

        String[] columnNames = {"Patient ID", "Medical Condition", "Treatment", "Start Date", "End Date"};
        Object[][] data = {
                {"P001", "Fever", "Paracetomol", "2023-06-22", "2023-07-01"},
                {"P001", "Cold and cough", "Cetirizine", "2023-06-23", "2023-06-30" }
                // Add more rows as needed
        };

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        medicalHistoryFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        medicalHistoryFrame.setVisible(true);
    }



    private void showTestReportsPage() {
        JFrame testReportsFrame = new JFrame("Test Reports");
        testReportsFrame.setBounds(100, 100, 600, 400);
        testReportsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        testReportsFrame.getContentPane().setLayout(new BorderLayout());

        String[] columnNames = {"Patient ID", "Test Name", "Result", "Date"};
        Object[][] data = {

                {"P001", "Blood Test", "Normal", "2023-06-22"},
                {"P001", "Blood Sugar level test", "Slightly higher than normal", "2023-06-23"}
                // Add more rows as needed
        };
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        testReportsFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        testReportsFrame.setVisible(true);
    }



    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HospitalManagementSystemGUI window = new HospitalManagementSystemGUI();
                    window.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private class Patient {
        private String patientID;
        private String name;
        private String latestVisit;
        private String visitingPurpose;
        private String prescribedMedicines;
        private List<MedicalHistory> medicalHistories;
        private List<TestReport> testReports;

        public Patient(String patientID, String name, String latestVisit, String visitingPurpose, String prescribedMedicines) {
            this.patientID = patientID;
            this.name = name;
            this.latestVisit = latestVisit;
            this.visitingPurpose = visitingPurpose;
            this.prescribedMedicines = prescribedMedicines;
            medicalHistories = new ArrayList<>();
            testReports = new ArrayList<>();
        }

        public String getPatientID() {
            return patientID;
        }

        public String getName() {
            return name;
        }

        public String getLatestVisit() {
            return latestVisit;
        }

        public String getVisitingPurpose() {
            return visitingPurpose;
        }

        public String getPrescribedMedicines() {
            return prescribedMedicines;
        }

        public List<MedicalHistory> getMedicalHistories() {
            return medicalHistories;
        }

        public List<TestReport> getTestReports() {
            return testReports;
        }
    }

    private class MedicalHistory {
        private String patientID;
        private String medicalCondition;
        private String treatment;
        private String startDate;
        private String endDate;

        public MedicalHistory(String patientID, String medicalCondition, String treatment, String startDate, String endDate) {
            this.patientID = patientID;
            this.medicalCondition = medicalCondition;
            this.treatment = treatment;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public String getPatientID() {
            return patientID;
        }

        public String getMedicalCondition() {
            return medicalCondition;
        }

        public String getTreatment() {
            return treatment;
        }

        public String getStartDate() {
            return startDate;
        }

        public String getEndDate() {
            return endDate;
        }
    }

    private class TestReport {
        private String patientID;
        private String testName;
        private String result;
        private String date;

        public TestReport(String patientID, String testName, String result, String date) {
            this.patientID = patientID;
            this.testName = testName;
            this.result = result;
            this.date = date;
        }

        public String getPatientID() {
            return patientID;
        }

        public String getTestName() {
            return testName;
        }

        public String getResult() {
            return result;
        }

        public String getDate() {
            return date;
        }
    }
}