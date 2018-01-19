public class PointMain{
	public static void main(String[] args){
		double dist;
		//Point Declaration
		Point P1=new Point(3.25,7.89);
		Point P2=new Point(5.37,18.12);
		Point P3=new Point();
		//Point Initializtion
		P3=P2;
		//Displaying points
		System.out.println("Point 1: ");
		P1.display();
		System.out.println("Point 2: ");
		P2.display();
		System.out.println("Point 3: ");
		P3.display();
		//Finding distance between points
		dist=P1.findDistance(7.9,16.25);
		System.out.println("The distance between P1 and (7.9,16.25) is : " +dist);
		dist=P1.findDistance(P3);
		System.out.println("The distance between P1 and P3 is : "+dist);
	}
}
