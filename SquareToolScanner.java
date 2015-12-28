import java.util.Scanner;

public class SquareToolScanner {

	public SquareToolScanner(String input) {
		try {
			float in = Float.parseFloat(input);
			Square sq = new Square(in);
			float result = sq.value;

			System.out.println("The square of " + input + " is " + result
					+ ". DUH.");

		} catch (NumberFormatException nfe) {
			System.out.println(input + " is not a valid number.");

		}
	}

	class Square {

		float value;

		Square(float x) {

			value = x * x;

		}
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to the Square Number Confabulator 3000!");
		System.out.println("Please enter the number you want to square:");
		String baseNumber = input.nextLine();

		try {
			Double reqNumber = Double.parseDouble(baseNumber);

			SquareToolScanner dr = new SquareToolScanner(baseNumber);
			
		} catch (NumberFormatException nfe) {
			System.out.println("You didn't give me a number, moron.");

			

		}

		input.close();
	}

}
