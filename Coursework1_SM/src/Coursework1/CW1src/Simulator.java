package Coursework1.CW1src;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

public class Simulator extends Observable {

	private static Simulator instance;
	
	//Singleton design pattern
    synchronized public static Simulator getInstance() {
		if(instance == null){
			instance = new Simulator();
		}
    	return instance;
	}
	
	private int mode;
	private ArrayList<Car> cars;
    private String statecommand;
    
	public Simulator() {
		this.cars = new ArrayList<Car>();
	}

	/**
	 * @param String
	 *            carId ; eg 00 , 01, 02 This should be called as soon as the
	 *            web app decides to make a new car
	 */
	
    /* The front-end doesn't have a page to add specified car and it only has one page to add devices directly,
     * so I change this method to "private" and it will only be called by "addDevice()";
     */
	
	private void addNewCar(int carId) {
		Car car = new Car(carId);
		cars.add(car);
		System.out.println("Success!");
	}
    

    //Getter and Setter
    public void setMode(int modeValue){
    	this.mode=modeValue;
    	System.out.println("Change mode to "+modeValue);
    }

    public int getMode(){
    	return this.mode;
    }
	


	/**
	 * @param String
	 *            deviceIdentifier ; eg cId&apId&state&value eg 01&02&01&00
	 *            state should only be 01 , or 00 value should stay as 00 for
	 *            now This should be called as soon as the web app decides to
	 *            add a new device
	 */

	public void addDevice(String deviceIdentifier) {

		String[] splitIdentifier = deviceIdentifier.split("&");
		int carId = Integer.parseInt(splitIdentifier[0]);
		int deviceId = Integer.parseInt(splitIdentifier[1]);
		int deviceState = Integer.parseInt(splitIdentifier[2]);
        Boolean carExists = false;
        System.out.println("Success!!");
        
		for (int i = 0; i < cars.size(); i++) {
			if (cars.get(i).getCarId() == carId) {
				cars.get(i).addNewDevice(deviceId);
				int length = cars.get(i).devices.size();
				Device device = cars.get(i).devices.get(length-1);
				device.setState(deviceState);//
				this.addObserver(device);    // When the device is created, it will be added as a observer.
				carExists = true;
			}
		}
		if (carExists == false) {              // If the car doesn't exists, create this car and then create the specified device
			addNewCar(carId);
			cars.get(cars.size()-1).addNewDevice(deviceId);
			int length = cars.get(cars.size()-1).devices.size();
			Device device = cars.get(cars.size()-1).devices.get(length-1);
			device.setState(deviceState);//
			this.addObserver(device);
		}
	}

	/**
	 * Should be called when the web app chooses to remove a device
	 * 
	 * @param removeIdentifier
	 *            ; eg 00&02 , cId&dId
	 * @throws InterruptedException 
	 */

	public void removeDevice(String removeIdentifier) throws InterruptedException {

		String[] splitIdentifier = removeIdentifier.split("&");
		int carId = Integer.parseInt(splitIdentifier[0]);
		int deviceId = Integer.parseInt(splitIdentifier[1]);

		for (int i = 0; i < cars.size(); i++) {
			if (cars.get(i).getCarId() == carId) {
				for (int j = 0; j < cars.get(i).devices.size(); j++) {
					if (cars.get(i).devices.get(j).getDeviceId() == deviceId) {
						Device device = cars.get(i).devices.get(j);
						this.deleteObserver(device);       // When this device is removed, we also delete this observer.
						cars.get(i).devices.remove(j);	
						device.setStop(true);
						System.out.println("Remove device: "+carId+" "+deviceId);
					}
				}

			}
		}
	}

	/**
	 * Should be called regularly (perhaps in a different thread) to constantly
	 * relay the current state of a device to the web app
	 * 
	 * @param dataRequest
	 *            ; cId&dId ; eg 00&01 - gets state of device 02 in car
	 *            00
	 * @return state of car, eg 00 (off) or 01 (on)
	 */

	public int getState(String dataRequest) {
//		System.out.println(dataRequest);
		int returnState = 0;
		String[] splitData = dataRequest.split("&");
		int carId = Integer.parseInt(splitData[0]);
		int deviceId = Integer.parseInt(splitData[1]);

		for (int i = 0; i < cars.size(); i++) {
			if (cars.get(i).getCarId() == carId) {
				for (int j = 0; j < cars.get(i).devices.size(); j++) {
					if (cars.get(i).devices.get(j).getDeviceId() == deviceId) {
						returnState = cars.get(i).devices.get(j).getState();
//						System.out.println(returnState);
					}
				}
			}
		}

		return returnState;
	}
	
	/* Should be called to get the power for devices
	 * @param dataRequest
	 *            ; cId&dId ; eg 00&01 - gets power of device 01 in car
	 *            00
	 * @return power of device
	 */
	public int getPower(String dataRequest) {
		System.out.println("input data " + dataRequest);
		int returnState = 0;
		String[] splitData = dataRequest.split("&");
		int carId = Integer.parseInt(splitData[0]);
		int deviceId = Integer.parseInt(splitData[1]);
		
		for (int i = 0; i < cars.size(); i++) {
			if (cars.get(i).getCarId() == carId) {
				for (int j = 0; j < cars.get(i).devices.size(); j++) {
					if (cars.get(i).devices.get(j).getDeviceId() == deviceId) {
						returnState = cars.get(i).devices.get(j).getPower();
					}
				}
			}
		}
		return returnState;
	}
	/**
	 * This should be called as soon as the web app turns on/off a device
	 * @param dataReceived ; cId&dId&state ;  eg 00&02&01 turns on the device 02 in car 00
	 */

	public int changeState(String dataReceived) {
		System.out.println("Change State!");
		this.statecommand = dataReceived;
		this.setChanged();
		this.notifyObservers(statecommand); 
		return 0;
	}
	
	/* This should be called to provide real temperature.
	 */
	public int getTemperature() {
		int max=35;
        int min=0;
        
        Random random = new Random();
        int temperature = random.nextInt(max)%(max-min+1) + min;
        System.out.println("Real temperature: " + temperature);
        return temperature;
	}

}
