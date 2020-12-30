package kr.ac.woosuk.java.fsg.models.enemies;
import javax.swing.JLabel;

import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;
import kr.ac.woosuk.java.fsg.models.enemyshots.VirusShot;
import kr.ac.woosuk.java.fsg.models.items.Item;
import kr.ac.woosuk.java.fsg.models.items.ThumbsUp;


public abstract class Enemy extends JLabel {
	protected int hppoint;
	protected int x;
	protected int y;
	
	public Enemy() {
		
		this.setBounds(0, 0, 75, 75);
		
	}

	public int hp() {
		return hppoint;
	}
	
	public void attack(int attackpoint) {
		this.hppoint -= attackpoint;
	}

	public EnemyShot attack() {
		return new VirusShot();
	}

	public void moveright() {
		this.x+=1;
	}

	public void moveleft() {
		this.x-=1;
	}
	
	public void moveup() {
		this.y-=1;
	}
	
	public void movedown() {
		this.y+=1;
	}

	public int getx() {
		return x;
	}

	public int gety() {
		return y;
	}

	public int getHppoint() {
		return hppoint;
	}
	public void setHppoint(int hppoint) {
		this.hppoint -= hppoint;
	}

	public Item addItem() {
		// TODO Auto-generated method stub
		return new ThumbsUp();
	}
}

