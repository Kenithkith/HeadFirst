
public class Output {
	
	void go() {
		int y = 7;
		
		for (int x = 1; x < 8; x++) {
			
			System.out.println("In For Loop #" + x);
			
			y++;
			
			System.out.println("X is " + x + " and Y immediately becomes " + y);
			System.out.println();
		
			
			if (x > 4) {
				System.out.println("=========");
				
				System.out.println("The if statement is met and we print:");
				System.out.println("We add 1 to Y and now Y is now equal to " + ++y + " "); // Add 1 to Y, and print that result.
				System.out.println();
			}
			
			if (y > 14) {
				System.out.println("The if statement is met and we print:");
				System.out.println(" x = " + x);
				
				break;
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		Output o = new Output();
		o.go();
		
		
	}
}
