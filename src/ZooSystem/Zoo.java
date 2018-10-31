package ZooSystem;
import java.util.ArrayList;

public class Zoo {

	private String location;
	private int numberOfEnclosures;
	private int zooID;
	
	public static int numberOfZoos;
	
	private ArrayList<Enclosure> enclosures;
	
	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Zoo() {
		//default constructor
		this("unknown", 30); //defaults
	}

	public Zoo(String location, int numberOfEnclosures) {
		//main constructor
		this.location = location;
		this.numberOfEnclosures = numberOfEnclosures;
		
		enclosures = new ArrayList<Enclosure>();
		
		numberOfZoos++; //We have created a new zoo. Lets keep count of it
		
		zooID = numberOfZoos;
		for (int i=0; i<numberOfEnclosures; i++) {
			addEnclosure(new Enclosure());
		}
		}
	
	

	private void addEnclosure(Enclosure enclosure) {
		this.enclosures.add(enclosure);
		
	}

	public void printInfo() {
		System.out.println("Location = "+ location);
		System.out.println("Enclosures = "+ numberOfEnclosures);
		System.out.println("ZooId = " + zooID);
		
	}
	
	
	
}
