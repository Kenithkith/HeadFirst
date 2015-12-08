import java.util.Scanner;


public class PasserByScanner {

	void toUpperCase(String[] text) {
		for (int i = 0; i < text.length; i++ ) {
			text[i] = text[i].toUpperCase();
		}
	}
		
	void toUpperCase(String text) {
		for (int i = 0; i < text.length(); i++ ) {
			text = text.toUpperCase();	
			
		}
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter your words or phrase:");
		String response = input.nextLine();
		
		// Need to parse response into a String[] by finding spaces
		String[] phrase = response.split(" ");
		
		PasserByScanner passerScan = new PasserByScanner();
		
		passerScan.toUpperCase(phrase);
		
		for (int i = 0; i < phrase.length; i++ ) {
			
			System.out.println(phrase[i] + ". ");
			
		}
		
		System.out.println();
		
	input.close();	
	}

	
}
