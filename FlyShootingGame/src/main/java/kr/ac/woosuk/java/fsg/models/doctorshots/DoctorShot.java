package kr.ac.woosuk.java.fsg.models.doctorshots;

import java.util.ArrayList;

import kr.ac.woosuk.java.fsg.models.enemies.Enemy;

public abstract class DoctorShot {
   protected int attackpoint;
   protected int position;
   protected int Y;
   protected int bombAttackPoint;


   
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

	public void attackAllEnemy(Enemy enemy) {
		enemy.attack(this.attackpoint);
	}
	
	public void attackAllEnemy(ArrayList<Enemy> list) {
		// TODO Auto-generated method stub
		for (Enemy enemy : list) {
			enemy.setHppoint(this.attackpoint);
		}
	}
}