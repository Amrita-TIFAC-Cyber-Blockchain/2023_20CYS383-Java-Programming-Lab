package com.amrita.jpl.cys21030.practice.gui.net.21030.practice
import java.util.Scanner


    class Payment {
        private String paymentMethod;
        private double amount;

        public Payment(String paymentMethod, double amount) {
            this.paymentMethod = paymentMethod;
            this.amount = amount;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public double getAmount() {
            return amount;
        }
    }

    class PaymentManager {
        private ArrayList<Payment> payments;

        public PaymentManager() {
            payments = new ArrayList<>();
        }

        public void addPayment(Payment payment) {
            payments.add(payment);
            System.out.println("Payment added: " + payment.getPaymentMethod() + ", Amount: $" + payment.getAmount());
        }

        public void displayPayments() {
            System.out.println("Payments:");
            for (Payment payment : payments) {
                System.out.println("Payment Method: " + payment.getPaymentMethod() + ", Amount: $" + payment.getAmount());
            }
        }
    }

    public class PaymentManagementSystem {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            PaymentManager paymentManager = new PaymentManager();

            while (true) {
                System.out.println("----- Payment Management System -----");
                System.out.println("1. Add Payment");
                System.out.println("2. Display Payments");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter payment method: ");
                        scanner.nextLine(); // Consume the newline character
                        String paymentMethod = scanner.nextLine();

                        System.out.print("Enter payment amount: $");
                        double amount = scanner.nextDouble();

                        Payment payment = new Payment(paymentMethod, amount);
                        paymentManager.addPayment(payment);
                        break;
                    case 2:
                        paymentManager.displayPayments();
                        break;
                    case 3:
                        System.out.println("Exiting the program...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

                System.out.println();
            }
        }
    }

}
