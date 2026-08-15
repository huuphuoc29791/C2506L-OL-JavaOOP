
import java.util.ArrayList;

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
            if (staff.id == id) {
                return true;
            }
        }
        return false;
    }

    //// findIndex(): Find the index of the staff by id.
    public int findIndex(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id == id) {
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
}