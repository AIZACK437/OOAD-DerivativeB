package bankingsystem;

public class InvestmentAccount extends Account {
    private static final double INTEREST_RATE = 0.05; // 5% monthly
    private static final double MIN_INITIAL_DEPOSIT = 500.0;

    public InvestmentAccount(String accountNumber, String branch, Customer owner, double initialDeposit) {
        super(accountNumber, branch, owner, initialDeposit);
        if (initialDeposit < MIN_INITIAL_DEPOSIT) {
            throw new IllegalArgumentException("Minimum initial deposit for Investment Account is BWP 500.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew BWP " + amount + " successfully. Remaining balance: BWP " + balance);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    @Override
    public void applyInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Monthly interest of BWP " + interest + " applied. New balance: BWP " + balance);
    }
}
