public class App {
    public static void main(String[] args) {
        BankAccount A = new BankAccount("001325", "DUONG HUU PHUOC");
        BankAccount B = new BankAccount("007592", "NGUYEN VAN AN");

        A.setPIN("123456");
        A.deposit(100000000);
        A.displayInfo();
        System.out.println();

        A.withdraw(5000000);
        A.displayInfo();
        System.out.println();

        A.transfer(B, 25000000);
        A.displayInfo();
        B.displayInfo();
    }
}
