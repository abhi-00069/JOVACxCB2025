interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
    }

    public abstract double calculateInterest();

    public double getBalance() {
        return balance;
    }

    public String getDetails() {
        return holderName + " (" + accountNumber + ") - ₹" + balance;
    }
}

class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String acc, String name, double bal) {
        super(acc, name, bal);
    }

    public double calculateInterest() {
        return getBalance() * 0.04;
    }

    public void applyForLoan(double amount) {}

    public boolean calculateLoanEligibility() {
        return getBalance() > 10000;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(String acc, String name, double bal) {
        super(acc, name, bal);
    }

    public double calculateInterest() {
        return 0;
    }

    public void applyForLoan(double amount) {}

    public boolean calculateLoanEligibility() {
        return getBalance() > 5000;
    }
}

public class BankingDemo {
    public static void main(String[] args) {
        BankAccount[] accounts = {
            new SavingsAccount("S123", "Abhishek", 15000),
            new CurrentAccount("C456", "Ravi", 8000)
        };

        for (BankAccount acc : accounts) {
            System.out.println(acc.getDetails());
            System.out.println("Interest: ₹" + acc.calculateInterest());
            System.out.println("Loan Eligible: " + ((Loanable) acc).calculateLoanEligibility());
            System.out.println();
        }
    }
}
