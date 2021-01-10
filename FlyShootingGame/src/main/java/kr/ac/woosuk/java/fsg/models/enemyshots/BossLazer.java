package kr.ac.woosuk.java.fsg.models.enemyshots;

import java.awt.Graphics;
import java.util.List;

import javax.swing.ImageIcon;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.doctors.Doctor;

public class BossLazer extends EnemyShot {

	public BossLazer(Controller controller, int x, int y) {
		super(controller, x, y);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		ImageIcon bgImg = new ImageIcon(this.getClass().getResource("/kr/ac/woosuk/java/fsg/images/lazer.png"));
		g.drawImage(bgImg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		setOpaque(false);
		super.paintComponent(g);
	}
	
	@Override
	public void run() {
		int i = 0;
		int j = 0; //한번만 맞게 하기 위해 만들었습니다.
		this.setBounds(this.getX()-50, this.getY()+75, 175, 950);
		while (i < 250) {
			try {
				List<Doctor> doctors = this.controller.getDoctors();
				if(j == 0) {
				for(Doctor doctor : doctors) {
					if(this.getX()+115 >= doctor.getX() && this.getX()-20 <= doctor.getX()) {
						//오른쪽								왼쪽범위
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
