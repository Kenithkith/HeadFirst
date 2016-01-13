
public class AverageValueTester {
	public static void main(String[] args) {
		
		float[] temps = new float[10];
		float sum = 0;
		int count = 0;
		int i;
		
		for (i = 0; i < args.length & i < 10; i++) {
			try {
				temps[i] = Float.parseFloat(args[i]);
				count++;
			} catch (NumberFormatException nfe) {
				System.out.println("Invalid input: " + args[i]);
				
			}
			sum += temps[i];
		}
		System.out.println("Average: " + sum/count);
	}
}
