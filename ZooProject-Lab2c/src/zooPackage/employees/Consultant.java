package zooPackage.employees;
import java.util.ArrayList;

import zooPackage.misc.Contract;

public class Consultant extends CasualEmployee {
	private ArrayList<Contract> contracts;

	public Consultant(String employeeName) {
		super(employeeName);
		contracts=new ArrayList<Contract>();
	}
	public void addContract(Contract contract){
		contracts.add(contract);
	}
	public ArrayList<Contract> getContracts(){
		return contracts;
	}
}
