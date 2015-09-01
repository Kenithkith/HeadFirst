import java.util.*;


public class DotCom {

	// DotCom's instance variables: an array list of cell locations, the DotCom's name.
	private ArrayList<String> locationCells;
	private String name;
	
	// A setter method that updates the DotCom's location.
	// (Random location provided by the GameHelper2 placeDotCom() method.
	public void setLocationCells(ArrayList<String> loc) {
		locationCells = loc;
	}
	
	// Your basic setter method.
	public void setName(String n) {
		name = n;
	}
	

	public String checkYourself(String userInput) {
		
		String result = "miss";
		
		// The ArrayList indexOf() method in action!
		// If the user's guess is one of the entries in the ArrayList,
		// indexOf() will return its ArrayList location.
		// If not, indexOf() will return a -1.
		int index = locationCells.indexOf(userInput);
		
		if (index >= 0) {
			
			// Using ArrayList's remove() method to delete an entry.
			locationCells.remove(index);
			
			// Using the isEmpty() method to see if all of the locations have been guessed.
			if (locationCells.isEmpty()) {
				result = "kill";
				
				// Tell the user when a DotCom has been sunk.
				System.out.println("Ouch! You sunk " + name + " :( ");
				
			} else {
				result = "hit";
			} // Close if statement.
			
		} // Close if statement.
		
		// Return "miss" or "hit" or "kill"
		return result;
		
		} // Close method.
} // Close class.
