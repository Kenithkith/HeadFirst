class HeightWeightDepth {
	
	private int height;
	private int weight;
	private int depth;
	
	public HeightWeightDepth(int height, int weight, int depth) {
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
		
		HeightWeightDepth building = new HeightWeightDepth(50,300,5);
		
		System.out.println("The building's height is " + building.getHeight() + " feet.");
		System.out.println("The building's weight is " + building.getWeight() + " pounds.");
		System.out.println("The building's depth is " + building.getDepth() + " feet.");
		
		
		
	}
}
