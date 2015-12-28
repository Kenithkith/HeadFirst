// Highway to......

public class TheBoringZone {

	int x, y, width, height;
	
	class Center { // Inner class starts.
		int centerX, centerY;
		
		Center(int x, int y) {
			centerX = x;
			centerY = y;
			
		}
	} // Inner class ends.
	
	// Constructor of this class creates an object of Center:
	public TheBoringZone(int x1, int y1, int x2, int y2) {
		
		x = x1;
		y = y1;
		width = y2 - y1;
		height = x2 - x1;
		
		// create object of inner class Center:
		Center c = new Center( (x1 + x2)/2, (y1 + y2)/2);
	}
}
