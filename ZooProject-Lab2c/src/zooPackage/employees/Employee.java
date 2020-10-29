package zooPackage.employees;

public abstract class Employee implements Employable {
	private static int uniqueEmployeeID;
	private static int baseSalary=200;
	private int employeeID;
	private String employeeName;
	private int salary;

	public Employee(String employeeName) {
		super();
		uniqueEmployeeID++;
		this.employeeID=Employee.uniqueEmployeeID;
		setEmployeeName(employeeName);
		setSalary(Employee.baseSalary);
		this.printInfo();
	}
	@Override
	public int getEmployeeID() {
		return employeeID;
	}
	@Override
	public void setEmployeeName(String employeeName) {
		this.employeeName=employeeName;
	}
	@Override
	public String getEmployeeName() {
		return employeeName;
	}
	@Override
	public void setSalary(int salary) {
		this.salary=salary;
	}
	@Override
	public int getSalary() {
		return salary;
	}
	public void printInfo(){
		System.out.println(this.getClass().getSimpleName()+":"+getEmployeeID()+":"+getEmployeeName());
	}
}
