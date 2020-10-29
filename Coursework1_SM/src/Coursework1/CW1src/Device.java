package Coursework1.CW1src;

import java.util.Observable;
import java.util.Observer;

public class Device extends Sensor implements Observer, Runnable {
	
	private int deviceId;
	private int carId;
	private int state;
    private int power;
    private volatile boolean stop;

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
	
	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public void setState(int newState){
		this.state = newState;
		System.out.println("Car " + carId + "  Device " + deviceId +" new state = " + state);
	}

	public void notifySensor(int state) {
		System.out.println("Device "+this.carId+", "+this.deviceId+" calling Sensor: State changed!!!");
	}
	

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
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
		System.out.println("Device "+this.carId+", "+this.deviceId+", "+this.state+" running...");
		while(!stop){
			preState = this.state;
			while(preState==this.state&&!stop)			
			{
				try {
					Thread.sleep(2000);
					System.out.println("Device"+this.carId+", "+this.deviceId+", "+ this.state+", "+this.stop+" Running!");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(!stop) {
				preState = this.state;
				notifySensor(this.state);
			}
		}
	}
	
}
