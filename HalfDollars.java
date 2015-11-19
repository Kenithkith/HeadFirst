import java.text.DecimalFormat;


public class HalfDollars {
	public static void main(String[] args) {
		
		int[] denver = { 1_900_000, 1_700_000, 1_700_000 };
		int[] philadelphia = new int[denver.length];
		int[] total = new int[denver.length];
		int average;
		
		philadelphia[0] = 1_900_000;
		philadelphia[1] = 1_800_000;
		philadelphia[2] = 1_750_000;
		
		total[0] = denver[0] + philadelphia[0];
		total[1] = denver[1] + philadelphia[1];
		total[2] = denver[2] + philadelphia[2];
		average = (total[0] + total[1] + total[2]) / total.length;
		
		System.out.print("2009 Production: ");
		System.out.format("%,d%n",  total[0]);
		System.out.print("2010 Production: ");
		System.out.format("%,d%n", total[1]);
		System.out.print("2011 Production: ");
		System.out.format("%,d%n",  total[2]);
		System.out.print("Average Production Per Year: ");
		System.out.format("%,d%n", average);
		
		// Create a DecimalFormat object for formatting output.
				DecimalFormat mills = new DecimalFormat("#,###,##0");
	
		System.out.println("\n2009 Production:  " + mills.format(total[0]));
		System.out.println("2010 Production:  " + mills.format(total[1]));
		System.out.println("2011 Production:  " + mills.format(total[2]));
		System.out.println("Average Production Per Year:  " + mills.format(average));

	}
}
