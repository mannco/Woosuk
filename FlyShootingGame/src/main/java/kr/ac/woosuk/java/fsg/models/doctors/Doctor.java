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
	protected int x;
	protected int y;
	protected int Bomb = 3;
	protected int life = 3;
	
	private Doctor doctor;
	
	@Override
	public void run() {
			
	}
	
	public Doctor(Controller controller) {
		
		this.setBounds(0, 0, 75, 75);
		this.setFocusable(true);
		
	}
	
	private class KeyListener extends KeyAdapter {
		
		@Override
	    public void keyPressed(KeyEvent e) {
			
	        switch(e.getKeyCode()){
	        
	        case KeyEvent.VK_UP:
	        	doctor.moveUp();
	        break;
	
	        case KeyEvent.VK_DOWN:
	        	doctor.moveDown();
	        break;
	        
	        case KeyEvent.VK_LEFT:
	        	doctor.moveLeft();
	        break;
	        
	        case KeyEvent.VK_RIGHT:
	        	doctor.moveRight();
	        break;
	        
	        }
	        
		}
		
	}
	
	public DoctorShot inject() {
		
		return new Syringe();
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
		DoctorShot shot = new Syringe();
		shot.addPower(this.powerlevel-1);
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
		this.x += 1;
	}

	public void moveLeft() {
		this.x -= 1;
	}
	
	public void moveUp() {
		this.y -= 1;
	}

	public void moveDown() {
		this.y += 1;
	}

	public int getx() {
		return x;
	}

	public int gety() {
		return y;
	}

	public DoctorShot useBomb() {
		if(this.Bomb >0) {
			this.Bomb -= 1;
			return new AlcoholBomb();
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
