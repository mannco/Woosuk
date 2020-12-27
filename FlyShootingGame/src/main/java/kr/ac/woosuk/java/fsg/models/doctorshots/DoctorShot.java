package kr.ac.woosuk.java.fsg.models.doctorshots;

import kr.ac.woosuk.java.fsg.models.enemies.Enemy;

public abstract class DoctorShot {
   protected int attackpoint;
   protected int position;
   protected int Y;


   
   public int  ItemPosition() {
      return position;
   }

   public int getAttackpoint() {
      return attackpoint;
   }

	public void addPower(int powerlevel) {
		this.attackpoint += powerlevel;
	}
	
	
	public void attackEnemy(Enemy virus) {
		virus.attack(this.attackpoint);
	}
	
	public void Moveup() {
		this.Y = -10;   
	}
		   
	public int getY() {
		return Y;
	}

	public void attackEnemies(Enemy enemy) {
		enemy.attack(attackpoint);
	}
}