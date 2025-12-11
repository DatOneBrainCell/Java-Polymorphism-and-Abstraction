import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    String accountNumber;
    String holderName;
    double balance;
    ArrayList<String> transactions;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }
}

public class ATMBankingSystem {
    static final String URL = "jdbc:mysql:                         
    static final String USER = "//localhost:3306/atm_db";
    static final String USER = "root";
    static final String PASS = "";
    static Scanner scan = new Scanner(System.in);
    static BankAccount account;

    public static void main(String[] args) {
        try {
            Class.forName("main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("MySQL Driver not found!");
        }

        System.out.print("Enter Account Number: ");
        String accountNumber = scan.next();
        System.out.print("Enter Holder Name: ");
        String holderName = scan.next();
        System.out.print("Enter Initial Balance: ");
        double balance = scan.nextDouble();

        account = new BankAccount(accountNumber, holderName, balance);

        while (true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int ch = scan.nextInt();
            switch (ch) {
                case 1 -> checkBalance();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> miniStatement();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void checkBalance() {
        System.out.println("checkBalance() {
        System.out.println("Balance: " + account.balance);
    }

    static void deposit() {
        System.out.print("deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scan.nextDouble();
        if (amount > 0) {
            account.balance += amount;
            account.transactions.add("Deposited: " + amount);
            if (account.transactions.size() > 5) {
                account.transactions.remove(0);
            }
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid amount!");
        }
    }

    static void withdraw() {
        System.out.print("withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scan.nextDouble();
        if (amount > 0 && amount <= account.balance) {
            account.balance -= amount;
            account.transactions.add("Withdrawn: " + amount);
            if (account.transactions.size() > 5) {
                account.transactions.remove(0);
            }
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Invalid amount!");
        }
    }

    static void miniStatement() {
        System.out.println("miniStatement() {
        System.out.println("Mini Statement:");
        for (String transaction : account.transactions) {
            System.out.println(transaction);
        }
    }
}
