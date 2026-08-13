
import java.util.Date;

public class Lecturer extends Staff {
    private int sessionCount;

    private double salaryMultiplier;

    // Constructor
    public Lecturer(
            String id,
            String fullName,
            Date birthday,
            int baseSalary,
            int sessionCount,
            double salaryMultiplier) {

        super(id, fullName, birthday, baseSalary);
        this.sessionCount = sessionCount;
        this.salaryMultiplier = salaryMultiplier;
    }

    // Methods
    @Override
    public int getSalary() {
        double salary = baseSalary * salaryMultiplier;
        if (sessionCount >= 60 && sessionCount < 80) {
            salary += 10000000;
        } else if (sessionCount >= 80 && sessionCount < 100) {
            salary += 15000000;
        }
        return (int) salary;
    }

    @Override
    public void displayInfo() {
        System.out.println("LECTURER");
        super.displayInfo();
        System.out.println(String.format("\t- Salary multiplier: %.1f", salaryMultiplier));
        System.out.println(String.format("\t- Session count: %d", sessionCount));
        System.out.println(String.format("\t- Salary: %,d", getSalary()));
    }
}
