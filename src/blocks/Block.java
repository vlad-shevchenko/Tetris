package blocks;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;

import mainFrame.MFrame;

public class Block {

	public Block() {
		this.points = new Point[4];
		this.block = new Point[4];
		this.pos = new Point(0, 0);
		
		this.points[0] = new Point(0, 0);
		
		for(int i = 1; i < 4; ++i) {
			switch ((int) (Math.random() * 4)) {
			case 0: {
				this.points[i] = new Point(points[i - 1].x + 1, points[i - 1].y + 0);
				break;
			}
			case 1: {
				this.points[i] = new Point(points[i - 1].x + 0, points[i - 1].y + 1);
				break;
			}
			case 2: {
				this.points[i] = new Point(points[i - 1].x - 1, points[i - 1].y + 0);
				break;
			}
			case 3: {
				this.points[i] = new Point(points[i - 1].x + 0, points[i - 1].y - 1);
				break;
			}
			default: {
				--i;
			}
			}
			
			for(int j = 0; j < i; ++j) {
				if(points[j].equals(points[i])) {
					--i;
					break;
				}
			}
		}
		
//		Point tmp = points[1];
//		points[1] = points[0];
//		points[0] = tmp;

		for(int i = 0; i < points.length; ++i) {
			if(points[i].x > 1) {
				move(-1, 0);
				break;
			}
			if(points[i].x < -1) {
				move(1, 0);
				break;
			}
			if(points[i].y > 1) {
				move(0, -1);
				break;
			}
			if(points[i].y < -1) {
				move(0, 1);
				break;
			}
		}
	}
	
	public void move(int x, int y) {
		for(int i = 0; i < points.length; ++i) {
			points[i].x += x;
			points[i].y += y;
		}
	}
	
	public void rotate() {
		final int cos = (int) Math.cos(Math.PI / 2);
		final int sin = (int) Math.sin(Math.PI / 2);
		
		for(int i = 0; i < points.length; ++i) {
			Point p = new Point();
			p.x = (int) (points[i].x * cos - points[i].y * sin);
			p.y = (int) (points[i].x * sin + points[i].y * cos);
			
			points[i] = p;
		}
		
		// Recalculate block cords
		setPos(pos);
	}
	
	public Point getPos() {
		return pos;
	}
	
	public void setPos(Point pos) {
		this.pos = pos;
		for(int i = 0; i < block.length; ++i)
			block[i] = add(points[i], pos);
	}

	public Point[] getBlock() {
		return block;
	}

	public void setBlock(Point[] block) {
		this.block = block;
	}
	
	private Point add(Point p1, Point p2) {
		return new Point(p1.x + p2.x, p1.y + p2.y);
	}

	private Point pos;
	private Point[] points;
	private Point[] block;
}
