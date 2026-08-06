public class Reactangle {
    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double value) {
        if (value < 0) {
            return;
        }
        width = value;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double value) {
        if (value < 0) {
            return;
        }
        height = value;
    }

    public double getPerimeter() {
        return (width + height) * 2;
    }

    public double getArea() {
        return width * height;
    }

    public boolean isSquare() {
        return width == height;
    }
}
