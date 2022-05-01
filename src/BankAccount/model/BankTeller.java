package BankAccount.model;

import java.util.Scanner;

public class BankTeller {

    

    public void addNewClients() {

    }

    public void manageClients() {

    }

    public void createTransactions() {

    }

    public void returnClientReports() {

    }

    /**
     * Asks and takes input from user.
     */
    public void acceptConsole() {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter your BankAccount Number: ");
        ac = console.nextInt();

        System.out.println("Enter your BankAccount password: ");
        pw = console.nextInt();
    };
}
