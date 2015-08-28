import java.util.Scanner;


public class SimpleDotComTestDrive {
	public static void main(String[] args) {
		
		int numOfGuesses = 0;
		GameHelper helper = new GameHelper();
		SimpleDotCom dot = new SimpleDotCom();
		
		int randomNum = (int) (Math.random() * 5);
			
		int[] locations = {randomNum, randomNum+1, randomNum+2};
		dot.setLocationCells(locations);
		
		boolean isAlive = true;
				
		//Scanner input = new Scanner(System.in);
		//System.out.println("Enter a number.");
		
		while (isAlive == true) {
					
			//String userGuess = input.next();
			String guess = helper.getUserInput("Enter a number.");
				
			String result = dot.checkYourself(guess);
			numOfGuesses++;
						
			if (result.equals("kill")) {
				isAlive = false;
				System.out.println("You've won!");
				System.out.println("You took " + numOfGuesses + " guesses.");
			} 
			
			else if (result.equals("hit")) {
				System.out.println("You hit it!");
				//System.out.println("Enter another number.");
				
			}else {
				//System.out.println("Enter another number.");
			}
		}
		
		
	//input.close();
	}
}
