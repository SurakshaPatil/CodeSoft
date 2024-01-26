package Task3_ATM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a bank account with an initial balance
        BankAccount userAccount = new BankAccount(1000.0);

        // Create an ATM instance and connect it to the user's bank account
        ATM atm = new ATM(userAccount);

        while (true) {
            // Display ATM menu
            atm.displayMenu();

            // Get user choice
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            // Perform the selected transaction
            atm.performTransaction(choice, scanner);
        }
    }

}
