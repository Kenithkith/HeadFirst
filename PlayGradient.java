import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

// A randomized gradient colour caster,
// painting an oval.

public class PlayGradient {

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		Color startColour = new Color(red, green, blue);
		
		red = (int) (Math.random() * 255);
		green = (int) (Math.random() * 255);
		blue = (int) (Math.random() * 255);
		Color endColour = new Color(red, green, blue);
		
		GradientPaint gradient = new GradientPaint(70, 70, startColour, 150, 150, endColour);
		g2d.setPaint(gradient);
		g2d.fillOval(70, 70, 100, 100);
	}
}
