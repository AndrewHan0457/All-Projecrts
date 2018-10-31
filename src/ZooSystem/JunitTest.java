package ZooSystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class JunitTest {
	double salary = 1000.0;
	Employee employee = new ZooKeeper("Andrew Han");
	double expectSalary;
	Enclosure enclosure = new Enclosure();
	
	public JunitTest() {
		// TODO Auto-generated constructor stub
		employee.setSalary((int)salary);
		expectSalary = (salary*0.05)+100.0;
	}
	
	@Test
	public void testCalulateChristmasBonus() {
		System.out.println(expectSalary);
		assertEquals((int)expectSalary, employee.calculateChristmasBonus());
	}
	
	@Test
	public void testisEmpty() {
		assertTrue("".equals(enclosure.toString()));
		assertTrue("".equals(enclosure.toString()));		
	}
	
	public static void main(String[] args) {
		Enclosure enclosure = new Enclosure();
		enclosure.addAnimal(new Parrot("Shinan", 3));
		enclosure.addAnimal(new Parrot("Shinan", 3));

		System.out.println(enclosure);
		
	}
}
