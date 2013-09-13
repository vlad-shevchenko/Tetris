package field;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class MTable extends JTable {

	public MTable(TableModel dm) {
		super(dm);

		this.setRowHeight(MFrame.ROW_HEIGHT);		
		for(int i = 0; i < this.getColumnCount(); ++i) {
			TableColumn column = this.getColumnModel().getColumn(i);
			column.setPreferredWidth(MFrame.COLUMN_WIDTH);
			column.setMinWidth(MFrame.COLUMN_WIDTH);
			column.setMaxWidth(MFrame.COLUMN_WIDTH);
			this.getColumnModel().setColumnMargin(MFrame.COLUMN_MARGIN);
		}
		
		this.setRowMargin(MFrame.ROW_MARGIN);
		
		this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		this.setRowSelectionAllowed(false);
		this.setDefaultRenderer(Color.class, new ColorTableCellRenderer());
	}
}
