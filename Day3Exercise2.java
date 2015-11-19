class Measurmentings {
	
	int height;
	int weight;
	int depth;
	
	public Measurmentings() {
		this.height = 0;
		this.weight = 0;
		this.depth = 0;
	}
	
	public Measurmentings(int height, int weight, int depth) {
		this.height = height;
		this.weight = weight;
		this.depth = depth;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public int getDepth() {
		return this.depth;
	}
}


public class Day3Exercise2 {
	public static void main(String[] args) {
		
		Measurmentings building1 = new Measurmentings(50,300,5);
		Measurmentings building2 = new Measurmentings();
		
		System.out.println("Building 1's height is " + building1.getHeight() + " feet.");
		System.out.println("Building 1's weight is " + building1.getWeight() + " pounds.");
		System.out.println("Building 1's depth is " + building1.getDepth() + " feet.");
		System.out.println("\nBuilding 2's height is " + building2.getHeight() + " feet.");
		System.out.println("Building 2's weight is " + building2.getWeight() + " pounds.");
		System.out.println("Building 2's depth is " + building2.getDepth() + " feet.");
		System.out.println("\nOops! Forgot to add Building 2's data!");
		
		building2.height = 60;
		building2.weight = 445;
		building2.depth = 16;
		
		System.out.println("\nBuilding 2's height is " + building2.getHeight() + " feet.");
		System.out.println("Building 2's weight is " + building2.getWeight() + " pounds.");
		System.out.println("Building 2's depth is " + building2.getDepth() + " feet.");
		
		
		
		
	}
}
