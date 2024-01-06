import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an address book application using Swing GUI.
 */
public class AddressBook extends JFrame {

    private JTable contactTable;
    private DefaultTableModel tableModel;

    private JTextField nameField;
    private JTextField phoneField;
    private JTextField emailField;

    private List<Contact> contacts;

    /**
     * Constructs the AddressBook object.
     */
    public AddressBook() {
        setTitle("21CYS Address Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main panel and set layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create the form panel and add labels and text fields
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Name: ");
        formPanel.add(nameLabel);

        nameField = new JTextField(30);
        formPanel.add(nameField);

        JLabel phoneLabel = new JLabel("Phone Number: ");
        formPanel.add(phoneLabel);

        phoneField = new JTextField(30);
        formPanel.add(phoneField);

        JLabel emailLabel = new JLabel("Email: ");
        formPanel.add(emailLabel);

        emailField = new JTextField(30);
        formPanel.add(emailField);

        // Create the button panel and add buttons
        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Add");
        buttonPanel.add(addButton);

        contacts = new ArrayList<>();
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addContact();
            }
        });

        JButton editButton = new JButton("Edit");
        buttonPanel.add(editButton);

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = contactTable.getSelectedRow();
                if (selectedRow >= 0) {
                    Contact contact = contacts.get(selectedRow);
                    editContact(contact);
                } else {
                    JOptionPane.showMessageDialog(AddressBook.this, "Please select a contact to edit!");
                }
            }
        });

        JButton deleteButton = new JButton("Delete");
        buttonPanel.add(deleteButton);

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = contactTable.getSelectedRow();
                if (selectedRow >= 0) {
                    contacts.remove(selectedRow);
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(AddressBook.this, "Please select a contact to delete!");
                }
            }
        });

        // Create the table with default table model
        tableModel = new DefaultTableModel(new Object[]{"Name", "Phone Number", "Email"}, 0);
        contactTable = new JTable(tableModel);

        // Create the scroll pane and add the table to it
        JScrollPane scrollPane = new JScrollPane(contactTable);

        // Add scroll pane, form panel, and button panel to the main panel
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the main panel to the content pane
        Container container = getContentPane();
        container.add(mainPanel);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    /**
     * Represents a contact in the address book.
     */
    class Contact {
        private String name;
        private String phoneNumber;
        private String email;

        public Contact(String name, String phoneNumber, String email) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    /**
     * Adds a new contact to the address book.
     */
    private void addContact() {
        String name = nameField.getText().trim();
        String phoneNumber = phoneField.getText().trim();
        String email = emailField.getText().trim();

        if (!name.isEmpty() && isValidPhoneNumber(phoneNumber) && isValidEmail(email)) {
            Contact contact = new Contact(name, phoneNumber, email);
            contacts.add(contact);
            tableModel.addRow(new Object[]{name, phoneNumber, email});
            clearFormFields();
        } else {
            JOptionPane.showMessageDialog(AddressBook.this, "Please enter valid contact details!");
        }
    }

    /**
     * Edits an existing contact in the address book.
     *
     * @param contact The contact to be edited.
     */
    private void editContact(Contact contact) {
        String name = nameField.getText().trim();
        String phoneNumber = phoneField.getText().trim();
        String email = emailField.getText().trim();

        if (!name.isEmpty() && isValidPhoneNumber(phoneNumber) && isValidEmail(email)) {
            contact.setName(name);
            contact.setPhoneNumber(phoneNumber);
            contact.setEmail(email);
            int row = contacts.indexOf(contact);
            tableModel.setValueAt(name, row, 0);
            tableModel.setValueAt(phoneNumber, row, 1);
            tableModel.setValueAt(email, row, 2);
            clearFormFields();
        } else {
            JOptionPane.showMessageDialog(AddressBook.this, "Please enter valid contact details!");
        }
    }

    /**
     * Validates a phone number.
     *
     * @param phone The phone number to validate.
     * @return true if the phone number is valid, false otherwise.
     */
    private boolean isValidPhoneNumber(String phone) {
        // Perform validation logic for phone number (e.g., length, format, etc.)
        return true;
    }

    /**
     * Validates an email address.
     *
     * @param email The email address to validate.
     * @return true if the email address is valid, false otherwise.
     */
    private boolean isValidEmail(String email) {
        // Perform validation logic for email (e.g., format, etc.)
        return true;
    }

    /**
     * Clears the form fields.
     */
    private void clearFormFields() {
        nameField.setText("");
        phoneField.setText("");
        emailField.setText("");
    }

    /**
     * The main entry point of the AddressBook application.
     *
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AddressBook().setVisible(true);
            }
        });
    }
}
