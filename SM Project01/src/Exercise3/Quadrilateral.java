package Exercise3;

public class Quadrilateral {
	
	Point[] p = new Point[4];
	
	public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
		this.p[0] = p1;
		this.p[1] = p2;
		this.p[2] = p3;
		this.p[3] = p4;
	}
	
	@Override
	public String toString() {
		return "Coordinates of Quadrilateral are: \n"+p[0]+", "+p[1]+", "+p[2]+", "+p[3];
	}
	
}