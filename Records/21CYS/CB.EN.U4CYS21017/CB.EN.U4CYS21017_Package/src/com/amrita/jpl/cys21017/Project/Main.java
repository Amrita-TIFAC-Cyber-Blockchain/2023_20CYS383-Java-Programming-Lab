import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        JOptionPane.showMessageDialog(null, "Deposit successful. New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            JOptionPane.showMessageDialog(null, "Withdrawal successful. New balance: " + balance);
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient funds.");
        }
    }

    public void transfer(BankAccount destinationAccount, double amount) {
        if (balance >= amount) {
            balance -= amount;
            destinationAccount.deposit(amount);
            JOptionPane.showMessageDialog(null, "Transfer successful. New balance: " + balance);
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient funds.");
        }
    }
}

class BankingSystem {
    private List<BankAccount> accounts;
    private int accountNumberCounter;

    public BankingSystem() {
        accounts = new ArrayList<>();
        accountNumberCounter = 1;
    }

    public void createAccount(String accountHolderName, double initialDeposit) {
        BankAccount account = new BankAccount(accountNumberCounter++, accountHolderName, initialDeposit);
        accounts.add(account);
        JOptionPane.showMessageDialog(null, "Account created successfully.\nAccount number: " + account.getAccountNumber());
    }

    public BankAccount findAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public void deposit(int accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            JOptionPane.showMessageDialog(null, "Account not found.");
        }
    }

    public void withdraw(int accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            JOptionPane.showMessageDialog(null, "Account not found.");
        }
    }

    public void transfer(int sourceAccountNumber, int destinationAccountNumber, double amount) {
        BankAccount sourceAccount = findAccount(sourceAccountNumber);
        if (sourceAccount != null) {
            BankAccount destinationAccount = findAccount(destinationAccountNumber);
            if (destinationAccount != null) {
                sourceAccount.transfer(destinationAccount, amount);
            } else {
                JOptionPane.showMessageDialog(null, "Destination account not found.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Source account not found.");
        }
    }

    public double getAccountBalance(int accountNumber) {
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            return account.getBalance();
        } else {
            JOptionPane.showMessageDialog(null, "Account not found.");
            return -1;
        }
    }
}

class BankingSystemGUI {
    private BankingSystem bankingSystem;

    private JFrame frame;
    private JTextField accountHolderNameField;
    private JTextField initialDepositField;
    private JTextField accountNumberField;
    private JTextField depositAmountField;
    private JTextField withdrawalAmountField;
    private JTextField sourceAccountField;
    private JTextField destinationAccountField;
    private JTextField transferAmountField;
    private JTextField balanceAccountNumberField;

    public BankingSystemGUI() {
        bankingSystem = new BankingSystem();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Banking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(14, 2, 10, 10));

        JLabel accountHolderNameLabel = new JLabel("Account Holder Name:");
        accountHolderNameField = new JTextField();
        JLabel initialDepositLabel = new JLabel("Initial Deposit:");
        initialDepositField = new JTextField();
        JButton createAccountButton = new JButton("Create Account");

        JLabel accountNumberLabel = new JLabel("Account Number:");
        accountNumberField = new JTextField();
        JLabel depositAmountLabel = new JLabel("Deposit Amount:");
        depositAmountField = new JTextField();
        JButton depositButton = new JButton("Deposit");

        JLabel withdrawalAmountLabel = new JLabel("Withdrawal Amount:");
        withdrawalAmountField = new JTextField();
        JButton withdrawalButton = new JButton("Withdraw");

        JLabel sourceAccountLabel = new JLabel("Source Account:");
        sourceAccountField = new JTextField();
        JLabel destinationAccountLabel = new JLabel("Destination Account:");
        destinationAccountField = new JTextField();
        JLabel transferAmountLabel = new JLabel("Transfer Amount:");
        transferAmountField = new JTextField();
        JButton transferButton = new JButton("Transfer");

        JLabel balanceAccountNumberLabel = new JLabel("Account Number:");
        balanceAccountNumberField = new JTextField();
        JButton balanceButton = new JButton("View Balance");

        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String accountHolderName = accountHolderNameField.getText();
                double initialDeposit = Double.parseDouble(initialDepositField.getText());
                bankingSystem.createAccount(accountHolderName, initialDeposit);
                clearFields();
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int accountNumber = Integer.parseInt(accountNumberField.getText());
                double amount = Double.parseDouble(depositAmountField.getText());
                bankingSystem.deposit(accountNumber, amount);
                clearFields();
            }
        });

        withdrawalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int accountNumber = Integer.parseInt(accountNumberField.getText());
                double amount = Double.parseDouble(withdrawalAmountField.getText());
                bankingSystem.withdraw(accountNumber, amount);
                clearFields();
            }
        });

        transferButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int sourceAccountNumber = Integer.parseInt(sourceAccountField.getText());
                int destinationAccountNumber = Integer.parseInt(destinationAccountField.getText());
                double amount = Double.parseDouble(transferAmountField.getText());
                bankingSystem.transfer(sourceAccountNumber, destinationAccountNumber, amount);
                clearFields();
            }
        });

        balanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int accountNumber = Integer.parseInt(balanceAccountNumberField.getText());
                double balance = bankingSystem.getAccountBalance(accountNumber);
                if (balance >= 0) {
                    JOptionPane.showMessageDialog(null, "Account balance: " + balance);
                }
                clearFields();
            }
        });

        frame.add(accountHolderNameLabel);
        frame.add(accountHolderNameField);
        frame.add(initialDepositLabel);
        frame.add(initialDepositField);
        frame.add(new JLabel(""));
        frame.add(createAccountButton);

        frame.add(accountNumberLabel);
        frame.add(accountNumberField);
        frame.add(depositAmountLabel);
        frame.add(depositAmountField);
        frame.add(new JLabel(""));
        frame.add(depositButton);

        frame.add(withdrawalAmountLabel);
        frame.add(withdrawalAmountField);
        frame.add(new JLabel(""));
        frame.add(withdrawalButton);

        frame.add(sourceAccountLabel);
        frame.add(sourceAccountField);
        frame.add(destinationAccountLabel);
        frame.add(destinationAccountField);
        frame.add(transferAmountLabel);
        frame.add(transferAmountField);
        frame.add(new JLabel(""));
        frame.add(transferButton);

        frame.add(balanceAccountNumberLabel);
        frame.add(balanceAccountNumberField);
        frame.add(new JLabel(""));
        frame.add(balanceButton);

        frame.setVisible(true);
    }

    private void clearFields() {
        accountHolderNameField.setText("");
        initialDepositField.setText("");
        accountNumberField.setText("");
        depositAmountField.setText("");
        withdrawalAmountField.setText("");
        sourceAccountField.setText("");
        destinationAccountField.setText("");
        transferAmountField.setText("");
        balanceAccountNumberField.setText("");
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BankingSystemGUI();
            }
        });
    }
}