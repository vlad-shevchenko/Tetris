package field;

import java.awt.LayoutManager;
import javax.swing.JPanel;

public class MPanel extends JPanel {

	public MPanel() {
		Field table = new Field(DEFAULT_FIELD_HEIGTH, DEFAULT_FIELD_WIDTH);
		this.repaint();
	}
	
	private final int DEFAULT_FIELD_WIDTH = 10;
	private final int DEFAULT_FIELD_HEIGTH = 20;	
}
