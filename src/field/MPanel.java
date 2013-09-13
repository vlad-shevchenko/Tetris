package field;

import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import javax.swing.JTable;
import field.MFrame;

public class MPanel extends JPanel {

	public MPanel() {
		Color[][] colorField = new Color[MFrame.FIELD_WIDTH][MFrame.FIELD_HEIGHT];
		for(int i = 0; i < MFrame.FIELD_WIDTH; ++i)
			for(int j = 0; j < MFrame.FIELD_HEIGHT; ++j)
				colorField[i][j] = Color.DARK_GRAY;
		
		FieldTableModel model = new FieldTableModel(colorField);
		MTable table = new MTable(model);
		
		this.add(table);
	}
}
