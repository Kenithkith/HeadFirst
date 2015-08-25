
public class BeerSong {
	public static void main(String[] args) {
		
		int beerNumber = 99;
		String word = "bottles";
		
		while (beerNumber > 0) {
			
			if (beerNumber == 1) {
				word = "bottle";
			}
			
			System.out.println(beerNumber + " " + word + " of beer on the wall. ");
			System.out.println(beerNumber + " " + word + " of beer.");
			System.out.println("Take one down.");
			System.out.println("Pass it around.");
			
			beerNumber = beerNumber - 1;
			
			
		
		
			if (beerNumber > 0) {
				
				if (beerNumber == 1) {
					word = "bottle";
				}
				
				System.out.println(beerNumber + " " + word + " of beer on the wall.");
				System.out.println();
			}
			else {
				System.out.println("There are no more bottles of beer on the wall.");
				System.out.println();
			} 
		}
		
	}
}
