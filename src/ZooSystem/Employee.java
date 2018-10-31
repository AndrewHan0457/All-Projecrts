package ZooSystem;

import javafx.scene.control.Alert;

public abstract class Employee implements Employable {

	private int ID;
	private String name; 
	private int salary;

	@Override
	public void setEmployeeID(int number) {
		
		ID = number; // this. not needd as number and ID have different names - no confusion
	}

	@Override
	public int getEmployeeID() {
		
		return ID;
	}

	@Override
	public void setEmployeeName(String name) {
		
		this.name = name;

	}

	@Override
	public String getEmployeeName() {
		
		return name;
	}

	@Override
	public void setSalary(int salary) {
		this.salary=(int)(salary*0.9);
		
	}

	@Override
	public int getSalary() {
		
		return salary;
	}

	
}
