package field;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import blocks.*;
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
			if(p.y >= 0)
				turnOn(p);
		}
	}
	
	public void redrawBlock(Block block) {
		this.clear();
		this.drawBlock(block);
	}
	
	public void addBlock(Block block) { 
		for(Point p : block.getBlock()) {
			if(p.x >= 0 && p.y >= 0)
				this.cells.activeCells[p.x][p.y] = true;
		}
		
		if(this.findLines())
			timer.setNormalDelay((int) (timer.getNormalDelay() * 0.80));
	}
	
	public boolean isBlockDown(Block block) {
		for(Point p : block.getBlock()) {
			if(p.y == MFrame.FIELD_HEIGHT - 1)
				return true;
			if((MFrame.isInField(new Point(p.x, p.y + 1))) && 
				p.y >= 0 &&
				(cells.activeCells[p.x][p.y + 1])) {
					return true;
			}
		}		
		return false;
	}

	public boolean isMovePosible(Block block, int x, int y) {
		for(Point p : block.getBlock()) {
			Point endPoint = Block.add(p, new Point(x, y));
			
			if(endPoint.y >= 0 && !MFrame.isInField(endPoint))
				return false;
			if(isBlockOut(block))
				return false;
			if((MFrame.isInField(endPoint)) && 
				endPoint.y >= 0 &&
				(cells.activeCells[endPoint.x][endPoint.y]))
				return false;
			
		}
		return true;
		
	}
	
	public boolean isLose(Block block) {
		for(Point p : block.getBlock()) {
			if(p.y < 0)
				return true;
		}
		return false;
	}
	
	class Cells {
		public Cells() {
			this.activeCells = new boolean[MFrame.FIELD_WIDTH + 3][MFrame.FIELD_HEIGHT + 3];
			
			for(int i = 0; i < MFrame.FIELD_WIDTH; ++i) {
				for(int j = 0; j < MFrame.FIELD_HEIGHT; ++j) {
					turn(activeCells[i][j], i, j);
				}
			}
		}
		
		public int findLines() {
			boolean isFull = true;
			
			for(int i = MFrame.FIELD_HEIGHT - 1; i >= 0; --i) {
				isFull = true;
				
				for(int j = 0; j < MFrame.FIELD_WIDTH; ++j) {
					if(activeCells[j][i] == false) {
						isFull = false;
						break;
					}
				}
				if(isFull)
					return i;
			}
			
			return -1;
		}

		public void eraseLine(int num) {
			for(int i = num; i >= 0; --i) {
				for(int j = 0; j < MFrame.FIELD_WIDTH; ++j) {
					if(i == 0)
						activeCells[j][i] = false;
					else
						activeCells[j][i] = activeCells[j][i - 1];
				}
			}
		}
		
		boolean[][] activeCells;
	}
	
	private boolean findLines() {
		int num;
		boolean erased = false;
		
		while((num = cells.findLines()) != -1) {
			cells.eraseLine(num);
			erased = true;
		} 
		
		return erased;
	}
	
	private boolean isBlockOut(Block block) {
		int minX = block.getMinX();
		int maxX = block.getMaxX();
		
		if(minX < 0) return true;
		if(maxX >= MFrame.FIELD_WIDTH) return true;
		
		return false;
	}
	
	private Cells cells;
	public MTimer timer;
}
