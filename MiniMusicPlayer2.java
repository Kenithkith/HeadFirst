import javax.sound.midi.*;

;

public class MiniMusicPlayer2 implements ControllerEventListener {

	public static void main(String[] args) {
		MiniMusicPlayer2 mini = new MiniMusicPlayer2();
		mini.go();
	}

	public void go() {

		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();

			// Register for events with the sequencer.
			// The event registration method take the listener
			// AND an int array representing the list of
			// ControllerEvents you want.
			// We only want one event, #127.

			int[] eventsIWant = { 127 };
			sequencer.addControllerEventListener(this, eventsIWant);

			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();

			for (int i = 5; i < 61; i += 4) {

				track.add(makeEvent(144, 1, i, 100, i));

				// Here's how we pick up the beat: we insert our OWN
				// ControllerEvent [176 say the event type is ControllerEvent]
				// with an argument for event number #127. This event will do
				// NOTHING! We put it in JUST so that we can get an event each
				// time a note is played. In other words, its sole purpose is
				// so that something will fire that WE can listen for (since we
				// can't
				// listen for NOTE ON/NOTE OFF events). Notice that we're making
				// this event happen at the SAME tick as the NOTE ON. So when
				// the
				// NOTE ON event happens, we'll know about it because OUR event
				// will fire at the same time.
				
				track.add(makeEvent(176, 1, 127, 0, i));

				track.add(makeEvent(128, 1, i, 100, i + 2));

			} // End for loop.

			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} // close go() method.

	public void controlChange(ShortMessage event) {
		System.out.print("La ");
	}

	public static MidiEvent makeEvent(int comd, int chan, int one, int two,
			int tick) {

		MidiEvent event = null;

		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
			
		} catch (Exception e) {
		}

		return event;
	}
}
