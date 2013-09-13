package mainFrame;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JTable;

import field.FieldTableModel;
import field.MTable;

public class MPanel extends JPanel {

	public MPanel() {		
		FieldTableModel model = new FieldTableModel();
		MTable table = new MTable(model);
		
		this.add(table);
	}
}
