package bankingsystem;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String firstName;
    private String lastName;
    private String address;
    private List<Account> accounts;

    public Customer(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account " + account.getAccountNumber() + " added for customer " + firstName + ".");
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void listAccounts() {
        System.out.println("Accounts for " + getFullName() + ":");
        for (Account acc : accounts) {
            System.out.println("- " + acc.getClass().getSimpleName() + ": " + acc.getAccountNumber() + " (BWP " + acc.getBalance() + ")");
        }
    }
}
