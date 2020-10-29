package Customers;

public class Seller extends Customer{
	
//	private Property [] on_saling_properties;
	private Property p;
	public Seller(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		p = new Property();
	}
	
	public void postProperty(Property p) {
		
	}

	public Property getP() {
		return p;
	}

	public void setP(Property p) {
		this.p = p;
	}
	
	
}
