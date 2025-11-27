package bankingsystem;

public class ChequeAccount extends Account {
    private String employerName;
    private String employerAddress;

    public ChequeAccount(String accountNumber, String branch, Customer owner, double initialDeposit,
                         String employerName, String employerAddress) {
        super(accountNumber, branch, owner, initialDeposit);
        if (employerName == null || employerName.isEmpty()) {
            throw new IllegalArgumentException("Employer information required to open a Cheque Account.");
        }
        this.employerName = employerName;
        this.employerAddress = employerAddress;
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
        System.out.println("Cheque Account does not earn interest.");
    }

    public String getEmployerName() {
        return employerName;
    }

    public String getEmployerAddress() {
        return employerAddress;
    }
}
