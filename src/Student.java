public class Student {
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) throws InvalidGPAException {
        if (gpa < 0 || gpa > 10) {
            throw new InvalidGPAException("GPA must be between 0 and 10");
        }
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return gpa;
    }

    @Override
    public String toString() {
        return String.format("ID: %s - Name: %s - GPA: %.1f", id, name, gpa);
    }
}
