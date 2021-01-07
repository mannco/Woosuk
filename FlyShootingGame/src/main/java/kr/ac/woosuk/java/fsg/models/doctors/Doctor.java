package kr.ac.woosuk.java.fsg.models.doctors;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JLabel;


import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.doctorshots.AlcoholBomb;
import kr.ac.woosuk.java.fsg.models.doctorshots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.doctorshots.Syringe;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;
import kr.ac.woosuk.java.fsg.models.items.AlcoholBombUp;
import kr.ac.woosuk.java.fsg.models.items.Item;
import kr.ac.woosuk.java.fsg.models.items.LifeUp;
import kr.ac.woosuk.java.fsg.models.items.PowerUp;
import kr.ac.woosuk.java.fsg.models.items.ThumbsUp;
import kr.ac.woosuk.java.fsg.views.GameView;

public abstract class Doctor extends JLabel implements Runnable {
	protected int score;
	protected int powerlevel = 1;
	protected int Bomb = 3;
	protected int life = 3;
	
	boolean Up;
	boolean Down;
	boolean Left;
	boolean Right;
	boolean shot;
	
	private Doctor doctor;
	protected Controller controller;
	
	@Override
	public void run() {
		while (this.life > 0) {
			try {

				
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.controller.removeDoctor(this);
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
	        	Up = true;
	        break;
	
	        case KeyEvent.VK_DOWN:
	        	Down = true;
	        break;
	        
	        case KeyEvent.VK_LEFT:
	        	Left = true;
	        break;
	        
	        case KeyEvent.VK_RIGHT:
	        	Right = true;
	        break;
	        
	        case KeyEvent.VK_A:
	        	shot = true;
	        break;
	        
	        case KeyEvent.VK_S:
	        	useBomb();
	        break;
	        
	        
	        }
	        if (Up) {
	        	moveUp();
	        }
	        if (Down) {
	        	moveDown();
	        }
	        if (Right) {
	        	moveRight();
	        }
	        if (Left) {
	        	moveLeft();
	        }
	        if (shot) {
	        	shot();
	        }
	        
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			super.keyReleased(e);
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				Up = false;
			} else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				Down = false;
			} else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				Right = false;
			} else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				Left = false;
			} else if(e.getKeyCode()==KeyEvent.VK_A) {
				shot = false;
			}
		}
	}
	

	

	public void getThumbsUp(Item item) {
		if(item instanceof ThumbsUp) {
		this.score += 10;
		}
	}

	public int getScore() {
		return score;
	}

	public int getPowerLevel() {
		return powerlevel += 1;
	}

	public DoctorShot shot() {
		DoctorShot shot = new Syringe(this.controller, this.getX()+50, this.getY()-5);
		this.controller.addDoctorShot(shot);
		shot.addPower(this.powerlevel-1);
		Thread thread = new Thread(shot);
		thread.start();
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
		if(this.getX() < 510 ) {
		this.setBounds(this.getX()+10, this.getY(), this.getWidth(), this.getHeight());
		}
	}

	public void moveLeft() {
		if(this.getX() > 0 ) {
		this.setBounds(this.getX()-10, this.getY(), this.getWidth(), this.getHeight());
		}
	}
	
	public void moveUp() {
		if(this.getY() > 0 ) {
		this.setBounds(this.getX(), this.getY()-10, this.getWidth(), this.getHeight());
		}
	}

	public void moveDown() {
		if(this.getY() < 685 ) {
		this.setBounds(this.getX(), this.getY()+10, this.getWidth(), this.getHeight());
		}
	}


	public DoctorShot useBomb() {
		if(this.Bomb > 0) {
			this.Bomb -= 1;
			DoctorShot shot = new AlcoholBomb(this.controller, this.getX()+50, this.getY()-5);
			this.controller.addDoctorShot(shot);
			Thread thread = new Thread(shot);
			thread.start();
			return shot;
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
		if(item instanceof LifeUp) {
			if(this.life < 3) {
				this.life += 1;
				System.out.println("닥터 라이프 증가");
			} else {
				System.out.println("Life의 최대 개수는 3개 입니다");
			}
		}
	}

	public void getBombUp(Item item) {
		if(item instanceof AlcoholBombUp) {
		this.Bomb += 1;
		}
	}
}
