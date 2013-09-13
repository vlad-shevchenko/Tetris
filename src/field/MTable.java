package field;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class MTable extends JTable {

	public MTable() {
		
	}

	public MTable(TableModel dm) {
		super(dm);

		this.setRowHeight(20);		
		for(int i = 0; i < this.getColumnCount(); ++i) {
			this.getColumnModel().getColumn(i).setWidth(20);
		}
		this.setRowSelectionAllowed(false);
	}
	
	private final int DEFAULT_ROW_HEIGHT = 20;
	private final int DEFAULT_COLUMN_WIDTH = 20;

}
