# Project Description 

## Payment Management System
### Team mates
- CB.EN.U4CYS21082 - Umashankar Kavya
- CB.EN.U4CYS21030 - Kavali Sai Suvarchala 

## Project Description
A payment management system is essential for individuals and businesses to keep track of their payments, payment history, and payment methods. Without such a system, payment management can be cumbersome, leading to errors, payment delays, and other issues. Additionally, security is of utmost importance when it comes to payment management. A payment management system that ensures secure payment processing and protection of sensitive payment information is necessary to prevent fraud and protect the privacy of users.

### Code

```
import java.util.*;

/**
 * Represents a user in the payment management system.
 */
class User {
    private String username;
    private String password;
    private String dob;
    private String phoneNo;
    private double balance;
    private String cardNumber;

    /**
     * Constructor for creating a new user.
     *
     * @param username      The username of the user.
     * @param password      The password of the user.
     * @param dob           The date of birth of the user.
     * @param phoneNo       The phone number of the user.
     * @param balance       The balance in the user's account.
     */
    public User(String username, String password, String dob, String phoneNo, double balance) {
        this.username = username;
        this.password = password;
        this.dob = dob;
        this.phoneNo = phoneNo;
        this.balance = balance;
        this.cardNumber = generateCardNumber();
    }

    /**
     * Generates a random 16-digit card number.
     *
     * @return The randomly generated card number.
     */
    private String generateCardNumber() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int digit = rand.nextInt(10);
            sb.append(digit);
        }
        return sb.toString();
    }

    // Getters and Setters

    /**
     * Returns the username of the user.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the password of the user.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns the date of birth of the user.
     *
     * @return The date of birth.
     */
    public String getDob() {
        return dob;
    }

    /**
     * Returns the phone number of the user.
     *
     * @return The phone number.
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Returns the balance in the user's account.
     *
     * @return The account balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns the card number of the user.
     *
     * @return The card number.
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the balance in the user's account.
     *
     * @param balance The new account balance.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}

/**
 * Represents a payment management system.
 */
class PaymentManagementSystem {
    private List<User> users;
    private Scanner scanner;

    /**
     * Constructor for creating a payment management system.
     */
    public PaymentManagementSystem() {
        users = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Registers a new user in the system.
     */
    public void registerUser() {
        System.out.println("=== User Registration ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Date of Birth (DOB): ");
        String dob = scanner.nextLine();
        System.out.print("Phone No: ");
        String phoneNo = scanner.nextLine();
        System.out.print("Deposit Amount: ");
        double depositAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        User newUser = new User(username, password, dob, phoneNo, depositAmount);
        users.add(newUser);
        System.out.println("Registration Successful!");
    }

    /**
     * Allows a user to login to their account.
     *
     * @return The logged-in user.
     */
    public User userLogin() {
        System.out.println("=== User Login ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Allows the admin to login.
     *
     * @return True if the login is successful, false otherwise.
     */
    public boolean adminLogin() {
        System.out.println("=== Admin Login ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Transfers money from the user's account to another account using UPI.
     *
     * @param user The logged-in user.
     */
    public void transferMoneyUPI(User user) {
        System.out.println("=== Transfer Money using UPI ===");
        if (user != null) {
            System.out.print("Enter recipient UPI ID: ");
            String upiId = scanner.nextLine();
            System.out.print("Enter amount to transfer: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (password.equals(user.getPassword())) {
                if (amount > user.getBalance()) {
                    System.out.println("Insufficient balance!");
                } else {
                    System.out.println("Transferring " + amount + " to " + upiId + "...");
                    // Implement the logic here
                    // Update the user balance and perform the transaction
                    user.setBalance(user.getBalance() - amount);
                    System.out.println("Transaction successful!");
                }
            } else {
                System.out.println("Invalid password!");
            }
        } else {
            System.out.println("User not logged in!");
        }
    }

    /**
     * Transfers money from the user's account to another account using a card.
     *
     * @param user The logged-in user.
     */
    public void transferMoneyCard(User user) {
        System.out.println("=== Transfer Money using Card ===");
        if (user != null) {
            System.out.print("Enter recipient card number: ");
            String cardNumber = scanner.nextLine();
            System.out.print("Enter amount to transfer: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (password.equals(user.getPassword())) {
                if (amount > user.getBalance()) {
                    System.out.println("Insufficient balance!");
                } else {
                    System.out.println("Transferring " + amount + " to " + cardNumber + "...");
                    // Implement the logic here
                    // Update the user balance and perform the transaction
                    user.setBalance(user.getBalance() - amount);
                    System.out.println("Transaction successful!");
                }
            } else {
                System.out.println("Invalid password!");
            }
        } else {
            System.out.println("User not logged in!");
        }
    }

    /**
     * Allows the user to withdraw money from their account.
     *
     * @param user The logged-in user.
     */
    public void withdrawMoney(User user) {
        System.out.println("=== Withdraw Money ===");
        if (user != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (password.equals(user.getPassword())) {
                if (amount > user.getBalance()) {
                    System.out.println("Insufficient balance!");
                } else {
                    System.out.println("Withdrawing " + amount + "...");
                    // Implement the logic here
                    // Update the user balance and perform the withdrawal
                    user.setBalance(user.getBalance() - amount);
                    System.out.println("Withdrawal successful!");
                }
            } else {
                System.out.println("Invalid password!");
            }
        } else {
            System.out.println("User not logged in!");
        }
    }

    /**
     * Allows the user to deposit money into their account.
     *
     * @param user The logged-in user.
     */
    public void depositMoney(User user) {
        System.out.println("=== Deposit Money ===");
        if (user != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (password.equals(user.getPassword())) {
                System.out.println("Depositing " + amount + "...");
                // Implement the logic here
                // Update the user balance and perform the deposit
                user.setBalance(user.getBalance() + amount);
                System.out.println("Deposit successful!");
            } else {
                System.out.println("Invalid password!");
            }
        } else {
            System.out.println("User not logged in!");
        }
    }

    /**
     * Allows the user to view their account balance.
     *
     * @param user The logged-in user.
     */
    public void viewBalance(User user) {
        System.out.println("=== View Balance ===");
        if (user != null) {
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (password.equals(user.getPassword())) {
                System.out.println("Balance: " + user.getBalance());
            } else {
                System.out.println("Invalid password!");
            }
        } else {
            System.out.println("User not logged in!");
        }
    }

    /**
     * Allows the admin to view the card numbers of all users.
     */
    public void viewCardNumber() {
        System.out.println("=== View Card Number ===");
        // Implement the logic to retrieve and display card numbers here
    }

    /**
     * Displays the main menu for the user and handles user input.
     *
     * @param user The logged-in user.
     */
    public void userMenu(User user) {
        int choice;
        do {
            System.out.println("\n=== User Menu ===");
            System.out.println("1. Transfer money to another account using UPI");
            System.out.println("2. Transfer money to another account using card");
            System.out.println("3. Withdraw money");
            System.out.println("4. Deposit money");
            System.out.println("5. View card number");
            System.out.println("6. View balance");
            System.out.println("7. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    transferMoneyUPI(user);
                    break;
                case 2:
                    transferMoneyCard(user);
                    break;
                case 3:
                    withdrawMoney(user);
                    break;
                case 4:
                    depositMoney(user);
                    break;
                case 5:
                    System.out.println("Card Number: " + user.getCardNumber());
                    break;
                case 6:
                    viewBalance(user);
                    break;
                case 7:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);
    }

    /**
     * Displays the main menu for the admin and handles user input.
     */
    public void adminMenu() {
        if (adminLogin()) {
            System.out.println("Admin Login Successful!");

            int choice;
            do {
                System.out.println("\n=== Admin Menu ===");
                System.out.println("1. Transfer money to another account using UPI");
                System.out.println("2. Transfer money to another account using card");
                System.out.println("3. Withdraw money");
                System.out.println("4. Deposit money");
                System.out.println("5. View card number");
                System.out.println("6. View balance");
                System.out.println("7. Logout");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter password: ");
                        String password1 = scanner.nextLine();

                        if (adminLogin()) {
                            transferMoneyUPI(null); // Implement the admin functionality here
                        } else {
                            System.out.println("Invalid password!");
                        }
                        break;
                    case 2:
                        System.out.print("Enter password: ");
                        String password2 = scanner.nextLine();

                        if (adminLogin()) {
                            transferMoneyCard(null); // Implement the admin functionality here
                        } else {
                            System.out.println("Invalid password!");
                        }
                        break;
                    case 3:
                        System.out.print("Enter password: ");
                        String password3 = scanner.nextLine();

                        if (adminLogin()) {
                            withdrawMoney(null); // Implement the admin functionality here
                        } else {
                            System.out.println("Invalid password!");
                        }
                        break;
                    case 4:
                        System.out.print("Enter password: ");
                        String password4 = scanner.nextLine();

                        if (adminLogin()) {
                            depositMoney(null); // Implement the admin functionality here
                        } else {
                            System.out.println("Invalid password!");
                        }
                        break;
                    case 5:
                        viewCardNumber(); // Implement the admin functionality here
                        break;
                    case 6:
                        System.out.print("Enter password: ");
                        String password6 = scanner.nextLine();

                        if (adminLogin()) {
                            viewBalance(null); // Implement the admin functionality here
                        } else {
                            System.out.println("Invalid password!");
                        }
                        break;
                    case 7:
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 7);
        } else {
            System.out.println("Invalid username or password!");
        }
    }

    /**
     * The main program that runs the payment management system.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        PaymentManagementSystem paymentSystem = new PaymentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Payment Management System ===");
            System.out.println("1. Register");
            System.out.println("2. User Login");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    paymentSystem.registerUser();
                    break;
                case 2:
                    User user = paymentSystem.userLogin();
                    if (user != null) {
                        paymentSystem.userMenu(user);
                    } else {
                        System.out.println("Invalid username or password!");
                    }
                    break;
                case 3:
                    paymentSystem.adminMenu();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }
}

```

```

 import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Payment {
    private String paymentId;
    private String paymentType;
    private double amount;

    public Payment(String paymentId, String paymentType, double amount) {
        this.paymentId = paymentId;
        this.paymentType = paymentType;
        this.amount = amount;
    }

    // Getters and Setters

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

class PaymentManagementSystem {
    private List<Payment> paymentList;

    public PaymentManagementSystem() {
        this.paymentList = new ArrayList<>();
    }

    public void addPayment(Payment payment) {
        paymentList.add(payment);
        System.out.println("Payment added successfully.");
    }

    public void viewPayments() {
        if (paymentList.isEmpty()) {
            System.out.println("No payments found.");
        } else {
            System.out.println("Payment ID\tPayment Type\tAmount");
            for (Payment payment : paymentList) {
                System.out.println(
                        payment.getPaymentId() + "\t" +
                                payment.getPaymentType() + "\t" +
                                payment.getAmount()
                );
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentManagementSystem paymentSystem = new PaymentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Payment Management System");
            System.out.println("1. Add Payment");
            System.out.println("2. View Payments");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Payment ID: ");
                    String paymentId = scanner.next();
                    System.out.print("Enter Payment Type: ");
                    String paymentType = scanner.next();
                    System.out.print("Enter Amount: ");
                    double amount = scanner.nextDouble();

                    Payment payment = new Payment(paymentId, paymentType, amount);
                    paymentSystem.addPayment(payment);
                    break;

                case 2:
                    paymentSystem.viewPayments();
                    break;

                case 0:
                    exit = true;
                    System.out.println("Exiting Payment Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }
}

```
