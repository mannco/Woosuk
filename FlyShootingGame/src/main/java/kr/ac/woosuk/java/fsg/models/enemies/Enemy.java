package kr.ac.woosuk.java.fsg.models.enemies;
import javax.swing.JLabel;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.doctorshots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.doctorshots.Syringe;
import kr.ac.woosuk.java.fsg.models.enemyshots.BossLazer;
import kr.ac.woosuk.java.fsg.models.enemyshots.BossRush;
import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;
import kr.ac.woosuk.java.fsg.models.enemyshots.GermShot;
import kr.ac.woosuk.java.fsg.models.enemyshots.VirusShot;
import kr.ac.woosuk.java.fsg.models.items.Item;
import kr.ac.woosuk.java.fsg.models.items.ThumbsUp;


public abstract class Enemy extends JLabel implements Runnable {
	protected int hppoint;
	protected Controller controller;
	
	public Enemy(Controller controller) {
		this.controller = controller;
		this.setBounds(0, 0, 75, 75);
		
	}

	public int hp() {
		return hppoint;
	}
	
	public void attack(int attackpoint) {
		this.hppoint -= attackpoint;
	}

	public EnemyShot attack() {
		EnemyShot shot = new VirusShot(this.controller, this.getX()+34, this.getY());
		this.controller.addEnemyShot(shot);
		Thread thread = new Thread(shot);
		thread.start();
		return shot;
	}
	
	public EnemyShot bosslazer() {
		EnemyShot shot = new BossLazer(this.controller, this.getX(), this.getY());
		this.controller.addEnemyShot(shot);
		Thread thread = new Thread(shot);
		thread.start();
		return shot;
	}
	
	public EnemyShot bossrush() {
		EnemyShot shot = new BossRush(this.controller, this.getX(), this.getY());
		this.controller.addEnemyShot(shot);
		Thread thread = new Thread(shot);
		thread.start();
		return shot;
	}

	public int getHppoint() {
		return hppoint;
	}
	public void setHppoint(int hppoint) {
		this.hppoint -= hppoint;
	}

	public Item addItem() {
		return new ThumbsUp(controller,this.getX(),this.getY());
	}
	
	@Override
	public void run() {
		
	}
}

