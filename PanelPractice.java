import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class PanelPractice {
	public static void main(String[] args) {
		
		PanelPractice gui = new PanelPractice();
		gui.go();
	}
	
	public void go() {
		JFrame frame = new JFrame();
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.darkGray);
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		
		JButton button1 = new JButton("Shock me!");
		JButton button2 = new JButton("Bliss");
		JButton button3 = new JButton("huh?");
		
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		
		frame.getContentPane().add(BorderLayout.EAST, panel1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 500);
		frame.setVisible(true);
		
	}
}
