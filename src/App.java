public class App {
    public static void main(String[] args) {
        Shape x = new Rectangle(5, 3);
        Shape y = new Square(8);
        Shape z = new Triangle(3, 4, 5);

        System.out.println(z.getPerimeter());
        System.out.println(z.getArea());
    }
}