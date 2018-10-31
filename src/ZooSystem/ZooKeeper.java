package ZooSystem;

public class ZooKeeper extends Employee {

	@Override
	public int calculateChristmasBonus() {
		int bonus = (int) ((double)getSalary() * 0.05+100.0);
		return bonus;
	}

	public ZooKeeper(String name){
		setEmployeeName(name);
		
	}
}
