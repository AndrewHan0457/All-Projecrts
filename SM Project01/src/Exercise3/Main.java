package Exercise3;

public class Main {

	public static void main(String[] args) {
		// TODO Quadrilateral.
		Quadrilateral quad = new Quadrilateral(
				new Point(1.1, 1.2), 
				new Point(6.6, 2.8), 
				new Point(6.2, 9.9), 
				new Point(2.2, 7.4)
				);
		System.out.println(quad);
		// TODO Trap
		Trapezoid trap = new Trapezoid(
				new Point(0.0, 0.0), 
				new Point(10.0, 0.0), 
				new Point(8.0, 5.0), 
				new Point(3.3, 5.0)
				);
		trap.setArea(36.75);
		trap.setHeight(5.0);
		System.out.println(trap);
		//TOSO Para.
		
	}

}
