
class Vet {
	public void giveShot(Animal a) {
		// do horrible things to the Animal at
		// the other end of the 'a' parameter
		// all in the name of science!
		
		a.makeNoise();
	}
}

class PetOwner {
	public void start() {
		System.out.println("I'll just wait out here in the lobby.");
	}
}

public class VetVisit {
	public static void main(String[] args) {
		
		Animal[] animals = new Animal[6];
		animals[0] = new Dog();
		animals[1] = new Cat();
		animals[2] = new Wolf();
		animals[3] = new Hippo();
		animals[4] = new Lion();
		animals[5] = new Tiger();
		
		for (int x = 0; x < 6; x++) {
			animals[x].eat();
			animals[x].roam();
			animals[x].sleep();
			System.out.println();
		}
		
		Vet v = new Vet();
		
		for (int x = 0; x < 6; x++) {
			System.out.println("Time for the next animal!");
			v.giveShot(animals[x]);
			System.out.println();
		}
	}
}
