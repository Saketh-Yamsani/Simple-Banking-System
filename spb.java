import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

class Bank {
    private Map<String, Double> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        JOptionPane.showMessageDialog(null, "Account created successfully!");
    }

    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            double newBalance = currentBalance + amount;
            accounts.put(accountNumber, newBalance);
            JOptionPane.showMessageDialog(null, "Deposit successful. New balance: " + newBalance);
        } else {
            JOptionPane.showMessageDialog(null, "Account not found!");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            if (currentBalance >= amount) {
                double newBalance = currentBalance - amount;
                accounts.put(accountNumber, newBalance);
                JOptionPane.showMessageDialog(null, "Withdrawal successful. New balance: " + newBalance);
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient funds!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Account not found!");
        }
    }

    public void checkBalance(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            JOptionPane.showMessageDialog(null, "Current balance: " + currentBalance);
        } else {
            JOptionPane.showMessageDialog(null, "Account not found!");
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();
        while (true) {
            String[] choices = {"Create Account", "Deposit", "Withdraw", "Check Balance", "Exit"};
            String choice = (String) JOptionPane.showInputDialog(null, "Banking System Menu:",
                    "Banking System", JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);

            switch (choice) {
                case "Create Account":
                    String accountNumber = JOptionPane.showInputDialog("Enter account number:");
                    double initialBalance = Double.parseDouble(JOptionPane.showInputDialog("Enter initial balance:"));
                    bank.createAccount(accountNumber, initialBalance);
                    break;

                case "Deposit":
                    accountNumber = JOptionPane.showInputDialog("Enter account number:");
                    double depositAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter deposit amount:"));
                    bank.deposit(accountNumber, depositAmount);
                    break;

                case "Withdraw":
                    accountNumber = JOptionPane.showInputDialog("Enter account number:");
                    double withdrawalAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter withdrawal amount:"));
                    bank.withdraw(accountNumber, withdrawalAmount);
                    break;

                case "Check Balance":
                    accountNumber = JOptionPane.showInputDialog("Enter account number:");
                    bank.checkBalance(accountNumber);
                    break;

                case "Exit":
                    JOptionPane.showMessageDialog(null, "Exiting the Banking System. Thank you!");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
