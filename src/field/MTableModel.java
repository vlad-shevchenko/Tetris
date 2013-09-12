package field;

import javax.swing.table.AbstractTableModel;

public class MTableModel extends AbstractTableModel {

	public MTableModel(int rows, int columns) {
		super();
		
		this.rows = rows;
		this.columns = columns;

		cells = new boolean[rows][columns];
		
		for(boolean[] row : cells)
			for(boolean cell : row)
				cell = false;
		
		
	}
	public int getColumnCount() {
		return 0;
			
	}

	public int getRowCount() {
		return 0;
			
	}

	public Object getValueAt(int arg0, int arg1) {
		return null;
			
	}

	boolean[][] cells;
	private String[] columnNames;
	private Object[][] data;
	private int rows;
	private int columns;
}
