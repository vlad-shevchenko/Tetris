package mainFrame;

import java.awt.Point;

import javax.swing.JFrame;

public class MFrame extends JFrame {

	public MFrame() {
		this.setBounds(200, 200, FRAME_WIDTH, FRAME_HEIGHT);
		this.setResizable(false);
		MPanel panel = new MPanel();
		this.add(panel);
		
		this.pack();
	}

	public static boolean isInField(Point p) {
		return (p.x >= 0 && 
//				p.y >= 0 && 
				p.x < FIELD_WIDTH && 
				p.y < FIELD_HEIGHT) ? true : false ;
	}
	
	public static final int ROW_HEIGHT = 20;
	public static final int COLUMN_WIDTH = 20;
	
	public static final int ROW_MARGIN = 1;
	public static final int COLUMN_MARGIN = 1;
	
	public static final int FIELD_WIDTH = 10;
	public static final int FIELD_HEIGHT = 15;	
	
	public static final int FRAME_WIDTH = FIELD_WIDTH * (COLUMN_WIDTH + COLUMN_MARGIN);
	public static final int FRAME_HEIGHT = FIELD_HEIGHT * (ROW_HEIGHT + ROW_MARGIN);
	
	public static final int DEFAULT_TIMER = 500;
}
