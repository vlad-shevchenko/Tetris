package blocks;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;

import mainFrame.MFrame;

public class Block {

	public Block() {
		this.points = new Point[4];
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

		for(int i = 0; i < points.length; ++i) {
			if(points[i].x > 1) {
				movePoints(-1, 0);
				break;
			}
			if(points[i].x < -1) {
				movePoints(1, 0);
				break;
			}
			if(points[i].y > 1) {
				movePoints(0, -1);
				break;
			}
			if(points[i].y < -1) {
				movePoints(0, 1);
				break;
			}
		}
		
		for(int i = 0; i < points.length; ++i) {
			if(points[i].equals(new Point(0, 0))){
				Point tmp = points[i];
				points[i] = points[0];
				points[0] = tmp;
				break;
			}
		}
	}
	
	public void move(int x, int y) {
		setPos(add(new Point(x, y), pos));
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
	
		int minX = getMinX();
		int minY = getMinY();
		int maxX = getMaxX();
		int maxY = getMaxY();
		
		if(minX < 0) forceMove(-minX, 0);
		if(minY < 0) forceMove(0, -minY);
		if(maxX > MFrame.FIELD_WIDTH - 1) forceMove(maxX - MFrame.FIELD_WIDTH - 1, 0);
		if(maxY > MFrame.FIELD_HEIGHT - 1) forceMove(0, maxY - MFrame.FIELD_HEIGHT - 1);
	}

	public Point[] getBlock() {
		return block;
	}

	public void setBlock(Point[] block) {
		this.block = block;
	}
	
	public int getMinX() {
		int minX = 0;
		
		for(int i = 0; i < block.length; ++i){
			if(block[i].x < minX) 
				minX = block[i].x;
		}
		
		return minX;
	}
	
	public int getMinY() {
		int minY = 0;
		
		for(int i = 0; i < block.length; ++i){
			if(block[i].y < minY) 
				minY = block[i].y;
		}
		
		return minY;
	}
	
	public int getMaxX() {
		int maxX = 0;
		
		for(int i = 0; i < block.length; ++i){
			if(block[i].x > maxX) 
				maxX = block[i].x;
		}
		
		return maxX;
	}
	
	public int getMaxY() {
		int maxY = 0;
		
		for(int i = 0; i < block.length; ++i){
			if(block[i].y > maxY) 
				maxY = block[i].y;
		}
		
		return maxY;
	}
	
	private Point add(Point p1, Point p2) {
		return new Point(p1.x + p2.x, p1.y + p2.y);
	}
	
	private void movePoints(int x, int y) {
		for(int i = 0; i < points.length; ++i) {
			points[i] = add(points[i], new Point(x, y));
		}
	}
	
	private void forceMove(int x, int y) {
		this.pos = add(pos, new Point(x, y));
		for(int i = 0; i < block.length; ++i) {
			block[i] = add(block[i], new Point(x, y));
		}
	}

	private Point pos;
	private Point[] points;
	private Point[] block = {new Point(0, 0), new Point(0, 0), new Point(0, 0), new Point(0, 0)};
}
