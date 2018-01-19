package shape3d;
import shape2d.*;


public class Sphere extends Circle implements threed{
  //double radius;
  public Sphere(double r){
    super(r);
  }
  public double volume(){
    return (4.0/3.0)*3.14159*radius*radius*radius;
  }
  public double surfaceArea(){
    return 4*3.14159*radius*radius;
  }
}
