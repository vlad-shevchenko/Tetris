package field;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class MTableModel extends AbstractTableModel {

	public MTableModel(int rows, int columns) {
//		super();
		
		this.rows = rows;
		this.columns = columns;

		cells = new boolean[rows][columns];
		data = new Object[rows][columns];
		
		for(boolean[] row : cells)
			for(boolean cell : row)
				cell = false;
		
		for(int i = 0; i < this.columns; ++i) {
			cells[this.rows - 1][i] = true;
		}
		
		for(int i = 0; i < this.rows; ++i) {
			for(int j = 0; j < this.columns; ++j) {
				if(cells[i][j]) {
					this.data[i][j] = Color.DARK_GRAY;
				} else { 
					this.data[i][j] = Color.GRAY;
				}
			}
		}
	}
	public int getColumnCount() {
		return this.columns;	
	}

	public int getRowCount() {
		return this.rows;			
	}

	public Object getValueAt(int row, int col) {
		return this.data[row][col];
	}

	boolean[][] cells;
	private String[] columnNames;
	private Object[][] data;
	private int rows;
	private int columns;
}
