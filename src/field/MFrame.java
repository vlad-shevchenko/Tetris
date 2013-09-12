package field;

import java.awt.GraphicsConfiguration;

import javax.swing.JFrame;

public class MFrame extends JFrame {

	public MFrame() {
		this.setBounds(100, 100, DEFAULT_WIDTH, DEFAULT_HEGHT);
		MPanel panel = new MPanel();
		this.add(panel);
	}
	
	private final int DEFAULT_WIDTH = 200;
	private final int DEFAULT_HEGHT = 300;	
}
