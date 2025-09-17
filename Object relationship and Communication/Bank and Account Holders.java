import java.util.ArrayList;

class Account {
    private String accountNumber;
    private double balance;
    private Bank bank;

    public Account(String accountNumber, Bank bank) {
        this.accountNumber = accountNumber;
        this.bank = bank;
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public Bank getBank() {
        return bank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

class Customer {
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Customer: " + name);
        for (Account acc : accounts) {
            System.out.println("Account " + acc.getAccountNumber() + " at " + acc.getBank().getName() + " has balance: ₹" + acc.getBalance());
        }
    }
}

class Bank {
    private String name;

    public Bank(String name) {
        this.name = name;
    }

    public Account openAccount(String accountNumber, Customer customer) {
        Account account = new Account(accountNumber, this);
        customer.addAccount(account);
        return account;
    }

    public String getName() {
        return name;
    }
}

public class BankAssociationDemo {
    public static void main(String[] args) {
        Bank hdfc = new Bank("HDFC Bank");
        Bank sbi = new Bank("SBI Bank");

        Customer abhishek = new Customer("Abhishek");

        Account acc1 = hdfc.openAccount("HDFC123", abhishek);
        Account acc2 = sbi.openAccount("SBI456", abhishek);

        acc1.deposit(5000);
        acc2.deposit(3000);

        abhishek.viewBalance();
    }
}
