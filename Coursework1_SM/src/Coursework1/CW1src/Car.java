package Coursework1.CW1src;
import java.util.ArrayList;

public class Car {
    final static int d1Value = 300; //speed sensor
    final static int d2Value = 300; //lidar sensor
    final static int d3Value = 500; //position sensor
    final static int d4Value = 1200;//accelerometer
    final static int d5Value = 150; //gyroscope
    final static int defaultValue = 100;       // This values are used to set power for specified devices.
    
	private int carId;
	public ArrayList<Device> devices;
	public String name;
	public String model;
	public int nbOfPassengers;
	
	public Car(int carId) {
		this.setCarId(carId);
		this.setDevices(new ArrayList<Device>());
		System.out.println("car " + carId + " created");
	}
	
	public void addNewDevice(int deviceId){
		Device device = new Device(deviceId, carId);
		new Thread(device).start();
		device.setStop(false);
		devices.add(device);
		
		switch (deviceId) {
		 case 01 :
			 device.setPower(d1Value);
			 break;
		 case 02 :
			 device.setPower(d2Value);
			 break;
		 case 03 :
			 device.setPower(d3Value);
			 break;
		 case 04 :
			 device.setPower(d4Value);
			 break;
		 case 05 :
			 device.setPower(d5Value);
			 break;
		 default:
			 device.setPower(defaultValue);
			 break;
		}
	}


	public int checkCarName(String name) {
		if(this.name==name)
			return 1;
		else
			return 0;
	}

	//Getters and Setters
	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public void setCarName(String name) {
		this.name=name;
	}

	public String getCarName() {
		return this.name;
	}

	public ArrayList<Device> getDevices() {
		return devices;
	}

	public void setDevices(ArrayList<Device> devices) {
		this.devices = devices;
	}

}