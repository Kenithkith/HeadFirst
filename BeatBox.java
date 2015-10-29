import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BeatBox {

	JPanel mainPanel;
	ArrayList<JCheckBox> checkboxList;
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	JFrame theFrame;
	
	String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", 
			"Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga",
			"Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"};
	int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};
	
	
	public static void main(String[] args) {
		BeatBox box = new BeatBox();
		box.buildGUI();
	}
	
	public void buildGUI() {
		theFrame = new JFrame("Cyber Beat Box");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();
		JPanel background = new JPanel(layout);
		background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		checkboxList = new ArrayList<JCheckBox>();
		Box buttonBox = new Box(BoxLayout.Y_AXIS);
		
		JButton start = new JButton("Start");
		start.addActionListener(new MyStartListener());
		buttonBox.add(start);
		
		JButton stop = new JButton("Stop");
		stop.addActionListener(new MyStopListener());
		buttonBox.add(stop);
		
		JButton upTempo = new JButton("Tempo Up");
		upTempo.addActionListener(new MyUpTempoListener());
		buttonBox.add(upTempo);
		
		JButton downTempo = new JButton("Tempo Down");
		downTempo.addActionListener(new MyDownTempoListener());
		buttonBox.add(downTempo);
		
		JButton send = new JButton("Serialize It");
		send.addActionListener(new MySendListener());
		buttonBox.add(send);
		
		JButton restore = new JButton("Restore It");
		restore.addActionListener(new MyReadInListener());
		buttonBox.add(restore);
		
		JButton clear = new JButton("Clear Selection");
		clear.addActionListener(new MyClearListener());
		buttonBox.add(clear);
		
		Box nameBox = new Box(BoxLayout.Y_AXIS);
		Font bigFont1 = new Font("serif", Font.BOLD, 16);
		nameBox.setFont(bigFont1);
		for (int i = 0; i < 16; i++) {
			nameBox.add(new Label (instrumentNames[i]));
		}
		
		
		background.add(BorderLayout.EAST, buttonBox);
		background.add(BorderLayout.WEST, nameBox);
		
		theFrame.getContentPane().add(background);
		
		GridLayout grid = new GridLayout(16,16);
		grid.setVgap(1);
		grid.setHgap(1);
		
		mainPanel = new JPanel(grid);
		background.add(BorderLayout.CENTER, mainPanel);
		
		// Makes the checkboxes, sets them to false (not checked)
		// then adds them to both the ArrayList and the GUI panel.
		for (int i = 0; i < 256; i++) {
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			checkboxList.add(c);
			mainPanel.add(c);
		}
		
		setUpMidi();
		
		theFrame.setBounds(50, 50, 300, 300);
		theFrame.pack();
		theFrame.setVisible(true);
			
	}
	
	public void setUpMidi() {
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequence = new Sequence(Sequence.PPQ, 4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(120);
			
		} catch(Exception e) { e.printStackTrace(); }
	}
	
	public void buildTrackAndStart() {
		
		// Well make a 16-element array to hold the values for one instrument,
		// across all 16 beats.  If the instrument is supposed to play on that beat,
		// the value at that element will be the key.  If that instrument is NOT
		// supposed to play on that beat, put in a zero.
		int[] trackList = null;
		
		// Get rid of the old track, make a fresh one.
		sequence.deleteTrack(track);
		track = sequence.createTrack();
		
		for (int i = 0; i < 16; i++) {
			// Do this to represent each of the 16 ROWS (i.e. Bass, Congo, etc.)
			trackList = new int[16];
			
			// Set the 'key' that represents which instrument this is (Bass,
			// Hi-Hat, etc.  The instruments array holds the actual MIDI numbers
			// for each instrument).
			int key = instruments[i];
			
			// Do this for each of the BEATS for this row.
			for (int j = 0; j < 16; j++ ) {
				
				JCheckBox jc = checkboxList.get(j + (16*i));
				
				// Is the checkBox at this beat selected? If yes, put the key
				// value in this slot in the array (the slot that represents 
				// this beat). Otherwise, the instrument is NOT supposed to play
				// at this beat, so set it to zero.				
				if (jc.isSelected()) {
					trackList[j] = key;
				} else {
					trackList[j] = 0;
				}
				
			} // close inner 'for' loop.
			
			// For this instrument, and for all 16 beats, make events and 
			// add them to the track. This uses both the makeTracks() and makeEvent() 
			// methods found further down this class.
			makeTracks(trackList);
			track.add(makeEvent(176, 1, 127, 0, 16));
		
		} // close outer 'for' loop.
		
		// We always want to make sure that there IS an event at Beat 16 
		// (It goes 0 to 15), otherwise the BeatBox might not go the full 
		// 16 beats before it starts over.
		track.add(makeEvent(192, 9, 1, 0, 15));
		try {
			sequencer.setSequence(sequence);
			sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
			sequencer.start();
			sequencer.setTempoInBPM(120);
		} catch(Exception e) { e.printStackTrace(); }
	} // close buildTrackAndStart() method
	
	
	public class MyStartListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			buildTrackAndStart();
		}
	} // close MyStartListener inner class
	
	public class MyStopListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			sequencer.stop();
		}
	} // close MyStopListener inner class
	
	// The Tempo Factor scales the sequencer's tempo by the factor
	// provided. The default is 1.0, so we're adjusting 
	// +/- 3% per click.
	public class MyUpTempoListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float) (tempoFactor * 1.03));
		}
	} // close MyUpTempoListener inner class.
	
	public class MyDownTempoListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float) (tempoFactor * .97));
		}
	} // close MyDownTempoListener inner class.
	
	public class MySendListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			
			// Make a boolean array to hold the state of each checkbox.
			boolean[] checkboxState = new boolean[256];
			
			for (int i = 0; i < 256; i++) {
				
				// Walk through the checkboxList (ArrayList of checkboxes),
				// and get the state of each one; then add it to boolean array.
				JCheckBox check = (JCheckBox) checkboxList.get(i);
				if (check.isSelected()) {
					checkboxState[i] = true;
				}
			}
			
			try {
				FileOutputStream fileStream = new FileOutputStream(new File ("Checkbox.ser"));
				ObjectOutputStream os = new ObjectOutputStream(fileStream);
				os.writeObject(checkboxState);
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public class MyReadInListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			
			boolean[] checkboxState = null;
			
			try {
				FileInputStream fileIn = new FileInputStream(new File ("Checkbox.ser"));
				ObjectInputStream is = new ObjectInputStream(fileIn);
				checkboxState = (boolean[]) is.readObject();
				
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			
			for (int i = 0; i < 256; i++) {
				
				JCheckBox check = (JCheckBox) checkboxList.get(i);
				if (checkboxState[i]) {
					check.setSelected(true);
				} else {
					check.setSelected(false);
				}
			}
			
			sequencer.stop();
			buildTrackAndStart();
		}
	}
	
	public class MyClearListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			
			for (int i = 0; i < 256; i++) {
			
				JCheckBox clearBox = checkboxList.get(i);
				
				clearBox.setSelected(false);
				
			}
		}
	}
	
	// This makes events for one instrument at a time, for all 16 beats.
	// So it might get an int[] for the Bass drum, and each index in the
	// array will hold either the key of that instrument or a zero.  If it's
	// a zero, the instrument isn't supposed to play at that beat.
	// Otherwise, make an event and add it to the track.
	public void makeTracks(int[] list) {
		
		for (int i = 0; i < 16; i++) {
			int key = list[i];
			
			if (key != 0) {
				track.add(makeEvent(144, 9, key, 100, i));
				track.add(makeEvent(128, 9, key, 100, i+1));
			}
		}
	} // close makeTracks() method.
	
	public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch(Exception e) { e.printStackTrace(); }
		return event;
	} // close makeEvent() method
	
	
} // close BeatBox class
