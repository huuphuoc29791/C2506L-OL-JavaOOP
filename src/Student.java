
import java.util.Scanner;

public class Student {
    String fullName;
    int age;
    double theoryGrade;
    double practicalGrade;

    double calcGPA() {
        return (theoryGrade + practicalGrade) / 2;
    }

    boolean isPassed() {
        return calcGPA() >= 4;
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
        System.out.println(String.format("GPA: %.1f", calcGPA()));
        if (isPassed()) {
            System.out.println("Result: Passed");
        } else {
            System.out.println("Result: Failed");
        }
    }
}
