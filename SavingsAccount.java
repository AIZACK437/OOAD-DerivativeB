package bankingsystem;

public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.0005; // 0.05% monthly

    public SavingsAccount(String accountNumber, String branch, Customer owner, double initialDeposit) {
        super(accountNumber, branch, owner, initialDeposit);
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawals are not allowed from a Savings Account.");
    }

    @Override
    public void applyInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Monthly interest of BWP " + interest + " applied. New balance: BWP " + balance);
    }
}
