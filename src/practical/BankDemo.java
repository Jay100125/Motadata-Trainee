package practical;

class Bank {
    private String bankName;
    private String ifscCode;
    private String branchName;

    public Bank(String bankName, String ifscCode, String branchName) {
        this.bankName = bankName;
        this.ifscCode = ifscCode;
        this.branchName = branchName;
    }

    public String getBranchName() {
        return branchName;
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private Bank bank;

    public BankAccount(String accountNumber, String accountHolderName, double balance, Bank bank) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = Math.max(0, balance);
        this.bank = bank;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
        else {
            System.out.println("Amount must be positive.");
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(this.accountNumber + " Have Insufficient balance!");
        }
        if(amount <= 0)
        {
            System.out.println(amount + ". Amount must be positive.");
        }
        balance -= amount;
        System.out.println("Withdrawal successful.");
    }

    public double getBalance() {
        return balance;
    }

    public String getBranchName() {
        return bank.getBranchName();
    }
}

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank("State Bank", "SBIN0001234", "Ahmedabad Branch");
        BankAccount account = new BankAccount("123456789", "Jay Patel", 5000.0, bank);
        BankAccount account2 = new BankAccount("987654321", "Jeet Patel", 7000, bank);
        BankAccount account3 = new BankAccount("3848403", "Jfanan Patel", -5000.0, bank);

        System.out.println(account3.getBalance());

        try {
            account.deposit(2000);
            account.deposit(-1000);
            account.withdraw(3000);
//            account2.deposit(2000);
//            account2.withdraw(13000);
            System.out.println("Balance: " + account.getBalance());
            System.out.println("Branch: " + account.getBranchName());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
