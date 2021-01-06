package kr.ac.woosuk.java.fsg.models.enemyshots;

import javax.swing.JLabel;

import kr.ac.woosuk.java.fsg.models.doctors.Doctor;

public abstract class EnemyShot extends JLabel {
	protected int attackpoint = 1;
	
	public EnemyShot() {
		
		this.setBounds(0, 0, 75, 75);
		
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
