package bankingsystem;

public abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected String branch;
    protected Customer owner;

    public Account(String accountNumber, String branch, Customer owner, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.branch = branch;
        this.owner = owner;
        this.balance = initialDeposit;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getBranch() {
        return branch;
    }

    public Customer getOwner() {
        return owner;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited BWP " + amount + " successfully. New balance: BWP " + balance);
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    public abstract void withdraw(double amount);
    public abstract void applyInterest();
}
