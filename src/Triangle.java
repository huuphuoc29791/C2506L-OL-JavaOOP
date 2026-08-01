
import java.util.Scanner;

public class Triangle {
    // Fields
    Point A;
    Point B;
    Point C;

    // Methods
    //// Constructor
    public Triangle() {
        A = new Point();
        B = new Point();
        C = new Point();
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" Input vertex A: ");
        A.input(scanner);
        System.out.print(" Input vertex B: ");
        B.input(scanner);
        System.out.print(" Input vertex C: ");
        C.input(scanner);
    }

    public void output() {
        System.out.println("3 vertices of triangle ABC:");
        A.output();
        B.output();
        C.output();
        System.out.println(String.format("Perimeter: %.2f", perimeter()));
        System.out.println(String.format("Area: %.2f", area()));
        if (isPerpendicular()) {
            System.out.println("This is a right triangle");
        } else {
            System.out.println("This is not a right triangle");
        }
    }

    public double perimeter() {
        return A.distanceTo(B) + B.distanceTo(C) + C.distanceTo(A);
    }

    public double area() {
        double AB = A.distanceTo(B);
        double BC = B.distanceTo(C);
        double CA = C.distanceTo(A);
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - AB) * (p - BC) * (p - CA));
    }

    public boolean isPerpendicular() {
        double a = B.distanceTo(C);
        double b = C.distanceTo(A);
        double c = A.distanceTo(B);
        return a * a == b * b + c * c ||
                b * b == c * c + a * a ||
                c * c == a * a + b * b;
    }
}
