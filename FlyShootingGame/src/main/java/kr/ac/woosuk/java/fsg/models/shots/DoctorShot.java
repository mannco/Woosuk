package kr.ac.woosuk.java.fsg.models.shots;

import kr.ac.woosuk.java.fsg.models.enemies.Enemy;

public abstract class DoctorShot {
   protected int attackpoint;
   protected int position;


   
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
}