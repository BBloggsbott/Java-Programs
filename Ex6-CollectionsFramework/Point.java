class Point{
	double x,y;
	Point(){
		x=0;
		y=0;
	}
	Point(double xx,double yy){
		x=xx;
		y=yy;
	}
	Point(Point p){
		x=p.x;
		y=p.y;
	}
	double findDistance(Point P1){
		double tx,ty,dist;
		tx=(x-P1.x);
		ty=(y-P1.y);
		tx=tx*tx;
		ty=ty*ty;
		dist=Math.sqrt(tx+ty);
		return dist;
	}
	
	double findDistance(double px, double py){
		double tx,ty,dist;
		tx=(x-px);
		ty=(y-py);
		tx=tx*tx;
		ty=ty*ty;
		dist=Math.sqrt(tx+ty);
		return dist;
	}
	public String toString(){
		return ("("+x+","+y+")");
	}
}