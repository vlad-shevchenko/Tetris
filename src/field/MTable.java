package field;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import mainFrame.MFrame;

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
		this.setDefaultRenderer(Color.class, 
			new TableCellRenderer() {
				public Component getTableCellRendererComponent(JTable table, Object value,
						boolean isSelected, boolean hasFocus, int row, int column) {
					setBackground((Color) value);
					return null;
				}
			}
		);
	}
}
