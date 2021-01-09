package kr.ac.woosuk.java.fsg.models.enemyshots;

import java.awt.Graphics;
import java.util.List;

import javax.swing.ImageIcon;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.doctors.Doctor;

public class VirusShot extends EnemyShot {
	
	public VirusShot(Controller controller, int x, int y) {
		super(controller,x,y);
	}

	@Override
	protected void paintComponent(Graphics g) {
		ImageIcon bgImg = new ImageIcon(this.getClass().getResource("/kr/ac/woosuk/java/fsg/images/imgvirusshot.png"));
		g.drawImage(bgImg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		setOpaque(false);
		super.paintComponent(g);
	}

	@Override
	public void run() {
		flag : while (this.getX() <= 800) {
			try {
				this.setLocation(this.getX(), this.getY()+1);
				List<Doctor> doctors = this.controller.getDoctors();
				for(Doctor doctor : doctors) {
					if(this.getX() >= doctor.getX() && this.getX() <= doctor.getX()+75 && this.getY() >= doctor.getY() &&  this.getY() <= doctor.getY()+75) {
						this.AttackDoctor(doctor);
						this.controller.removeEnemyShot(this);
						break flag;
					}
				}
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.controller.removeEnemyShot(this);
	}

}
