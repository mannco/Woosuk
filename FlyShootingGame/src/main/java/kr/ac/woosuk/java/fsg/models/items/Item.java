package kr.ac.woosuk.java.fsg.models.items;

import javax.swing.JLabel;

public abstract class Item extends JLabel {
	protected int addPoint;
	protected int x;
	protected int y;
	
	public void moveRight() {
		this.x += 1;
		
	}

	public int getx() {
		
		return x;
	}

	public void moveLeft() {
		this.x -= 1;
		
	}

	public void moveUp() {
		this.y -= 1;
		
	}

	public int gety() {
		
		return y;
	}

	public void moveDown() {
		this.y += 1;
		
	}
	

}
