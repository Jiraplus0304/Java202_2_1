package geometry;

public class Square implements Shape, HasColor {
    private final double side;
    private String color;
    public Square(String color, double side) { this.color = color; this.side = side; }
    @Override public double getPerimeter() { return side * 4.0; }
    @Override public double getArea() { return side * side; }
    @Override public String getColor() { return color; }
    @Override public void setColor(String color) { this.color = color; }
}
