package kr.ac.woosuk.java.fsg.models.items;

import java.awt.Graphics;
import java.util.List;

import javax.swing.ImageIcon;

import kr.ac.woosuk.java.fsg.controllers.Controller;
import kr.ac.woosuk.java.fsg.models.doctors.Doctor;

public class AlcoholBombUp extends Item {
	@Override
	protected void paintComponent(Graphics g) {
		ImageIcon bgImg = new ImageIcon(this.getClass().getResource("/kr/ac/woosuk/java/fsg/images/imgalcoholbombup.png"));
		g.drawImage(bgImg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		setOpaque(false);
		super.paintComponent(g);
	}

	public AlcoholBombUp(Controller controller, int x, int y) {
		super(controller, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		int i =0;
		flag : while (i < 5000) {
			try {
				List<Doctor> doctors = this.controller.getDoctors();
				for(Doctor doctor : doctors) {
					if(this.getX()+35 >= doctor.getX() && this.getX() <= doctor.getX()+35 && this.getY()+35 >= doctor.getY() && this.getY() <= doctor.getY()+35) {
						doctor.getBombUp(this);
						break flag;
					}
				}
				Thread.sleep(50);
				i++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.controller.removeItem(this);
	}

}
