import java.util.Scanner;

public class Point {
    // Fields
    double x;
    double y;

    // Methods
    //// Constructors
    public Point() {
        x = y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void input(Scanner sc) {
        x = sc.nextDouble();
        y = sc.nextDouble();
    }

    public void output() {
        System.out.println(String.format("\t(%.2f, %.2f)", x, y));
    }

    /// Calculate the distance between this Point to Point p.
    public double distanceTo(Point p) {
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }
}