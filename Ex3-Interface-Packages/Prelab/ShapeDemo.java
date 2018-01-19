import shape2d.*;
import shape3d.*;

public class ShapeDemo{
  public static void main(String[] args) {
    Square sq = new Square(4);
    Rectangle r = new Rectangle(6,7);
    Circle c = new Circle(5);
    Cube cu = new Cube(4);
    Cuboid cb = new Cuboid(7,8,9);
    Sphere s = new Sphere(7);
    System.out.println("Square:\nArea: "+sq.area()+"\nPerimeter: "+sq.perimeter());
    System.out.println("Rectangle:\nArea: "+r.area()+"\nPerimeter: "+r.perimeter());
    System.out.println("Circle:\nArea: "+c.area()+"\nPerimeter: "+c.perimeter());
    System.out.println("Cube:\nVolume: "+cu.volume()+"\nSurface Area: "+cu.surfaceArea());
    System.out.println("Cuboid:\nVolume: "+cb.volume()+"\nSurface Area: "+cb.surfaceArea());
    System.out.println("Sphere:\nVolume: "+s.volume()+"\nSurface Area: "+s.surfaceArea());
  }
}
