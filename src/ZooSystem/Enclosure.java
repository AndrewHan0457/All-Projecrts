package ZooSystem;

import java.util.ArrayList;

public class Enclosure {

	private ArrayList<Animal> animals;
	
	public Enclosure() {
		animals = new ArrayList<Animal>();
		
	}

	public void addAnimal(Animal animal){
		animals.add(animal);
	}

	@Override
	public String toString() {
		String string = "";
		for (Animal animal : animals) {
			string = string + " " + animal;
		}
		return string.trim();
	}
	
	

}
