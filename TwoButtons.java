import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class TwoButtons {

	JFrame frame;
	JLabel label;
	
	public static void main (String[] args) {
		TwoButtons gui = new TwoButtons();
		gui.go();
		
	}
	
	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton labelButton = new JButton("Change Label Text");
		labelButton.addActionListener(new LabelListener());
		
		JButton colourButton = new JButton("Change Colour of Circle");
		colourButton.addActionListener(new ColourListener());
		
		label = new JLabel("Hi, I'm a label.");
		MyDrawPanel1 drawPanel1 = new MyDrawPanel1();
		
		frame.getContentPane().add(BorderLayout.SOUTH, colourButton);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel1);
		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
	class LabelListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			label.setText("Ouch!");
			
		}
	}
	
	class ColourListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			frame.repaint();
		}
	}
}
