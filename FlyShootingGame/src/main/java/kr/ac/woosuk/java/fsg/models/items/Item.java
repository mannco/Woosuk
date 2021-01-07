package kr.ac.woosuk.java.fsg.models.items;

import java.util.List;

import javax.swing.JLabel;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.doctors.Doctor;

public abstract class Item extends JLabel implements Runnable {
	protected int addPoint;
	protected int x;
	protected int y;
	protected Controller controller;
	
	public Item(Controller controller, int x, int y) {
		this.controller = controller;
		this.setBounds(x, y, 35, 35);
	}
	
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
