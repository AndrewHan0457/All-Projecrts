package zooPackage.animals;

public abstract class Animal implements Maintainable {

	public abstract void eat();

	public void enjoy(){
		System.out.println(getClass().getName()+" is enjoying!");
	}
}
