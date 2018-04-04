import java.util.*;
class PointDemo{
	public static void main(String[] args){
		ArrayList<Point> points = new ArrayList<Point>();
		Scanner s=new Scanner(System.in);
		int n;
		
		System.out.println("Enter Number of Points: ");
		n=s.nextInt();
		
		for(int i=0;i<n;i++){
			System.out.println("Enter (x,y) for Point "+(i+1));
			points.add(new Point(new Point(s.nextDouble(),s.nextDouble())));
		}
		System.out.println("Points in Array List"+points+"\n\n");
		System.out.println("Distance Between Pairs of points:");
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				System.out.println(points.get(i)+" and "+points.get(j)+" is "+(points.get(i)).findDistance(points.get(j)));				
			}
		}
	}
	
}