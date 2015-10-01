import javax.sound.midi.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer3 {

	static JFrame f = new JFrame("My First Music Video");
	static MyDrawPanel ml;

	public static void main(String[] args) {

		MiniMusicPlayer3 mini = new MiniMusicPlayer3();
		mini.go();

	}

	public void setUpGui() {

		ml = new MyDrawPanel();
		f.setContentPane(ml);
		f.setBounds(50, 50, 500, 500);
		f.setVisible(true);
	}

	public void go() {

		setUpGui();

		try {

			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addControllerEventListener(ml, new int[] {127});
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();

			int r = 0;

			for (int i = 0; i < 60; i += 4) {

				r = (int) ((Math.random() * 50) + 30);
				track.add(makeEvent(144, 1, r, 100, i));
				track.add(makeEvent(176, 1, 127, 0, i));
				track.add(makeEvent(128, 1, r, 100, i + 2));

			} // End for loop.

			sequencer.setSequence(seq);
			sequencer.start();
			sequencer.setTempoInBPM(160);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {

		MidiEvent event = null;

		try {

			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);

		} catch (Exception e) {
		}

		return event;

	}

	class MyDrawPanel extends JPanel implements ControllerEventListener {

		// We set a flag to false, and we'll set it to true
		// only when we get an event.
		boolean msg = false;

		public void controlChange(ShortMessage event) {
			// We got an event, so we set the flag to true
			// and called repaint().
			msg = true;
			repaint();
		}

		public void paintComponent(Graphics g) {
			// We have to use a flag because OTHER things
			// might trigger a repaint(), and we to paint
			// ONLY when there's a ControllerEvent.
			if (msg) {

				// This code below is to generate a random
				// color and paint a semi-random rectangle.
				Graphics2D g2 = (Graphics2D) g;

				int r = (int) (Math.random() * 250);
				int gr = (int) (Math.random() * 250);
				int b = (int) (Math.random() * 250);

				g.setColor(new Color(r, gr, b));

				int ht = (int) ((Math.random() * 150) + 10);
				int width = (int) ((Math.random() * 150) + 10);
				int x = (int) ((Math.random() * 400) + 10);
				int y = (int) ((Math.random() * 350) + 10);

				g.fillRect(x, y, ht, width);
				msg = false;
			} // Close if statement.
		} // Close paintComponent() method.
	} // Close inner class.
}
