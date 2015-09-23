import java.awt.Color;

import javax.swing.*;

public class SimpleGui1 {
	public static void main(String[] args) {
		
		// Make a frame.
		JFrame frame = new JFrame();
		
		// Make a button.  You can pass the button constructor
		// the text you want on the button.
		JButton button = new JButton("Click me!");
		
		// You can give the button a colour by creating Color instance
		// and assigning it to the .setBackground
		Color bg = Color.RED;
		button.setBackground(bg );
		
		// This line makes the program quit as soon as you close the window.
		// If you leave this out it will just sit there on the screen forever.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Add the button to the frame's content pane.
		frame.getContentPane().add(button);
		
		// Give the frame a size, in pixels.
		frame.setSize(300, 300);
		
		// Finally, make it visible!
		// If you forget to do this, you won't see anything when you run the code.
		frame.setVisible(true);
	}
}
