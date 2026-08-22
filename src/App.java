
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Student> students = loadStudents("students.csv");
        for (Student s : students) {
            System.out.println(s);
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
                String[] data = line.split(",");
                students.add(new Student(data[0], data[1], Double.parseDouble(data[2])));
            }
        } catch (IOException e) {
            System.out.println("Cannot load students: " + e.getMessage());
        }
        return students;
    }
}