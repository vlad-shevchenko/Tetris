package mainFrame;

import javax.swing.JPanel;
import field.FieldTableModel;
import field.MTable;

public class MPanel extends JPanel {

	public MPanel() {		
		FieldTableModel model = new FieldTableModel();
		MTable table = new MTable(model);
		
		this.add(table);
	}
}
