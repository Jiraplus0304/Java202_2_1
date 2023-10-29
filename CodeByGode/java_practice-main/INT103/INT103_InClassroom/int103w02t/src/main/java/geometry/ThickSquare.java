package geometry;

public class ThickSquare extends Square implements ThickShape {
    private final double thickness;
    public ThickSquare(String color, double side, double thickness) { 
        super(color, side); 
        this.thickness = thickness; 
    }
    @Override public double getVolume() { return thickness * getArea(); }
    @Override public double getThickness() { return thickness; }
    
}
