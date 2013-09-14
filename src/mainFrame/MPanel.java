package mainFrame;

import java.awt.Color;
import java.awt.Point;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import blocks.Block;
import blocks.MTimer;
import field.FieldTableModel;
import field.MTable;

public class MPanel extends JPanel implements ActionListener, KeyListener {

	public MPanel() {		
		FieldTableModel model = new FieldTableModel();
		table = new MTable(model);
		
		table.addKeyListener(this);
		
		currentBlock = new Block();
	
		table.drawBlock(currentBlock);
		
		this.add(table);
		
		MTimer timer = new MTimer();
		timer.start();
		timer.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ev) {
		if(table.isBlockDown(currentBlock)){
			table.addBlock(currentBlock);
			currentBlock = new Block();
			table.redrawBlock(currentBlock);
		}
		currentBlock.move(0, 1);
		table.redrawBlock(currentBlock);
	}

	public void keyPressed(KeyEvent ev) {
		switch (ev.getKeyCode()) {
		case KeyEvent.VK_LEFT : {
			if(table.isMovePosible(-1, 0))
				currentBlock.move(-1, 0);
			break;
		}
		case KeyEvent.VK_RIGHT : {
			currentBlock.move(1, 0);
			break;
		}
		case KeyEvent.VK_SPACE : {
			currentBlock.rotate();
			break;
		}
		}

		table.redrawBlock(currentBlock);
	}

	public void keyReleased(KeyEvent ev) 
	{}
	public void keyTyped(KeyEvent ev) 
	{}
	
	private Block currentBlock;
	private MTable table;
}
