package Customers;

import InterfacesAndEnums.Pay;

public class Tenant extends Customer implements Pay{

	public Tenant(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void pay() {
		
	}

	@Override
	public void pay(Buyer b, Seller s) {
		// TODO Auto-generated method stub
		
	}
	
}
