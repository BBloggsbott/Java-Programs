package shape3d;
import shape2d.*;
public class Cuboid extends Rectangle implements threed{
  double height;
  public Cuboid(double l,double b,double h){
    super(l,b);
    height=h;
  }
  public double volume(){
    return length*breadth*height;
  }
  public double surfaceArea(){
    return 2*((length*breadth)+(length*height)+(breadth*height));
  }
}
