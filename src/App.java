
public class App {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("VCB", 1000);
        acc.displayBalance();

        acc.deposit(325);
        acc.displayBalance();

        try {
            acc.withdraw(5000);
            acc.displayBalance();
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
