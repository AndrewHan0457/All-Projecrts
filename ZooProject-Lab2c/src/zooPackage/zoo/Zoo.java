package zooPackage.zoo;
import java.util.ArrayList;

public class Zoo {
	private String location;
	private int numEnclosures;
	private static int numZoos;
	private int zooID;
	private ArrayList<Enclosure> enclosures;

	// if I have setters I should use them everywhere in the code
	public Zoo(String location,int numEnclosures) {
		setLocation(location);
		setNumEnclosures(numEnclosures);
		Zoo.numZoos++;
		this.zooID=Zoo.numZoos;
		enclosures=new ArrayList<Enclosure>();
		for(int i=0; i<numEnclosures; i++){
			addEnclosure(new Enclosure());
		}
		this.printInfo();
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getNumEnclosures() {
		return numEnclosures;
	}
	public void setNumEnclosures(int numEnclosures) {
		this.numEnclosures = numEnclosures;
	}
	public static int getNumZoos(){
		return Zoo.numZoos;
	}
	public int getzooID(){
		return zooID;
	}
	private void addEnclosure(Enclosure enclosure) {
		this.enclosures.add(enclosure);
	}
	public void printInfo(){
		System.out.println(this.getClass().getSimpleName()+":"+zooID+":"+location+":"+numEnclosures);
	}
}
