package ZooSystem;

public class Admin extends Employee {

	@Override
	public int calculateChristmasBonus() {
		int bonus = (int) ((double)getSalary() * 0.08);
		return bonus;
		
	}

}
