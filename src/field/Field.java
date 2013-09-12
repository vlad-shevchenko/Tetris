package field;


import java.awt.geom.Rectangle2D;

import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class Field extends JTable {
	public Field(int numRows, int numColumns) {
		super(numRows, numColumns);

		this.rows = numRows;
		this.columns = numColumns;

		cells = new boolean[rows][columns];
		
		for(boolean[] row : cells)
			for(boolean cell : row)
				cell = false;
		
		for(int i = 0; i < numColumns; ++i) {
			cells[0][i] = true;
		}
		
		for(int i = 0; i < this.columns; ++i) {
			for(int j = 0; j < this.rows; ++j) {
				if(cells[i][j]) {
					Rectangle2D.Double rect = new Rectangle2D.Double(0, 0, 20, 20);
//					rect.s
					this.setValueAt(rect, i, j);
				}
			}
		}
		
		this.repaint();
	}

	boolean[][] cells;
	
	private int columns;
	private int rows;
}
