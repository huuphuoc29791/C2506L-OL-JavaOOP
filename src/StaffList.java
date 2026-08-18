
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class StaffList {
    private ArrayList<Staff> list;

    // Constructors
    public StaffList() {
        list = new ArrayList<Staff>();
    }

    // Methods
    //// print(): Print all staffs in the list.
    public void print() {
        for (Staff staff : list) {
            staff.displayInfo();
        }
    }

    //// print(type): Print all staffs by type
    public void print(StaffType type) {
        for (Staff staff : list) {
            if (staff.type == type) {
                staff.displayInfo();
            }
        }
    }

    //// containsId(): Check if id exists in the list.
    public boolean containsId(String id) {
        for (Staff staff : list) {
            if (staff.id.equals(id)) {
                return true;
            }
        }
        return false;
    }

    //// findIndex(): Find the index of the staff by id.
    public int findIndex(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id.equals(id)) {
                return i;
            }
        }
        return -1;
    }

    //// add(): Add new staff to the list. If id exists, return false.
    public boolean add(Staff newStaff) {
        if (containsId(newStaff.id)) {
            return false;
        }
        list.add(newStaff);
        return true;
    }

    //// update(): Update staff by id. If not found, return false.
    public boolean update(String id, Staff newStaffData) {
        int index = findIndex(id);
        if (index == -1) {
            return false;
        }
        list.set(index, newStaffData);
        return true;
    }

    //// remove(): Remove staff by id. If not found, return false.
    public boolean remove(String id) {
        int index = findIndex(id);
        if (index == -1) {
            return false;
        }
        list.remove(index);
        return true;
    }

    //// filterBySalary(): List all staffs that has salary ≥ salary parameter
    public ArrayList<Staff> filterBySalary(int salary) {
        ArrayList<Staff> result = list.stream()
                .filter(s -> s.getSalary() >= salary)
                .collect(Collectors.toCollection(ArrayList::new));
        return result;
    }

    //// sortByName(): Sort staff list by name
    public ArrayList<Staff> sortByName() {
        ArrayList<Staff> result = list.stream()
                .sorted(Comparator.comparing(Staff::getFullName))
                .collect(Collectors.toCollection(ArrayList::new));
        return result;
    }
}