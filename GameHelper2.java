import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper2 {

	// Class variables
	public static final String alphabet = "abcdefg";
	private int gridLength = 7;
	private int gridSize = 49;
	private int[] grid = new int[gridSize];
	private int comCount = 0;

	public String getUserInput(String prompt) {
		String inputLine = null;
		System.out.println(prompt + "  ");
		try {
			BufferedReader is = new BufferedReader(
			new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0)
				return null;
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
		return inputLine.toLowerCase();
	}

	public ArrayList<String> placeDotCom(int comSize) {
		ArrayList<String> alphaCells = new ArrayList<String>();
		// holds 'f6' type coordinates
		String[] alphacoords = new String[comSize];
		// temporary String for concat
		String temp = null;
		// current candidate coords
		int[] coords = new int[comSize];
		// current attempts counter
		int attempts = 0;
		// flag = found a good location?
		boolean success = false;
		// current starting location
		int location = 0;
		
		comCount++;
		int incr = 1;
		if ((comCount % 2) == 1) {
			incr = gridLength;
		}
		
		// main search loop
		while (!success & attempts++ < 200) {
			// get random starting point
			location = (int) (Math.random() * gridSize);
			// PRINT:  System.out.print(" try " + location);
			
			// Nth position in dotcom to place
			int x = 0;
			// assume success
			success = true;
			
			// look for adjacent unused spots
			while (success && x < comSize) {
				// if not already used
				 if (grid[location] == 0) {
					 // save location
					 coords[x++] = location;
					 // try next adjacent
					 location += incr;
					 
					 // out of bounds - 'bottom'
					 if (location >= gridSize) {
						 // failure
						 success = false;
					 }
					 
					 // out of bounds - right edge
					 if (x > 0 && (location % gridLength == 0)) {
						 // failure
						 success = false;
					 }
				
				 // found already used location
				 } else { 
					 // PRINT:  System.out.print(" used " + location);
					 // failure
					 success = false;
				 	}
				 }
			 } // end main search loop/while statement
		
		// turn location into alpha coords
		int x = 0;
		int row = 0;
		int column = 0;
		// System.out.print("\n");
		
		while (x < comSize) {
			// mark master grid points as 'used'
			grid[coords[x]] = 1;
			// get row value
			row = (int) (coords[x] / gridLength);
			// get numeric column value
			column = coords[x] % gridLength;
			// convert to alpha
			temp = String.valueOf(alphabet.charAt(column));
			
			alphaCells.add(temp.concat(Integer.toString(row)));
			x++;
			// PRINT:  System.out.print(" coord " + x + " + alphaCells.get(x - 1)); 
		}	
		
		// PRINT:  System.out.print("\n");
		
		return alphaCells;
	
	}
}
