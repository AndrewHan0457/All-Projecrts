package zooPackage;

import java.util.HashMap;

import zooPackage.animals.Animal;
import zooPackage.animals.Parrot;
import zooPackage.db.*;
import zooPackage.employees.*;
import zooPackage.misc.*;
import zooPackage.zoo.*;

public class ZooApp {
	private Database database;
	private HashMap<Integer,String> hashMapZoos;

	public ZooApp() {
		//this.database = new Database();
		//this.hashMapZoos=this.database.readZooRecords();
	}
	public HashMap<Integer,String> getHashMapZoos() {
		return hashMapZoos;
	}
	public static void main(String[] args) {
		ZooApp zooApp=new ZooApp();
		Zoo z1=new Zoo("Chester",12);
		Zoo z2=new Zoo("Warwick",52);
		Employee con1=new Consultant("Bob");
		Employee doc1=new Doctor("Tao");
		Animal par1=new Parrot();
		par1.enjoy();
		par1.eat();
		par1.maintain();
		//System.out.println(zooApp.getHashMapZoos());
		ZooCorp zooCorp1=new ZooCorp();
		zooCorp1.addEmployee(con1);
		zooCorp1.addEmployee(doc1);
		zooCorp1.printEmployeesNames();
		zooCorp1.addZoo(z1);
		zooCorp1.addZoo(z2);
		zooCorp1.printZoosLocations();
	}
}

