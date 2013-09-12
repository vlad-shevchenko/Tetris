package field;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ColorTableCellRenderer extends JPanel implements TableCellRenderer {

	public Component getTableCellRendererComponent(JTable arg0, Object arg1,
			boolean arg2, boolean arg3, int arg4, int arg5) {
		setBackground((Color) arg1);
		return this;
	}

}
