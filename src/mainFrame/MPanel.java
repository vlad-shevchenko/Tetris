package mainFrame;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import blocks.Block;
import blocks.MTimer;
import field.FieldTableModel;
import field.MTable;

public class MPanel extends JPanel implements ActionListener {

	public MPanel() {		
		FieldTableModel model = new FieldTableModel();
		table = new MTable(model);
		
		MTimer timer = new MTimer();
		timer.start();
		timer.addActionListener(this);
		
		currentBlock = new Block();
		
		// Set center of block to center of field
		currentBlock.setPos(new Point((int) (MFrame.FIELD_WIDTH / 2), (int) (MFrame.FIELD_HEIGHT / 2)));
		table.drawBlock(currentBlock);
		
		this.add(table);
	}

	public void actionPerformed(ActionEvent ev) {
		currentBlock.rotate();
		table.clear();
		table.drawBlock(currentBlock);
	}
	
	private Block currentBlock;
	private MTable table;
}
