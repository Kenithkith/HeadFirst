
class StaticSuper {

	// This is a static initializer.  It runs as soon as the class
	// is loaded, before any static method is called and even before
	// any static variable can be used.
	static {
		System.out.println("super static block!");
	}
	
	// Original code needed () added.
	StaticSuper()  {
		System.out.println("super conductor!");
	}
}

public class StaticTests extends StaticSuper {

	static int rand;
	
	static {
		rand = (int) (Math.random() * 6);
		System.out.println("static block " + rand);
	}
	
	StaticTests() {
		System.out.println("constructor");
	}
	
	public static void main(String[] args) {
		
		System.out.println("in main");
		StaticTests st = new StaticTests();
		
	}
	
	
	/**
	 * Order of print out is:
	 * 	
	 * super static block! <-- static initializer when StaticSuper is extended.
	 * static block 0 <-- initializer in StaticTests.
	 * in main <-- first line after main created.
	 * super conductor! <-- constructor when subclass StaticTests object is created.
	 * constructor <-- constructor printout when StaticTests object is created.
	 * 
	 * 
	 */
}
