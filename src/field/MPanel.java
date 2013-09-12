package field;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JTable;

public class MPanel extends JPanel {

	public MPanel() {
//		Field table = new Field(DEFAULT_FIELD_HEIGTH, DEFAULT_FIELD_WIDTH);
		MTableModel model = new MTableModel(DEFAULT_FIELD_HEIGTH, DEFAULT_FIELD_WIDTH);
		JTable table = new JTable(model);
		table.setDefaultRenderer(Color.class, new ColorTableCellRenderer());
		table.setRowSelectionAllowed(false);
		this.add(table);
		table.setVisible(true);
//		this.repaint();
	}
	
	private final int DEFAULT_FIELD_WIDTH = 10;
	private final int DEFAULT_FIELD_HEIGTH = 15;	
}
