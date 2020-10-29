package zooPackage.employees;

public abstract class PermanentEmployee extends Employee {

	public PermanentEmployee(String employeeName) {
		super(employeeName);
	}
	public abstract int calculateChrismasBonus();
}
