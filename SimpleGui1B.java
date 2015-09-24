import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class SimpleGui1B implements ActionListener {
	JButton button;
	
	public static void main(String[] args) {
	
		SimpleGui1B gui = new SimpleGui1B();
		gui.go();
		
	}
	
		public void go() {
			
			JFrame frame = new JFrame();
			button = new JButton("Click me now, you idiot!");
			Color bg = Color.RED;
			button.setBackground(bg );
		
			// Register your interest with the button.  
			// This says to the button:  " Add me to your list
			// of listeners."  The argument you pass MUST be
			// an object from a class that implements ActionListener!
			button.addActionListener(this);
		
		
			frame.getContentPane().add(BorderLayout.SOUTH, button);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(300, 300);
			frame.setVisible(true);
	}
		
		// Implement the ActionListener interface's
		// actionPerformed() method.  This is the actual
		// event-handling method!
		// The button calls this method to let you know 
		// an event happened.  It sends you an ActionEvent object
		// as the argument, but we don't need it here.  
		
		public void actionPerformed(ActionEvent event) {
			button.setText("Yay, I've been clicked!");
			Color bg2 = Color.GREEN;
			button.setBackground(bg2 );
		}
}
