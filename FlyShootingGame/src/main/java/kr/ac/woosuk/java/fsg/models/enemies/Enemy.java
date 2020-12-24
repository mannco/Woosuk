package kr.ac.woosuk.java.fsg.models.enemies;
import kr.ac.woosuk.java.fsg.models.items.Item;

public abstract class Enemy {
	protected int hppoint;
	
	public void product() {
	}

	public int hp() {
		return hppoint;
	}
	
	public void attack(int attackpoint) {
		this.hppoint -= attackpoint;
	}
	
	

}

