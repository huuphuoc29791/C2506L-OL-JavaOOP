
import java.util.Date;

public class Scientist extends Staff {
    private int researchHours;

    private int researchProjects;

    // Constructor
    public Scientist(
            String id,
            String fullName,
            Date birthday,
            int baseSalary,
            int researchHours,
            int researchProjects) {

        super(id, fullName, birthday, baseSalary);
        this.researchHours = researchHours;
        this.researchProjects = researchProjects;
    }

    // Methods
    @Override
    public int getSalary() {
        double salary = baseSalary;
        if (researchHours < 80) {
            salary += 5000000;
        } else if (researchHours < 120) {
            salary += 8000000;
        } else {
            salary += 12000000 + Math.min((researchHours - 120) / 8 * 1000000, 4000000);
        }
        salary += Math.min(researchProjects * 3000000, 12000000);
        return (int) salary;
    }

    @Override
    public void displayInfo() {
        System.out.println("SCIENTIST");
        super.displayInfo();
        System.out.println(String.format("\t- Research hours: %d", researchHours));
        System.out.println(String.format("\t- Research projects: %d", researchProjects));
        System.out.println(String.format("\t- Salary: %,d", getSalary()));
    }
}
