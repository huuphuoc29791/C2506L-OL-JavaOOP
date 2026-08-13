
import java.util.Date;

public class OfficeStaff extends Staff {
    private int workingHours;

    // Constructor
    public OfficeStaff(
            String id,
            String fullName,
            Date birthday,
            int baseSalary,
            int workingHours) {

        super(id, fullName, birthday, baseSalary);
        this.workingHours = workingHours;
    }

    // Methods
    @Override
    public int getSalary() {
        double salary = (baseSalary + 500000) * workingHours / 8;
        if (workingHours < 120) {
            salary *= 0.8;
        }
        return (int) salary;
    }

    @Override
    public void displayInfo() {
        System.out.println("OFFICE STAFF");
        super.displayInfo();
        System.out.println(String.format("\t- Working hours: %d", workingHours));
        System.out.println(String.format("\t- Salary: %,d", getSalary()));
    }
}
