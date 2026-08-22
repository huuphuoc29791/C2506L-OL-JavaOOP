
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<Student> students;

    public static void main(String[] args) {
        students = loadStudents("students.csv");
        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    for (Student s : students) {
                        System.out.println(s);
                    }
                    break;
                case 2:
                    addNewStudent();
                    break;
                default:
                    saveStudents(students, "students.csv");
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("1. Display student list");
        System.out.println("2. Add new student");
        System.out.println("0. Quit");
        System.out.print("Choose function: ");
    }

    public static void addNewStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input ID: ");
        String id = scanner.nextLine();
        System.out.print("Input name: ");
        String name = scanner.nextLine();
        System.out.print("Input GPA: ");
        double gpa = scanner.nextDouble();
        try {
            students.add(new Student(id, name, gpa));
        } catch (InvalidGPAException e) {
            System.out.println("Invalid GPA: " + e.getMessage());
        }
    }

    public static void saveStudents(ArrayList<Student> students, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Student s : students) {
                bw.write(String.format("%s,%s,%f", s.getId(), s.getName(), s.getGPA()));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Cannot save students to file: " + e.getMessage());
        }
    }

    public static ArrayList<Student> loadStudents(String fileName) {
        ArrayList<Student> students = new ArrayList<Student>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {

                try {
                    String[] data = line.split(",");
                    students.add(new Student(data[0], data[1], Double.parseDouble(data[2])));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid GPA: " + line);
                } catch (InvalidGPAException e) {
                    System.out.println("Invalid GPA: " + e.getMessage());
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid student format: " + line);
                }

            }

        } catch (IOException e) {
            System.out.println("Cannot load students: " + e.getMessage());
        }
        return students;
    }
}