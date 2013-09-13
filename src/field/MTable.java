package field;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JTable;
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
		this.cellSelectionEnabled = false;
		this.setDefaultRenderer(Color.class, 
			new TableCellRenderer() {
				public Component getTableCellRendererComponent(JTable table, Object value,
						boolean isSelected, boolean hasFocus, int row, int column) {
					setBackground((Color) value);
					return null;
				}
			}
		);
		
		this.cells = new Cells();
	}
	
	public void setValueAt(Object obj, int x, int y) {
		this.dataModel.setValueAt(obj, x, y);
	}
	
	public void turnOn(int x, int y) {
		setValueAt(Color.GRAY, x, y);
	}
	
	public void turnOff(int x, int y) {
		setValueAt(Color.DARK_GRAY, x, y);
	}
	
	public void turnOn(Point p) {
		turnOn(p.x, p.y);
	}
	
	public void turnOff(Point p) {
		turnOff(p.x, p.y);
	}
	
	public void turn(boolean flag, int x, int y) {
		if(flag) 
			turnOn(x, y);
		else
			turnOff(x, y);
	}
	
	class Cells {
		public Cells() {
			this.activeCells = new boolean[MFrame.FIELD_WIDTH][MFrame.FIELD_HEIGHT];
			
			for(int i = 0; i < MFrame.FIELD_WIDTH; ++i) {
				for(int j = 0; j < MFrame.FIELD_HEIGHT; ++j) {
					turn(activeCells[i][j], i, j);
				}
			}
		}
		
		boolean[][] activeCells;
	}
	
	private Cells cells;
}
