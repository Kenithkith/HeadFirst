import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {

	// Make two instance variables in the main GUI class
	// for the x and y coordinates of the circle.
	int x = 70;
	int y = 70;
	
	public static void main (String[] args) {

		SimpleAnimation gui = new SimpleAnimation();
		gui.go();
	}
	
	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Nothing new here.  May the widgets & put them in the frame.
		
		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.getContentPane().add(drawPanel);
		frame.setSize(500, 500);
		frame.setVisible(true);
		
		// Repeat the movement 150 times.
		for (int i = 0; i < 150; i++) {
			// Increment the x and y coordinates.
			x++;
			y++;
			
			// Tell the panel to repaint itself - 
			// so we can see the circle in the new location.
			drawPanel.repaint();
			
			try {
				// Slow it down a little (otherwise it will move
				// so quickly you won't SEE it move.)  Don't worry,
				//  you weren't suppose to already know this.  We'll
				// get to Threads in chapter 15.
				Thread.sleep(50);
				
			} catch (Exception ex) { }
		
		} // Close for loop. 
	} // Close go() method.
	
	
	// Now here's the inner class.
	class MyDrawPanel extends JPanel {
		
		public void paintComponent(Graphics g) {
			
			// We first set up a background colour.
			// This will hide/erase trail marks made by our traveling circle.
			g.setColor(Color.black);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			// Then we set the colour of the circle.
			g.setColor(Color.green);
			
			// Uses the continually-updated x and y
			// coordinates of the outer class.
			g.fillOval(x, y, 80, 80);
			
			// To be fancy we set the outline of circle.
			g.setColor(Color.darkGray);
			g.drawOval(x, y, 80, 80);
			
			// Let's see what happens when a red/yellow square is
			// just sitting in the way.
			g.setColor(Color.RED);
			g.fillRect(120, 120, 100, 100);
			g.setColor(Color.YELLOW);
			g.drawRect(120, 120, 100, 100);
			
			
		} // Close paintComponent() method.
	} // Close inner class.

} // Close outer class.
