public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private int balance;
    private String pin;

    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        balance = 0;
        pin = "000000";
    }

    // Getter for accountName
    public String getAccountNummber() {
        return accountNumber;
    }

    // Getter & Setter for ownerName
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String value) {
        ownerName = value;
    }

    // Getter for balance
    public int getBalance() {
        return balance;
    }

    // Setter for pin
    public void setPIN(String value) {
        if (value.length() != 6) {
            System.out.println("PIN must be 6 digits");
            return;
        }
        pin = value;
    }

    // Methods
    public int deposit(int amount) {
        if (amount < 0) {
            System.out.println("Amount must be a positive integer");
        } else {
            balance += amount;
            System.out.println(String.format("Deposit: %d VND", amount));
        }
        return balance;
    }

    public int withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("Amount must be a positive integer");
        } else if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
            System.out.println(String.format("Withdrawn: %d VND", amount));
        }
        return balance;
    }

    public boolean transfer(BankAccount dest, int amount) {
        if (amount <= 0) {
            System.out.println("Amount must be a positive integer");
            return false;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance");
            return false;
        }
        balance -= amount;
        dest.balance += amount;
        System.out.println(
                String.format("Transfer to account %s - %s: %d VND", dest.accountNumber, dest.ownerName, amount));
        return true;
    }

    public void displayInfo() {
        System.out.println(String.format("Account number: %s", accountNumber));
        System.out.println(String.format("Owner's name': %s", ownerName));
        System.out.println(String.format("Balance: %d", balance));
    }
}
