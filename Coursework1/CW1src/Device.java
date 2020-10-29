
import java.util.Observable;
import java.util.Observer;

public class Device extends Sensor implements Observer,Runnable {
	
	private int deviceId;
	private int carId;
	private int state;
    private int power;

	public Device(int deviceId, int carId) {
		super();
		this.setDeviceId(deviceId);	
		this.carId = carId;
		this.state = 0;	 
		System.out.println("Car " + carId + "  Device " + deviceId + " created");
	}
 
	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	 
	public int getPower() {
		return power;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
	public int getState(){
		System.out.println("device " + deviceId + " state = " + state);
		return this.state;
	}
	
	public void setState(int newState){
		this.state = newState;
		System.out.println("Car " + carId + "  Device " + deviceId + " new state = " + state);
	}

	public void notifySensor(int state) {
		System.out.println("!!!!");
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		String[] splitData = arg.toString().split("&");
		int carID = Integer.parseInt(splitData[0]);
		int deviceId = Integer.parseInt(splitData[1]);
		int state = Integer.parseInt(splitData[2]);
		if (this.carId == carID && this.deviceId == deviceId) {
			setState(state);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int preState;
		while(true){
			preState = this.state;
			while(preState==this.state)
				;
			preState = this.state;
			notifySensor(this.state);
		}
	}
}
