package Coursework1.CW1src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * this class is used to create the device
 * 
 */
public class CreateDevice extends Functionality{
	
	private static Simulator simulator;
    
    
    public CreateDevice(Simulator simulator){
	    this.simulator = simulator;
    }
    
    private static CreateDevice instance;
    synchronized public static CreateDevice getInstance() {
		if(instance == null){
			instance = new CreateDevice(simulator);
		}   	
	    	return instance;
	}

    
    public void sendCommand(){
    	System.out.println("......");
    	
	    BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("./InputCommand/Create.csv"));
            String tempString = null;
            
            while ((tempString = reader.readLine()) != null) {
//        	    String data = null;
        	    String[] commands = tempString.split(",");
        	   
        	    for(int i=0; i<commands.length; i++) {
            	    System.out.println(commands[i]);
        	    }
        	    System.out.println(commands.length);
        	    
        	 	simulator.addDevice(commands[0]+"&"+commands[1]+"&"+commands[2]+"&"+commands[3]);
 	       
            } 			    
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
