package kr.ac.woosuk.java.fsg.models.enemies;
import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;
import kr.ac.woosuk.java.fsg.models.enemyshots.VirusShot;
import kr.ac.woosuk.java.fsg.models.items.Item;


public abstract class Enemy {
	protected int hppoint;
	protected int x;
	protected int y;

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
}

