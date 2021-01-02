package kr.ac.woosuk.java.fsg.models.doctorshots;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import kr.ac.woosuk.java.fsg.controllers.Controller;

public class AlcoholBomb extends DoctorShot {
	
	@Override
	protected void paintComponent(Graphics g) {
		ImageIcon bgImg = new ImageIcon(this.getClass().getResource("/kr/ac/woosuk/java/fsg/images/imgalcoholbomb.png"));
		g.drawImage(bgImg.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		setOpaque(false);
		super.paintComponent(g);
	}
	
	public AlcoholBomb(Controller controller, int x, int y) {
		super(controller,x,y);
		this.attackpoint = 999;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
