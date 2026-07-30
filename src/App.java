
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Student student = new Student();
        Scanner sc = new Scanner(System.in);
        student.input(sc);
        student.displayInfo();
    }
}
