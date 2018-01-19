
class Point{
	double x,y;
	Point(){
		x=0.0;
		y=0.0;
	}

	Point( double px, double py){	//Constructor to intialize the data members
		x=px;
		y=py;
	}

	double findDistance(Point P1){ //Function to calculate the distance between two points using another object
		double tx,ty,dist;
		tx=(x-P1.x);
		ty=(y-P1.y);
		tx=tx*tx;
		ty=ty*ty;
		dist=Math.sqrt(tx+ty);
		return dist;
	}

	double findDistance(double px, double py){ //Function to calculate distance between who points using the values passed
		double tx,ty,dist;
		tx=(x-px);
		ty=(y-py);
		tx=tx*tx;
		ty=ty*ty;
		dist=Math.sqrt(tx+ty);
		return dist;
	}
	void display(){	//Function to display the point
		System.out.println("X : "+x);
		System.out.println("Y : "+y);
	}

}
