import java.awt.Point;


public class NamedPoint extends Point {

	String name;
	
	NamedPoint(int x, int y, String name) {
		super(x, y);
		this.name = name;
	}
	
	public static void main(String[] args) {
		
		NamedPoint newPoint = new NamedPoint(5, 5, "Small Point");
		
		System.out.println("x is " + newPoint.x + ".");
		System.out.println("y is " + newPoint.y + ".");
		System.out.println("Name is " + newPoint.name + ".");
	}
}
