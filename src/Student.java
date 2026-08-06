
import java.util.Scanner;

public class Student {
    private String fullName;
    private int age;
    private double theoryGrade;
    private double practicalGrade;

    // Getter & Setter
    public int getAge() {
        return age;
    }

    public void setAge(int value) {
        if (value < 0) {
            return;
        }
        age = value;
    }

    public double getGPA() {
        return (theoryGrade + practicalGrade) / 2;
    }

    public boolean isPassed() {
        return getGPA() >= 5;
    }

    void input(Scanner sc) {
        System.out.print("Enter full name: ");
        fullName = sc.nextLine();
        System.out.print("Enter age: ");
        age = sc.nextInt();
        System.out.print("Enter theory and pratical grade: ");
        theoryGrade = sc.nextDouble();
        practicalGrade = sc.nextDouble();
    }

    void displayInfo() {
        System.out.println(String.format("Full name: %s", fullName));
        System.out.println(String.format("Age: %d", age));
        System.out.println(String.format("GPA: %.1f", getGPA()));
        if (isPassed()) {
            System.out.println("Result: Passed");
        } else {
            System.out.println("Result: Failed");
        }
    }
}