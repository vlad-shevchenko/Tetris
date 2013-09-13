package field;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JTable;

public class MPanel extends JPanel {

	public MPanel() {
		Color[][] colorField = new Color[DEFAULT_FIELD_WIDTH][DEFAULT_FIELD_HEIGHT];
		for(int i = 0; i < DEFAULT_FIELD_WIDTH; ++i)
			for(int j = 0; j < DEFAULT_FIELD_HEIGHT; ++j)
				colorField[i][j] = Color.DARK_GRAY;
		
		FieldTableModel model = new FieldTableModel(colorField);
		MTable table = new MTable(model);
		
		this.add(table);
	}
	
	private final int DEFAULT_FIELD_WIDTH = 10;
	private final int DEFAULT_FIELD_HEIGHT = 15;	
}
