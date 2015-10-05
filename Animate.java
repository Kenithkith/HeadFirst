import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Animate {

	int x = 0;
	int y = 0;
	
	public static void main(String[] args) {
		
		Animate gui = new Animate();
		gui.go();
		
	}
	
	public void go() {
		
		JFrame frame = new JFrame();
		MyDrawP drawP = new MyDrawP();
		frame.getContentPane().add(drawP);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 270);
		frame.setVisible(true);
		
		for (int i = 0; i < 136; i++) {
			
			x += 2; y++;
			drawP.repaint();
		
		
		try {
			Thread.sleep(50);
		} catch(Exception ex) { }
		}
		
		if (y > 124) {
			
			JButton button = new JButton("So long, and thanks for all the fish!");
			frame.getContentPane().add(BorderLayout.CENTER, button);
			frame.setVisible(true);
		}
	}
	
	class MyDrawP extends JPanel {

		public void paintComponent(Graphics g) {
			
			Graphics2D g2d = (Graphics2D) g;
			
			g.setColor(Color.white);
			g.fillRect(0,0, 500, 250);
			
			int red = (int) (Math.random() * 255);
			int green = (int) (Math.random() * 255);
			int blue = (int) (Math.random() * 255);
			Color startColour = new Color(red, green, blue);
			
			g.setColor(startColour);	
			g.fillRect(x, y, 500-x*2, 250-y*2);
			
		}
	}
}
