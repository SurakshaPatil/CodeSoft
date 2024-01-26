package Task3_ATM;

import java.util.Scanner;

public class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit(scanner);
                break;
            case 3:
                withdraw(scanner);
                break;
            case 4:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void checkBalance() {
        System.out.println("Current Balance: " + userAccount.getBalance());
    }

    private void deposit(Scanner scanner) {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            userAccount.deposit(amount);
            System.out.println("Deposit successful. New balance: " + userAccount.getBalance());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    private void withdraw(Scanner scanner) {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();

        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: " + userAccount.getBalance());
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }

}
