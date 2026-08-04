import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Time A = new Time();
        Time B = new Time();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input time A: ");
        A.input(scanner);
        System.out.print("Input time B: ");
        B.input(scanner);
        System.out.print("Time difference: ");
        A.difference(B).output();
    }
}
