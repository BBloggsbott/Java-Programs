package shape3d;
import shape2d.*;
public class Cube extends Square implements threed{
  //double edge;
  public Cube(double e){
    super(e);
  }
  public double volume(){
    return side*side*side;
  }
  public double surfaceArea(){
    return 6*side*side;
  }
}
