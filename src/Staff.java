
import java.util.Date;

public abstract class Staff {
    protected String id;

    protected String fullName;

    protected Date birthday;

    protected int baseSalary;

    // Constructors
    public Staff(String id, String fullName, Date birthday, int baseSalary) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.baseSalary = baseSalary;
    }

    // Getters & Setters
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Methods
    public abstract int getSalary();

    public void displayInfo() {
        System.out.println(String.format("\t%s - %s", id, fullName));
        System.out.println(String.format("\t- Birthday: %s", birthday.toString()));
        System.out.println(String.format("\t- Base salary: %d", baseSalary));
    }
}
