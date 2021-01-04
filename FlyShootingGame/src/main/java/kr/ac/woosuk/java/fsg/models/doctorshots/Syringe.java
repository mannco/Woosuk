package kr.ac.woosuk.java.fsg.models.doctorshots;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import kr.ac.woosuk.java.fsg.controllers.Controller;

public class Syringe extends DoctorShot {
	
	@Override
	protected void paintComponent(Graphics g) {
		ImageIcon bgImg = new ImageIcon(this.getClass().getResource("/kr/ac/woosuk/java/fsg/images/imgsyringe.png"));
		g.drawImage(bgImg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		setOpaque(false);
		super.paintComponent(g);
	}
	
	public Syringe(Controller controller, int x, int y) {
		super(controller,x,y);
		this.attackpoint = 10;
	}

	@Override
	public void run() {
		while (this.getY() >= 0) {
			try {
				this.setLocation(this.getX(), this.getY()-20);
				
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.controller.removeDoctorShot(this);
	}
}
