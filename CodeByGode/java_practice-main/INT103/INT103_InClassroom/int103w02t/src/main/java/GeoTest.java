import geometry.*;
public class GeoTest {
   
    public static void main(String[] args) {
        Square s = new Square("Blue", 5.0); 
        System.out.println("Color: " + s.getColor());
        System.out.println("Perimeter: " + s.getPerimeter());// dynamic binding
        System.out.println("Area: " + s.getArea());
        HasColor h = s;
        h.setColor("Green");
        System.out.println("Color: " + s.getColor());
        ThickSquare ts = new ThickSquare("White", 8.0, 2.0);
        System.out.println("Color: " + ts.getColor());
        ThickShape th = ts;
        System.out.println("Thickness: " + th.getThickness());
        System.out.println("Volume: " + th.getVolume());
        System.out.println("Perimeter: " + th.getPerimeter());
    }
}
