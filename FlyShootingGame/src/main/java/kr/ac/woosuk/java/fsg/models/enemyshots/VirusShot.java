package kr.ac.woosuk.java.fsg.models.enemyshots;

import java.awt.Graphics;
import java.util.List;

import javax.swing.ImageIcon;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.doctors.Doctor;

public class VirusShot extends EnemyShot {
	
	public VirusShot(Controller controller, int x, int y) {
		super(controller,x,y);
		// TODO Auto-generated constructor stub
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
		int i=0;
		int doctorX = 300;
		int doctorY = 800;
		flag : while (i > 60) {
			try {
				if(this.getX() > doctorX) {
					this.setLocation(this.getX()-20, this.getY());
				}
				if(this.getX() < doctorX) {
					this.setLocation(this.getX()+20, this.getY());
				}
				if(this.getY() < doctorY) {
					this.setLocation(this.getX(), this.getY()+20);
				}
				if(this.getY() > doctorY) {
					this.setLocation(this.getX(), this.getY()-20);
				}
				List<Doctor> doctors = this.controller.getDoctors();
				for(Doctor doctor : doctors) {
					if(i==0) {
						doctorX = doctor.getX();
						doctorY = doctor.getY();
					}
					if(this.getX() <= doctor.getX()+75 && this.getX() >= doctor.getX() && this.getY()-5 <= doctor.getY()) {
						this.AttackDoctor(doctor);
						this.controller.removeEnemyShot(this);
						break flag;
					}
				}
				i++;
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.controller.removeEnemyShot(this);
	}

}
