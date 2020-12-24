package kr.ac.woosuk.java.fsg.models.enemies;
import kr.ac.woosuk.java.fsg.models.enemyshots.EnemyShot;
import kr.ac.woosuk.java.fsg.models.enemyshots.VirusShot;
import kr.ac.woosuk.java.fsg.models.items.Item;


public abstract class Enemy {
	protected int hppoint;

	public int hp() {
		return hppoint;
	}
	
	public void attack(int attackpoint) {
		this.hppoint -= attackpoint;
	}

	public EnemyShot dispense() {
		// TODO Auto-generated method stub
		return new VirusShot();
	}
	
	

}

