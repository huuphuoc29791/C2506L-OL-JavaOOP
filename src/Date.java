
import java.util.Scanner;

public class Date {
    int day;
    int month;
    int year;

    int[] DAYS_IN_MONTH = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public Date() {
        day = month = year = 1;
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void input(Scanner scanner) {
        do {
            day = scanner.nextInt();
            month = scanner.nextInt();
            year = scanner.nextInt();
        } while (!isValid());
    }

    public void output() {
        System.out.print(String.format("%02d/%02d/%04d", day, month, year));
    }

    private boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || y % 400 == 0;
    }

    public boolean isValid() {
        if (year <= 0)
            return false;
        if (isLeapYear(year)) {
            DAYS_IN_MONTH[2] = 29;
        }
        if (month < 1 || month > 12)
            return false;
        if (day < 1 || day > DAYS_IN_MONTH[month])
            return false;
        return true;
    }

    private int toTotalDays() {
        DAYS_IN_MONTH[2] = 28;
        int result = 0;
        for (int y = 1; y < year; y++) {
            result += isLeapYear(y) ? 366 : 365;
        }
        for (int m = 1; m < month; m++) {
            result += DAYS_IN_MONTH[m];
            if (m == 2 && isLeapYear(year)) {
                result++;
            }
        }
        result += day;

        return result;
    }

    public int difference(Date d) {
        return Math.abs(toTotalDays() - d.toTotalDays());
    }
}
