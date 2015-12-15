import java.util.Scanner;


public class ParseCount {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("What number are you thinking of?");
		String babble = input.nextLine();
		
		int count = Integer.parseInt(babble);
		
		System.out.println("You said your number was " + count + ".");
		
	input.close();	
	}

}
