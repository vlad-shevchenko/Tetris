package field;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import mainFrame.MFrame;

public class FieldTableModel implements TableModel {

	public FieldTableModel() {
		this.data = new Object[MFrame.FIELD_WIDTH][MFrame.FIELD_HEIGHT];
		this.fieldWidth = MFrame.FIELD_WIDTH;
		this.fieldHeigth = MFrame.FIELD_HEIGHT;
	}
	
	public FieldTableModel(Object[][] data) {
		this.data = data;
		this.fieldWidth = data.length;
		this.fieldHeigth = data[0].length;
	}
	
	public void addTableModelListener(TableModelListener arg0) {
		this.listeners.add(arg0);
	}

	public Class<?> getColumnClass(int arg0) {
		return Color.class;	
	}

	public int getColumnCount() {
		return this.fieldWidth;			
	}

	public String getColumnName(int arg0) {
		return null;
	}

	public int getRowCount() {
		return this.fieldHeigth;			
	}

	public Object getValueAt(int arg0, int arg1) {
		return this.data[arg1][arg0];
	}

	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

	public void removeTableModelListener(TableModelListener arg0) {
		this.listeners.remove(arg0);
	}

	public void setValueAt(Object arg0, int arg1, int arg2) {
		this.data[arg1][arg2] = arg0;
	}
	
	private int fieldWidth, fieldHeigth;
	private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
	private Object[][] data;

}
