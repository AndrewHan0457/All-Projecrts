import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * this class is used to change the device state 
 * 
 */
public class ChangeState extends Functionality{
	private Simulator simulator;
	
	   public ChangeState(Simulator simulator){
		   this.simulator = simulator;
	   }
	   
	   public void sendCommand(){
		   BufferedReader reader = null;
	       try {
	           reader = new BufferedReader(new FileReader("./InputCommand/ChangeState.csv"));
	           String tempString = null;
	           reader.readLine();
	           while ((tempString = reader.readLine()) != null) {
	        	   String[] commands = tempString.split(",");
	        	   simulator.changeState(commands[0]+"&"+commands[1]+"&"+commands[2]);
	           }
	           reader.close();
	       } catch (IOException e) {
	           e.printStackTrace();
	       } 
	   }
}
