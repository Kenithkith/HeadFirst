import java.text.DecimalFormat;

public class Day2Investment {
	public static void main(String[] args) {

		double investment = 14000;
		double year1 = 1.40;
		double year2 = -1500;
		double year3 = 1.12;

		// Create a DecimalFormat object for formatting output.
		DecimalFormat pound = new DecimalFormat("#,##0.00");

		System.out.println("I made an investment of £"
				+ pound.format(investment) + ".");

		investment *= year1;
		System.out
				.println("At the end of the first year, my investment was worth £"
						+ pound.format(investment) + ".");

		investment += year2;
		System.out
				.println("At the end of the second year, my investment was worth £"
						+ pound.format(investment) + ".");

		investment *= year3;
		System.out
				.println("At the end of the third year, my investment was worth £"
						+ pound.format(investment) + ".");

		int x = 13;
		int y = 3;

		int divide = x / y;
		int remainder = x % y;

		System.out.println("13 divided by 3 equals " + divide
				+ ", with a remainder of " + remainder + ".");
		
		System.out.println("The answer: " + divide + "\t remainder " + remainder);
	}
}
