
public class RangeLister {

	int[] makeRange(int lower, int upper) {
		int[] range = new int[(upper - lower) + 1];

		
		for (int i = 0; i < range.length; i++ ) {
			range[i] = lower++;
		}
		
		return range;
	}
	
	public static void main(String[] args) {
		
		int[] range;
		RangeLister lister = new RangeLister();
		
		range = lister.makeRange(12, 22);
		System.out.print("The array: [");
		
		for (int i = 0; i < range.length; i++ ) {
			
			if (i < (range.length - 1))
				System.out.print(range[i] + ", ");
			
			else
				System.out.print(range[i]);
		}
		
		System.out.print("]");
	}

}
