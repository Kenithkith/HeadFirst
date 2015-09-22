import java.util.Scanner;

class MyEx extends Exception {
	
}


public class ExTestDrive {
	public static void main (String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Yes or no?");
		String test = input.nextLine();
		
		System.out.print("t");
		
		
		try {
			doRisky(test);
			System.out.print("r");
			System.out.print("o");
			
		} catch(MyEx e) {
			System.out.print("a");
			
		} finally {
			System.out.print("w");
			System.out.print("s");
		}
	
	input.close();
	}
	
	static void doRisky(String t) throws MyEx {
		System.out.print("h");
		
		if ("yes".equals(t)) {
			throw new MyEx();
		}
	}
}
