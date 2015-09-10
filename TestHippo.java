
class Animal {
	
	public Animal() {
		System.out.println("Making an Animal...");
	}
}

class Hippo extends Animal {
	
	public Hippo() {
		System.out.println("Making a Hippo...");
	}
}


public class TestHippo {
	public static void main(String[] args) {
		
		System.out.println("Starting up the machine.");
		System.out.print(" *grinding noises *" + "\n" + "\n");
		
		Hippo h = new Hippo();
		
		System.out.println();
		System.out.println("Ding! It's done!");
		
	}
}
