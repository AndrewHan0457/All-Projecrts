package zooPackage.employees;

public class ZooKeeper extends PermanentEmployee {

	public ZooKeeper(String employeeName) {
		super(employeeName);
	}
	@Override
	public int calculateChrismasBonus() {
		return (int)(getSalary()*0.05+100);
	}
}
