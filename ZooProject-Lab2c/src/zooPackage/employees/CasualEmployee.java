package zooPackage.employees;
import java.util.Date;

public abstract class CasualEmployee extends Employee {
	private int projectLength;
	private Date startDate;

	public CasualEmployee(String employeeName) {
		super(employeeName);
	}
	public int getProjectLength() {
		return projectLength;
	}
	public void setProjectLength(int projectLength) {
		this.projectLength = projectLength;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
