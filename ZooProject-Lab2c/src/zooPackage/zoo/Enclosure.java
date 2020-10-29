package zooPackage.zoo;
import java.util.ArrayList;
import zooPackage.animals.Animal;

/**
* Objects of this class represents zoo enclosures.
* 
* @author      Peer-Olaf Siebers
* @version     2.3
* @since       1.0
*/

public class Enclosure {
	private ArrayList<Animal> animals;
	
	public Enclosure() {
		animals=new ArrayList<Animal>();
	}
	/**
	* This method adds animals to the "animals" list.
	* 
	* @param  animal An animal that lives in any of the Zoos.
	*/
	public void addAnimal(Animal animal){
		animals.add(animal);
	}
}

