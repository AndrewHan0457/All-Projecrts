package ZooSystem;

public class ZooApp {

	public static void main(String[] args) {
		
		Zoo.numberOfZoos = 0;
		
		
		/*// First part of the worksheet:
		Zoo z1 = new Zoo();
		Zoo z2 = new Zoo("London", 32);
		
		z1.printInfo();
		z2.printInfo();*/
		
		//our 5 new zoos:
		Zoo zL = new Zoo("London", 10);
		Zoo zT = new Zoo("Tokyo", 20);
		Zoo zN = new Zoo("New York", 35);
		Zoo zP = new Zoo("Paris", 40);
		Zoo zB = new Zoo("Beeston", 42);
		
		System.out.println("Number of zoos =" + Zoo.numberOfZoos);
		
		zL.printInfo();
		zT.printInfo();
		zN.printInfo();
		zP.printInfo();
		zB.printInfo();
		
		//****to do : now we should use ZooCorp objects...
		
		ZooCorp megaZooLtd = new ZooCorp(zL);
		
		//Lets try creating a ZooKeeper
		ZooKeeper keeper1 = new ZooKeeper("Bob");
		keeper1.setSalary(10000);
		System.out.println("Bonus = "+ keeper1.calculateChristmasBonus());
		
		megaZooLtd.addStaff(keeper1);
		
	}

}
