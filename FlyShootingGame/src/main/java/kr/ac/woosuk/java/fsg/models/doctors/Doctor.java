package kr.ac.woosuk.java.fsg.models.doctors;

import kr.ac.woosuk.java.fsg.models.doctorshots.DoctorShot;
import kr.ac.woosuk.java.fsg.models.doctorshots.Syringe;
import kr.ac.woosuk.java.fsg.models.items.Item;
import kr.ac.woosuk.java.fsg.models.items.PowerUp;

public abstract class Doctor {
	protected int score;
	protected int powerlevel = 1;
	protected int x;
	protected int y;
	
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

	public int Score() {
		// TODO Auto-generated method stub
		return score += 5;
	}

	public int moveRight() {
		// TODO Auto-generated method stub
		return x += 1;
	}

	public int moveleft() {
		// TODO Auto-generated method stub
		return x -= 1;
	}
	
	public int moveUp() {
		// TODO Auto-generated method stub
		return y -= 1;
	}

	public int moveDown() {
		// TODO Auto-generated method stub
		return y += 1;
	}

	public int getx() {
		// TODO Auto-generated method stub
		return x;
	}

	public int gety() {
		// TODO Auto-generated method stub
		return y;
	}

}
