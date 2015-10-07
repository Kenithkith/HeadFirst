import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Button1 {
	public static void main(String[] args) {
		
		Button1 practice1 = new Button1();
		practice1.go();
	}
	
	public void go() {
		JFrame frame = new JFrame();
		JButton button = new JButton("There is no spoon...");
		Font bigFont1 = new Font("serif", Font.BOLD, 28);
		button.setFont(bigFont1);
		JButton button2 = new JButton("forks!");
		JButton button3 = new JButton("I still need some milk");
		JButton button4 = new JButton("cow");
		Font bigFont2 = new Font("san serif", Font.ITALIC, 40);
		button4.setFont(bigFont2);
		JButton button5 = new JButton("Dinner is very, very noisy." );
		
		
		frame.getContentPane().add(BorderLayout.NORTH, button);
		frame.getContentPane().add(BorderLayout.EAST, button2);
		frame.getContentPane().add(BorderLayout.SOUTH, button3);
		frame.getContentPane().add(BorderLayout.WEST, button4);
		frame.getContentPane().add(BorderLayout.CENTER, button5);
		frame.setSize(500, 500);
		frame.setVisible(true);
		
	}
}
