package zooPackage.zoo;

import java.util.ArrayList;
import java.util.List;

import zooPackage.employees.Employee;

public class ZooCorp {
	private List<Zoo> zoos;
	private List<Employee> employees;

	public ZooCorp() {
		zoos=new ArrayList<Zoo>();
		employees=new ArrayList<Employee>();
	}
	public void addZoo(Zoo zoo){
		zoos.add(zoo);
	}
	public String printZooList(){
		return zoos.toString();
	}
	public int getZooListSize(){
		return zoos.size();
	}
	public void printZoosLocations(){
		System.out.print("{");
		for(int i=0;i<zoos.size();i++) {
		    System.out.print(zoos.get(i).getLocation());
		    if(i<zoos.size()-1)
		    	System.out.print(", ");
	    }
		System.out.println("}");
	}
	public void addEmployee(Employee employee){
		employees.add(employee);
	}
	public String printEmployeeList(){
		return employees.toString();
	}
	public int getEmployeeListSize(){
		return employees.size();
	}
	public void printEmployeesNames(){
		System.out.print("{");
		for(int i=0;i<employees.size();i++) {
		    System.out.print(employees.get(i).getEmployeeName());
		    if(i<employees.size()-1)
		    	System.out.print(", ");
	    }
		System.out.println("}");
	}
}
