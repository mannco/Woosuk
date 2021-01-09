package kr.ac.woosuk.java.fsg.models.enemyshots;

import java.awt.Graphics;
import java.util.List;

import javax.swing.ImageIcon;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.doctors.Doctor;

public class BossRush extends EnemyShot {

	public BossRush(Controller controller, int x, int y) {
		super(controller, x, y);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		ImageIcon bgImg = new ImageIcon(this.getClass().getResource("/kr/ac/woosuk/java/fsg/images/imgboss.png"));
		g.drawImage(bgImg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		setOpaque(false);
		super.paintComponent(g);
	}
	
	@Override
	public void run() {
		int i = 0;
		int j = 0; //한번만 맞게 하기 위해 만들었습니다.
		this.setBounds(this.getX(), this.getY(), 75, 75);
		while (i < 250) {
			try {
				this.setLocation(260, this.getY()+2);
				List<Doctor> doctors = this.controller.getDoctors();
				for(Doctor doctor : doctors) {
					if(j == 0) {
					if(this.getX() >= doctor.getX() && this.getX() <= doctor.getX()+75 && this.getY() >= doctor.getY() &&  this.getY() <= doctor.getY()+75) {
						this.AttackDoctor(doctor);
						j++;
					}
					}
				}
				i++;
				Thread.sleep(10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.controller.removeEnemyShot(this);
	}

}
