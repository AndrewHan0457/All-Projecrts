package ZooSystem;

abstract class Animal {
	
	public String name;
	public int quantity;
	
	public Animal(String name, int quantity) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " " + quantity;
	}
}
