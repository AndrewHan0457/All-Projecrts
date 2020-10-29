package Exercise3;

public class Trapezoid extends Quadrilateral {
	
	Double height;
	Double area;
	
	public Trapezoid(Point p1, Point p2, Point p3, Point p4) {
		super(p1, p2, p3, p4);
		// TODO Auto-generated constructor stub
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Coordinates of Trapezoid are: \n"+p[0]+", "+p[1]+", "+p[2]+", "+p[3]+
				"\nheight is£º" + height + "\narea is: " + area;
	}

	
}
