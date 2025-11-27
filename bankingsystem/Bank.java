package bankingsystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Simple in-memory Bank repository/service.
 * - stores customers and accounts
 * - provides lookup by account number
 * - simple account-number generator
 *
 * This is intentionally simple for assignment/demo purposes.
 */
public class Bank {
    private static final Bank INSTANCE = new Bank();
    private final Map<String, Customer> customersByFullName = new HashMap<>();
    private final Map<String, Account> accountsByNumber = new HashMap<>();
    private final Random rnd = new Random();

    private Bank() {}

    public static Bank getInstance() {
        return INSTANCE;
    }

    public Customer createCustomer(String firstName, String lastName, String address) {
        String fullName = firstName.trim() + " " + lastName.trim();
        Customer existing = customersByFullName.get(fullName);
        if (existing != null) {
            return existing; // return existing to avoid duplicate objects with same name
        }
        Customer c = new Customer(firstName.trim(), lastName.trim(), address.trim());
        customersByFullName.put(c.getFullName(), c);
        return c;
    }

    public Customer findCustomerByFullName(String fullName) {
        return customersByFullName.get(fullName.trim());
    }

    public Account findAccount(String accountNumber) {
        if (accountNumber == null) return null;
        return accountsByNumber.get(accountNumber.trim());
    }

    private String generateAccountNumber() {
        // simple random account number prefixed with ACC
        int num = 100000 + rnd.nextInt(900000);
        return "ACC" + num;
    }

    /**
     * Open a new account for an existing customer and register it in the bank.
     * type: "savings", "cheque", "investment"
     * employerName used only for cheque accounts (may be null for others).
     */
    public Account openAccount(Customer owner, String type, String branch, double initialDeposit, String employerName) {
        if (owner == null) throw new IllegalArgumentException("Owner cannot be null");
        String accNum = generateAccountNumber();
        Account account;
        switch (type == null ? "" : type.toLowerCase()) {
            case "cheque":
            case "checking":
                account = new ChequeAccount(accNum, branch, owner, initialDeposit, employerName == null ? "" : employerName, "");
                break;
            case "investment":
                account = new InvestmentAccount(accNum, branch, owner, initialDeposit);
                break;
            case "savings":
            default:
                account = new SavingsAccount(accNum, branch, owner, initialDeposit);
                break;
        }
        accountsByNumber.put(accNum, account);
        owner.addAccount(account);
        return account;
    }

    public void applyInterestToAllAccounts() {
        for (Account a : accountsByNumber.values()) {
            a.applyInterest();
        }
    }
}