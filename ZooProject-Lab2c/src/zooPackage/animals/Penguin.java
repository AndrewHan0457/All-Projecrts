package zooPackage.animals;

public class Penguin extends Bird {

	@Override
	public void maintain() {
		// TODO Auto-generated method stub
	}
	@Override
	public void eat() {
		System.out.println(getClass().getName()+" is eating!");
	}
}
