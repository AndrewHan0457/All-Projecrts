package zooPackage.employees;

public class Doctor extends ZooKeeper {
	private boolean hasApprobation;

	public Doctor(String employeeName) {
		super(employeeName);
	}

	public boolean getHasApprobation() {
		return hasApprobation;
	}

	public void setHasApprobation(boolean hasApprobation) {
		this.hasApprobation = hasApprobation;
	}
}
