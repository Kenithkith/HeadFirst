public class GuessGame {

	// GuessGame has three instance variables for the three player objects.
	Player p1;
	Player p2;
	Player p3;

	public void startGame() {
		// Create three Player objects and assign them the three Player instance
		// variables listed above.
		p1 = new Player();
		p2 = new Player();
		p3 = new Player();

		// Declare three variable to hold the guesses each player will make.
		int guessP1 = 0;
		int guessP2 = 0;
		int guessP3 = 0;

		// Declare three variables to hold a true or false based on the player's
		// answer.
		boolean p1isRight = false;
		boolean p2isRight = false;
		boolean p3isRight = false;

		// Make a 'target' number that the players have to guess.
		int targetNumber = (int) (Math.random() * 10);
		System.out.println("I am thinking of a number between 0 and 9...");

		while (true) {
			System.out.println("Number to guess is " + targetNumber + ".");

			// Call each player's guess.
			p1.guess();
			p2.guess();
			p3.guess();

			// Get each player's guess by accessing the number variable.
			guessP1 = p1.number;
			System.out.println("Player 1 guessed " + guessP1 + ".");

			guessP2 = p2.number;
			System.out.println("Player 2 guessed " + guessP2 + ".");

			guessP3 = p3.number;
			System.out.println("Player 3 guessed " + guessP3 + ".");

			// Check each player's guess to see if it matches the 'target'
			// number. If a player is right, then set that player's variable to
			// be true. [Remember it is set to false by default.]
			if (guessP1 == targetNumber) {
				p1isRight = true;
			}
			
			if (guessP2 == targetNumber) {
				p2isRight = true;
			}
			
			if (guessP3 == targetNumber) {
				p3isRight = true;
			}
			
			// If any players are right, declare winner. Else go through guessing loop again.
			if (p1isRight || p2isRight || p3isRight) {
				
				System.out.println("We have a winner!");
				System.out.println("Player 1 got it right? " + p1isRight);
				System.out.println("Player 2 got it right? " + p2isRight);
				System.out.println("Player 3 got it right? " + p3isRight);
				System.out.println("Game is over.");
				break;
			}
			else {
				System.out.println("Players will have to try again.");
			}
			
			
			
		}

	}

}
