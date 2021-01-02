package kr.ac.woosuk.java.fsg.models.doctors;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

import javax.swing.JLabel;


import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.doctorshots.AlcoholBomb;
import kr.ac.woosuk.java.fsg.models.doctorshots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.doctorshots.Syringe;
import kr.ac.woosuk.java.fsg.models.items.Item;
import kr.ac.woosuk.java.fsg.models.items.PowerUp;
import kr.ac.woosuk.java.fsg.views.GameView;

public abstract class Doctor extends JLabel implements Runnable {
	protected int score;
	protected int powerlevel = 1;
	protected int Bomb = 3;
	protected int life = 3;
	
	private Doctor doctor;
	protected Controller controller;
	
	@Override
	public void run() {
			
	}
	
	public Doctor(Controller controller) {
		this.controller = controller;
		this.setBounds(0, 0, 75, 75);
		this.setFocusable(true);
		this.addKeyListener(new KeyListener());
		
	}
	
	private class KeyListener extends KeyAdapter {
		
		@Override
	    public void keyPressed(KeyEvent e) {
			
	        switch(e.getKeyCode()){
	        
	        case KeyEvent.VK_UP:
	        	moveUp();
	        break;
	
	        case KeyEvent.VK_DOWN:
	        	moveDown();
	        break;
	        
	        case KeyEvent.VK_LEFT:
	        	moveLeft();
	        break;
	        
	        case KeyEvent.VK_RIGHT:
	        	moveRight();
	        break;
	        
	        case KeyEvent.VK_A:
	        	shot();
	        break;
	        
	        }
		}
	}
	

	

	public void getThumbsUp(Item item) {
		this.score += 10;
	}

	public int getScore() {
		return score;
	}

	public int getPowerLevel() {
		return powerlevel += 1;
	}

	public DoctorShot shot() {
		DoctorShot shot = new Syringe(this.controller, this.getX(), this.getY());
		this.controller.addDoctorShot(shot);
		shot.addPower(this.powerlevel-1);
		//Thread thread = new Thread(shot);
		//thread.start();
		return shot;
	}

	public void getPowerUp(Item item) {
		if(item instanceof PowerUp) {
			this.powerlevel++;
		}
	}

	public int Score() {
		return score += 5;
	}

	public void moveRight() {
		this.setBounds(this.getX()+10, this.getY(), this.getWidth(), this.getHeight());
	}

	public void moveLeft() {
		this.setBounds(this.getX()-10, this.getY(), this.getWidth(), this.getHeight());
	}
	
	public void moveUp() {
		this.setBounds(this.getX(), this.getY()-10, this.getWidth(), this.getHeight());
	}

	public void moveDown() {
		this.setBounds(this.getX(), this.getY()+10, this.getWidth(), this.getHeight());
	}


	public DoctorShot useBomb() {
		if(this.Bomb >0) {
			this.Bomb -= 1;
			return new AlcoholBomb(this.controller, this.getX(), this.getY());
		} else {
			return null;
		}
	}

	public int getBombScore() {
		
		return Bomb;
	}

	public void lifeDecrease() {
		if(this.life > 0) {
				this.life -= 1;
		}	
	}

	public int getLifepoint() {
		return life;
	}

	public void attack(int attackpoint) {
		this.life -= attackpoint;
	}

	public int getPower() {
		return powerlevel;
	}

	public int getLife() {
		return life;
	}

	public void getLifeUp(Item item) {
		this.life += 1;
	}

	public void getBombUp(Item item) {
		this.Bomb += 1;
	}
}
