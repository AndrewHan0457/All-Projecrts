package ZooSystem;

public class Parrot extends Bird{
	
	
	public Parrot(String name, int quantity) {
		super(name, quantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double lengthOfBeak() {
		return name.length();
	}
	
	public void speech() {
		System.out.println(this.name+" is speeching");
	}
}
