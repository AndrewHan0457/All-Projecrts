
import java.util.HashMap;

/**
 * this class is used to manage the device.
 * 
 */
public class Manager {
	
	Simulator simulator;
	HashMap<String, Object> hashmap = new HashMap<String, Object>();

	/**
	 * construct a constructor with hashmap to put the key=filename, value=object(mode)
	 * 
	 */
	public Manager(Simulator sim) {
		// TODO Auto-generated constructor stub
		simulator = sim;		
		hashmap.put("Create.csv", new CreateDevice(simulator));
		hashmap.put("Delete.csv", new DeleteDevice(simulator));
		hashmap.put("ChangeState.csv", new ChangeState(simulator));
		hashmap.put("Mode.csv", new ModeDevice(simulator));
	}
	
	/**
	 * this method is used to get the object's sendCommand() method
	 * 
	 */
	public void SwitchCsvObject(String filename) {		
		((Functionality) hashmap.get(filename)).sendCommand();
	}	   
}
