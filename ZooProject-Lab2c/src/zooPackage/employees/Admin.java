package zooPackage.employees;

public class Admin extends PermanentEmployee {

	public Admin(String employeeName) {
		super(employeeName);
	}
	@Override
	public int calculateChrismasBonus() {
		return (int)(getSalary()*0.08);
	}
}
