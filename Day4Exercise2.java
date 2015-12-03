import java.util.Scanner;

// Create a class that takes words for the first ten numbers 
// ("one" to "ten") and converts them into a single LONG integer.
// Use a switch statement for the conversion and command-line arguments
// for the words.  (Or use scanner if you want it look better.)

public class Day4Exercise2 {
	public static void main(String[] args) {

		long number = 0;
		String word;

		if (args.length > 0) 
			word = new String(args[0]);
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number from one to ten, in word format.");
		word = input.nextLine();

			char[] starter = word.toCharArray();

			switch (starter[0]) {
			case 'o':
				number = 1l;
				break;
			case 't':
				if (starter[1] == 'w')
					number = 2l;
				if (starter[1] == 'h')
					number = 3l;
				if (starter[1] == 'e')
					number = 10l;
				break;
			case 'f':
				if (starter[1] == 'o')
					number = 4l;
				if (starter[1] == 'i')
					number = 5l;
				break;
			case 's':
				if (starter[1] == 'i')
					number = 6l;
				if (starter[1] == 'e')
					number = 7l;
				break;
			case 'e':
				number = 8l;
				break;
			case 'n':
				number = 9l;
				break;

			default:
				System.out.println("Number input error.");

				// return number;

			}

			System.out.println("Your number is " + number + ".");
		
	input.close();
	}
}
