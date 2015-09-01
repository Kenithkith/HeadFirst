import java.util.*;


public class DotComBust {
		// 1. Declare and initialise the variables we'll need.
		private GameHelper2 helper = new GameHelper2();
		
		private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
		int numOfGuesses = 0;
		
		public void setUpGame() {
			// First make some instances of DotComs and give them names.
			
			// 2. make three DotCom objects, give 'em names, and stick 'em in the ArrayList.
			DotCom one = new DotCom();
			one.setName("Pets.com");
			DotCom two = new DotCom();
			two.setName("eToys.com");
			DotCom three = new DotCom();
			three.setName("Go2.com");
			
			dotComsList.add(one);
			dotComsList.add(two);
			dotComsList.add(three);
			
			// 3. Print brief instructions for user.
			System.out.println("Your goal is to sink three dot coms:  ");
			System.out.println("Pets.com, eToys.com, and Go2.com.");
			System.out.println("Try to sink them all in the fewest number of guesses.");
			
			// 4. Repeat with each DotCom in the list.
			for (DotCom dotComToSet : dotComsList) {
				
				// 5. Ask the helper for a DotCom location.
				ArrayList<String> newLocation = helper.placeDotCom(3);
				
				// 6. Call the setter method on this DotCom to give it the location you just got from the helper.
				dotComToSet.setLocationCells(newLocation);
				
			} // Close for loop.
		} // Close setUpGame method.
		
		
		public void startPlaying() {
			
			// 7. As long as the DotCom list is NOT empty
			while (!dotComsList.isEmpty()) {
				
				// 8. Get user input.
				String userGuess = helper.getUserInput("Enter a guess.");
				
				// 9. Call our own checkUserGuess method.
				checkUserGuess(userGuess);
				
			} // Close while loop.
			
			// 10. Call our own finishGame method.
			finishGame();
			
		} // Close startPlaying method.
		
		
		public void checkUserGuess(String userGuess) {
			
			// 11. Increment the number of guesses the user has made.
			numOfGuesses++;
			
			// 12.  Assume it's a "miss" unless told otherwise.
			String result = "miss";
			
			// 13. Repeat with all DotComs in the list.
			for (DotCom dotComToTest : dotComsList) {
				
				//14. Ask the DotCom to check the user guess, looking for a hit (or kill).
				result = dotComToTest.checkYourself(userGuess);
				
				if (result.equals("hit")) {
					
					//15. Get out of the loop early, no point in testing the others.
					break;
				}
				
				if (result.equals("kill")) {
					
					// 16. This guy's dead, so take him out of the DotCom's list
					//     then get out of the loop.
					dotComsList.remove(dotComToTest);
					
					break;
					
				} // Close if statement.
			} // Close for statement.
			
			// 17.  Print the result for the user.
			System.out.println(result);
			
		} // Close checkUserGuess method.
		
		
		public void finishGame() {
			
			// 18.  Print a message telling the user how he did in the game.
			System.out.println("All Dot Coms are dead!  Your stock is now worthless.");
			
			if (numOfGuesses <= 18) {
				System.out.println("It only took you " + numOfGuesses + " guesses.");
				System.out.println("You got out before your options sank.");
			} else {
				System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
				System.out.println("Fish are dancing with your options.");
			} // Close else option.
		} // Close finishGame method.
		
		
		public static void main (String[] args) {
			
			// 19. Create the game object.
			DotComBust game = new DotComBust();
			
			// 20. Tell the game object to set up the game.
			game.setUpGame();
			
			// 21. Tell the game object to start the main game play loop
			//     (Keep asking for user input and checking the guess.
			game.startPlaying();
		
		
		}  // Close main method.
} // Close class.
