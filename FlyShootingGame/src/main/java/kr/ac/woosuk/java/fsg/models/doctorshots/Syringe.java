package kr.ac.woosuk.java.fsg.models.doctorshots;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Syringe extends DoctorShot {
	
	@Override
	protected void paintComponent(Graphics g) {
		ImageIcon bgImg = new ImageIcon(this.getClass().getResource("/kr/ac/woosuk/java/fsg/images/imgsyringe.png"));
		g.drawImage(bgImg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		setOpaque(false);
		super.paintComponent(g);
	}
	
	public Syringe() {
		this.attackpoint = 10;
	}
}
