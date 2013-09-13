package mainFrame;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JTable;

import field.FieldTableModel;
import field.MTable;

public class MPanel extends JPanel {

	public MPanel() {
//		Color[][] colorField = new Color[MFrame.FIELD_WIDTH][MFrame.FIELD_HEIGHT];
//		for(int i = 0; i < MFrame.FIELD_WIDTH; ++i)
//			for(int j = 0; j < MFrame.FIELD_HEIGHT; ++j)
//				colorField[i][j] = Color.DARK_GRAY;
		
		FieldTableModel model = new FieldTableModel();
		MTable table = new MTable(model);
		table.setValueAt(Color.BLACK, 5, 5);
		
		this.add(table);
	}
}
