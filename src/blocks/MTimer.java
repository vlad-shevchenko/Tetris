package blocks;

import javax.swing.Timer;
import mainFrame.MFrame;

public class MTimer extends Timer {

	public MTimer() {
		super(MFrame.DEFAULT_TIMER, null);
	}

	public int getNormalDelay() {
		return normalDelay;
	}
	
	public void setNormalDelay(int delay) {
		this.normalDelay = delay;
		this.setDelay((speedUp) ? normalDelay / 5 : normalDelay);
	}
	
	public void speedUp() {
		this.setDelay(normalDelay / 5);
		speedUp = true;
	}

	public void speedDown() {
		this.setDelay(normalDelay);
		speedUp = false;
	}

	private boolean speedUp = false;
	private int normalDelay = MFrame.DEFAULT_TIMER;

}
