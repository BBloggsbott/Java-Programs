package shape2d;

public class Square implements twod{
  public double side;
  public Square(double s){
    side=s;
  }
  public double area(){
    return side*side;
  }
  public double perimeter(){
    return 4*side;
  }
}
