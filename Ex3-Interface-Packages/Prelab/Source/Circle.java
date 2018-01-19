package shape2d;

public class Circle implements twod{
  public double radius;
  public Circle(double r){
    radius=r;
  }
  public double area(){
    return 3.14159*radius*radius;
  }
  public double perimeter(){
    return 3.14159*2*radius;
  }
}
