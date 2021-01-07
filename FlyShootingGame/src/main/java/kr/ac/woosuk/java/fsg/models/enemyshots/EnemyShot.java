package kr.ac.woosuk.java.fsg.models.enemyshots;

import javax.swing.JLabel;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.doctors.Doctor;

public abstract class EnemyShot extends JLabel implements Runnable {
	protected int attackpoint = 1;
	protected Controller controller;
	
	public EnemyShot(Controller controller, int x, int y) {
		this.controller = controller;
		this.setBounds(x, y, 75, 75);
		
	}

	public int getAttackpoint() {
		return attackpoint;
	}

	public void AttackDoctor(Doctor doctor) {
		doctor.attack(this.attackpoint);
	}


	public int attack() {
		return attackpoint;
	}
}
