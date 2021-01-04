package kr.ac.woosuk.java.fsg.models.doctorshots;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.enemies.Enemy;

public abstract class DoctorShot extends JLabel implements Runnable {
   protected int attackpoint;
   protected int position;
   protected int y;
   protected int bombAttackPoint;
   protected int x;
   protected Controller controller;
   
   public DoctorShot(Controller controller, int x, int y) {
	   this.controller = controller;
	   this.setBounds(x, y, 10, 40);
	   
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
			if(this.getX() == enemy.getX() && this.getY() ==enemy.getY()) {
				this.attackEnemy(enemy);
				this.controller.removeDoctorShot(this);
				break;
			}
		}
	}
	@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
}