
public class TestBoats {
	public static void main(String[] args) {
	
		Boat b1 = new Boat();
		Sailboat b2 = new Sailboat();
		Rowboat b3 = new Rowboat();
		
		
		b2.setLength(32);  // sailboat
		b1.move();		// boat
		b3.move();		// rowboat
		b2.move();		// sailboat
		
		
	}
}
