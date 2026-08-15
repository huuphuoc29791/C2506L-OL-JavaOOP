
import java.util.Date;

public class App {
    public static void main(String[] args) {
        StaffList l = new StaffList();
        l.add(new Lecturer("123", "Andy", new Date(1991, 7, 29), 100000, 35, 5.3));
        l.add(new OfficeStaff("456", "Brand", new Date(1992, 8, 24), 50000, 24));
        l.add(new Scientist("789", "Chris", new Date(1992, 8, 24), 65000, 150, 3));

        l.print(StaffType.LECTURER);
    }
}
