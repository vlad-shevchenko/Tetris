package field;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import blocks.Block;
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
	
	public void clear() {
		for(int i = 0; i < MFrame.FIELD_WIDTH; ++i) {
			for(int j = 0; j < MFrame.FIELD_HEIGHT; ++j) {
				turn(cells.activeCells[i][j], i, j);
			}			
		}
	}
	
	public void drawBlock(Block block) {
		for(Point p : block.getBlock()) {
			turnOn(p);
		}
	}
	
//	public void correctBlockPos(Block block) {
//		Point[] points = block.getBlock();
//		int minX = 0;
//		int minY = 0;
//		int maxX = 0;
//		int maxY = 0;
//		
//		for(int i = 1; i < points.length; ++i) {
//			if(points[i].x < minX) minX = points[i].x;
//			if(points[i].y < minY) minY = points[i].y;
//			if(points[i].x > maxX) maxX = points[i].x;
//			if(points[i].x > maxY) maxY = points[i].y;
//		}
//		
//		if(minX < 0) block.move(-minX, 0);
//		if(minY < 0) block.move(0, -minY);
//		if(maxX > MFrame.FIELD_WIDTH - 1) block.move(maxX - MFrame.FIELD_WIDTH, 0);
//		block.setPos(block.getPos());
//	}	
	
	public void redrawBlock(Block block) {
//		this.correctBlockPos(block);
		this.clear();
		this.drawBlock(block);
	}
	
	private void findLines() {
		
	}
	
	public void addBlock(Block block) { 
		for(Point p : block.getBlock()) {
			this.cells.activeCells[p.x][p.y] = true;
			findLines();
		}
	}
	
	public boolean isBlockDown(Block block) {
		for(Point p : block.getBlock()) {
			if(cells.activeCells[p.x][p.y + 1])
				return true;
		}		
		return false;
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
