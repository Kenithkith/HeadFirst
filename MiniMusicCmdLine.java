import java.util.Scanner;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;


public class MiniMusicCmdLine {
	public static void main(String[] args) {
		
		MiniMusicCmdLine mini = new MiniMusicCmdLine();
				
		Scanner input = new Scanner(System.in);
		
		System.out.println("What instrument number would you like used?");
		int instrument = input.nextInt();
		System.out.println();
		System.out.println("What note number would you like played?");
		int note = input.nextInt();
		
		mini.play(instrument, note);
		
	input.close();
	}
	
	public void play(int instrument, int note) {
		
		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			
			MidiEvent event = null;
			
			ShortMessage first = new ShortMessage();
			first.setMessage(192, 1, instrument, 0);
			MidiEvent changeInstrument = new MidiEvent(first, 1);
			track.add(changeInstrument);
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, note, 100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, note, 100);
			MidiEvent noteOff = new MidiEvent(b, 16);
			track.add(noteOff);
			
			player.setSequence(seq);
			player.start();
			
		} catch (Exception ex) {
			System.out.println("It's not working!");
			ex.printStackTrace();
		}
	}
}
