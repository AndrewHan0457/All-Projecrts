
public class Sensor {
	
	public String Type;
	public int Id;
	
	//Constructors
	public Sensor(){
		Id=0;
		Type="Unknown";
	}
	
	public Sensor(int id){
		Id=id;
	}
	;
	
	
	//Getters and Setters
	public int getSensorId(){
		return Id;
		
	}
	
	public void setSensorId(int i){
		Id=i;
		
	}
	
	public String getSensorType(){
		return Type;
		
	}
	
	public void setSensorType(String type){
		Type=type;
		
	}
	
	//check type of sensor
	public void checkSensorType(String s){
		if (Type=="Unknown")
			Type="Type 1";
		else
			Type="Type 2";
		
	}
	

}
