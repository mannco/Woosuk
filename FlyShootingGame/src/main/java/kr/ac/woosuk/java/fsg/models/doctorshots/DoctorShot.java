package kr.ac.woosuk.java.fsg.models.doctorshots;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import kr.ac.woosuk.java.fsg.models.enemies.Enemy;

public abstract class DoctorShot extends JLabel {
   protected int attackpoint;
   protected int position;
   protected int y;
   protected int bombAttackPoint;
   protected int x;
   
   public DoctorShot() {
	   
	   this.setBounds(0, 0, 75, 75);
	   
   }

   
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
		this.y = -10;   
	}
		   
	public int gety() {
		return y;
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

	public void search(List<Enemy> enemies) {
		for(Enemy enemy : enemies) {
			if(this.x == enemy.getx() && this.y ==enemy.gety()) {
				this.attackEnemy(enemy);
				break;
			}
		}
	}
}