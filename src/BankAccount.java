public class BankAccount {
    private String accountName;

    private double balance;

    public BankAccount(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(String.format("Deposited %.2f USD to account %s", amount, accountName));
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
        System.out.println(String.format("Withdrawn %.2f USD from account %s", amount, accountName));
    }

    public void displayBalance() {
        System.out.println("Account name: " + accountName);
        System.out.println(String.format("Balance: %.2f USD", balance));
    }
}
