import java.util.Scanner;

public class DayCounter {
	public static void main(String[] args) {

		int yearIn;
		int monthIn;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Select a year, using the 4 digit format.");
		yearIn = input.nextInt();
		
		System.out.println("Select a month, using digits 1 through 12.");
		monthIn = input.nextInt();
		

		if (args.length > 0)
			monthIn = Integer.parseInt(args[1]);
		if (args.length > 1)
			yearIn = Integer.parseInt(args[1]);

		System.out.println(monthIn + "/" + yearIn + " has "
				+ countDays(monthIn, yearIn) + " days.");
		
	input.close();
	}
	
	static int countDays(int month, int year) {
		int count = -1;
		
		switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				count = 31;
				break;
				
			case 4:
			case 6:
			case 9:
			case 11:
				count = 30;
				break;
			
			case 2:
				if ( year % 4 == 0)
					count = 29;
				else
					count = 28;
				if ((year % 100 == 0) & (year % 4 != 0))
					count = 28;
				
				
		}
		return count;
	}
	
	
}
