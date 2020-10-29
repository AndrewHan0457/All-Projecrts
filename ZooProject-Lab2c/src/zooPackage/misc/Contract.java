package zooPackage.misc;

public class Contract {
	private static int uniqueContractID;
	private int contractID;

	public Contract() {
		uniqueContractID++;
		this.contractID=Contract.uniqueContractID;
	}
}
