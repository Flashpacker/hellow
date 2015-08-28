import javax.sound.midi.*;
import javax.swing.JPanel;

public class MiniMusicPlayer1{
	public static void main(String args[]){
		MiniMusicPlayer1 player = new MiniMusicPlayer1();
		player.go();
	}
	
	public void go(){
		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			int[] s = {127};
			sequencer.addControllerEventListener(this, s);
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			
			Track track = seq.createTrack();
			
			for (int i = 5; i < 61; i+= 4) {
				track.add(makeEvent(144,1,i,100,i));
				track.add(makeEvent(176,1,127,100,i));
				track.add(makeEvent(128,1,i,100,i + 2));
			} // end loop
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
			} catch (Exception ex) {ex.printStackTrace();}
	}
	
	private static MidiEvent makeEvent(int i, int j, int i2, int k, int i3) {
		// TODO Auto-generated method stub
		MidiEvent midi = null;
		try {
			ShortMessage message = new ShortMessage(i,j,i2,k);
			midi = new MidiEvent(message,i3);
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return midi;
	}

	class MyDrawPanel extends JPanel implements ControllerEventListener {
		
		public void controlChange(ShortMessage event) {
			
		}
	}
}