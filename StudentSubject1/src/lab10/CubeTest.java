package lab10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CubeTest {

	Cube cu = new Cube();
	@Test
	void test1() {
		double x = cu.posCube(4.0,4.0);
		assertEquals(256.0, x);
	}
	
	@Test
	void test2() {
		double y = cu.cubeRoot(27);
		assertEquals(3.0, y);
	}

	@Test
	void test3() {
		double[] bill = {1.0, 10.0, 2.0};
		double total = cu.totalCost(bill);
		assertEquals(13, total);
	}
}
