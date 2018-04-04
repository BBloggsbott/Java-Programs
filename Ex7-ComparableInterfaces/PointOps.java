import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;


class Point{
	public double xval;
	public double yval;
	public Point(){
		this.xval = 0.0;
		this.yval = 0.0;
	}
	public Point(double x, double y){
		this.xval = x;
		this.yval = y;
	}
	public Point(Point oldPoint){
		this.xval = oldPoint.xval;
		this.yval = oldPoint.yval;
	}
	public double findDistance(double findX, double findY){
		return Math.sqrt( ((this.xval - findX)*(this.xval - findX)) + ((this.yval - findY)*(this.yval - findY)) );
	}
	public double findDistance(Point originPoint){
		return findDistance(originPoint.xval, originPoint.yval);
	}
	public void displayPoint(){
		System.out.println("Point : " + this);
	}
	public String toString(){
		return new String("( " + this.xval + " , " + this.yval + " )");
	}
	/*static class PointComparator implements Comparator<Point>{
		public int compare(Point a, Point b){
			double distanceA = a.findDistance(0.0, 0.0);
			double distanceB = b.findDistance(0.0, 0.0);
			if(distanceA > distanceB)	return 1;
			else if(distanceA < distanceB)	return -1;
			else	return 0;
		}
	}*/
}


public class PointOps{
	public static void main(String[] args){
		HashSet<Point> set = new HashSet<Point>(10);
		Scanner in = new Scanner(System.in);
		boolean enter = true;
		while(enter){
				System.out.print("POINT $ ");
				String command = in.nextLine().toLowerCase();
				String[] arguments = command.split(" ", 0);

			switch(arguments[0]){
			
				case "addpoint":
					set.add(new Point(Double.parseDouble(arguments[1]), Double.parseDouble(arguments[2])));
					break;
				case "distance":
					Iterator<Point> hi = set.iterator();
					Point first = hi.next();
					while(hi.hasNext()){
						Point next = hi.next();
						double distance = first.findDistance(next);
						System.out.println("Distance Between " + first + " & " + next + " = " + distance);
						first = next;
					}
					break;
				case "sortset":
					ArrayList<Point> list = new ArrayList<Point>(set);
					//Collections.sort(list, new Point.PointComparator());
					Collections.sort(list,new Comparator<Point>()
					{
						 
						public int compare(Point a, Point b)
						{
			              double distanceA = a.findDistance(0.0, 0.0);
			              double distanceB = b.findDistance(0.0, 0.0);
						  if(distanceA > distanceB)	{return 1;}
						  else if(distanceA < distanceB)	{return -1;}
			              else	
						  {return 0;}
		                }
					});
					System.out.println(list);
					/*Iterator i = list.iterator();
					while(i.hasNext()){
						first = (Point)i.next();
						first.displayPoint();
					}*/
					break;
				case "exit":
					enter = false;
					break;
				case "help":
					System.out.println("HELP :\nSYNTAX : ${command} <options>\n 1. addpoint - adds a point given as parameter into the set.\n 2. distance - finds the distance between consecutive elements of the set.\n 3. sortset - sorts the set and outputs the result.\n 4. exit - exits the program.\n 5. help - displays this help menu.\ndefault: shows help menu.");
					
					break;
				default:
					System.out.println("\nWrong Command !\nSYNTAX : ${command} <options>\nhere is the list of commands");
					
					System.out.println("HELP :\n 1. addpoint - adds a point given as parameter into the set.\n 2. distance - finds the distance between consecutive elements of the set.\n 3. sortset - sorts the set and outputs the result.\n 4. exit - exits the program.\n 5. help - displays this help menu.\ndefault: shows help menu.");
					break;
			}
		}
	}
}
