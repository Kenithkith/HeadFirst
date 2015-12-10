import java.util.Scanner;

public class AveragerByScanner {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		int sum = 0;
		
		System.out.println("Please enter your integers.  Use spaces to separate them, not commas.");
		String numbers = input.nextLine();
		
		String[] parsnips = numbers.split(" ");
		
		if (parsnips.length == 0) {
			
			System.out.println("You did not enter any numbers.");
		}
		
		if (parsnips.length > 0) {

			for (int i = 0; i < parsnips.length; i++) {

				sum += Integer.parseInt(parsnips[i]);

			}

			System.out.println("Sum is: " + sum);
			System.out.println("Average is: " + (float) sum / parsnips.length);

		}
		
	input.close();
	}
}
