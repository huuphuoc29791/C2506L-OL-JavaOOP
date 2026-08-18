
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffManagerApp {
    private StaffList list;
    private int choice;

    public StaffManagerApp() {
        list = new StaffList();
        list.add(new Lecturer(
                "L001", "Nguyen Van An",
                LocalDate.of(1985, 4, 15),
                18000000, 55, 2.0

        ));

        list.add(new Scientist(
                "S001", "Nguyen Thanh Nam",
                LocalDate.of(1980, 5, 14),
                20000000, 70, 1

        ));

        list.add(new OfficeStaff(
                "O001", "Do Thi Hoa",
                LocalDate.of(1992, 3, 12),
                8000000, 100

        ));

        list.add(new Lecturer(
                "L002", "Tran Thi Binh",
                LocalDate.of(1988, 7, 20),
                20000000, 65, 2.2

        ));

        list.add(new OfficeStaff(
                "O002", "Hoang Van Khang",
                LocalDate.of(1989, 6, 25),
                9000000, 115

        ));

        list.add(new Scientist(
                "S002", "Tran Ngoc Oanh",
                LocalDate.of(1986, 8, 22),
                22000000, 100, 2

        ));

        list.add(new Scientist(
                "S003", "Le Quang Phuc",
                LocalDate.of(1983, 10, 3),
                25000000, 130, 4

        ));

        list.add(new Lecturer(
                "L003", "Le Hoang Cuong",
                LocalDate.of(1982, 2, 10),
                22000000, 85, 2.5

        ));

        list.add(new OfficeStaff(
                "O003", "Vo Thi Lan",
                LocalDate.of(1995, 9, 8),
                8500000, 160

        ));

        list.add(new Scientist(
                "S004", "Pham Thu Quynh",
                LocalDate.of(1987, 1, 30),
                24000000, 160, 6

        ));

        list.add(new OfficeStaff(
                "O004", "Bui Quoc Minh",
                LocalDate.of(1991, 1, 18),
                10000000, 180

        ));

        list.add(new Lecturer(
                "L004", "Pham Minh Dung",
                LocalDate.of(1990, 11, 5),
                17000000, 105, 1.8

        ));
    }

    public void run() {
        showMenu();
        switch (choice) {
            // Function: View all staffs
            case 1:
                list.print();
                break;
            // Function: View staffs by type
            case 2:
                viewStaffsByType();
                break;
            // Function: Add new staff
            case 3:
                break;
            // Function: Edit staff
            case 4:
                break;
            // Function: Delete staff
            case 5:
                deleteStaff();
                break;
            // Function: List all staffs having salary ≥ 50.000.000
            case 6:
                filterStaffBySalary();
                break;
            // Function: Sort by name
            case 7:
                sortByName();
                break;
        }
    }

    private void showMenu() {
        System.out.println("App functions:");
        System.out.println("1. View all staffs");
        System.out.println("2. View staffs by type");
        System.out.println("3. Add new staff");
        System.out.println("4. Edit staff");
        System.out.println("5. Delete staff");
        System.out.println("6. List all staffs having salary ≥ 50.000.000");
        System.out.println("7. Sort by name");
        System.out.print("Select a function: ");

        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        scanner.close();
    }

    private void viewStaffsByType() {
        System.out.println("List of staff types:");
        System.out.println("1. Lecturer");
        System.out.println("2. Scientist");
        System.out.println("3. Office Staff");
        System.out.print("Choose a staff type: ");
        StaffType chosenType = StaffType.LECTURER;
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                chosenType = StaffType.LECTURER;
                break;
            case 2:
                chosenType = StaffType.SCIENTIST;
                break;
            case 3:
                chosenType = StaffType.OFFICESTAFF;
                break;
        }
        list.print(chosenType);
        scanner.close();
    }

    private void deleteStaff() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input ID: ");
        String id = scanner.nextLine();
        System.out.print(id);
        if (list.remove(id)) {
            System.out.println("Staff deleted");
        } else {
            System.out.println("Error: Staff not found!");
        }
        scanner.close();
    }

    private void filterStaffBySalary() {
        ArrayList<Staff> result = list.filterBySalary(50000000);
        for (Staff staff : result) {
            staff.displayInfo();
        }
    }

    private void sortByName() {
        ArrayList<Staff> result = list.sortByName();
        for (Staff staff : result) {
            staff.displayInfo();
        }
    }
}
