package  lab10;

public class Cube {

	public double posCube(double a, double b) {
		return Math.pow(a, b);
	}
	
	public double cubeRoot(double a) {
		return Math.pow(a, 1.0/3.0);
	}

	public double totalCost(double[] bill) {
		double total = 0.0;
		for (double d : bill) {
			total += d;
		}
		return total;
	}
	
}
