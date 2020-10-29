package Coursework1.CW1src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * this class is used to delete object when user want to delete some devices.
 * 
 */
public class DeleteDevice extends Functionality{
	 private static Simulator simulator; 
	 private static DeleteDevice instance;
	  
	 public DeleteDevice(Simulator simulator){
		 this.simulator = simulator;
	 }
	 synchronized public static DeleteDevice getInstance() {
		if(instance == null){
			instance = new DeleteDevice(simulator);
		}   	
	    	return instance;
	 }
	   
	   public void sendCommand(){
		   BufferedReader reader = null;
	       try {
	           reader = new BufferedReader(new FileReader("./InputCommand/Delete.csv"));
	           String tempString = null;
	           while ((tempString = reader.readLine()) != null) {
	        	   String[] commands = tempString.split(",");
	  	           simulator.removeDevice(commands[0]+"&"+commands[1]);
	           }
	           reader.close();
	       } catch (IOException e) {
	           e.printStackTrace();
	       } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	   }
}
