import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui3C implements ActionListener {

	JFrame frame;

	public static void main(String[] args) {

		SimpleGui3C gui = new SimpleGui3C();
		gui.go();

	}

	public void go() {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton button = new JButton("Change colours!");
		button.addActionListener(this);

		MyDrawPanel1 drawPanel1 = new MyDrawPanel1();

		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel1);
		frame.setSize(300, 300);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent event) {
		frame.repaint();

	}
}
