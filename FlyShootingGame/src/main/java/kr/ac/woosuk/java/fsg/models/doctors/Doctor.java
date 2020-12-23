package kr.ac.woosuk.java.fsg.models.doctors;

import kr.ac.woosuk.java.fsg.models.items.Item;
import kr.ac.woosuk.java.fsg.models.items.PowerUp;
import kr.ac.woosuk.java.fsg.models.shots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.shots.Syringe;

public abstract class Doctor {
	protected int score;
	protected int powerlevel = 1;
	
	public DoctorShot inject() {
		// TODO Auto-generated method stub
		return new Syringe();
	}

	public void getItem(Item item) {
		// TODO Auto-generated method stub
		
	}

	public int getScore() {
		// TODO Auto-generated method stub
		return score += 10;
	}

	public int getPowerLevel() {
		// TODO Auto-generated method stub
		return powerlevel += 1;
	}

	public DoctorShot shot() {
		// TODO Auto-generated method stub
		DoctorShot shot = new Syringe();
		shot.addPower(this.powerlevel-1);
		return shot;
	}

	public void getPowerUp(Item item) {
		if(item instanceof PowerUp) {
			this.powerlevel++;
		}
	}



}
