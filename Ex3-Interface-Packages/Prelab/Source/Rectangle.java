package shape2d;

public class Rectangle implements twod{
  public double length,breadth;
  public Rectangle(double l, double b){
    length=l;
    breadth=b;
  }
  public double area(){
    return length*breadth;
  }
  public double perimeter(){
    return 2*(length+breadth);
  }
}
