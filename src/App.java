
import java.util.Date;

public class App {
    public static void main(String[] args) {
        Staff s = new Scientist("126", "Andy Smith", new Date(1991, 7, 29), 12000000, 60, 3);
        s.displayInfo();
    }
}
