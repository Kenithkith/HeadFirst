
abstract class Animal2 {
	
	//All animals (including subclasses) have a name.
	private String name;
	
	// A getter method that Hippo2 inherits.
	public String getName() {
		return name;
	}
	
	// The constructor that takes the name and assigns it to the name instance variable.
	public Animal2 (String theName) {
		name = theName;
	}
}


class Hippo2 extends Animal2 {

	// Hippo2 constructor takes a name.
	public Hippo2 (String name) {
		
		// It sends the name up the Stack to the Animal2 constructor.
		super(name);
	}
}

public class MakeHippo {
	public static void main(String[] args) {
		
		// Makea Hippo2, passing the name "Buffy" to the Hippo2 constructor.
		Hippo2 h = new Hippo2("Buffy");
	
		// Then calls the Hippo2's inherited getName().
		System.out.println(h.getName());
	}
}


