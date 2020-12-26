package kr.ac.woosuk.java.fsg.models.enemyshots;

import kr.ac.woosuk.java.fsg.models.doctors.Doctor;

public abstract class EnemyShot {
	protected int attackpoint = 1;
	protected int y;

	public int getAttackpoint() {
		return attackpoint;
	}

	public void AttackDoctor(Doctor doctor) {
		doctor.attack(this.attackpoint);
	}

	public void moveDown() {
		this.y += 1;
	}

	public int getY() {
		return y;
	}

}
