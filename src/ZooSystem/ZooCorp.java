package ZooSystem;
import java.util.ArrayList;

public class ZooCorp {
	
	private ArrayList<Zoo> zoos;
	private ArrayList<Employable> personnel;
	
	public ZooCorp() {
		//Default Constructor
		zoos = new ArrayList<Zoo>();
		personnel = new ArrayList<Employable>();
		
	}

	public ZooCorp(Zoo firstZoo) {
		this();
		zoos.add(firstZoo);
		
	}
	
	public void addStaff(Employable person){
		personnel.add(person);	
	
	}

	
	
	
	
	
	
}
