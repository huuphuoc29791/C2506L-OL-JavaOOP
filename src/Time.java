import java.util.Scanner;

public class Time {
    int hour;
    int minute;
    int second;

    public Time() {
        hour = minute = second = 0;
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void input(Scanner scanner) {
        do {
            hour = scanner.nextInt();
            minute = scanner.nextInt();
            second = scanner.nextInt();
        } while (!isValid());
    }

    public void output() {
        System.out.print(String.format("%02d:%02d:%02d", hour, minute, second));
    }

    public boolean isValid() {
        return (hour >= 0 && hour <= 23) &&
                (minute >= 0 && minute <= 59) &&
                (second >= 0 && second <= 59);
    }

    public int compare(Time t) {
        if (hour > t.hour)
            return 1;
        if (hour < t.hour)
            return -1;
        if (minute > t.minute)
            return 1;
        if (minute < t.minute)
            return -1;
        if (second > t.second)
            return 1;
        if (second < t.second)
            return -1;
        return 0;
    }

    public Time difference(Time t) {
        Time result = new Time();
        if (compare(t) == 0) {
            return result;
        }
        Time max = new Time();
        Time min = new Time();
        if (compare(t) == 1) {
            max = this;
            min = t;
        }
        if (compare(t) == -1) {
            max = t;
            min = this;
        }
        result.hour = max.hour - min.hour;
        result.minute = max.minute - min.minute;
        result.second = max.second - min.second;

        if (result.second < 0) {
            result.second += 60;
            result.minute--;
        }
        if (result.minute < 0) {
            result.minute += 60;
            result.hour--;
        }

        return result;
    }
}